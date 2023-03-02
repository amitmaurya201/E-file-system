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

import java.util.Date;
import java.util.List;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileCloseDetail;
import io.jetprocess.model.FileCorrReceipt;
import io.jetprocess.model.FileMovement;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.service.ReceiptCloseDetailLocalService;
import io.jetprocess.service.base.FileCloseDetailLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.FileCloseDetail", service = AopService.class)
public class FileCloseDetailLocalServiceImpl extends FileCloseDetailLocalServiceBaseImpl {

	public FileCloseDetail addCloseFileDetail(long fileId, long closedBy, String closingRemarks, long closingMovementId)
			throws PortalException {
		long closedFileId = counterLocalService.increment(FileCloseDetail.class.getName());
		FileCloseDetail fileCloseDetail = createFileCloseDetail(closedFileId);
		fileCloseDetail.setClosedBy(closedBy);
		fileCloseDetail.setClosingRemarks(closingRemarks);
		fileCloseDetail.setClosedMovementId(closingMovementId);
		fileCloseDetail.setFileId(fileId);
		DocFile docFile = docFileLocalService.getDocFile(fileId);
		docFile.setCurrentState(FileStatus.CLOSED);
		docFileLocalService.updateDocFile(docFile);
		List<FileCorrReceipt> fileCorrReceiptList = fileCorrReceiptLocalService.getFileCorrReceiptByFileId(fileId);
		for (FileCorrReceipt fileCorrReceipt : fileCorrReceiptList) {
			long receiptId = fileCorrReceipt.getReceiptId();
			long receiptMovement = fileCorrReceipt.getReceiptMovementId();
			receiptCloseDetailLocalService.addClosedReceiptDetails(receiptId, closedBy, closingRemarks,
					receiptMovement);
		}

		addFileCloseDetail(fileCloseDetail);
		return fileCloseDetail;
	}

	public FileCloseDetail reopenClosedFile(long closedFileId, long fileId, long reopenMovementId, long reopenBy,
			String reopenRemarks) throws PortalException {
		System.out.println("reopen service" );
		FileCloseDetail fileCloseDetail = getFileCloseDetail(closedFileId);
		fileCloseDetail.setReopenRemarks(reopenRemarks);
		fileCloseDetail.setReopenBy(reopenBy);
		fileCloseDetail.setReopenDate(new Date());
		fileCloseDetail.setReopenMovementId(reopenMovementId);
		FileMovement fileMovement = fileMovementLocalService.getFileMovementById(fileCloseDetail.getClosedMovementId());
		DocFile docFile = docFileLocalService.getDocFileByDocFileId(fileId);
		// if file closed from created file list.
		if (MovementStatus.CREATED == fileMovement.getMovementType()) {
			docFile.setCurrentState(FileStatus.CREADTED);
		} else {
			docFile.setCurrentState(FileStatus.IN_MOVEMENT);
		}
		docFileLocalService.updateDocFile(docFile);
		updateFileCloseDetail(fileCloseDetail);
		System.out.println("reopen service");
		return fileCloseDetail;
	}

	@Reference
	private DocFileLocalService docFileLocalService;
	@Reference
	private FileMovementLocalService fileMovementLocalService;
	@Reference
	private ReceiptCloseDetailLocalService receiptCloseDetailLocalService;
	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;
}