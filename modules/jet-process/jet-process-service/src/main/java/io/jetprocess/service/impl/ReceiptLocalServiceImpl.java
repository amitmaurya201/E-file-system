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
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.ContactDetailLocalService;
import io.jetprocess.service.base.ReceiptLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.Receipt",
	service = AopService.class
)
public class ReceiptLocalServiceImpl extends ReceiptLocalServiceBaseImpl {

	
	public Receipt addReceipt(long groupId, Date createdOn, String type, String deliveryMode, Date receivedOn, Date letterDate, String referenceNumber, String organisation,String modeNumber, String category, String subCategory, String subject, String remarks, String document, long senderId, ServiceContext serviceContext) throws PortalException {
		
		//Get Group(Site) and user Information
		Group group =groupLocalService.getGroup(groupId);
		System.out.println(group);
		long userId=serviceContext.getUserId();
		System.out.println(userId);
		User user=userLocalService.getUser(userId);
		System.out.println(user);
		
		//Generate A New Primary Key For The ContactDetails
		long receiptId=counterLocalService.increment(Receipt.class.getName());
		System.out.println(receiptId);
		Receipt receipt = createReceipt(receiptId);
		
		//1.Update Actual Fields
		receipt.setCreatedOn(createdOn);
		receipt.setType(type);
		receipt.setDeliveryMode(deliveryMode);
		receipt.setReceivedOn(receivedOn);
		receipt.setLetterDate(letterDate);
		receipt.setReferenceNumber(referenceNumber);
		receipt.setModeNumber(modeNumber);
		receipt.setOrganisation(organisation);
		receipt.setCategory(category);
		receipt.setDocument(document);
		receipt.setSubCategory(subCategory);
		receipt.setSubject(subject);
		receipt.setRemarks(remarks);
		//long contactDetailId = counterLocalService.increment(ContactDetail.class.getName());
		receipt.setSenderId(senderId);
		
		//2.Update Audit and Other Generic Fields
		receipt.setGroupId(groupId);
		receipt.setCompanyId(group.getCompanyId());
		receipt.setUserName(user.getScreenName());
		receipt.setUserId(userId);
		receipt.setCreateDate(serviceContext.getCreateDate(new Date()));
		receipt.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		receipt = super.addReceipt(receipt);
		return receipt;
	}
	
	public Receipt deleteReceipt(Receipt receipt) {
		return super.deleteReceipt(receipt);
	}
	
	public List<Receipt> getReceiptByGroupId(long groupId, int start, int end){
		return receiptPersistence.findBygroupId(groupId, start, end);
		
	}
	@Reference
	private ContactDetailLocalService contactDetailLocalService;


}