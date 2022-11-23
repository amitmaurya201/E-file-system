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

package io.jetprocess.masterdata.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import io.jetprocess.masterdata.model.UserPost;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserPost in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserPostCacheModel
	implements CacheModel<UserPost>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserPostCacheModel)) {
			return false;
		}

		UserPostCacheModel userPostCacheModel = (UserPostCacheModel)object;

		if (userPostId == userPostCacheModel.userPostId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userPostId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userPostId=");
		sb.append(userPostId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", postId=");
		sb.append(postId);
		sb.append(", sectionId=");
		sb.append(sectionId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", postName=");
		sb.append(postName);
		sb.append(", sectionName=");
		sb.append(sectionName);
		sb.append(", departmentName=");
		sb.append(departmentName);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", postMarking=");
		sb.append(postMarking);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserPost toEntityModel() {
		UserPostImpl userPostImpl = new UserPostImpl();

		if (uuid == null) {
			userPostImpl.setUuid("");
		}
		else {
			userPostImpl.setUuid(uuid);
		}

		userPostImpl.setUserPostId(userPostId);
		userPostImpl.setGroupId(groupId);
		userPostImpl.setPostId(postId);
		userPostImpl.setSectionId(sectionId);

		if (description == null) {
			userPostImpl.setDescription("");
		}
		else {
			userPostImpl.setDescription(description);
		}

		if (userName == null) {
			userPostImpl.setUserName("");
		}
		else {
			userPostImpl.setUserName(userName);
		}

		if (shortName == null) {
			userPostImpl.setShortName("");
		}
		else {
			userPostImpl.setShortName(shortName);
		}

		userPostImpl.setUserId(userId);

		if (postName == null) {
			userPostImpl.setPostName("");
		}
		else {
			userPostImpl.setPostName(postName);
		}

		if (sectionName == null) {
			userPostImpl.setSectionName("");
		}
		else {
			userPostImpl.setSectionName(sectionName);
		}

		if (departmentName == null) {
			userPostImpl.setDepartmentName("");
		}
		else {
			userPostImpl.setDepartmentName(departmentName);
		}

		userPostImpl.setDepartmentId(departmentId);

		if (postMarking == null) {
			userPostImpl.setPostMarking("");
		}
		else {
			userPostImpl.setPostMarking(postMarking);
		}

		userPostImpl.resetOriginalValues();

		return userPostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userPostId = objectInput.readLong();

		groupId = objectInput.readLong();

		postId = objectInput.readLong();

		sectionId = objectInput.readLong();
		description = objectInput.readUTF();
		userName = objectInput.readUTF();
		shortName = objectInput.readUTF();

		userId = objectInput.readLong();
		postName = objectInput.readUTF();
		sectionName = objectInput.readUTF();
		departmentName = objectInput.readUTF();

		departmentId = objectInput.readLong();
		postMarking = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userPostId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(postId);

		objectOutput.writeLong(sectionId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (shortName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortName);
		}

		objectOutput.writeLong(userId);

		if (postName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postName);
		}

		if (sectionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sectionName);
		}

		if (departmentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(departmentName);
		}

		objectOutput.writeLong(departmentId);

		if (postMarking == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postMarking);
		}
	}

	public String uuid;
	public long userPostId;
	public long groupId;
	public long postId;
	public long sectionId;
	public String description;
	public String userName;
	public String shortName;
	public long userId;
	public String postName;
	public String sectionName;
	public String departmentName;
	public long departmentId;
	public String postMarking;

}