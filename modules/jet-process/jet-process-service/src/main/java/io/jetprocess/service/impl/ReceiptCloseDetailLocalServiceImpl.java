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

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptCloseDetail;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.service.base.ReceiptCloseDetailLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.ReceiptCloseDetail",
	service = AopService.class
)
public class ReceiptCloseDetailLocalServiceImpl extends ReceiptCloseDetailLocalServiceBaseImpl {
	
	
	public ReceiptCloseDetail addClosedReceiptDetails(long receiptId,long closedBy,String closingRemarks,long closingReceiptMovementId) throws PortalException {
	
		long receiptClosedId = counterLocalService.increment(ReceiptCloseDetail.class.getName());
		ReceiptCloseDetail receiptCloseDetail = createReceiptCloseDetail(receiptClosedId);
		receiptCloseDetail.setReceiptId(receiptId);
		receiptCloseDetail.setClosedBy(closedBy);
		receiptCloseDetail.setClosingRemarks(closingRemarks);
		receiptCloseDetail.setClosingReceiptMovementId(closingReceiptMovementId);
		Receipt receipt = receiptLocalService.getReceipt(receiptId);
		receipt.setCurrentState(FileStatus.CLOSED);
		receiptLocalService.updateReceipt(receipt);
		System.out.println("updated receipt ---->"+receiptLocalService.updateReceipt(receipt));
		ReceiptMovement receiptMovement = receiptMovementLocalService.getReceiptMovement(closingReceiptMovementId);
		receiptMovement.setActive(false);
		receiptMovementLocalService.updateReceiptMovement(receiptMovement);
		System.out.println("updated receiptmovement-->"+receiptMovementLocalService.updateReceiptMovement(receiptMovement));
		addReceiptCloseDetail(receiptCloseDetail);
		return receiptCloseDetail;
		
	}

	@Reference
	private ReceiptLocalService receiptLocalService;
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;
	
	
	
}