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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.base.ReceiptLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.Receipt",
	service = AopService.class
)
public class ReceiptLocalServiceImpl extends ReceiptLocalServiceBaseImpl {
	
	public Receipt createReceipt(long groupId,long typeId,long deliveryModeId, Date receivedOn, Date letterDate,
			String referenceNumber,String modeNumber, long receiptCategoryId, long receiptSubCategoryId,
			String subject, String remarks, String document, String name, String designation,
			String mobile, String email, String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,ServiceContext serviceContext) throws PortalException {
		// Get Group(Site) and user Information
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		String number = null;
		// Generate A New Primary Key For The ContactDetails
		long receiptId = counterLocalService.increment(Receipt.class.getName());
		// number=generateReceiptNumber(receiptId);
		System.out.println(receiptId);
		Receipt receipt = createReceipt(receiptId);

		// 1.Update Actual Fields
		receipt.setTypeId(typeId);
		receipt.setDeliveryModeId(deliveryModeId);
		receipt.setReceivedOn(receivedOn);
		receipt.setLetterDate(letterDate);
		receipt.setReferenceNumber(referenceNumber);
		receipt.setModeNumber(modeNumber);
		receipt.setOrganizationId(organizationId);
		receipt.setReceiptCategoryId(receiptCategoryId);
		receipt.setDocument(document);
		receipt.setReceiptSubCategoryId(receiptSubCategoryId);
		receipt.setSubject(subject);
		receipt.setRemarks(remarks);
		receipt.setName(name);
		receipt.setAddress(address);
		receipt.setDesignation(designation);
		receipt.setEmail(email);
		receipt.setMobile(mobile);
		receipt.setCountryId(countryId);
		receipt.setStateId(stateId);
		receipt.setCity(city);	
		receipt.setSubOrganizationId(subOrganizationId);
		receipt.setPinCode(pinCode);
		// 2.Update Audit and Other Generic Fields
		receipt.setGroupId(groupId);
		receipt.setCompanyId(group.getCompanyId());
		receipt.setUserName(user.getScreenName());
		receipt.setUserId(userId);
		receipt.setCreateDate(serviceContext.getCreateDate(new Date()));
		receipt.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		number=generateReceiptNumber(receiptId);
		receipt.setReceiptNumber(number);
		receipt = super.addReceipt(receipt);
		
		return receipt;
	}
	
	public Receipt updateReceipt(long receiptId,long groupId, long typeId,long deliveryModeId, Date receivedOn, Date letterDate,
			String referenceNumber,String modeNumber, long receiptCategoryId, long receiptSubCategoryId,
			String subject, String remarks, String document, String name, String designation,
			String mobile, String email, String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,ServiceContext serviceContext) throws PortalException {
	       Receipt receipt = getReceipt(receiptId);
	       Group group = groupLocalService.getGroup(groupId);
			long userId = serviceContext.getUserId();
			User user = userLocalService.getUser(userId);
	    // 1.Update Actual Fields
			receipt.setTypeId(typeId);
			receipt.setDeliveryModeId(deliveryModeId);
			receipt.setReceivedOn(receivedOn);
			receipt.setLetterDate(letterDate);
			receipt.setReferenceNumber(referenceNumber);
			receipt.setModeNumber(modeNumber);
			receipt.setOrganizationId(organizationId);
			receipt.setReceiptCategoryId(receiptCategoryId);
			receipt.setDocument(document);
			receipt.setReceiptSubCategoryId(receiptSubCategoryId);
			receipt.setSubject(subject);
			receipt.setRemarks(remarks);
			receipt.setName(name);
			receipt.setAddress(address);
			receipt.setDesignation(designation);
			receipt.setEmail(email);
			receipt.setMobile(mobile);
			receipt.setCountryId(countryId);
			receipt.setStateId(stateId);
			receipt.setCity(city);	
			receipt.setSubOrganizationId(subOrganizationId);
			receipt.setPinCode(pinCode);
			// 2.Update Audit and Other Generic Fields
			receipt.setGroupId(groupId);
			receipt.setCompanyId(group.getCompanyId());
			receipt.setUserName(user.getScreenName());
			receipt.setUserId(userId);

			// 2.Update Audit and Other Generic Fields
			
			receipt.setModifiedDate(serviceContext.getModifiedDate(new Date()));
			receipt = super.updateReceipt(receipt);
	        return receipt;
	  
	  }
	
	public Receipt deleteReceipt(Receipt receipt) {
		return super.deleteReceipt(receipt);
	}

	public List<Receipt> getAllReceipt(){
		return super.getReceipts(QueryUtil.ALL_POS, QueryUtil.ALL_POS );
	}

    private String generateReceiptNumber(long receiptId) {
		String receiptNumber = "R"+ receiptId;
		return receiptNumber;

	 }
}