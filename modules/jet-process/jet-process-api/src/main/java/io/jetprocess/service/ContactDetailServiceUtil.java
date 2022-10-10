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

import io.jetprocess.model.ContactDetail;

import java.util.List;

/**
 * Provides the remote service utility for ContactDetail. This utility wraps
 * <code>io.jetprocess.service.impl.ContactDetailServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetailService
 * @generated
 */
public class ContactDetailServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.ContactDetailServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ContactDetail addContactDetails(
			long groupId, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country,
			String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addContactDetails(
			groupId, minDeptOth, name, designation, mobile, email, address,
			country, state, district, pinCode, serviceContext);
	}

	public static ContactDetail deleteContactDetail(long contactDetailId)
		throws PortalException {

		return getService().deleteContactDetail(contactDetailId);
	}

	public static List<ContactDetail> getContactDetailByGroupId(
		long groupId, int start, int end) {

		return getService().getContactDetailByGroupId(groupId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ContactDetail updateContactDetail(
			long contactDetailId, String minDeptOth, String name,
			String designation, String mobile, String email, String address,
			String country, String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateContactDetail(
			contactDetailId, minDeptOth, name, designation, mobile, email,
			address, country, state, district, pinCode, serviceContext);
	}

	public static ContactDetailService getService() {
		return _service;
	}

	private static volatile ContactDetailService _service;

}