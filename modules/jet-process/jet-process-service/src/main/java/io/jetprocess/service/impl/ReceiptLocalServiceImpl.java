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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.docstore.DocStore;
import io.jetprocess.exception.NoSuchReceiptException;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.base.ReceiptLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.Receipt", service = AopService.class)
public class ReceiptLocalServiceImpl extends ReceiptLocalServiceBaseImpl {

	public Receipt createReceipt(long groupId, long typeId, long tempfileEntryId, long deliveryModeId,String nature,
			String receivedOn, String letterDate, String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId, String pinCode, long organizationId,
			long subOrganizationId, String city, long userPostId)
			throws PortalException, IOException {
		// Get Group(Site) and user Information
		Group group = groupLocalService.getGroup(groupId);
		String receiptNumber =null;
		
		long receiptId = counterLocalService.increment(Receipt.class.getName());
		Receipt receipt = createReceipt(receiptId);
		if (subject.isEmpty() || name.isEmpty() || address.isEmpty() || designation.isEmpty()) {
			return null;
		}
		 
		if (tempfileEntryId != 0) {
			long dmFileId = receiptLocalService.getDmFileId(tempfileEntryId, groupId);
			String viewFileUrl = docstore.ViewDocumentAndMediaFile(dmFileId);
			receipt.setViewPdfUrl(viewFileUrl);
			receipt.setDmFileId(dmFileId);
		}
		if (nature.equals("Electronic")) {
			if (tempfileEntryId == 0) {
				return null;
			}
		}
		receipt.setTypeId(typeId);
		receipt.setDeliveryModeId(deliveryModeId);
		receipt.setReceivedOn(receivedOn);
		receipt.setLetterDate(letterDate);
		receipt.setReferenceNumber(referenceNumber);
		receipt.setModeNumber(modeNumber);
		receipt.setOrganizationId(organizationId);
		receipt.setReceiptCategoryId(receiptCategoryId);
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
		receipt.setNature(nature);
		receipt.setSubOrganizationId(subOrganizationId);
		receipt.setPinCode(pinCode);
		receipt.setGroupId(groupId);
		receipt.setCompanyId(group.getCompanyId());
		receiptNumber = generateReceiptNumber(receiptId);
		receipt.setReceiptNumber(receiptNumber);
		receipt.setUserPostId(userPostId);
		receipt.setCurrentState(FileStatus.CREADTED);
		receipt.setCurrentlyWith(userPostId);
		receipt = super.addReceipt(receipt);
		return receipt;
	}

	public Receipt updateReceipt(long receiptId,long groupId, long typeId, long tempfileEntryId,String nature,
			String receivedOn, String letterDate, String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId, String pinCode, long organizationId,
			long subOrganizationId, String city, long userPostId)
			throws PortalException, IOException {
		Receipt receipt = getReceipt(receiptId);
		System.out.println("receipt132763"+receipt);
		long dmFileId = 0l;
		String viewFileUrl = null;

		receipt.setTypeId(typeId);
		receipt.setReceivedOn(receivedOn);
		receipt.setLetterDate(letterDate);
		receipt.setReferenceNumber(referenceNumber);
		receipt.setModeNumber(modeNumber);
		receipt.setOrganizationId(organizationId);
		receipt.setReceiptCategoryId(receiptCategoryId);
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
		receipt.setUserPostId(userPostId);
		if (tempfileEntryId != 0) {
			dmFileId = receiptLocalService.getDmFileId(tempfileEntryId, groupId);
			viewFileUrl = docstore.ViewDocumentAndMediaFile(dmFileId);
			receipt.setViewPdfUrl(viewFileUrl);
			receipt.setDmFileId(dmFileId);
		} else {
			if (nature.equals("Electronic")) {
				receipt.setDmFileId(receipt.getDmFileId());
				receipt.setViewPdfUrl(receipt.getViewPdfUrl());
			} else {
				receipt.setViewPdfUrl("");
				receipt.setDmFileId(0);
			}
		}
		receipt = super.updateReceipt(receipt);
		return receipt;

	}
	

	public String generateReceiptNumber(long receiptId) {
		String receiptNumber = "R" + receiptId;
		return receiptNumber;

	}

	public long getDmFileId(long tempFileId, long groupId) throws PortalException, IOException {

		String changeLog = "docStore";
		FileEntry fileEntry = docstore.getTempFile(tempFileId);
		String title = fileEntry.getFileName();
		InputStream is = fileEntry.getContentStream();
		String mimeType = fileEntry.getMimeType();
		long documentAndMediaFileId = docstore.documentAndMediaFileUpload(groupId, is, title, mimeType, changeLog, 0l,
				"");
		docstore.deleteTempFile(tempFileId);
		return documentAndMediaFileId;
	}

	public Boolean isSendAvailable(long userPostId, long receiptId) throws PortalException {
		boolean state = false;
		Receipt receipt = getReceipt(receiptId);
		if (userPostId == receipt.getCurrentlyWith()) {
			state = true;
		} else {
			state = false;
		}
		return state;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	@Reference
	private DocStore docstore;
}
