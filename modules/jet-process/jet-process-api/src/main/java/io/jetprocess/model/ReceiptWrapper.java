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
		attributes.put("type", getType());
		attributes.put("deliveryMode", getDeliveryMode());
		attributes.put("receivedOn", getReceivedOn());
		attributes.put("letterDate", getLetterDate());
		attributes.put("referenceNumber", getReferenceNumber());
		attributes.put("modeNumber", getModeNumber());
		attributes.put("organisation", getOrganisation());
		attributes.put("category", getCategory());
		attributes.put("subCategory", getSubCategory());
		attributes.put("subject", getSubject());
		attributes.put("remarks", getRemarks());
		attributes.put("document", getDocument());
		attributes.put("minDeptOth", getMinDeptOth());
		attributes.put("name", getName());
		attributes.put("designation", getDesignation());
		attributes.put("mobile", getMobile());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("district", getDistrict());
		attributes.put("pinCode", getPinCode());
		attributes.put("receiptNumber", getReceiptNumber());

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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String deliveryMode = (String)attributes.get("deliveryMode");

		if (deliveryMode != null) {
			setDeliveryMode(deliveryMode);
		}

		Date receivedOn = (Date)attributes.get("receivedOn");

		if (receivedOn != null) {
			setReceivedOn(receivedOn);
		}

		Date letterDate = (Date)attributes.get("letterDate");

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

		String organisation = (String)attributes.get("organisation");

		if (organisation != null) {
			setOrganisation(organisation);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String subCategory = (String)attributes.get("subCategory");

		if (subCategory != null) {
			setSubCategory(subCategory);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String document = (String)attributes.get("document");

		if (document != null) {
			setDocument(document);
		}

		String minDeptOth = (String)attributes.get("minDeptOth");

		if (minDeptOth != null) {
			setMinDeptOth(minDeptOth);
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

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String pinCode = (String)attributes.get("pinCode");

		if (pinCode != null) {
			setPinCode(pinCode);
		}

		String receiptNumber = (String)attributes.get("receiptNumber");

		if (receiptNumber != null) {
			setReceiptNumber(receiptNumber);
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
	 * Returns the category of this receipt.
	 *
	 * @return the category of this receipt
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
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
	 * Returns the country of this receipt.
	 *
	 * @return the country of this receipt
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
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
	 * Returns the delivery mode of this receipt.
	 *
	 * @return the delivery mode of this receipt
	 */
	@Override
	public String getDeliveryMode() {
		return model.getDeliveryMode();
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
	 * Returns the district of this receipt.
	 *
	 * @return the district of this receipt
	 */
	@Override
	public String getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the document of this receipt.
	 *
	 * @return the document of this receipt
	 */
	@Override
	public String getDocument() {
		return model.getDocument();
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
	public Date getLetterDate() {
		return model.getLetterDate();
	}

	/**
	 * Returns the min dept oth of this receipt.
	 *
	 * @return the min dept oth of this receipt
	 */
	@Override
	public String getMinDeptOth() {
		return model.getMinDeptOth();
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
	 * Returns the organisation of this receipt.
	 *
	 * @return the organisation of this receipt
	 */
	@Override
	public String getOrganisation() {
		return model.getOrganisation();
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
	 * Returns the received on of this receipt.
	 *
	 * @return the received on of this receipt
	 */
	@Override
	public Date getReceivedOn() {
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
	 * Returns the state of this receipt.
	 *
	 * @return the state of this receipt
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the sub category of this receipt.
	 *
	 * @return the sub category of this receipt
	 */
	@Override
	public String getSubCategory() {
		return model.getSubCategory();
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
	 * Returns the type of this receipt.
	 *
	 * @return the type of this receipt
	 */
	@Override
	public String getType() {
		return model.getType();
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
	 * Sets the category of this receipt.
	 *
	 * @param category the category of this receipt
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
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
	 * Sets the country of this receipt.
	 *
	 * @param country the country of this receipt
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
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
	 * Sets the delivery mode of this receipt.
	 *
	 * @param deliveryMode the delivery mode of this receipt
	 */
	@Override
	public void setDeliveryMode(String deliveryMode) {
		model.setDeliveryMode(deliveryMode);
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
	 * Sets the district of this receipt.
	 *
	 * @param district the district of this receipt
	 */
	@Override
	public void setDistrict(String district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the document of this receipt.
	 *
	 * @param document the document of this receipt
	 */
	@Override
	public void setDocument(String document) {
		model.setDocument(document);
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
	public void setLetterDate(Date letterDate) {
		model.setLetterDate(letterDate);
	}

	/**
	 * Sets the min dept oth of this receipt.
	 *
	 * @param minDeptOth the min dept oth of this receipt
	 */
	@Override
	public void setMinDeptOth(String minDeptOth) {
		model.setMinDeptOth(minDeptOth);
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
	 * Sets the organisation of this receipt.
	 *
	 * @param organisation the organisation of this receipt
	 */
	@Override
	public void setOrganisation(String organisation) {
		model.setOrganisation(organisation);
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
	 * Sets the received on of this receipt.
	 *
	 * @param receivedOn the received on of this receipt
	 */
	@Override
	public void setReceivedOn(Date receivedOn) {
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
	 * Sets the state of this receipt.
	 *
	 * @param state the state of this receipt
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the sub category of this receipt.
	 *
	 * @param subCategory the sub category of this receipt
	 */
	@Override
	public void setSubCategory(String subCategory) {
		model.setSubCategory(subCategory);
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
	 * Sets the type of this receipt.
	 *
	 * @param type the type of this receipt
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
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

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ReceiptWrapper wrap(Receipt receipt) {
		return new ReceiptWrapper(receipt);
	}

}