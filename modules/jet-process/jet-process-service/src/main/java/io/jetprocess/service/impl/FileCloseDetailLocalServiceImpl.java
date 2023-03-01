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

import java.util.List;

import io.jetprocess.core.util.FileStatus;
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
@Component(
	property = "model.class.name=io.jetprocess.model.FileCloseDetail",
	service = AopService.class
)
public class FileCloseDetailLocalServiceImpl
	extends FileCloseDetailLocalServiceBaseImpl {
	
	public FileCloseDetail addCloseFileDetail(long fileId,long closedBy,String closingRemarks,long closingMovementId) throws PortalException {
		long closedFileId = counterLocalService.increment(FileCloseDetail.class.getName());
		FileCloseDetail fileCloseDetail = createFileCloseDetail(closedFileId);
		fileCloseDetail.setClosedBy(closedBy);
		fileCloseDetail.setClosingRemarks(closingRemarks);
		fileCloseDetail.setClosedMovementId(closingMovementId);
		fileCloseDetail.setFileId(fileId);
		DocFile docFile =docFileLocalService.getDocFile(fileId);
		docFile.setCurrentState(FileStatus.CLOSED);
		docFileLocalService.updateDocFile(docFile);
		System.out.println("updatedocfile");
		FileMovement fileMovement = fileMovementLocalService.getFileMovement(closingMovementId);
		fileMovement.setActive(false);
		fileMovementLocalService.updateFileMovement(fileMovement);
		System.out.println("updatefileMovementId");
		//if(fileCorrReceiptLocalService.get) {
		List <FileCorrReceipt> fileCorrReceiptList=fileCorrReceiptLocalService.getFileCorrReceiptByFileId(fileId);
		System.out.println("filecorrReceipt");
		for(FileCorrReceipt fileCorrReceipt:fileCorrReceiptList) {
			long receiptId= fileCorrReceipt.getReceiptId();
			receiptCloseDetailLocalService.addClosedReceiptDetails(receiptId, closedBy, closingRemarks, closingMovementId);
			System.out.println("in close receipt loop");
		}
		System.out.println("after for loop");
		addFileCloseDetail(fileCloseDetail);
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