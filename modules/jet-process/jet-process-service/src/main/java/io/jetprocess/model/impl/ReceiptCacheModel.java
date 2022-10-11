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

import io.jetprocess.model.Receipt;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Receipt in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReceiptCacheModel implements CacheModel<Receipt>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReceiptCacheModel)) {
			return false;
		}

		ReceiptCacheModel receiptCacheModel = (ReceiptCacheModel)object;

		if (receiptId == receiptCacheModel.receiptId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, receiptId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", receiptId=");
		sb.append(receiptId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", deliveryMode=");
		sb.append(deliveryMode);
		sb.append(", receivedOn=");
		sb.append(receivedOn);
		sb.append(", letterDate=");
		sb.append(letterDate);
		sb.append(", referenceNumber=");
		sb.append(referenceNumber);
		sb.append(", modeNumber=");
		sb.append(modeNumber);
		sb.append(", organisation=");
		sb.append(organisation);
		sb.append(", category=");
		sb.append(category);
		sb.append(", subCategory=");
		sb.append(subCategory);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", document=");
		sb.append(document);
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
		sb.append(", receiptNumber=");
		sb.append(receiptNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Receipt toEntityModel() {
		ReceiptImpl receiptImpl = new ReceiptImpl();

		if (uuid == null) {
			receiptImpl.setUuid("");
		}
		else {
			receiptImpl.setUuid(uuid);
		}

		receiptImpl.setReceiptId(receiptId);
		receiptImpl.setGroupId(groupId);
		receiptImpl.setCompanyId(companyId);
		receiptImpl.setUserId(userId);

		if (userName == null) {
			receiptImpl.setUserName("");
		}
		else {
			receiptImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			receiptImpl.setCreateDate(null);
		}
		else {
			receiptImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			receiptImpl.setModifiedDate(null);
		}
		else {
			receiptImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			receiptImpl.setType("");
		}
		else {
			receiptImpl.setType(type);
		}

		if (deliveryMode == null) {
			receiptImpl.setDeliveryMode("");
		}
		else {
			receiptImpl.setDeliveryMode(deliveryMode);
		}

		if (receivedOn == Long.MIN_VALUE) {
			receiptImpl.setReceivedOn(null);
		}
		else {
			receiptImpl.setReceivedOn(new Date(receivedOn));
		}

		if (letterDate == Long.MIN_VALUE) {
			receiptImpl.setLetterDate(null);
		}
		else {
			receiptImpl.setLetterDate(new Date(letterDate));
		}

		if (referenceNumber == null) {
			receiptImpl.setReferenceNumber("");
		}
		else {
			receiptImpl.setReferenceNumber(referenceNumber);
		}

		if (modeNumber == null) {
			receiptImpl.setModeNumber("");
		}
		else {
			receiptImpl.setModeNumber(modeNumber);
		}

		if (organisation == null) {
			receiptImpl.setOrganisation("");
		}
		else {
			receiptImpl.setOrganisation(organisation);
		}

		if (category == null) {
			receiptImpl.setCategory("");
		}
		else {
			receiptImpl.setCategory(category);
		}

		if (subCategory == null) {
			receiptImpl.setSubCategory("");
		}
		else {
			receiptImpl.setSubCategory(subCategory);
		}

		if (subject == null) {
			receiptImpl.setSubject("");
		}
		else {
			receiptImpl.setSubject(subject);
		}

		if (remarks == null) {
			receiptImpl.setRemarks("");
		}
		else {
			receiptImpl.setRemarks(remarks);
		}

		if (document == null) {
			receiptImpl.setDocument("");
		}
		else {
			receiptImpl.setDocument(document);
		}

		if (minDeptOth == null) {
			receiptImpl.setMinDeptOth("");
		}
		else {
			receiptImpl.setMinDeptOth(minDeptOth);
		}

		if (name == null) {
			receiptImpl.setName("");
		}
		else {
			receiptImpl.setName(name);
		}

		if (designation == null) {
			receiptImpl.setDesignation("");
		}
		else {
			receiptImpl.setDesignation(designation);
		}

		if (mobile == null) {
			receiptImpl.setMobile("");
		}
		else {
			receiptImpl.setMobile(mobile);
		}

		if (email == null) {
			receiptImpl.setEmail("");
		}
		else {
			receiptImpl.setEmail(email);
		}

		if (address == null) {
			receiptImpl.setAddress("");
		}
		else {
			receiptImpl.setAddress(address);
		}

		if (country == null) {
			receiptImpl.setCountry("");
		}
		else {
			receiptImpl.setCountry(country);
		}

		if (state == null) {
			receiptImpl.setState("");
		}
		else {
			receiptImpl.setState(state);
		}

		if (district == null) {
			receiptImpl.setDistrict("");
		}
		else {
			receiptImpl.setDistrict(district);
		}

		if (pinCode == null) {
			receiptImpl.setPinCode("");
		}
		else {
			receiptImpl.setPinCode(pinCode);
		}

		if (receiptNumber == null) {
			receiptImpl.setReceiptNumber("");
		}
		else {
			receiptImpl.setReceiptNumber(receiptNumber);
		}

		receiptImpl.resetOriginalValues();

		return receiptImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		receiptId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readUTF();
		deliveryMode = objectInput.readUTF();
		receivedOn = objectInput.readLong();
		letterDate = objectInput.readLong();
		referenceNumber = objectInput.readUTF();
		modeNumber = objectInput.readUTF();
		organisation = objectInput.readUTF();
		category = objectInput.readUTF();
		subCategory = objectInput.readUTF();
		subject = objectInput.readUTF();
		remarks = objectInput.readUTF();
		document = objectInput.readUTF();
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
		receiptNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(receiptId);

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

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (deliveryMode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deliveryMode);
		}

		objectOutput.writeLong(receivedOn);
		objectOutput.writeLong(letterDate);

		if (referenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referenceNumber);
		}

		if (modeNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modeNumber);
		}

		if (organisation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organisation);
		}

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (subCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subCategory);
		}

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (document == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(document);
		}

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

		if (receiptNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receiptNumber);
		}
	}

	public String uuid;
	public long receiptId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;
	public String deliveryMode;
	public long receivedOn;
	public long letterDate;
	public String referenceNumber;
	public String modeNumber;
	public String organisation;
	public String category;
	public String subCategory;
	public String subject;
	public String remarks;
	public String document;
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
	public String receiptNumber;

}