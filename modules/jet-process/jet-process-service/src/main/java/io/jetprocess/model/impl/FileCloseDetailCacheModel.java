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

import io.jetprocess.model.FileCloseDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FileCloseDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileCloseDetailCacheModel
	implements CacheModel<FileCloseDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileCloseDetailCacheModel)) {
			return false;
		}

		FileCloseDetailCacheModel fileCloseDetailCacheModel =
			(FileCloseDetailCacheModel)object;

		if (fileClosedId == fileCloseDetailCacheModel.fileClosedId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileClosedId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fileClosedId=");
		sb.append(fileClosedId);
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
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", closedBy=");
		sb.append(closedBy);
		sb.append(", closingRemarks=");
		sb.append(closingRemarks);
		sb.append(", reopenDate=");
		sb.append(reopenDate);
		sb.append(", reopenRemarks=");
		sb.append(reopenRemarks);
		sb.append(", closedMovementId=");
		sb.append(closedMovementId);
		sb.append(", reopenBy=");
		sb.append(reopenBy);
		sb.append(", reopenMovementId=");
		sb.append(reopenMovementId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileCloseDetail toEntityModel() {
		FileCloseDetailImpl fileCloseDetailImpl = new FileCloseDetailImpl();

		if (uuid == null) {
			fileCloseDetailImpl.setUuid("");
		}
		else {
			fileCloseDetailImpl.setUuid(uuid);
		}

		fileCloseDetailImpl.setFileClosedId(fileClosedId);
		fileCloseDetailImpl.setGroupId(groupId);
		fileCloseDetailImpl.setCompanyId(companyId);
		fileCloseDetailImpl.setUserId(userId);

		if (userName == null) {
			fileCloseDetailImpl.setUserName("");
		}
		else {
			fileCloseDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fileCloseDetailImpl.setCreateDate(null);
		}
		else {
			fileCloseDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fileCloseDetailImpl.setModifiedDate(null);
		}
		else {
			fileCloseDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		fileCloseDetailImpl.setFileId(fileId);
		fileCloseDetailImpl.setClosedBy(closedBy);

		if (closingRemarks == null) {
			fileCloseDetailImpl.setClosingRemarks("");
		}
		else {
			fileCloseDetailImpl.setClosingRemarks(closingRemarks);
		}

		if (reopenDate == Long.MIN_VALUE) {
			fileCloseDetailImpl.setReopenDate(null);
		}
		else {
			fileCloseDetailImpl.setReopenDate(new Date(reopenDate));
		}

		if (reopenRemarks == null) {
			fileCloseDetailImpl.setReopenRemarks("");
		}
		else {
			fileCloseDetailImpl.setReopenRemarks(reopenRemarks);
		}

		fileCloseDetailImpl.setClosedMovementId(closedMovementId);
		fileCloseDetailImpl.setReopenBy(reopenBy);
		fileCloseDetailImpl.setReopenMovementId(reopenMovementId);

		fileCloseDetailImpl.resetOriginalValues();

		return fileCloseDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fileClosedId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		fileId = objectInput.readLong();

		closedBy = objectInput.readLong();
		closingRemarks = objectInput.readUTF();
		reopenDate = objectInput.readLong();
		reopenRemarks = objectInput.readUTF();

		closedMovementId = objectInput.readLong();

		reopenBy = objectInput.readLong();

		reopenMovementId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fileClosedId);

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

		objectOutput.writeLong(fileId);

		objectOutput.writeLong(closedBy);

		if (closingRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(closingRemarks);
		}

		objectOutput.writeLong(reopenDate);

		if (reopenRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reopenRemarks);
		}

		objectOutput.writeLong(closedMovementId);

		objectOutput.writeLong(reopenBy);

		objectOutput.writeLong(reopenMovementId);
	}

	public String uuid;
	public long fileClosedId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long fileId;
	public long closedBy;
	public String closingRemarks;
	public long reopenDate;
	public String reopenRemarks;
	public long closedMovementId;
	public long reopenBy;
	public long reopenMovementId;

}