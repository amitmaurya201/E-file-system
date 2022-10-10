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

package io.jetprocess.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import io.jetprocess.model.ContactDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactDetailCacheModel
	implements CacheModel<ContactDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContactDetailCacheModel)) {
			return false;
		}

		ContactDetailCacheModel contactDetailCacheModel =
			(ContactDetailCacheModel)object;

		if (contactDetailId == contactDetailCacheModel.contactDetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contactDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", contactDetailId=");
		sb.append(contactDetailId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", minDeptOth=");
		sb.append(minDeptOth);
		sb.append(", name=");
		sb.append(name);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", district=");
		sb.append(district);
		sb.append(", pinCode=");
		sb.append(pinCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactDetail toEntityModel() {
		ContactDetailImpl contactDetailImpl = new ContactDetailImpl();

		if (uuid == null) {
			contactDetailImpl.setUuid("");
		}
		else {
			contactDetailImpl.setUuid(uuid);
		}

		contactDetailImpl.setContactDetailId(contactDetailId);
		contactDetailImpl.setGroupId(groupId);
		contactDetailImpl.setCompanyId(companyId);
		contactDetailImpl.setUserId(userId);

		if (userName == null) {
			contactDetailImpl.setUserName("");
		}
		else {
			contactDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactDetailImpl.setCreateDate(null);
		}
		else {
			contactDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactDetailImpl.setModifiedDate(null);
		}
		else {
			contactDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (minDeptOth == null) {
			contactDetailImpl.setMinDeptOth("");
		}
		else {
			contactDetailImpl.setMinDeptOth(minDeptOth);
		}

		if (name == null) {
			contactDetailImpl.setName("");
		}
		else {
			contactDetailImpl.setName(name);
		}

		if (designation == null) {
			contactDetailImpl.setDesignation("");
		}
		else {
			contactDetailImpl.setDesignation(designation);
		}

		if (mobile == null) {
			contactDetailImpl.setMobile("");
		}
		else {
			contactDetailImpl.setMobile(mobile);
		}

		if (email == null) {
			contactDetailImpl.setEmail("");
		}
		else {
			contactDetailImpl.setEmail(email);
		}

		if (address == null) {
			contactDetailImpl.setAddress("");
		}
		else {
			contactDetailImpl.setAddress(address);
		}

		if (country == null) {
			contactDetailImpl.setCountry("");
		}
		else {
			contactDetailImpl.setCountry(country);
		}

		if (state == null) {
			contactDetailImpl.setState("");
		}
		else {
			contactDetailImpl.setState(state);
		}

		if (district == null) {
			contactDetailImpl.setDistrict("");
		}
		else {
			contactDetailImpl.setDistrict(district);
		}

		if (pinCode == null) {
			contactDetailImpl.setPinCode("");
		}
		else {
			contactDetailImpl.setPinCode(pinCode);
		}

		contactDetailImpl.resetOriginalValues();

		return contactDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		contactDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		minDeptOth = objectInput.readUTF();
		name = objectInput.readUTF();
		designation = objectInput.readUTF();
		mobile = objectInput.readUTF();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		country = objectInput.readUTF();
		state = objectInput.readUTF();
		district = objectInput.readUTF();
		pinCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(contactDetailId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (minDeptOth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(minDeptOth);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		if (mobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (country == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (district == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(district);
		}

		if (pinCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pinCode);
		}
	}

	public String uuid;
	public long contactDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String minDeptOth;
	public String name;
	public String designation;
	public String mobile;
	public String email;
	public String address;
	public String country;
	public String state;
	public String district;
	public String pinCode;

}