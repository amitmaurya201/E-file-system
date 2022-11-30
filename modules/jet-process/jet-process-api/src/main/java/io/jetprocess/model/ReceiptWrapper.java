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

package io.jetprocess.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Receipt}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Receipt
 * @generated
 */
public class ReceiptWrapper
	extends BaseModelWrapper<Receipt>
	implements ModelWrapper<Receipt>, Receipt {

	public ReceiptWrapper(Receipt receipt) {
		super(receipt);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("receiptId", getReceiptId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typeId", getTypeId());
		attributes.put("deliveryModeId", getDeliveryModeId());
		attributes.put("receivedOn", getReceivedOn());
		attributes.put("letterDate", getLetterDate());
		attributes.put("referenceNumber", getReferenceNumber());
		attributes.put("modeNumber", getModeNumber());
		attributes.put("receiptCategoryId", getReceiptCategoryId());
		attributes.put("receiptSubCategoryId", getReceiptSubCategoryId());
		attributes.put("subject", getSubject());
		attributes.put("remarks", getRemarks());
		attributes.put("name", getName());
		attributes.put("designation", getDesignation());
		attributes.put("mobile", getMobile());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("countryId", getCountryId());
		attributes.put("stateId", getStateId());
		attributes.put("pinCode", getPinCode());
		attributes.put("receiptNumber", getReceiptNumber());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("city", getCity());
		attributes.put("subOrganizationId", getSubOrganizationId());
		attributes.put("userPostId", getUserPostId());
		attributes.put("viewPdfUrl", getViewPdfUrl());
		attributes.put("dmFileId", getDmFileId());
		attributes.put("nature", getNature());
		attributes.put("currentlyWith", getCurrentlyWith());
		attributes.put("currentState", getCurrentState());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long receiptId = (Long)attributes.get("receiptId");

		if (receiptId != null) {
			setReceiptId(receiptId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Long deliveryModeId = (Long)attributes.get("deliveryModeId");

		if (deliveryModeId != null) {
			setDeliveryModeId(deliveryModeId);
		}

		String receivedOn = (String)attributes.get("receivedOn");

		if (receivedOn != null) {
			setReceivedOn(receivedOn);
		}

		String letterDate = (String)attributes.get("letterDate");

		if (letterDate != null) {
			setLetterDate(letterDate);
		}

		String referenceNumber = (String)attributes.get("referenceNumber");

		if (referenceNumber != null) {
			setReferenceNumber(referenceNumber);
		}

		String modeNumber = (String)attributes.get("modeNumber");

		if (modeNumber != null) {
			setModeNumber(modeNumber);
		}

		Long receiptCategoryId = (Long)attributes.get("receiptCategoryId");

		if (receiptCategoryId != null) {
			setReceiptCategoryId(receiptCategoryId);
		}

		Long receiptSubCategoryId = (Long)attributes.get(
			"receiptSubCategoryId");

		if (receiptSubCategoryId != null) {
			setReceiptSubCategoryId(receiptSubCategoryId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String pinCode = (String)attributes.get("pinCode");

		if (pinCode != null) {
			setPinCode(pinCode);
		}

		String receiptNumber = (String)attributes.get("receiptNumber");

		if (receiptNumber != null) {
			setReceiptNumber(receiptNumber);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Long subOrganizationId = (Long)attributes.get("subOrganizationId");

		if (subOrganizationId != null) {
			setSubOrganizationId(subOrganizationId);
		}

		Long userPostId = (Long)attributes.get("userPostId");

		if (userPostId != null) {
			setUserPostId(userPostId);
		}

		String viewPdfUrl = (String)attributes.get("viewPdfUrl");

		if (viewPdfUrl != null) {
			setViewPdfUrl(viewPdfUrl);
		}

		Long dmFileId = (Long)attributes.get("dmFileId");

		if (dmFileId != null) {
			setDmFileId(dmFileId);
		}

		String nature = (String)attributes.get("nature");

		if (nature != null) {
			setNature(nature);
		}

		Long currentlyWith = (Long)attributes.get("currentlyWith");

		if (currentlyWith != null) {
			setCurrentlyWith(currentlyWith);
		}

		Integer currentState = (Integer)attributes.get("currentState");

		if (currentState != null) {
			setCurrentState(currentState);
		}
	}

	@Override
	public Receipt cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this receipt.
	 *
	 * @return the address of this receipt
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the city of this receipt.
	 *
	 * @return the city of this receipt
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this receipt.
	 *
	 * @return the company ID of this receipt
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country ID of this receipt.
	 *
	 * @return the country ID of this receipt
	 */
	@Override
	public long getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this receipt.
	 *
	 * @return the create date of this receipt
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currently with of this receipt.
	 *
	 * @return the currently with of this receipt
	 */
	@Override
	public long getCurrentlyWith() {
		return model.getCurrentlyWith();
	}

	/**
	 * Returns the current state of this receipt.
	 *
	 * @return the current state of this receipt
	 */
	@Override
	public int getCurrentState() {
		return model.getCurrentState();
	}

	/**
	 * Returns the delivery mode ID of this receipt.
	 *
	 * @return the delivery mode ID of this receipt
	 */
	@Override
	public long getDeliveryModeId() {
		return model.getDeliveryModeId();
	}

	/**
	 * Returns the designation of this receipt.
	 *
	 * @return the designation of this receipt
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the dm file ID of this receipt.
	 *
	 * @return the dm file ID of this receipt
	 */
	@Override
	public long getDmFileId() {
		return model.getDmFileId();
	}

	/**
	 * Returns the email of this receipt.
	 *
	 * @return the email of this receipt
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this receipt.
	 *
	 * @return the group ID of this receipt
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the letter date of this receipt.
	 *
	 * @return the letter date of this receipt
	 */
	@Override
	public String getLetterDate() {
		return model.getLetterDate();
	}

	/**
	 * Returns the mobile of this receipt.
	 *
	 * @return the mobile of this receipt
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the mode number of this receipt.
	 *
	 * @return the mode number of this receipt
	 */
	@Override
	public String getModeNumber() {
		return model.getModeNumber();
	}

	/**
	 * Returns the modified date of this receipt.
	 *
	 * @return the modified date of this receipt
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this receipt.
	 *
	 * @return the name of this receipt
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nature of this receipt.
	 *
	 * @return the nature of this receipt
	 */
	@Override
	public String getNature() {
		return model.getNature();
	}

	/**
	 * Returns the organization ID of this receipt.
	 *
	 * @return the organization ID of this receipt
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the pin code of this receipt.
	 *
	 * @return the pin code of this receipt
	 */
	@Override
	public String getPinCode() {
		return model.getPinCode();
	}

	/**
	 * Returns the primary key of this receipt.
	 *
	 * @return the primary key of this receipt
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receipt category ID of this receipt.
	 *
	 * @return the receipt category ID of this receipt
	 */
	@Override
	public long getReceiptCategoryId() {
		return model.getReceiptCategoryId();
	}

	/**
	 * Returns the receipt ID of this receipt.
	 *
	 * @return the receipt ID of this receipt
	 */
	@Override
	public long getReceiptId() {
		return model.getReceiptId();
	}

	/**
	 * Returns the receipt number of this receipt.
	 *
	 * @return the receipt number of this receipt
	 */
	@Override
	public String getReceiptNumber() {
		return model.getReceiptNumber();
	}

	/**
	 * Returns the receipt sub category ID of this receipt.
	 *
	 * @return the receipt sub category ID of this receipt
	 */
	@Override
	public long getReceiptSubCategoryId() {
		return model.getReceiptSubCategoryId();
	}

	/**
	 * Returns the received on of this receipt.
	 *
	 * @return the received on of this receipt
	 */
	@Override
	public String getReceivedOn() {
		return model.getReceivedOn();
	}

	/**
	 * Returns the reference number of this receipt.
	 *
	 * @return the reference number of this receipt
	 */
	@Override
	public String getReferenceNumber() {
		return model.getReferenceNumber();
	}

	/**
	 * Returns the remarks of this receipt.
	 *
	 * @return the remarks of this receipt
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the state ID of this receipt.
	 *
	 * @return the state ID of this receipt
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the subject of this receipt.
	 *
	 * @return the subject of this receipt
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the sub organization ID of this receipt.
	 *
	 * @return the sub organization ID of this receipt
	 */
	@Override
	public long getSubOrganizationId() {
		return model.getSubOrganizationId();
	}

	/**
	 * Returns the type ID of this receipt.
	 *
	 * @return the type ID of this receipt
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the user ID of this receipt.
	 *
	 * @return the user ID of this receipt
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this receipt.
	 *
	 * @return the user name of this receipt
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user post ID of this receipt.
	 *
	 * @return the user post ID of this receipt
	 */
	@Override
	public long getUserPostId() {
		return model.getUserPostId();
	}

	/**
	 * Returns the user uuid of this receipt.
	 *
	 * @return the user uuid of this receipt
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this receipt.
	 *
	 * @return the uuid of this receipt
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the view pdf url of this receipt.
	 *
	 * @return the view pdf url of this receipt
	 */
	@Override
	public String getViewPdfUrl() {
		return model.getViewPdfUrl();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this receipt.
	 *
	 * @param address the address of this receipt
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the city of this receipt.
	 *
	 * @param city the city of this receipt
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this receipt.
	 *
	 * @param companyId the company ID of this receipt
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country ID of this receipt.
	 *
	 * @param countryId the country ID of this receipt
	 */
	@Override
	public void setCountryId(long countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this receipt.
	 *
	 * @param createDate the create date of this receipt
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currently with of this receipt.
	 *
	 * @param currentlyWith the currently with of this receipt
	 */
	@Override
	public void setCurrentlyWith(long currentlyWith) {
		model.setCurrentlyWith(currentlyWith);
	}

	/**
	 * Sets the current state of this receipt.
	 *
	 * @param currentState the current state of this receipt
	 */
	@Override
	public void setCurrentState(int currentState) {
		model.setCurrentState(currentState);
	}

	/**
	 * Sets the delivery mode ID of this receipt.
	 *
	 * @param deliveryModeId the delivery mode ID of this receipt
	 */
	@Override
	public void setDeliveryModeId(long deliveryModeId) {
		model.setDeliveryModeId(deliveryModeId);
	}

	/**
	 * Sets the designation of this receipt.
	 *
	 * @param designation the designation of this receipt
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the dm file ID of this receipt.
	 *
	 * @param dmFileId the dm file ID of this receipt
	 */
	@Override
	public void setDmFileId(long dmFileId) {
		model.setDmFileId(dmFileId);
	}

	/**
	 * Sets the email of this receipt.
	 *
	 * @param email the email of this receipt
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this receipt.
	 *
	 * @param groupId the group ID of this receipt
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the letter date of this receipt.
	 *
	 * @param letterDate the letter date of this receipt
	 */
	@Override
	public void setLetterDate(String letterDate) {
		model.setLetterDate(letterDate);
	}

	/**
	 * Sets the mobile of this receipt.
	 *
	 * @param mobile the mobile of this receipt
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the mode number of this receipt.
	 *
	 * @param modeNumber the mode number of this receipt
	 */
	@Override
	public void setModeNumber(String modeNumber) {
		model.setModeNumber(modeNumber);
	}

	/**
	 * Sets the modified date of this receipt.
	 *
	 * @param modifiedDate the modified date of this receipt
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this receipt.
	 *
	 * @param name the name of this receipt
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the nature of this receipt.
	 *
	 * @param nature the nature of this receipt
	 */
	@Override
	public void setNature(String nature) {
		model.setNature(nature);
	}

	/**
	 * Sets the organization ID of this receipt.
	 *
	 * @param organizationId the organization ID of this receipt
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the pin code of this receipt.
	 *
	 * @param pinCode the pin code of this receipt
	 */
	@Override
	public void setPinCode(String pinCode) {
		model.setPinCode(pinCode);
	}

	/**
	 * Sets the primary key of this receipt.
	 *
	 * @param primaryKey the primary key of this receipt
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receipt category ID of this receipt.
	 *
	 * @param receiptCategoryId the receipt category ID of this receipt
	 */
	@Override
	public void setReceiptCategoryId(long receiptCategoryId) {
		model.setReceiptCategoryId(receiptCategoryId);
	}

	/**
	 * Sets the receipt ID of this receipt.
	 *
	 * @param receiptId the receipt ID of this receipt
	 */
	@Override
	public void setReceiptId(long receiptId) {
		model.setReceiptId(receiptId);
	}

	/**
	 * Sets the receipt number of this receipt.
	 *
	 * @param receiptNumber the receipt number of this receipt
	 */
	@Override
	public void setReceiptNumber(String receiptNumber) {
		model.setReceiptNumber(receiptNumber);
	}

	/**
	 * Sets the receipt sub category ID of this receipt.
	 *
	 * @param receiptSubCategoryId the receipt sub category ID of this receipt
	 */
	@Override
	public void setReceiptSubCategoryId(long receiptSubCategoryId) {
		model.setReceiptSubCategoryId(receiptSubCategoryId);
	}

	/**
	 * Sets the received on of this receipt.
	 *
	 * @param receivedOn the received on of this receipt
	 */
	@Override
	public void setReceivedOn(String receivedOn) {
		model.setReceivedOn(receivedOn);
	}

	/**
	 * Sets the reference number of this receipt.
	 *
	 * @param referenceNumber the reference number of this receipt
	 */
	@Override
	public void setReferenceNumber(String referenceNumber) {
		model.setReferenceNumber(referenceNumber);
	}

	/**
	 * Sets the remarks of this receipt.
	 *
	 * @param remarks the remarks of this receipt
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the state ID of this receipt.
	 *
	 * @param stateId the state ID of this receipt
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the subject of this receipt.
	 *
	 * @param subject the subject of this receipt
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the sub organization ID of this receipt.
	 *
	 * @param subOrganizationId the sub organization ID of this receipt
	 */
	@Override
	public void setSubOrganizationId(long subOrganizationId) {
		model.setSubOrganizationId(subOrganizationId);
	}

	/**
	 * Sets the type ID of this receipt.
	 *
	 * @param typeId the type ID of this receipt
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the user ID of this receipt.
	 *
	 * @param userId the user ID of this receipt
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this receipt.
	 *
	 * @param userName the user name of this receipt
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user post ID of this receipt.
	 *
	 * @param userPostId the user post ID of this receipt
	 */
	@Override
	public void setUserPostId(long userPostId) {
		model.setUserPostId(userPostId);
	}

	/**
	 * Sets the user uuid of this receipt.
	 *
	 * @param userUuid the user uuid of this receipt
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this receipt.
	 *
	 * @param uuid the uuid of this receipt
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the view pdf url of this receipt.
	 *
	 * @param viewPdfUrl the view pdf url of this receipt
	 */
	@Override
	public void setViewPdfUrl(String viewPdfUrl) {
		model.setViewPdfUrl(viewPdfUrl);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ReceiptWrapper wrap(Receipt receipt) {
		return new ReceiptWrapper(receipt);
	}

}