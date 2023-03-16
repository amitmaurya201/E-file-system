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
 * This class is a wrapper for {@link DocumentNoteMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMap
 * @generated
 */
public class DocumentNoteMapWrapper
	extends BaseModelWrapper<DocumentNoteMap>
	implements DocumentNoteMap, ModelWrapper<DocumentNoteMap> {

	public DocumentNoteMapWrapper(DocumentNoteMap documentNoteMap) {
		super(documentNoteMap);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("documentNoteMapId", getDocumentNoteMapId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("noteDocumentId", getNoteDocumentId());
		attributes.put("noteId", getNoteId());
		attributes.put("movementId", getMovementId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long documentNoteMapId = (Long)attributes.get("documentNoteMapId");

		if (documentNoteMapId != null) {
			setDocumentNoteMapId(documentNoteMapId);
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

		Long noteDocumentId = (Long)attributes.get("noteDocumentId");

		if (noteDocumentId != null) {
			setNoteDocumentId(noteDocumentId);
		}

		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
		}

		Long movementId = (Long)attributes.get("movementId");

		if (movementId != null) {
			setMovementId(movementId);
		}
	}

	@Override
	public DocumentNoteMap cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this document note map.
	 *
	 * @return the company ID of this document note map
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this document note map.
	 *
	 * @return the create date of this document note map
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the document note map ID of this document note map.
	 *
	 * @return the document note map ID of this document note map
	 */
	@Override
	public long getDocumentNoteMapId() {
		return model.getDocumentNoteMapId();
	}

	/**
	 * Returns the group ID of this document note map.
	 *
	 * @return the group ID of this document note map
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this document note map.
	 *
	 * @return the modified date of this document note map
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the movement ID of this document note map.
	 *
	 * @return the movement ID of this document note map
	 */
	@Override
	public long getMovementId() {
		return model.getMovementId();
	}

	/**
	 * Returns the note document ID of this document note map.
	 *
	 * @return the note document ID of this document note map
	 */
	@Override
	public long getNoteDocumentId() {
		return model.getNoteDocumentId();
	}

	/**
	 * Returns the note ID of this document note map.
	 *
	 * @return the note ID of this document note map
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the primary key of this document note map.
	 *
	 * @return the primary key of this document note map
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this document note map.
	 *
	 * @return the user ID of this document note map
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this document note map.
	 *
	 * @return the user name of this document note map
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this document note map.
	 *
	 * @return the user uuid of this document note map
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this document note map.
	 *
	 * @return the uuid of this document note map
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
	 * Sets the company ID of this document note map.
	 *
	 * @param companyId the company ID of this document note map
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this document note map.
	 *
	 * @param createDate the create date of this document note map
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the document note map ID of this document note map.
	 *
	 * @param documentNoteMapId the document note map ID of this document note map
	 */
	@Override
	public void setDocumentNoteMapId(long documentNoteMapId) {
		model.setDocumentNoteMapId(documentNoteMapId);
	}

	/**
	 * Sets the group ID of this document note map.
	 *
	 * @param groupId the group ID of this document note map
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this document note map.
	 *
	 * @param modifiedDate the modified date of this document note map
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the movement ID of this document note map.
	 *
	 * @param movementId the movement ID of this document note map
	 */
	@Override
	public void setMovementId(long movementId) {
		model.setMovementId(movementId);
	}

	/**
	 * Sets the note document ID of this document note map.
	 *
	 * @param noteDocumentId the note document ID of this document note map
	 */
	@Override
	public void setNoteDocumentId(long noteDocumentId) {
		model.setNoteDocumentId(noteDocumentId);
	}

	/**
	 * Sets the note ID of this document note map.
	 *
	 * @param noteId the note ID of this document note map
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the primary key of this document note map.
	 *
	 * @param primaryKey the primary key of this document note map
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this document note map.
	 *
	 * @param userId the user ID of this document note map
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this document note map.
	 *
	 * @param userName the user name of this document note map
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this document note map.
	 *
	 * @param userUuid the user uuid of this document note map
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this document note map.
	 *
	 * @param uuid the uuid of this document note map
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
	protected DocumentNoteMapWrapper wrap(DocumentNoteMap documentNoteMap) {
		return new DocumentNoteMapWrapper(documentNoteMap);
	}

}