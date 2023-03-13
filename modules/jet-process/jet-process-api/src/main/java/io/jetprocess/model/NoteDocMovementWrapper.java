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
 * This class is a wrapper for {@link NoteDocMovement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocMovement
 * @generated
 */
public class NoteDocMovementWrapper
	extends BaseModelWrapper<NoteDocMovement>
	implements ModelWrapper<NoteDocMovement>, NoteDocMovement {

	public NoteDocMovementWrapper(NoteDocMovement noteDocMovement) {
		super(noteDocMovement);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("movementId", getMovementId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("receiverId", getReceiverId());
		attributes.put("senderId", getSenderId());
		attributes.put("noteDocumentId", getNoteDocumentId());
		attributes.put("remarks", getRemarks());
		attributes.put("active", isActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long movementId = (Long)attributes.get("movementId");

		if (movementId != null) {
			setMovementId(movementId);
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

		Long receiverId = (Long)attributes.get("receiverId");

		if (receiverId != null) {
			setReceiverId(receiverId);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}

		Long noteDocumentId = (Long)attributes.get("noteDocumentId");

		if (noteDocumentId != null) {
			setNoteDocumentId(noteDocumentId);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public NoteDocMovement cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this note doc movement.
	 *
	 * @return the active of this note doc movement
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this note doc movement.
	 *
	 * @return the company ID of this note doc movement
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this note doc movement.
	 *
	 * @return the create date of this note doc movement
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this note doc movement.
	 *
	 * @return the group ID of this note doc movement
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this note doc movement.
	 *
	 * @return the modified date of this note doc movement
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the movement ID of this note doc movement.
	 *
	 * @return the movement ID of this note doc movement
	 */
	@Override
	public long getMovementId() {
		return model.getMovementId();
	}

	/**
	 * Returns the note document ID of this note doc movement.
	 *
	 * @return the note document ID of this note doc movement
	 */
	@Override
	public long getNoteDocumentId() {
		return model.getNoteDocumentId();
	}

	/**
	 * Returns the primary key of this note doc movement.
	 *
	 * @return the primary key of this note doc movement
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receiver ID of this note doc movement.
	 *
	 * @return the receiver ID of this note doc movement
	 */
	@Override
	public long getReceiverId() {
		return model.getReceiverId();
	}

	/**
	 * Returns the remarks of this note doc movement.
	 *
	 * @return the remarks of this note doc movement
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the sender ID of this note doc movement.
	 *
	 * @return the sender ID of this note doc movement
	 */
	@Override
	public long getSenderId() {
		return model.getSenderId();
	}

	/**
	 * Returns the user ID of this note doc movement.
	 *
	 * @return the user ID of this note doc movement
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this note doc movement.
	 *
	 * @return the user name of this note doc movement
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this note doc movement.
	 *
	 * @return the user uuid of this note doc movement
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this note doc movement.
	 *
	 * @return the uuid of this note doc movement
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this note doc movement is active.
	 *
	 * @return <code>true</code> if this note doc movement is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this note doc movement is active.
	 *
	 * @param active the active of this note doc movement
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this note doc movement.
	 *
	 * @param companyId the company ID of this note doc movement
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this note doc movement.
	 *
	 * @param createDate the create date of this note doc movement
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this note doc movement.
	 *
	 * @param groupId the group ID of this note doc movement
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this note doc movement.
	 *
	 * @param modifiedDate the modified date of this note doc movement
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the movement ID of this note doc movement.
	 *
	 * @param movementId the movement ID of this note doc movement
	 */
	@Override
	public void setMovementId(long movementId) {
		model.setMovementId(movementId);
	}

	/**
	 * Sets the note document ID of this note doc movement.
	 *
	 * @param noteDocumentId the note document ID of this note doc movement
	 */
	@Override
	public void setNoteDocumentId(long noteDocumentId) {
		model.setNoteDocumentId(noteDocumentId);
	}

	/**
	 * Sets the primary key of this note doc movement.
	 *
	 * @param primaryKey the primary key of this note doc movement
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receiver ID of this note doc movement.
	 *
	 * @param receiverId the receiver ID of this note doc movement
	 */
	@Override
	public void setReceiverId(long receiverId) {
		model.setReceiverId(receiverId);
	}

	/**
	 * Sets the remarks of this note doc movement.
	 *
	 * @param remarks the remarks of this note doc movement
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the sender ID of this note doc movement.
	 *
	 * @param senderId the sender ID of this note doc movement
	 */
	@Override
	public void setSenderId(long senderId) {
		model.setSenderId(senderId);
	}

	/**
	 * Sets the user ID of this note doc movement.
	 *
	 * @param userId the user ID of this note doc movement
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this note doc movement.
	 *
	 * @param userName the user name of this note doc movement
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this note doc movement.
	 *
	 * @param userUuid the user uuid of this note doc movement
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this note doc movement.
	 *
	 * @param uuid the uuid of this note doc movement
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
	protected NoteDocMovementWrapper wrap(NoteDocMovement noteDocMovement) {
		return new NoteDocMovementWrapper(noteDocMovement);
	}

}