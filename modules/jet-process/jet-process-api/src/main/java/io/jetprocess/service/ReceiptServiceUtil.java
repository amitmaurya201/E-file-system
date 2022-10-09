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

import com.liferay.portal.kernel.exception.PortalException;

import io.jetprocess.model.Receipt;

import java.util.List;

/**
 * Provides the remote service utility for Receipt. This utility wraps
 * <code>io.jetprocess.service.impl.ReceiptServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptService
 * @generated
 */
public class ReceiptServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.ReceiptServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Receipt addReceipt(
			long groupId, java.util.Date createdOn, String type,
			String deliveryMode, java.util.Date receivedOn,
			java.util.Date letterDate, String referenceNumber,
			String organisation, String modeNumber, String category,
			String subCategory, String subject, String remarks, String document,
			long senderId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addReceipt(
			groupId, createdOn, type, deliveryMode, receivedOn, letterDate,
			referenceNumber, organisation, modeNumber, category, subCategory,
			subject, remarks, document, senderId, serviceContext);
	}

	public static Receipt deleteReceipt(long receiptId) throws PortalException {
		return getService().deleteReceipt(receiptId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Receipt> getReceiptByGroupId(
		long groupId, int start, int end) {

		return getService().getReceiptByGroupId(groupId, start, end);
	}

	public static ReceiptService getService() {
		return _service;
	}

	private static volatile ReceiptService _service;

}