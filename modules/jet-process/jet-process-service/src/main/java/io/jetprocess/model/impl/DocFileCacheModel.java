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

import io.jetprocess.model.DocFile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocFile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocFileCacheModel implements CacheModel<DocFile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocFileCacheModel)) {
			return false;
		}

		DocFileCacheModel docFileCacheModel = (DocFileCacheModel)object;

		if (docFileId == docFileCacheModel.docFileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, docFileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", docFileId=");
		sb.append(docFileId);
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
		sb.append(", nature=");
		sb.append(nature);
		sb.append(", type=");
		sb.append(type);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", fileNumber=");
		sb.append(fileNumber);
		sb.append(", category=");
		sb.append(category);
		sb.append(", subCategory=");
		sb.append(subCategory);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", reference=");
		sb.append(reference);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocFile toEntityModel() {
		DocFileImpl docFileImpl = new DocFileImpl();

		if (uuid == null) {
			docFileImpl.setUuid("");
		}
		else {
			docFileImpl.setUuid(uuid);
		}

		docFileImpl.setDocFileId(docFileId);
		docFileImpl.setGroupId(groupId);
		docFileImpl.setCompanyId(companyId);
		docFileImpl.setUserId(userId);

		if (userName == null) {
			docFileImpl.setUserName("");
		}
		else {
			docFileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			docFileImpl.setCreateDate(null);
		}
		else {
			docFileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			docFileImpl.setModifiedDate(null);
		}
		else {
			docFileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nature == null) {
			docFileImpl.setNature("");
		}
		else {
			docFileImpl.setNature(nature);
		}

		if (type == null) {
			docFileImpl.setType("");
		}
		else {
			docFileImpl.setType(type);
		}

		if (subject == null) {
			docFileImpl.setSubject("");
		}
		else {
			docFileImpl.setSubject(subject);
		}

		if (fileNumber == null) {
			docFileImpl.setFileNumber("");
		}
		else {
			docFileImpl.setFileNumber(fileNumber);
		}

		if (category == null) {
			docFileImpl.setCategory("");
		}
		else {
			docFileImpl.setCategory(category);
		}

		if (subCategory == null) {
			docFileImpl.setSubCategory("");
		}
		else {
			docFileImpl.setSubCategory(subCategory);
		}

		if (remarks == null) {
			docFileImpl.setRemarks("");
		}
		else {
			docFileImpl.setRemarks(remarks);
		}

		if (reference == null) {
			docFileImpl.setReference("");
		}
		else {
			docFileImpl.setReference(reference);
		}

		docFileImpl.resetOriginalValues();

		return docFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		docFileId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nature = objectInput.readUTF();
		type = objectInput.readUTF();
		subject = objectInput.readUTF();
		fileNumber = objectInput.readUTF();
		category = objectInput.readUTF();
		subCategory = objectInput.readUTF();
		remarks = objectInput.readUTF();
		reference = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(docFileId);

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

		if (nature == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nature);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (fileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileNumber);
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

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (reference == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reference);
		}
	}

	public String uuid;
	public long docFileId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nature;
	public String type;
	public String subject;
	public String fileNumber;
	public String category;
	public String subCategory;
	public String remarks;
	public String reference;

}