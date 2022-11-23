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
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String name, String designation, String mobile, String email,
			String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,
			long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptService.createReceipt(
			groupId, typeId, tempfileEntryId, deliveryModeId, receivedOn,
			letterDate, referenceNumber, modeNumber, receiptCategoryId,
			receiptSubCategoryId, subject, remarks, name, designation, mobile,
			email, address, countryId, stateId, pinCode, organizationId,
			subOrganizationId, city, userPostId, serviceContext);
	}

	@Override
	public io.jetprocess.model.Receipt deleteReceipt(long receiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptService.deleteReceipt(receiptId);
	}

	@Override
	public java.util.List<io.jetprocess.model.Receipt> getAllReceipt() {
		return _receiptService.getAllReceipt();
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
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String document, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId,
			String pinCode, long organizationId, long subOrganizationId,
			String city, long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptService.updateReceipt(
			receiptId, groupId, typeId, tempfileEntryId, deliveryModeId,
			receivedOn, letterDate, referenceNumber, modeNumber,
			receiptCategoryId, receiptSubCategoryId, subject, remarks, document,
			name, designation, mobile, email, address, countryId, stateId,
			pinCode, organizationId, subOrganizationId, city, userPostId,
			serviceContext);
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