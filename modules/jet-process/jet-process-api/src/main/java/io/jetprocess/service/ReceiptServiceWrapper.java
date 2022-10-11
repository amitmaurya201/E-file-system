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
	public io.jetprocess.model.Receipt addReceipt(
			long groupId, String type, String deliveryMode,
			java.util.Date receivedOn, java.util.Date letterDate,
			String referenceNumber, String organisation, String modeNumber,
			String category, String subCategory, String subject, String remarks,
			String document, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country,
			String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptService.addReceipt(
			groupId, type, deliveryMode, receivedOn, letterDate,
			referenceNumber, organisation, modeNumber, category, subCategory,
			subject, remarks, document, minDeptOth, name, designation, mobile,
			email, address, country, state, district, pinCode, serviceContext);
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
	public java.util.List<io.jetprocess.model.Receipt> getReceiptByGroupId(
		long groupId, int start, int end) {

		return _receiptService.getReceiptByGroupId(groupId, start, end);
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