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

import io.jetprocess.model.FileNote;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FileNote in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileNoteCacheModel
	implements CacheModel<FileNote>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileNoteCacheModel)) {
			return false;
		}

		FileNoteCacheModel fileNoteCacheModel = (FileNoteCacheModel)object;

		if (fileNoteId == fileNoteCacheModel.fileNoteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileNoteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fileNoteId=");
		sb.append(fileNoteId);
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
		sb.append(", fileMovementId=");
		sb.append(fileMovementId);
		sb.append(", noteId=");
		sb.append(noteId);
		sb.append(", movementType=");
		sb.append(movementType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileNote toEntityModel() {
		FileNoteImpl fileNoteImpl = new FileNoteImpl();

		if (uuid == null) {
			fileNoteImpl.setUuid("");
		}
		else {
			fileNoteImpl.setUuid(uuid);
		}

		fileNoteImpl.setFileNoteId(fileNoteId);
		fileNoteImpl.setGroupId(groupId);
		fileNoteImpl.setCompanyId(companyId);
		fileNoteImpl.setUserId(userId);

		if (userName == null) {
			fileNoteImpl.setUserName("");
		}
		else {
			fileNoteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fileNoteImpl.setCreateDate(null);
		}
		else {
			fileNoteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fileNoteImpl.setModifiedDate(null);
		}
		else {
			fileNoteImpl.setModifiedDate(new Date(modifiedDate));
		}

		fileNoteImpl.setFileId(fileId);
		fileNoteImpl.setFileMovementId(fileMovementId);
		fileNoteImpl.setNoteId(noteId);
		fileNoteImpl.setMovementType(movementType);

		fileNoteImpl.resetOriginalValues();

		return fileNoteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fileNoteId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		fileId = objectInput.readLong();

		fileMovementId = objectInput.readLong();

		noteId = objectInput.readLong();

		movementType = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fileNoteId);

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

		objectOutput.writeLong(fileMovementId);

		objectOutput.writeLong(noteId);

		objectOutput.writeLong(movementType);
	}

	public String uuid;
	public long fileNoteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long fileId;
	public long fileMovementId;
	public long noteId;
	public long movementType;

}