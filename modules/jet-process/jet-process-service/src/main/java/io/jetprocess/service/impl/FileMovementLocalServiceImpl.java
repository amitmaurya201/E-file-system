/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package io.jetprocess.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.constant.util.FileConstants;
import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileCorrReceipt;
import io.jetprocess.model.FileMovement;
import io.jetprocess.model.FileNote;
import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.service.FileNoteLocalService;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.service.base.FileMovementLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.FileMovement", service = AopService.class)
public class FileMovementLocalServiceImpl extends FileMovementLocalServiceBaseImpl {

	/**
	 * create save send file method
	 * 
	 * @param receiverId
	 * @param senderId
	 * @param fileId
	 * @param priority
	 * @param dueDate
	 * @param remark
	 * @throws PortalException
	 */
	public void saveSendFile(long receiverId, long senderId, long fileId, String priority, Date dueDate, String remark)
			throws PortalException {
		logger.info("save send file ");
		DocFile docFile = docFileLocalService.getDocFile(fileId);
		long maxFmId = masterdataLocalService.getMaximumFmIdByFileIdData(fileId);
		FileMovement fileMovement = fileMovementLocalService.getFileMovement(maxFmId);
		if (fileMovement.getReceivedOn().isEmpty() || fileMovement.getReadOn().isEmpty()) {
			if (docFile.getNature().equals(FileConstants.ELECTRONIC_NATURE)) {
				if (fileMovement.getActive() == false) {
					fileMovement.setReadOn("");
				} else {
					fileMovement.setReadOn(FileConstants.READ);
				}
			} else if (docFile.getNature().equals(FileConstants.PHYSICAL_NATURE)) {
				if (fileMovement.getActive() == false) {
					fileMovement.setReadOn("");
				} else {
					fileMovement.setReceivedOn(FileConstants.RECEIVE);
				}
			}
			updateFileMovement(fileMovement);
		}
		FileMovement saveFileMovement = saveFileMovement(receiverId, senderId, fileId, priority, dueDate, remark, true,
				FileStatus.IN_MOVEMENT, MovementStatus.NORMAL);
		receiptMovementAttachInFile(receiverId, senderId, fileId, docFile, saveFileMovement);
		addBlankNote(senderId, fileId, docFile, maxFmId, fileMovement);
	}

	private void addBlankNote(long senderId, long fileId, DocFile docFile, long maxFmId, FileMovement fileMovement)
			throws PortalException {
		if (fileMovement.getPullBackRemark() == null || fileMovement.getPullBackRemark().equals("null")
				|| fileMovement.getPullBackRemark().isEmpty()) {
			FileNote fileNote = fileNoteLocalService.getFileNoteByFilemovementId(maxFmId);
			if (Validator.isNull(fileNote) && docFile.getNature().equals(FileConstants.ELECTRONIC_NATURE)) {
				noteLocalService.addBlankNote(fileId, maxFmId, senderId);

			}

		}
	}

	private void receiptMovementAttachInFile(long receiverId, long senderId, long fileId, DocFile docFile,
			FileMovement saveFileMovement) {
		List<FileCorrReceipt> fileCorrReceiptByFileId = fileCorrReceiptLocalService.getFileCorrReceiptByFileId(fileId);
		for (FileCorrReceipt fileCorrReceipt : fileCorrReceiptByFileId) {
			if (fileCorrReceipt.getDetachRemark() == "") {
				ReceiptMovement receiptMovement=null;
				try {
					Receipt receipt = receiptLocalService.getReceipt(fileCorrReceipt.getReceiptId());
					if(receipt.getCurrentState()==FileStatus.CLOSED) {
						String remarkOfInFile = "In File" + " - " + docFile.getFileNumber();
						 receiptMovement = receiptMovementLocalService.saveReceiptMovement(receiverId, senderId,
								fileCorrReceipt.getReceiptId(), "", null, remarkOfInFile, true, FileStatus.CLOSED,
								MovementStatus.IN_FILE);
					}else {
						String remarkOfInFile = "In File" + " - " + docFile.getFileNumber();
						 receiptMovement = receiptMovementLocalService.saveReceiptMovement(receiverId, senderId,
								fileCorrReceipt.getReceiptId(), "", null, remarkOfInFile, true, FileStatus.IN_MOVEMENT,
								MovementStatus.IN_FILE);
					}
					
					receiptMovement.setFileInMovementId(saveFileMovement.getFmId());
					receiptMovementLocalService.updateReceiptMovement(receiptMovement);
				} catch (PortalException e) {
					e.printStackTrace();
				}
				
				
			}
		}
	}

	public List<FileMovement> getFileMovementByFileId(long fileId) {
		return fileMovementPersistence.findByfileId(fileId);
	}

	// create a method for pull back
	public FileMovement pullBackFileMovement(long fileId, long fileMovementId, String remarks) throws PortalException {

		FileMovement fileMovement = getFileMovement(fileMovementId);
		List<FileMovement> fileMovementByFileIdList = fileMovementLocalService.getFileMovementByFileId(fileId);
		for (FileMovement fileMovementByFileId : fileMovementByFileIdList) {

			if (fileMovement.getFmId() == fileMovementByFileId.getFmId()) {
				fileMovement.setActive(false);
				fileMovement.setPullBackRemark(remarks);
				fileMovementLocalService.updateFileMovement(fileMovement);
			}
		}
		return fileMovement;
	}

	// get Filemovement by fileMovementId
	public FileMovement getFileMovementById(long fileMovementId) throws PortalException {
		FileMovement fileMovement = fileMovementLocalService.getFileMovement(fileMovementId);
		return fileMovement;
	}

	public FileMovement saveFileMovement(long receiverId, long senderId, long fileId, String priority, Date dueDate,
			String remark, boolean active, int currentState, long movementType) throws PortalException {
		long fileMovementId = counterLocalService.increment(FileMovement.class.getName());
		FileMovement fileMovement = fileMovementLocalService.createFileMovement(fileMovementId);
		fileMovement.setFmId(fileMovementId);
		fileMovement.setReceiverId(receiverId);
		fileMovement.setSenderId(senderId);
		fileMovement.setFileId(fileId);
		fileMovement.setRemark(remark);
		fileMovement.setPriority(priority);
		fileMovement.setDueDate(dueDate);
		fileMovement.setActive(active);
		fileMovement.setMovementType(movementType);
		addFileMovement(fileMovement);
		DocFile docFile = docFileLocalService.getDocFileByDocFileId(fileId);
		docFile.setCurrentlyWith(receiverId);
		docFile.setCurrentState(currentState);
		docFileLocalService.updateDocFile(docFile);

		return fileMovement;

	}

	// Create a method for check Is File able to Read or Received
	public boolean pullBackedAlready(long fileMovementId) throws PortalException {
		FileMovement fileMovement = getFileMovement(fileMovementId);
		boolean state = fileMovement.getActive();
		return state;
	}

	// for pullBack is available
	public Boolean isPullBackAvailable(long fileMovementId) throws PortalException {
		boolean pullable = false;
		FileMovement fileMovement = getFileMovementById(fileMovementId);
		if ((fileMovement.getReceivedOn().isEmpty()) && (fileMovement.getReadOn().isEmpty())) {
			pullable = true;
		}
		return pullable;
	}

	public boolean saveReadMovement(long fileId, long fileMovementId) throws PortalException {
		boolean state = false;
		state = fileMovementLocalService.pullBackedAlready(fileMovementId);
		if (state == true) {
			FileMovement fileMovement = getFileMovement(fileMovementId);
			if (fileMovement.getReadOn().isEmpty() || Validator.isNull(fileMovement.getReadOn())) {
				fileMovement.setReadOn(FileConstants.READ);
				updateFileMovement(fileMovement);
			}
		}
		return state;
	}

	public boolean saveReceiveMovement(long fileId, long fileMovementId) throws PortalException {
		boolean state = false;
		state = fileMovementLocalService.pullBackedAlready(fileMovementId);
		if (state == true) {
			FileMovement fileMovement = getFileMovement(fileMovementId);
			if (fileMovement.getReceivedOn().isEmpty() || Validator.isNull(fileMovement.getReceivedOn())) {
				fileMovement.setReceivedOn(FileConstants.RECEIVE);
				updateFileMovement(fileMovement);
			}
		}
		return state;
	}

	// get status for pullback time
	public Boolean isActive(long docFileId) {
		boolean state = false;
		List<FileMovement> fileMovementBydocFileId = fileMovementLocalService.getFileMovementByFileId(docFileId);
		for (FileMovement fileMovement : fileMovementBydocFileId) {
			if (!fileMovement.getActive()) {
				state = false;
			} else {
				state = true;
				break;
			}
		}
		return state;
	}

	@Reference
	private DocFileLocalService docFileLocalService;

	@Reference
	private MasterdataLocalService masterdataLocalService;

	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	@Reference
	private ReceiptLocalService receiptLocalService;

	@Reference
	private FileNoteLocalService fileNoteLocalService;
	@Reference
	private NoteLocalService noteLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
