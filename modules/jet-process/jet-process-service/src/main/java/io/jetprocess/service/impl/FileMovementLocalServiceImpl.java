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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.constant.util.FileConstants;

import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileCorr;
import io.jetprocess.model.FileMovement;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileCorrLocalService;
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
	public void saveSendFile(long receiverId, long senderId, long fileId, String priority, String dueDate,
			String remark) throws PortalException {
		boolean state = isFileMovementAvailable(fileId);
		if (state == true) {
			saveFileMovement(receiverId, senderId, fileId, priority, dueDate, remark);
		} else {
			Long maxFmId = masterdataLocalService.getMaximumFmIdByFileIdData(fileId);
			FileMovement fm;
			fm = fileMovementLocalService.getFileMovement(maxFmId);
			if (fm.getReceivedOn().isEmpty() || fm.getReadOn().isEmpty()) {
				DocFile docFile;
				docFile = docFileLocalService.getDocFile(fileId);
				if (docFile.getNature().equals(FileConstants.ELECTRONIC_NATURE)) {
					if (fm.getActive() == false) {
						fm.setReadOn("");
					} else {
						fm.setReadOn(FileConstants.READ);
					}
				} else if (docFile.getNature().equals(FileConstants.PHYSICAL_NATURE)) {
					if (fm.getActive() == false) {
						fm.setReadOn("");
					} else {
						fm.setReceivedOn(FileConstants.RECEIVE);
					}
				}
				updateFileMovement(fm);
			}
			saveFileMovement(receiverId, senderId, fileId, priority, dueDate, remark);
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
	public FileMovement getFileMovementById(long fmId) throws PortalException {

		FileMovement fileMovement = fileMovementLocalService.getFileMovement(fmId);
		return fileMovement;
	}
	void saveFileMovement(long receiverId, long senderId, long fileId, String priority, String dueDate, String remark)
			throws PortalException {

		long fmId = counterLocalService.increment(FileMovement.class.getName());
		FileMovement fm = fileMovementLocalService.createFileMovement(fmId);
		fm.setFmId(fmId);
		fm.setReceiverId(receiverId);
		fm.setSenderId(senderId);
		fm.setFileId(fileId);
		fm.setRemark(remark);
		fm.setPriority(priority);
		fm.setDueDate(dueDate);

		FileMovement fileMovement = fileMovementLocalService.addFileMovement(fm);
		if (fileMovement.getActive() != true) {
			fileMovement.setActive(true);
			fileMovementLocalService.updateFileMovement(fileMovement);
		}
		List<FileCorr> fileCorrList = fileCorrLocalService.getFileCorrs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if (fileCorrList == null) {
			
				DocFile docFile = docFileLocalService.getDocFileByDocFileId(fileId);
				if (fileId == docFile.getDocFileId()) {
					docFile.setCurrentlyWith(receiverId);
					docFileLocalService.updateDocFile(docFile);
					if (Validator.isNotNull(docFile.getCurrentState())) {
						docFile.setCurrentState(FileStatus.IN_MOVEMENT);
						docFileLocalService.updateDocFile(docFile);

					}
				} else {
				}
			
		} else {
			for (FileCorr fileCorr2 : fileCorrList) {
				if (fileCorr2.getDocFileId() == fileId) {

					long rmId = counterLocalService.increment(ReceiptMovement.class.getName());
					ReceiptMovement receiptMovement = receiptMovementLocalService.createReceiptMovement(rmId);
					receiptMovement.setRmId(rmId);
					receiptMovement.setReceiverId(receiverId);
					receiptMovement.setSenderId(senderId);
					receiptMovement.setReceiptId(fileId);
					receiptMovement.setRemark(remark);
					receiptMovement.setPriority(priority);
					receiptMovement.setDueDate(dueDate);
					receiptMovement.setActive(true);
					receiptMovement.setFileInMovementId(fmId);
					receiptMovementLocalService.addReceiptMovement(receiptMovement);
				}
			}
			try {
				DocFile docFile = docFileLocalService.getDocFileByDocFileId(fileId);
				if (fileId == docFile.getDocFileId()) {
					docFile.setCurrentlyWith(receiverId);
					docFileLocalService.updateDocFile(docFile);
					if (Validator.isNotNull(docFile.getCurrentState())) {
						docFile.setCurrentState(FileStatus.IN_MOVEMENT);
						docFileLocalService.updateDocFile(docFile);

					}
				} else {
				}
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}
	// Create a method for check Is File able to Read or Received
	public boolean pullBackedAlready(long fmId) throws PortalException {
		FileMovement fileMovement = getFileMovement(fmId);
		boolean state = fileMovement.getActive();
		return state;
	}
	// for pullBack is available
	public Boolean isPullBackAvailable(long fmId) throws PortalException {
		boolean pullable = false;
		FileMovement fileMovement = getFileMovementById(fmId);
		if ((fileMovement.getReceivedOn().isEmpty()) && (fileMovement.getReadOn().isEmpty())) {
			pullable = true;
		} else {
			pullable = false;
		}
		return pullable;
	}
	public boolean saveReadMovement(long fileId, long fmId) throws PortalException {
		boolean state = false;
		
			state = fileMovementLocalService.pullBackedAlready(fmId);
			if (state == true) {
				List<FileMovement> fileMovement = fileMovementLocalService.getFileMovementByFileId(fileId);
				for (FileMovement fileMovement2 : fileMovement) {
					if (fileMovement2.getFileId() == fileId) {
						fileMovement2.setReadOn("read");
						fileMovementLocalService.updateFileMovement(fileMovement2);
					}
				}
			}	
		return state;
	}
	private boolean isFileMovementAvailable(long fileId) {
		List<FileMovement> findByfileId = fileMovementPersistence.findByfileId(fileId);
		if (findByfileId.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean saveReceiveMovement(long fileId, long fmId) throws PortalException {
		boolean state = false;
		state = fileMovementLocalService.pullBackedAlready(fmId);
		if (state == true) {

			List<FileMovement> fileMovement = fileMovementLocalService.getFileMovementByFileId(fileId);
			for (FileMovement fileMovement2 : fileMovement) {
				if (fileMovement2.getFileId() == fileId) {
					fileMovement2.setReceivedOn("receive");
					fileMovementLocalService.updateFileMovement(fileMovement2);
				}
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
	DocFileLocalService docFileLocalService;

	@Reference
	MasterdataLocalService masterdataLocalService;

	@Reference
	FileCorrLocalService fileCorrLocalService;

	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;

	@Reference
	ReceiptLocalService receiptLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
