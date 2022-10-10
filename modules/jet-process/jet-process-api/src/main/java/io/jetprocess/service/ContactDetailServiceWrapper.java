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
 * Provides a wrapper for {@link ContactDetailService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetailService
 * @generated
 */
public class ContactDetailServiceWrapper
	implements ContactDetailService, ServiceWrapper<ContactDetailService> {

	public ContactDetailServiceWrapper() {
		this(null);
	}

	public ContactDetailServiceWrapper(
		ContactDetailService contactDetailService) {

		_contactDetailService = contactDetailService;
	}

	@Override
	public io.jetprocess.model.ContactDetail addContactDetails(
			long groupId, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country,
			String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailService.addContactDetails(
			groupId, minDeptOth, name, designation, mobile, email, address,
			country, state, district, pinCode, serviceContext);
	}

	@Override
	public io.jetprocess.model.ContactDetail deleteContactDetail(
			long contactDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailService.deleteContactDetail(contactDetailId);
	}

	@Override
	public java.util.List<io.jetprocess.model.ContactDetail>
		getContactDetailByGroupId(long groupId, int start, int end) {

		return _contactDetailService.getContactDetailByGroupId(
			groupId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactDetailService.getOSGiServiceIdentifier();
	}

	@Override
	public io.jetprocess.model.ContactDetail updateContactDetail(
			long contactDetailId, String minDeptOth, String name,
			String designation, String mobile, String email, String address,
			String country, String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailService.updateContactDetail(
			contactDetailId, minDeptOth, name, designation, mobile, email,
			address, country, state, district, pinCode, serviceContext);
	}

	@Override
	public ContactDetailService getWrappedService() {
		return _contactDetailService;
	}

	@Override
	public void setWrappedService(ContactDetailService contactDetailService) {
		_contactDetailService = contactDetailService;
	}

	private ContactDetailService _contactDetailService;

}