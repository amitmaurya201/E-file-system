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
 * This class is a wrapper for {@link ContactDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetail
 * @generated
 */
public class ContactDetailWrapper
	extends BaseModelWrapper<ContactDetail>
	implements ContactDetail, ModelWrapper<ContactDetail> {

	public ContactDetailWrapper(ContactDetail contactDetail) {
		super(contactDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("contactDetailId", getContactDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long contactDetailId = (Long)attributes.get("contactDetailId");

		if (contactDetailId != null) {
			setContactDetailId(contactDetailId);
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
	}

	@Override
	public ContactDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this contact detail.
	 *
	 * @return the address of this contact detail
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the company ID of this contact detail.
	 *
	 * @return the company ID of this contact detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact detail ID of this contact detail.
	 *
	 * @return the contact detail ID of this contact detail
	 */
	@Override
	public long getContactDetailId() {
		return model.getContactDetailId();
	}

	/**
	 * Returns the country of this contact detail.
	 *
	 * @return the country of this contact detail
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the create date of this contact detail.
	 *
	 * @return the create date of this contact detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation of this contact detail.
	 *
	 * @return the designation of this contact detail
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the district of this contact detail.
	 *
	 * @return the district of this contact detail
	 */
	@Override
	public String getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the email of this contact detail.
	 *
	 * @return the email of this contact detail
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this contact detail.
	 *
	 * @return the group ID of this contact detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the min dept oth of this contact detail.
	 *
	 * @return the min dept oth of this contact detail
	 */
	@Override
	public String getMinDeptOth() {
		return model.getMinDeptOth();
	}

	/**
	 * Returns the mobile of this contact detail.
	 *
	 * @return the mobile of this contact detail
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the modified date of this contact detail.
	 *
	 * @return the modified date of this contact detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this contact detail.
	 *
	 * @return the name of this contact detail
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pin code of this contact detail.
	 *
	 * @return the pin code of this contact detail
	 */
	@Override
	public String getPinCode() {
		return model.getPinCode();
	}

	/**
	 * Returns the primary key of this contact detail.
	 *
	 * @return the primary key of this contact detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this contact detail.
	 *
	 * @return the state of this contact detail
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user ID of this contact detail.
	 *
	 * @return the user ID of this contact detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this contact detail.
	 *
	 * @return the user name of this contact detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this contact detail.
	 *
	 * @return the user uuid of this contact detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this contact detail.
	 *
	 * @return the uuid of this contact detail
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
	 * Sets the address of this contact detail.
	 *
	 * @param address the address of this contact detail
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the company ID of this contact detail.
	 *
	 * @param companyId the company ID of this contact detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact detail ID of this contact detail.
	 *
	 * @param contactDetailId the contact detail ID of this contact detail
	 */
	@Override
	public void setContactDetailId(long contactDetailId) {
		model.setContactDetailId(contactDetailId);
	}

	/**
	 * Sets the country of this contact detail.
	 *
	 * @param country the country of this contact detail
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
	}

	/**
	 * Sets the create date of this contact detail.
	 *
	 * @param createDate the create date of this contact detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation of this contact detail.
	 *
	 * @param designation the designation of this contact detail
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the district of this contact detail.
	 *
	 * @param district the district of this contact detail
	 */
	@Override
	public void setDistrict(String district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the email of this contact detail.
	 *
	 * @param email the email of this contact detail
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this contact detail.
	 *
	 * @param groupId the group ID of this contact detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the min dept oth of this contact detail.
	 *
	 * @param minDeptOth the min dept oth of this contact detail
	 */
	@Override
	public void setMinDeptOth(String minDeptOth) {
		model.setMinDeptOth(minDeptOth);
	}

	/**
	 * Sets the mobile of this contact detail.
	 *
	 * @param mobile the mobile of this contact detail
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the modified date of this contact detail.
	 *
	 * @param modifiedDate the modified date of this contact detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this contact detail.
	 *
	 * @param name the name of this contact detail
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pin code of this contact detail.
	 *
	 * @param pinCode the pin code of this contact detail
	 */
	@Override
	public void setPinCode(String pinCode) {
		model.setPinCode(pinCode);
	}

	/**
	 * Sets the primary key of this contact detail.
	 *
	 * @param primaryKey the primary key of this contact detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this contact detail.
	 *
	 * @param state the state of this contact detail
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user ID of this contact detail.
	 *
	 * @param userId the user ID of this contact detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this contact detail.
	 *
	 * @param userName the user name of this contact detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this contact detail.
	 *
	 * @param userUuid the user uuid of this contact detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this contact detail.
	 *
	 * @param uuid the uuid of this contact detail
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
	protected ContactDetailWrapper wrap(ContactDetail contactDetail) {
		return new ContactDetailWrapper(contactDetail);
	}

}