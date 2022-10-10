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
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.model.ContactDetail;
import io.jetprocess.service.base.ContactDetailLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.ContactDetail",
	service = AopService.class
)
public class ContactDetailLocalServiceImpl
	extends ContactDetailLocalServiceBaseImpl {


	
public ContactDetail addContactDetails(long groupId, String minDeptOth, String name, String designation, String mobile, String email, String address, String country, String state, String district, String pinCode, ServiceContext serviceContext) throws PortalException {
		
		//Get Group(Site) and user Information
		Group group =groupLocalService.getGroup(groupId);
		System.out.println(group);
		long userId=serviceContext.getUserId();
		System.out.println(userId);
		User user=userLocalService.getUser(userId);
		System.out.println(user);
		
		//Generate A New Primary Key For The ContactDetails
		long contactDetailId=counterLocalService.increment(ContactDetail.class.getName());
		System.out.println(contactDetailId);
		ContactDetail contactDetail = createContactDetail(contactDetailId);
		
		//1.Update Actual Fields
		contactDetail.setName(name);
		contactDetail.setAddress(address);
		contactDetail.setDesignation(designation);
		contactDetail.setEmail(email);
		contactDetail.setMobile(mobile);
		contactDetail.setCountry(country);
		contactDetail.setState(state);
		contactDetail.setDistrict(district);
		contactDetail.setPinCode(pinCode);
		
		//2.Update Audit and Other Generic Fields
		contactDetail.setGroupId(groupId);
		contactDetail.setCompanyId(group.getCompanyId());
		contactDetail.setCreateDate(serviceContext.getCreateDate(new Date()));
		contactDetail.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		contactDetail.setUserId(userId);
		contactDetail.setUserName(user.getScreenName());
		contactDetail=super.addContactDetail(contactDetail);
		
		return contactDetail;
	}
	
    public ContactDetail deleteContactDetail(ContactDetail contactDetail) {
	 return super.deleteContactDetail(contactDetail);
    }



	public ContactDetail updateContactDetail(long contactDetailId, String minDeptOth, String name, String designation, String mobile, String email, String address, String country, String state, String district, String pinCode, ServiceContext serviceContext) throws PortalException {
		ContactDetail contactDetail = getContactDetail(contactDetailId);
		contactDetail.setName(name);
		contactDetail.setAddress(address);
		contactDetail.setCountry(country);
		contactDetail.setState(state);
		contactDetail.setEmail(email);
		contactDetail.setMobile(mobile);
		contactDetail.setMinDeptOth(minDeptOth);
		contactDetail.setDistrict(district);
		contactDetail.setDesignation(designation);
		contactDetail.setPinCode(pinCode);
		contactDetail.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		contactDetail = super.updateContactDetail(contactDetail);
		
		return contactDetail;
		
	}

	public List<ContactDetail> getContactDetailByGroupId(long groupId, int start, int end){
		return contactDetailPersistence.findByGroupId(groupId, start, end);
		
	}






}