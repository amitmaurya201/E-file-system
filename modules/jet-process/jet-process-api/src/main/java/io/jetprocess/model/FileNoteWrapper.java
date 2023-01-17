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
 * This class is a wrapper for {@link FileNote}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileNote
 * @generated
 */
public class FileNoteWrapper
	extends BaseModelWrapper<FileNote>
	implements FileNote, ModelWrapper<FileNote> {

	public FileNoteWrapper(FileNote fileNote) {
		super(fileNote);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fileNoteId", getFileNoteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileId", getFileId());
		attributes.put("fileMovementId", getFileMovementId());
		attributes.put("noteId", getNoteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fileNoteId = (Long)attributes.get("fileNoteId");

		if (fileNoteId != null) {
			setFileNoteId(fileNoteId);
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

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Long fileMovementId = (Long)attributes.get("fileMovementId");

		if (fileMovementId != null) {
			setFileMovementId(fileMovementId);
		}

		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
		}
	}

	@Override
	public FileNote cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this file note.
	 *
	 * @return the company ID of this file note
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this file note.
	 *
	 * @return the create date of this file note
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the file ID of this file note.
	 *
	 * @return the file ID of this file note
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the file movement ID of this file note.
	 *
	 * @return the file movement ID of this file note
	 */
	@Override
	public long getFileMovementId() {
		return model.getFileMovementId();
	}

	/**
	 * Returns the file note ID of this file note.
	 *
	 * @return the file note ID of this file note
	 */
	@Override
	public long getFileNoteId() {
		return model.getFileNoteId();
	}

	/**
	 * Returns the group ID of this file note.
	 *
	 * @return the group ID of this file note
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this file note.
	 *
	 * @return the modified date of this file note
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note ID of this file note.
	 *
	 * @return the note ID of this file note
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the primary key of this file note.
	 *
	 * @return the primary key of this file note
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this file note.
	 *
	 * @return the user ID of this file note
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this file note.
	 *
	 * @return the user name of this file note
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this file note.
	 *
	 * @return the user uuid of this file note
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this file note.
	 *
	 * @return the uuid of this file note
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
	 * Sets the company ID of this file note.
	 *
	 * @param companyId the company ID of this file note
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this file note.
	 *
	 * @param createDate the create date of this file note
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the file ID of this file note.
	 *
	 * @param fileId the file ID of this file note
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the file movement ID of this file note.
	 *
	 * @param fileMovementId the file movement ID of this file note
	 */
	@Override
	public void setFileMovementId(long fileMovementId) {
		model.setFileMovementId(fileMovementId);
	}

	/**
	 * Sets the file note ID of this file note.
	 *
	 * @param fileNoteId the file note ID of this file note
	 */
	@Override
	public void setFileNoteId(long fileNoteId) {
		model.setFileNoteId(fileNoteId);
	}

	/**
	 * Sets the group ID of this file note.
	 *
	 * @param groupId the group ID of this file note
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this file note.
	 *
	 * @param modifiedDate the modified date of this file note
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note ID of this file note.
	 *
	 * @param noteId the note ID of this file note
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the primary key of this file note.
	 *
	 * @param primaryKey the primary key of this file note
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this file note.
	 *
	 * @param userId the user ID of this file note
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this file note.
	 *
	 * @param userName the user name of this file note
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this file note.
	 *
	 * @param userUuid the user uuid of this file note
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this file note.
	 *
	 * @param uuid the uuid of this file note
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
	protected FileNoteWrapper wrap(FileNote fileNote) {
		return new FileNoteWrapper(fileNote);
	}

}