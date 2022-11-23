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

package io.jetprocess.masterdata.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserPost}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPost
 * @generated
 */
public class UserPostWrapper
	extends BaseModelWrapper<UserPost>
	implements ModelWrapper<UserPost>, UserPost {

	public UserPostWrapper(UserPost userPost) {
		super(userPost);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userPostId", getUserPostId());
		attributes.put("groupId", getGroupId());
		attributes.put("postId", getPostId());
		attributes.put("sectionId", getSectionId());
		attributes.put("description", getDescription());
		attributes.put("userName", getUserName());
		attributes.put("shortName", getShortName());
		attributes.put("userId", getUserId());
		attributes.put("postName", getPostName());
		attributes.put("sectionName", getSectionName());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("postMarking", getPostMarking());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userPostId = (Long)attributes.get("userPostId");

		if (userPostId != null) {
			setUserPostId(userPostId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long sectionId = (Long)attributes.get("sectionId");

		if (sectionId != null) {
			setSectionId(sectionId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String postName = (String)attributes.get("postName");

		if (postName != null) {
			setPostName(postName);
		}

		String sectionName = (String)attributes.get("sectionName");

		if (sectionName != null) {
			setSectionName(sectionName);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String postMarking = (String)attributes.get("postMarking");

		if (postMarking != null) {
			setPostMarking(postMarking);
		}
	}

	@Override
	public UserPost cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the department ID of this user post.
	 *
	 * @return the department ID of this user post
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the department name of this user post.
	 *
	 * @return the department name of this user post
	 */
	@Override
	public String getDepartmentName() {
		return model.getDepartmentName();
	}

	/**
	 * Returns the description of this user post.
	 *
	 * @return the description of this user post
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this user post.
	 *
	 * @return the group ID of this user post
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the post ID of this user post.
	 *
	 * @return the post ID of this user post
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the post marking of this user post.
	 *
	 * @return the post marking of this user post
	 */
	@Override
	public String getPostMarking() {
		return model.getPostMarking();
	}

	/**
	 * Returns the post name of this user post.
	 *
	 * @return the post name of this user post
	 */
	@Override
	public String getPostName() {
		return model.getPostName();
	}

	/**
	 * Returns the primary key of this user post.
	 *
	 * @return the primary key of this user post
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the section ID of this user post.
	 *
	 * @return the section ID of this user post
	 */
	@Override
	public long getSectionId() {
		return model.getSectionId();
	}

	/**
	 * Returns the section name of this user post.
	 *
	 * @return the section name of this user post
	 */
	@Override
	public String getSectionName() {
		return model.getSectionName();
	}

	/**
	 * Returns the short name of this user post.
	 *
	 * @return the short name of this user post
	 */
	@Override
	public String getShortName() {
		return model.getShortName();
	}

	/**
	 * Returns the user ID of this user post.
	 *
	 * @return the user ID of this user post
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user post.
	 *
	 * @return the user name of this user post
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user post ID of this user post.
	 *
	 * @return the user post ID of this user post
	 */
	@Override
	public long getUserPostId() {
		return model.getUserPostId();
	}

	/**
	 * Returns the user uuid of this user post.
	 *
	 * @return the user uuid of this user post
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user post.
	 *
	 * @return the uuid of this user post
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the department ID of this user post.
	 *
	 * @param departmentId the department ID of this user post
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the department name of this user post.
	 *
	 * @param departmentName the department name of this user post
	 */
	@Override
	public void setDepartmentName(String departmentName) {
		model.setDepartmentName(departmentName);
	}

	/**
	 * Sets the description of this user post.
	 *
	 * @param description the description of this user post
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this user post.
	 *
	 * @param groupId the group ID of this user post
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the post ID of this user post.
	 *
	 * @param postId the post ID of this user post
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the post marking of this user post.
	 *
	 * @param postMarking the post marking of this user post
	 */
	@Override
	public void setPostMarking(String postMarking) {
		model.setPostMarking(postMarking);
	}

	/**
	 * Sets the post name of this user post.
	 *
	 * @param postName the post name of this user post
	 */
	@Override
	public void setPostName(String postName) {
		model.setPostName(postName);
	}

	/**
	 * Sets the primary key of this user post.
	 *
	 * @param primaryKey the primary key of this user post
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the section ID of this user post.
	 *
	 * @param sectionId the section ID of this user post
	 */
	@Override
	public void setSectionId(long sectionId) {
		model.setSectionId(sectionId);
	}

	/**
	 * Sets the section name of this user post.
	 *
	 * @param sectionName the section name of this user post
	 */
	@Override
	public void setSectionName(String sectionName) {
		model.setSectionName(sectionName);
	}

	/**
	 * Sets the short name of this user post.
	 *
	 * @param shortName the short name of this user post
	 */
	@Override
	public void setShortName(String shortName) {
		model.setShortName(shortName);
	}

	/**
	 * Sets the user ID of this user post.
	 *
	 * @param userId the user ID of this user post
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user post.
	 *
	 * @param userName the user name of this user post
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user post ID of this user post.
	 *
	 * @param userPostId the user post ID of this user post
	 */
	@Override
	public void setUserPostId(long userPostId) {
		model.setUserPostId(userPostId);
	}

	/**
	 * Sets the user uuid of this user post.
	 *
	 * @param userUuid the user uuid of this user post
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user post.
	 *
	 * @param uuid the uuid of this user post
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected UserPostWrapper wrap(UserPost userPost) {
		return new UserPostWrapper(userPost);
	}

}