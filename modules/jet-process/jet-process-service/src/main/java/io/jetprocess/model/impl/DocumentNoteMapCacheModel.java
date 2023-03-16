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

import io.jetprocess.model.DocumentNoteMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocumentNoteMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentNoteMapCacheModel
	implements CacheModel<DocumentNoteMap>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentNoteMapCacheModel)) {
			return false;
		}

		DocumentNoteMapCacheModel documentNoteMapCacheModel =
			(DocumentNoteMapCacheModel)object;

		if (documentNoteMapId == documentNoteMapCacheModel.documentNoteMapId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentNoteMapId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", documentNoteMapId=");
		sb.append(documentNoteMapId);
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
		sb.append(", noteDocumentId=");
		sb.append(noteDocumentId);
		sb.append(", noteId=");
		sb.append(noteId);
		sb.append(", movementId=");
		sb.append(movementId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentNoteMap toEntityModel() {
		DocumentNoteMapImpl documentNoteMapImpl = new DocumentNoteMapImpl();

		if (uuid == null) {
			documentNoteMapImpl.setUuid("");
		}
		else {
			documentNoteMapImpl.setUuid(uuid);
		}

		documentNoteMapImpl.setDocumentNoteMapId(documentNoteMapId);
		documentNoteMapImpl.setGroupId(groupId);
		documentNoteMapImpl.setCompanyId(companyId);
		documentNoteMapImpl.setUserId(userId);

		if (userName == null) {
			documentNoteMapImpl.setUserName("");
		}
		else {
			documentNoteMapImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			documentNoteMapImpl.setCreateDate(null);
		}
		else {
			documentNoteMapImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentNoteMapImpl.setModifiedDate(null);
		}
		else {
			documentNoteMapImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentNoteMapImpl.setNoteDocumentId(noteDocumentId);
		documentNoteMapImpl.setNoteId(noteId);
		documentNoteMapImpl.setMovementId(movementId);

		documentNoteMapImpl.resetOriginalValues();

		return documentNoteMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		documentNoteMapId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		noteDocumentId = objectInput.readLong();

		noteId = objectInput.readLong();

		movementId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(documentNoteMapId);

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

		objectOutput.writeLong(noteDocumentId);

		objectOutput.writeLong(noteId);

		objectOutput.writeLong(movementId);
	}

	public String uuid;
	public long documentNoteMapId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long noteDocumentId;
	public long noteId;
	public long movementId;

}