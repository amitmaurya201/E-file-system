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

package io.jetprocess.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReceiptService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptService
 * @generated
 */
public class ReceiptServiceWrapper
	implements ReceiptService, ServiceWrapper<ReceiptService> {

	public ReceiptServiceWrapper() {
		this(null);
	}

	public ReceiptServiceWrapper(ReceiptService receiptService) {
		_receiptService = receiptService;
	}

	@Override
	public io.jetprocess.model.Receipt createReceipt(
			long groupId, long typeId, long tempfileEntryId,
			long deliveryModeId, String nature, java.util.Date receivedOn,
			java.util.Date letterDate, String referenceNumber,
			String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String name, String designation, String mobile, String email,
			String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,
			long userPostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.io.IOException {

		return _receiptService.createReceipt(
			groupId, typeId, tempfileEntryId, deliveryModeId, nature,
			receivedOn, letterDate, referenceNumber, modeNumber,
			receiptCategoryId, receiptSubCategoryId, subject, remarks, name,
			designation, mobile, email, address, countryId, stateId, pinCode,
			organizationId, subOrganizationId, city, userPostId);
	}

	@Override
	public io.jetprocess.model.Receipt deleteReceipt(long receiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptService.deleteReceipt(receiptId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _receiptService.getOSGiServiceIdentifier();
	}

	@Override
	public io.jetprocess.model.Receipt getReceiptByReceiptId(long receiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptService.getReceiptByReceiptId(receiptId);
	}

	@Override
	public io.jetprocess.model.Receipt updateReceipt(
			long receiptId, long groupId, long typeId, long tempfileEntryId,
			String nature, java.util.Date receivedOn, java.util.Date letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String name, String designation, String mobile, String email,
			String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,
			long userPostId, long dmFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.io.IOException {

		return _receiptService.updateReceipt(
			receiptId, groupId, typeId, tempfileEntryId, nature, receivedOn,
			letterDate, referenceNumber, modeNumber, receiptCategoryId,
			receiptSubCategoryId, subject, remarks, name, designation, mobile,
			email, address, countryId, stateId, pinCode, organizationId,
			subOrganizationId, city, userPostId, dmFileId);
	}

	@Override
	public ReceiptService getWrappedService() {
		return _receiptService;
	}

	@Override
	public void setWrappedService(ReceiptService receiptService) {
		_receiptService = receiptService;
	}

	private ReceiptService _receiptService;

}