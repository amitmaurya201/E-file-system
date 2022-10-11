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
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.base.ReceiptServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=jet_process",
		"json.web.service.context.path=Receipt" }, service = AopService.class)
public class ReceiptServiceImpl extends ReceiptServiceBaseImpl {

	public Receipt addReceipt(long groupId, String type, String deliveryMode, Date receivedOn, Date letterDate,
			String referenceNumber, String organisation, String modeNumber, String category, String subCategory,
			String subject, String remarks, String document, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country, String state, String district, String pinCode,
			ServiceContext serviceContext) throws PortalException {

		return receiptLocalService.addReceipt(groupId, type, deliveryMode, receivedOn, letterDate, referenceNumber, organisation, modeNumber, category, subCategory, subject, remarks, document, minDeptOth, name, designation, mobile, email, address, country, state, district, pinCode, serviceContext);
	}

	public Receipt deleteReceipt(long receiptId) throws PortalException {
		Receipt receipt = receiptLocalService.getReceipt(receiptId);
		return receiptLocalService.deleteReceipt(receipt);

	}

	public List<Receipt> getReceiptByGroupId(long groupId, int start, int end) {
		return receiptLocalService.getReceiptByGroupId(groupId, start, end);

	}

}