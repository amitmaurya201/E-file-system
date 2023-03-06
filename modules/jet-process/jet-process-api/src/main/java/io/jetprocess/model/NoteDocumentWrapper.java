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
 * This class is a wrapper for {@link NoteDocument}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocument
 * @generated
 */
public class NoteDocumentWrapper
	extends BaseModelWrapper<NoteDocument>
	implements ModelWrapper<NoteDocument>, NoteDocument {

	public NoteDocumentWrapper(NoteDocument noteDocument) {
		super(noteDocument);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("noteDocumentId", getNoteDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("noteDocumentNumber", getNoteDocumentNumber());
		attributes.put("subject", getSubject());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("subjectCategoryId", getSubjectCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long noteDocumentId = (Long)attributes.get("noteDocumentId");

		if (noteDocumentId != null) {
			setNoteDocumentId(noteDocumentId);
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

		String noteDocumentNumber = (String)attributes.get(
			"noteDocumentNumber");

		if (noteDocumentNumber != null) {
			setNoteDocumentNumber(noteDocumentNumber);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long subjectCategoryId = (Long)attributes.get("subjectCategoryId");

		if (subjectCategoryId != null) {
			setSubjectCategoryId(subjectCategoryId);
		}
	}

	@Override
	public NoteDocument cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this note document.
	 *
	 * @return the company ID of this note document
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this note document.
	 *
	 * @return the create date of this note document
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this note document.
	 *
	 * @return the created by of this note document
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this note document.
	 *
	 * @return the group ID of this note document
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this note document.
	 *
	 * @return the modified date of this note document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the note document ID of this note document.
	 *
	 * @return the note document ID of this note document
	 */
	@Override
	public long getNoteDocumentId() {
		return model.getNoteDocumentId();
	}

	/**
	 * Returns the note document number of this note document.
	 *
	 * @return the note document number of this note document
	 */
	@Override
	public String getNoteDocumentNumber() {
		return model.getNoteDocumentNumber();
	}

	/**
	 * Returns the primary key of this note document.
	 *
	 * @return the primary key of this note document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the subject of this note document.
	 *
	 * @return the subject of this note document
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the subject category ID of this note document.
	 *
	 * @return the subject category ID of this note document
	 */
	@Override
	public long getSubjectCategoryId() {
		return model.getSubjectCategoryId();
	}

	/**
	 * Returns the user ID of this note document.
	 *
	 * @return the user ID of this note document
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this note document.
	 *
	 * @return the user name of this note document
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this note document.
	 *
	 * @return the user uuid of this note document
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this note document.
	 *
	 * @return the uuid of this note document
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
	 * Sets the company ID of this note document.
	 *
	 * @param companyId the company ID of this note document
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this note document.
	 *
	 * @param createDate the create date of this note document
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this note document.
	 *
	 * @param createdBy the created by of this note document
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this note document.
	 *
	 * @param groupId the group ID of this note document
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this note document.
	 *
	 * @param modifiedDate the modified date of this note document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the note document ID of this note document.
	 *
	 * @param noteDocumentId the note document ID of this note document
	 */
	@Override
	public void setNoteDocumentId(long noteDocumentId) {
		model.setNoteDocumentId(noteDocumentId);
	}

	/**
	 * Sets the note document number of this note document.
	 *
	 * @param noteDocumentNumber the note document number of this note document
	 */
	@Override
	public void setNoteDocumentNumber(String noteDocumentNumber) {
		model.setNoteDocumentNumber(noteDocumentNumber);
	}

	/**
	 * Sets the primary key of this note document.
	 *
	 * @param primaryKey the primary key of this note document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the subject of this note document.
	 *
	 * @param subject the subject of this note document
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the subject category ID of this note document.
	 *
	 * @param subjectCategoryId the subject category ID of this note document
	 */
	@Override
	public void setSubjectCategoryId(long subjectCategoryId) {
		model.setSubjectCategoryId(subjectCategoryId);
	}

	/**
	 * Sets the user ID of this note document.
	 *
	 * @param userId the user ID of this note document
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this note document.
	 *
	 * @param userName the user name of this note document
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this note document.
	 *
	 * @param userUuid the user uuid of this note document
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this note document.
	 *
	 * @param uuid the uuid of this note document
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
	protected NoteDocumentWrapper wrap(NoteDocument noteDocument) {
		return new NoteDocumentWrapper(noteDocument);
	}

}