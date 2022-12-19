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

import io.jetprocess.model.FileCorr;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FileCorr in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileCorrCacheModel
	implements CacheModel<FileCorr>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileCorrCacheModel)) {
			return false;
		}

		FileCorrCacheModel fileCorrCacheModel = (FileCorrCacheModel)object;

		if (fileCorrId == fileCorrCacheModel.fileCorrId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileCorrId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fileCorrId=");
		sb.append(fileCorrId);
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
		sb.append(", correspondenceType=");
		sb.append(correspondenceType);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileCorr toEntityModel() {
		FileCorrImpl fileCorrImpl = new FileCorrImpl();

		if (uuid == null) {
			fileCorrImpl.setUuid("");
		}
		else {
			fileCorrImpl.setUuid(uuid);
		}

		fileCorrImpl.setFileCorrId(fileCorrId);
		fileCorrImpl.setGroupId(groupId);
		fileCorrImpl.setCompanyId(companyId);
		fileCorrImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			fileCorrImpl.setCreateDate(null);
		}
		else {
			fileCorrImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fileCorrImpl.setModifiedDate(null);
		}
		else {
			fileCorrImpl.setModifiedDate(new Date(modifiedDate));
		}

		fileCorrImpl.setDocFileId(docFileId);
		fileCorrImpl.setReceiptId(receiptId);
		fileCorrImpl.setUserPostId(userPostId);

		if (correspondenceType == null) {
			fileCorrImpl.setCorrespondenceType("");
		}
		else {
			fileCorrImpl.setCorrespondenceType(correspondenceType);
		}

		if (remarks == null) {
			fileCorrImpl.setRemarks("");
		}
		else {
			fileCorrImpl.setRemarks(remarks);
		}

		fileCorrImpl.resetOriginalValues();

		return fileCorrImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fileCorrId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		docFileId = objectInput.readLong();

		receiptId = objectInput.readLong();

		userPostId = objectInput.readLong();
		correspondenceType = objectInput.readUTF();
		remarks = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fileCorrId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(docFileId);

		objectOutput.writeLong(receiptId);

		objectOutput.writeLong(userPostId);

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
	}

	public String uuid;
	public long fileCorrId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long docFileId;
	public long receiptId;
	public long userPostId;
	public String correspondenceType;
	public String remarks;

}