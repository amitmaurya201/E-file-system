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

		if (userPostId.equals(userPostCacheModel.userPostId)) {
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
		StringBundler sb = new StringBundler(13);

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

		if (userPostId == null) {
			userPostImpl.setUserPostId("");
		}
		else {
			userPostImpl.setUserPostId(userPostId);
		}

		userPostImpl.setGroupId(groupId);
		userPostImpl.setPostId(postId);
		userPostImpl.setSectionId(sectionId);
		userPostImpl.setDescription(description);

		userPostImpl.resetOriginalValues();

		return userPostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userPostId = objectInput.readUTF();

		groupId = objectInput.readLong();

		postId = objectInput.readLong();

		sectionId = objectInput.readLong();

		description = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (userPostId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userPostId);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(postId);

		objectOutput.writeLong(sectionId);

		objectOutput.writeLong(description);
	}

	public String uuid;
	public String userPostId;
	public long groupId;
	public long postId;
	public long sectionId;
	public long description;

}