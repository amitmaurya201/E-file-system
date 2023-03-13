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

import io.jetprocess.model.NoteDocMovement;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NoteDocMovement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NoteDocMovementCacheModel
	implements CacheModel<NoteDocMovement>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NoteDocMovementCacheModel)) {
			return false;
		}

		NoteDocMovementCacheModel noteDocMovementCacheModel =
			(NoteDocMovementCacheModel)object;

		if (movementId == noteDocMovementCacheModel.movementId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, movementId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", movementId=");
		sb.append(movementId);
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
		sb.append(", receiverId=");
		sb.append(receiverId);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", noteDocumentId=");
		sb.append(noteDocumentId);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NoteDocMovement toEntityModel() {
		NoteDocMovementImpl noteDocMovementImpl = new NoteDocMovementImpl();

		if (uuid == null) {
			noteDocMovementImpl.setUuid("");
		}
		else {
			noteDocMovementImpl.setUuid(uuid);
		}

		noteDocMovementImpl.setMovementId(movementId);
		noteDocMovementImpl.setGroupId(groupId);
		noteDocMovementImpl.setCompanyId(companyId);
		noteDocMovementImpl.setUserId(userId);

		if (userName == null) {
			noteDocMovementImpl.setUserName("");
		}
		else {
			noteDocMovementImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			noteDocMovementImpl.setCreateDate(null);
		}
		else {
			noteDocMovementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			noteDocMovementImpl.setModifiedDate(null);
		}
		else {
			noteDocMovementImpl.setModifiedDate(new Date(modifiedDate));
		}

		noteDocMovementImpl.setReceiverId(receiverId);
		noteDocMovementImpl.setSenderId(senderId);
		noteDocMovementImpl.setNoteDocumentId(noteDocumentId);

		if (remarks == null) {
			noteDocMovementImpl.setRemarks("");
		}
		else {
			noteDocMovementImpl.setRemarks(remarks);
		}

		noteDocMovementImpl.setActive(active);

		noteDocMovementImpl.resetOriginalValues();

		return noteDocMovementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		movementId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		receiverId = objectInput.readLong();

		senderId = objectInput.readLong();

		noteDocumentId = objectInput.readLong();
		remarks = objectInput.readUTF();

		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(movementId);

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

		objectOutput.writeLong(receiverId);

		objectOutput.writeLong(senderId);

		objectOutput.writeLong(noteDocumentId);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeBoolean(active);
	}

	public String uuid;
	public long movementId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long receiverId;
	public long senderId;
	public long noteDocumentId;
	public String remarks;
	public boolean active;

}