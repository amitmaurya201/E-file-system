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
public class ReceiptCloseDetailLocalServiceImpl  extends ReceiptCloseDetailLocalServiceBaseImpl {
	
	public ReceiptCloseDetail addClosedReceiptDetails(long receiptId,long closedBy,String closingRemarks,long closedMovementId) throws PortalException {
		
		long receiptClosedId = counterLocalService.increment(ReceiptCloseDetail.class.getName());
		ReceiptCloseDetail receiptCloseDetail = createReceiptCloseDetail(receiptClosedId);
		receiptCloseDetail.setReceiptId(receiptId);
		receiptCloseDetail.setClosedBy(closedBy);
		receiptCloseDetail.setClosingRemarks(closingRemarks);
		receiptCloseDetail.setClosedMovementId(closedMovementId);
		Receipt receipt = receiptLocalService.getReceipt(receiptId);
		receipt.setCurrentState(FileStatus.CLOSED);
		receiptLocalService.updateReceipt(receipt);
		addReceiptCloseDetail(receiptCloseDetail);
		return receiptCloseDetail;
		
	}
	
	public ReceiptCloseDetail addReopenReceiptDetails(long receiptId, long reopenBy, String reopenRemarks,
			long reopenMovementId, Date reopenDate) throws PortalException {

		ReceiptCloseDetail receiptCloseDetail = getReceiptCloseDetail(reopenMovementId);
		System.out.println("reopen ---> receiptId-->"+receiptId+"reopenBy--->"+reopenBy+"reopenRemarks--->"+reopenMovementId+"reopenDate--->"+reopenDate);
		
		receiptCloseDetail.setReopenMovementId(reopenMovementId);
		receiptCloseDetail.setReopenRemarks(reopenRemarks);
		receiptCloseDetail.setReopenDate(reopenDate);
		receiptCloseDetail.setReopenBy(reopenBy);
		System.out.println("receiptreopenDetail--->"+receiptCloseDetail);
		System.out.println("reopen ---> receiptId-->"+receiptId+"reopenBy--->"+reopenBy+"reopenRemarks--->"+reopenMovementId+"reopenDate--->"+reopenDate);
		receiptCloseDetailLocalService.updateReceiptCloseDetail(receiptCloseDetail);
		return receiptCloseDetail;
	} 
	
	@Reference 
	private ReceiptLocalService receiptLocalService;
	
	@Reference 
	private ReceiptMovementLocalService receiptMovementLocalService; 
	
	
}