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

import java.io.IOException;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.base.ReceiptServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=jet_process",
		"json.web.service.context.path=Receipt" }, service = AopService.class)
public class ReceiptServiceImpl extends ReceiptServiceBaseImpl {
	
	public Receipt createReceipt(long groupId, long typeId, long tempfileEntryId, long deliveryModeId,String nature,
			Date receivedOn, Date letterDate, String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId, String pinCode, long organizationId,
			long subOrganizationId, String city, long userPostId)
			throws PortalException, IOException {
		return receiptLocalService.createReceipt(groupId, typeId, tempfileEntryId, deliveryModeId, nature, 
				receivedOn, letterDate, referenceNumber, modeNumber, receiptCategoryId, 
				receiptSubCategoryId, subject, remarks, name, designation, mobile, email, 
				address, countryId, stateId, pinCode, organizationId, subOrganizationId, 
				city, userPostId);
	}

	public Receipt updateReceipt(long receiptId,long groupId, long typeId, long tempfileEntryId, String nature,
			Date receivedOn, Date letterDate, String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId, String pinCode, long organizationId,
			long subOrganizationId, String city, long userPostId, long dmFileId)
			throws PortalException, IOException {
		return receiptLocalService.updateReceipt(receiptId, groupId,typeId, tempfileEntryId,nature,
				receivedOn, letterDate, referenceNumber, modeNumber, receiptCategoryId, receiptSubCategoryId, subject,
				remarks, name, designation, mobile, email, address, countryId, stateId, pinCode,
				organizationId, subOrganizationId, city, userPostId,dmFileId);
	}

	public Receipt deleteReceipt(long receiptId) throws PortalException {
		Receipt receipt = receiptLocalService.getReceipt(receiptId);
		return receiptLocalService.deleteReceipt(receipt);
	}

	public Receipt getReceiptByReceiptId(long receiptId) throws PortalException {
		return receiptLocalService.getReceipt(receiptId);
	}
}