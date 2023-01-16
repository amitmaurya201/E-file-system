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
 * This class is a wrapper for {@link FileMovement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileMovement
 * @generated
 */
public class FileMovementWrapper
	extends BaseModelWrapper<FileMovement>
	implements FileMovement, ModelWrapper<FileMovement> {

	public FileMovementWrapper(FileMovement fileMovement) {
		super(fileMovement);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fmId", getFmId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("receiverId", getReceiverId());
		attributes.put("senderId", getSenderId());
		attributes.put("fileId", getFileId());
		attributes.put("priority", getPriority());
		attributes.put("dueDate", getDueDate());
		attributes.put("remark", getRemark());
		attributes.put("readOn", getReadOn());
		attributes.put("receivedOn", getReceivedOn());
		attributes.put("pullBackRemark", getPullBackRemark());
		attributes.put("active", isActive());
		attributes.put("movementType", getMovementType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fmId = (Long)attributes.get("fmId");

		if (fmId != null) {
			setFmId(fmId);
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

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String priority = (String)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String dueDate = (String)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}

		String readOn = (String)attributes.get("readOn");

		if (readOn != null) {
			setReadOn(readOn);
		}

		String receivedOn = (String)attributes.get("receivedOn");

		if (receivedOn != null) {
			setReceivedOn(receivedOn);
		}

		String pullBackRemark = (String)attributes.get("pullBackRemark");

		if (pullBackRemark != null) {
			setPullBackRemark(pullBackRemark);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long movementType = (Long)attributes.get("movementType");

		if (movementType != null) {
			setMovementType(movementType);
		}
	}

	@Override
	public FileMovement cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this file movement.
	 *
	 * @return the active of this file movement
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this file movement.
	 *
	 * @return the company ID of this file movement
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this file movement.
	 *
	 * @return the create date of this file movement
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the due date of this file movement.
	 *
	 * @return the due date of this file movement
	 */
	@Override
	public String getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the file ID of this file movement.
	 *
	 * @return the file ID of this file movement
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the fm ID of this file movement.
	 *
	 * @return the fm ID of this file movement
	 */
	@Override
	public long getFmId() {
		return model.getFmId();
	}

	/**
	 * Returns the group ID of this file movement.
	 *
	 * @return the group ID of this file movement
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this file movement.
	 *
	 * @return the modified date of this file movement
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the movement type of this file movement.
	 *
	 * @return the movement type of this file movement
	 */
	@Override
	public long getMovementType() {
		return model.getMovementType();
	}

	/**
	 * Returns the primary key of this file movement.
	 *
	 * @return the primary key of this file movement
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this file movement.
	 *
	 * @return the priority of this file movement
	 */
	@Override
	public String getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the pull back remark of this file movement.
	 *
	 * @return the pull back remark of this file movement
	 */
	@Override
	public String getPullBackRemark() {
		return model.getPullBackRemark();
	}

	/**
	 * Returns the read on of this file movement.
	 *
	 * @return the read on of this file movement
	 */
	@Override
	public String getReadOn() {
		return model.getReadOn();
	}

	/**
	 * Returns the received on of this file movement.
	 *
	 * @return the received on of this file movement
	 */
	@Override
	public String getReceivedOn() {
		return model.getReceivedOn();
	}

	/**
	 * Returns the receiver ID of this file movement.
	 *
	 * @return the receiver ID of this file movement
	 */
	@Override
	public long getReceiverId() {
		return model.getReceiverId();
	}

	/**
	 * Returns the remark of this file movement.
	 *
	 * @return the remark of this file movement
	 */
	@Override
	public String getRemark() {
		return model.getRemark();
	}

	/**
	 * Returns the sender ID of this file movement.
	 *
	 * @return the sender ID of this file movement
	 */
	@Override
	public long getSenderId() {
		return model.getSenderId();
	}

	/**
	 * Returns the user ID of this file movement.
	 *
	 * @return the user ID of this file movement
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this file movement.
	 *
	 * @return the user uuid of this file movement
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this file movement.
	 *
	 * @return the uuid of this file movement
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this file movement is active.
	 *
	 * @return <code>true</code> if this file movement is active; <code>false</code> otherwise
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
	 * Sets whether this file movement is active.
	 *
	 * @param active the active of this file movement
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this file movement.
	 *
	 * @param companyId the company ID of this file movement
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this file movement.
	 *
	 * @param createDate the create date of this file movement
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the due date of this file movement.
	 *
	 * @param dueDate the due date of this file movement
	 */
	@Override
	public void setDueDate(String dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the file ID of this file movement.
	 *
	 * @param fileId the file ID of this file movement
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the fm ID of this file movement.
	 *
	 * @param fmId the fm ID of this file movement
	 */
	@Override
	public void setFmId(long fmId) {
		model.setFmId(fmId);
	}

	/**
	 * Sets the group ID of this file movement.
	 *
	 * @param groupId the group ID of this file movement
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this file movement.
	 *
	 * @param modifiedDate the modified date of this file movement
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the movement type of this file movement.
	 *
	 * @param movementType the movement type of this file movement
	 */
	@Override
	public void setMovementType(long movementType) {
		model.setMovementType(movementType);
	}

	/**
	 * Sets the primary key of this file movement.
	 *
	 * @param primaryKey the primary key of this file movement
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this file movement.
	 *
	 * @param priority the priority of this file movement
	 */
	@Override
	public void setPriority(String priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the pull back remark of this file movement.
	 *
	 * @param pullBackRemark the pull back remark of this file movement
	 */
	@Override
	public void setPullBackRemark(String pullBackRemark) {
		model.setPullBackRemark(pullBackRemark);
	}

	/**
	 * Sets the read on of this file movement.
	 *
	 * @param readOn the read on of this file movement
	 */
	@Override
	public void setReadOn(String readOn) {
		model.setReadOn(readOn);
	}

	/**
	 * Sets the received on of this file movement.
	 *
	 * @param receivedOn the received on of this file movement
	 */
	@Override
	public void setReceivedOn(String receivedOn) {
		model.setReceivedOn(receivedOn);
	}

	/**
	 * Sets the receiver ID of this file movement.
	 *
	 * @param receiverId the receiver ID of this file movement
	 */
	@Override
	public void setReceiverId(long receiverId) {
		model.setReceiverId(receiverId);
	}

	/**
	 * Sets the remark of this file movement.
	 *
	 * @param remark the remark of this file movement
	 */
	@Override
	public void setRemark(String remark) {
		model.setRemark(remark);
	}

	/**
	 * Sets the sender ID of this file movement.
	 *
	 * @param senderId the sender ID of this file movement
	 */
	@Override
	public void setSenderId(long senderId) {
		model.setSenderId(senderId);
	}

	/**
	 * Sets the user ID of this file movement.
	 *
	 * @param userId the user ID of this file movement
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this file movement.
	 *
	 * @param userUuid the user uuid of this file movement
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this file movement.
	 *
	 * @param uuid the uuid of this file movement
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
	protected FileMovementWrapper wrap(FileMovement fileMovement) {
		return new FileMovementWrapper(fileMovement);
	}

}