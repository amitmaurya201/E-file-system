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

package io.jetprocess.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Note}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Note
 * @generated
 */
public class NoteWrapper
	extends BaseModelWrapper<Note> implements ModelWrapper<Note>, Note {

	public NoteWrapper(Note note) {
		super(note);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("noteId", getNoteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("content", getContent());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("signature", getSignature());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String signature = (String)attributes.get("signature");

		if (signature != null) {
			setSignature(signature);
		}
	}

	@Override
	public Note cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this note.
	 *
	 * @return the company ID of this note
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this note.
	 *
	 * @return the content of this note
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this note.
	 *
	 * @return the create date of this note
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this note.
	 *
	 * @return the created by of this note
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this note.
	 *
	 * @return the group ID of this note
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this note.
	 *
	 * @return the modified date of this note
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note ID of this note.
	 *
	 * @return the note ID of this note
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the primary key of this note.
	 *
	 * @return the primary key of this note
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the signature of this note.
	 *
	 * @return the signature of this note
	 */
	@Override
	public String getSignature() {
		return model.getSignature();
	}

	/**
	 * Returns the user ID of this note.
	 *
	 * @return the user ID of this note
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this note.
	 *
	 * @return the user name of this note
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this note.
	 *
	 * @return the user uuid of this note
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this note.
	 *
	 * @return the uuid of this note
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
	 * Sets the company ID of this note.
	 *
	 * @param companyId the company ID of this note
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this note.
	 *
	 * @param content the content of this note
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this note.
	 *
	 * @param createDate the create date of this note
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this note.
	 *
	 * @param createdBy the created by of this note
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this note.
	 *
	 * @param groupId the group ID of this note
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this note.
	 *
	 * @param modifiedDate the modified date of this note
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note ID of this note.
	 *
	 * @param noteId the note ID of this note
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the primary key of this note.
	 *
	 * @param primaryKey the primary key of this note
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the signature of this note.
	 *
	 * @param signature the signature of this note
	 */
	@Override
	public void setSignature(String signature) {
		model.setSignature(signature);
	}

	/**
	 * Sets the user ID of this note.
	 *
	 * @param userId the user ID of this note
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this note.
	 *
	 * @param userName the user name of this note
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this note.
	 *
	 * @param userUuid the user uuid of this note
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this note.
	 *
	 * @param uuid the uuid of this note
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected NoteWrapper wrap(Note note) {
		return new NoteWrapper(note);
	}

}