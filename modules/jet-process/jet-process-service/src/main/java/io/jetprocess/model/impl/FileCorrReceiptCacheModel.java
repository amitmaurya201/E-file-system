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

import io.jetprocess.model.FileCorrReceipt;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FileCorrReceipt in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileCorrReceiptCacheModel
	implements CacheModel<FileCorrReceipt>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileCorrReceiptCacheModel)) {
			return false;
		}

		FileCorrReceiptCacheModel fileCorrReceiptCacheModel =
			(FileCorrReceiptCacheModel)object;

		if (fileCorrReceiptId == fileCorrReceiptCacheModel.fileCorrReceiptId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileCorrReceiptId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fileCorrReceiptId=");
		sb.append(fileCorrReceiptId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", docFileId=");
		sb.append(docFileId);
		sb.append(", receiptId=");
		sb.append(receiptId);
		sb.append(", userPostId=");
		sb.append(userPostId);
		sb.append(", receiptMovementId=");
		sb.append(receiptMovementId);
		sb.append(", correspondenceType=");
		sb.append(correspondenceType);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", fileMovementId=");
		sb.append(fileMovementId);
		sb.append(", detachRemark=");
		sb.append(detachRemark);
		sb.append(", detachBy=");
		sb.append(detachBy);
		sb.append(", detachOn=");
		sb.append(detachOn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileCorrReceipt toEntityModel() {
		FileCorrReceiptImpl fileCorrReceiptImpl = new FileCorrReceiptImpl();

		if (uuid == null) {
			fileCorrReceiptImpl.setUuid("");
		}
		else {
			fileCorrReceiptImpl.setUuid(uuid);
		}

		fileCorrReceiptImpl.setFileCorrReceiptId(fileCorrReceiptId);
		fileCorrReceiptImpl.setGroupId(groupId);
		fileCorrReceiptImpl.setCompanyId(companyId);
		fileCorrReceiptImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			fileCorrReceiptImpl.setCreateDate(null);
		}
		else {
			fileCorrReceiptImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fileCorrReceiptImpl.setModifiedDate(null);
		}
		else {
			fileCorrReceiptImpl.setModifiedDate(new Date(modifiedDate));
		}

		fileCorrReceiptImpl.setDocFileId(docFileId);
		fileCorrReceiptImpl.setReceiptId(receiptId);
		fileCorrReceiptImpl.setUserPostId(userPostId);
		fileCorrReceiptImpl.setReceiptMovementId(receiptMovementId);

		if (correspondenceType == null) {
			fileCorrReceiptImpl.setCorrespondenceType("");
		}
		else {
			fileCorrReceiptImpl.setCorrespondenceType(correspondenceType);
		}

		if (remarks == null) {
			fileCorrReceiptImpl.setRemarks("");
		}
		else {
			fileCorrReceiptImpl.setRemarks(remarks);
		}

		fileCorrReceiptImpl.setFileMovementId(fileMovementId);

		if (detachRemark == null) {
			fileCorrReceiptImpl.setDetachRemark("");
		}
		else {
			fileCorrReceiptImpl.setDetachRemark(detachRemark);
		}

		fileCorrReceiptImpl.setDetachBy(detachBy);

		if (detachOn == Long.MIN_VALUE) {
			fileCorrReceiptImpl.setDetachOn(null);
		}
		else {
			fileCorrReceiptImpl.setDetachOn(new Date(detachOn));
		}

		fileCorrReceiptImpl.resetOriginalValues();

		return fileCorrReceiptImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fileCorrReceiptId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		docFileId = objectInput.readLong();

		receiptId = objectInput.readLong();

		userPostId = objectInput.readLong();

		receiptMovementId = objectInput.readLong();
		correspondenceType = objectInput.readUTF();
		remarks = objectInput.readUTF();

		fileMovementId = objectInput.readLong();
		detachRemark = objectInput.readUTF();

		detachBy = objectInput.readLong();
		detachOn = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fileCorrReceiptId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(docFileId);

		objectOutput.writeLong(receiptId);

		objectOutput.writeLong(userPostId);

		objectOutput.writeLong(receiptMovementId);

		if (correspondenceType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(correspondenceType);
		}

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeLong(fileMovementId);

		if (detachRemark == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detachRemark);
		}

		objectOutput.writeLong(detachBy);
		objectOutput.writeLong(detachOn);
	}

	public String uuid;
	public long fileCorrReceiptId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long docFileId;
	public long receiptId;
	public long userPostId;
	public long receiptMovementId;
	public String correspondenceType;
	public String remarks;
	public long fileMovementId;
	public String detachRemark;
	public long detachBy;
	public long detachOn;

}