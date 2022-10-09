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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.model.ContactDetail;
import io.jetprocess.service.base.ContactDetailServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=jet_process",
		"json.web.service.context.path=ContactDetail"
	},
	service = AopService.class
)
public class ContactDetailServiceImpl extends ContactDetailServiceBaseImpl {



	public ContactDetail addContactDetails(long groupId, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country, String state, String district, String pinCode,
			ServiceContext serviceContext) throws PortalException {
		return contactDetailLocalService.addContactDetails(groupId, minDeptOth, name, designation, mobile, email,
				address, country, state, district, pinCode, serviceContext);
	}

	public ContactDetail deleteContactDetail(long contactDetailId) throws PortalException {
		ContactDetail contactDetail = contactDetailLocalService.getContactDetail(contactDetailId);
		return contactDetailLocalService.deleteContactDetail(contactDetail);
	}

	public List<ContactDetail> getContactDetailByGroupId(long groupId, int start, int end) {
		return contactDetailLocalService.getContactDetailByGroupId(groupId, start, end);
	}

	public ContactDetail updateContactDetail(long contactDetailId, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country, String state, String district, String pinCode,
			ServiceContext serviceContext) throws PortalException {
		return contactDetailLocalService.updateContactDetail(contactDetailId, minDeptOth, name, designation, mobile,
				email, address, country, state, district, pinCode, serviceContext);
	}

}