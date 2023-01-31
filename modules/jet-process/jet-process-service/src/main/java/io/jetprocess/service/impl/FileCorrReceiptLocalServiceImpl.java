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
import com.liferay.portal.kernel.util.Validator;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.model.FileCorrReceipt;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.base.FileCorrReceiptLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.FileCorrReceipt",
	service = AopService.class
)
public class FileCorrReceiptLocalServiceImpl
	extends FileCorrReceiptLocalServiceBaseImpl {
	
	public void addReceiptInFile(long receiptId, long docFileId, long userPostId, String remark, long receiptMovementId)
			throws PortalException {	

		long fileCorrId = counterLocalService.increment();
		FileCorrReceipt fileCorrReceipt = createFileCorrReceipt(fileCorrId);
		fileCorrReceipt.setReceiptId(receiptId);
		fileCorrReceipt.setDocFileId(docFileId);
		fileCorrReceipt.setReceiptMovementId(receiptMovementId);
		fileCorrReceipt.setUserPostId(userPostId);
		fileCorrReceipt.setCorrespondenceType(FileStatus.RECEIPT_TYPE);
		fileCorrReceipt.setRemarks(remark);
	        addFileCorrReceipt(fileCorrReceipt);
		Receipt receiptObj = receiptLocalService.getReceipt(receiptId);
		if (Validator.isNotNull(receiptObj)) {
			receiptObj.setAttachStatus(FileStatus.ATTACH_STATUS);
			receiptLocalService.updateReceipt(receiptObj);

		}
	
	
	}
	
	@Reference
	private ReceiptLocalService receiptLocalService;
}