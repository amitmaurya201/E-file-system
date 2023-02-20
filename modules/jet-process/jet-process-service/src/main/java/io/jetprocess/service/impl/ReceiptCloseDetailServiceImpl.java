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

import io.jetprocess.model.ReceiptCloseDetail;
import io.jetprocess.service.base.ReceiptCloseDetailServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=jet_process",
		"json.web.service.context.path=ReceiptCloseDetail"
	},
	service = AopService.class
)
public class ReceiptCloseDetailServiceImpl
	extends ReceiptCloseDetailServiceBaseImpl {
	
	
	//create method for save closedetails 
	public ReceiptCloseDetail addClosedReceiptDetails(long receiptId,long closedBy,String closingRemarks,long closingReceiptMovementId) throws PortalException {
		System.out.println("Closed Receipt Details ---->");
		return receiptCloseDetailLocalService.addClosedReceiptDetails(receiptId, closedBy, closingRemarks, closingReceiptMovementId);
				
	}
	
}