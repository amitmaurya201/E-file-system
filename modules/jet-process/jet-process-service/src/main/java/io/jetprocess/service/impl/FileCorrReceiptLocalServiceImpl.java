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

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.exception.NoSuchFileCorrReceiptException;
import io.jetprocess.model.FileCorrReceipt;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.base.FileCorrReceiptLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.FileCorrReceipt", service = AopService.class)
public class FileCorrReceiptLocalServiceImpl extends FileCorrReceiptLocalServiceBaseImpl {

	public void addReceiptInFile(long receiptId, long docFileId, long userPostId, String remark, long receiptMovementId,
			long fileMovementId) throws PortalException {
		logger.info("add receipt in file called");
		long fileCorrId = counterLocalService.increment();
		FileCorrReceipt fileCorrReceipt = createFileCorrReceipt(fileCorrId);
		fileCorrReceipt.setReceiptId(receiptId);
		fileCorrReceipt.setDocFileId(docFileId);
		fileCorrReceipt.setReceiptMovementId(receiptMovementId);
		fileCorrReceipt.setUserPostId(userPostId);
		fileCorrReceipt.setCorrespondenceType(FileStatus.RECEIPT_TYPE);
		fileCorrReceipt.setRemarks(remark);
		fileCorrReceipt.setFileMovementId(fileMovementId);
		addFileCorrReceipt(fileCorrReceipt);
		Receipt receiptObj = receiptLocalService.getReceipt(receiptId);
		if (Validator.isNotNull(receiptObj)) {
			receiptObj.setAttachStatus(FileStatus.ATTACH_STATUS);
			receiptLocalService.updateReceipt(receiptObj);
		}
	}

	public List<FileCorrReceipt> getFileCorrReceiptByFileId(long fileId) {
		logger.info("get FileCorrReceipt by fileId method called");
		return fileCorrReceiptPersistence.findByfileCorrReceiptBydocFileId(fileId);
	}
	
public boolean detachFileCorrReceipt(long receiptId, long receiptMovementId, String detachRemark, long detachBy) {
		System.out.println("----- File Correspondence detach ------");
		FileCorrReceipt fileCorrReceipt = getFileCorrReceiptByReceiptIdAndReceiptMovementId(receiptId,receiptMovementId );
		fileCorrReceipt.setDetachRemark(detachRemark);
		fileCorrReceipt.setDetachBy(detachBy);
		fileCorrReceipt.setDetachOn(new Date());
		Receipt receipt=null;
		try {
			receipt = receiptLocalService.getReceipt(receiptId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		receipt.setAttachStatus(null);
		receiptLocalService.updateReceipt(receipt);
		fileCorrReceiptLocalService.updateFileCorrReceipt(fileCorrReceipt);
		return false;
	}
	public FileCorrReceipt getFileCorrReceiptByReceiptIdAndReceiptMovementId(long receiptId, long receiptMovementId) {
		logger.info("Getting File Correspondence Receipt By Receipt And Receipt Movement Id");
		FileCorrReceipt fileCorrReceipt=null; 
		try {
			fileCorrReceipt = fileCorrReceiptPersistence.findByFileCorrReceipt(receiptId, receiptMovementId);
		} catch (NoSuchFileCorrReceiptException e) {
			logger.error(e);
		}
		return fileCorrReceipt;
	}
    
	

	@Reference
	private ReceiptLocalService receiptLocalService;
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());

}