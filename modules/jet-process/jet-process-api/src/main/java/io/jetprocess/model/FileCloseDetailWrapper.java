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
 * This class is a wrapper for {@link FileCloseDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCloseDetail
 * @generated
 */
public class FileCloseDetailWrapper
	extends BaseModelWrapper<FileCloseDetail>
	implements FileCloseDetail, ModelWrapper<FileCloseDetail> {

	public FileCloseDetailWrapper(FileCloseDetail fileCloseDetail) {
		super(fileCloseDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fileClosedId", getFileClosedId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileId", getFileId());
		attributes.put("closedBy", getClosedBy());
		attributes.put("closingRemarks", getClosingRemarks());
		attributes.put("reopenDate", getReopenDate());
		attributes.put("reopenRemarks", getReopenRemarks());
		attributes.put("closingMovementId", getClosingMovementId());
		attributes.put("reopenBy", getReopenBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fileClosedId = (Long)attributes.get("fileClosedId");

		if (fileClosedId != null) {
			setFileClosedId(fileClosedId);
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

		Long closedBy = (Long)attributes.get("closedBy");

		if (closedBy != null) {
			setClosedBy(closedBy);
		}

		String closingRemarks = (String)attributes.get("closingRemarks");

		if (closingRemarks != null) {
			setClosingRemarks(closingRemarks);
		}

		Date reopenDate = (Date)attributes.get("reopenDate");

		if (reopenDate != null) {
			setReopenDate(reopenDate);
		}

		String reopenRemarks = (String)attributes.get("reopenRemarks");

		if (reopenRemarks != null) {
			setReopenRemarks(reopenRemarks);
		}

		Long closingMovementId = (Long)attributes.get("closingMovementId");

		if (closingMovementId != null) {
			setClosingMovementId(closingMovementId);
		}

		Long reopenBy = (Long)attributes.get("reopenBy");

		if (reopenBy != null) {
			setReopenBy(reopenBy);
		}
	}

	@Override
	public FileCloseDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the closed by of this file close detail.
	 *
	 * @return the closed by of this file close detail
	 */
	@Override
	public long getClosedBy() {
		return model.getClosedBy();
	}

	/**
	 * Returns the closing movement ID of this file close detail.
	 *
	 * @return the closing movement ID of this file close detail
	 */
	@Override
	public long getClosingMovementId() {
		return model.getClosingMovementId();
	}

	/**
	 * Returns the closing remarks of this file close detail.
	 *
	 * @return the closing remarks of this file close detail
	 */
	@Override
	public String getClosingRemarks() {
		return model.getClosingRemarks();
	}

	/**
	 * Returns the company ID of this file close detail.
	 *
	 * @return the company ID of this file close detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this file close detail.
	 *
	 * @return the create date of this file close detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the file closed ID of this file close detail.
	 *
	 * @return the file closed ID of this file close detail
	 */
	@Override
	public long getFileClosedId() {
		return model.getFileClosedId();
	}

	/**
	 * Returns the file ID of this file close detail.
	 *
	 * @return the file ID of this file close detail
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the group ID of this file close detail.
	 *
	 * @return the group ID of this file close detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this file close detail.
	 *
	 * @return the modified date of this file close detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this file close detail.
	 *
	 * @return the primary key of this file close detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reopen by of this file close detail.
	 *
	 * @return the reopen by of this file close detail
	 */
	@Override
	public long getReopenBy() {
		return model.getReopenBy();
	}

	/**
	 * Returns the reopen date of this file close detail.
	 *
	 * @return the reopen date of this file close detail
	 */
	@Override
	public Date getReopenDate() {
		return model.getReopenDate();
	}

	/**
	 * Returns the reopen remarks of this file close detail.
	 *
	 * @return the reopen remarks of this file close detail
	 */
	@Override
	public String getReopenRemarks() {
		return model.getReopenRemarks();
	}

	/**
	 * Returns the user ID of this file close detail.
	 *
	 * @return the user ID of this file close detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this file close detail.
	 *
	 * @return the user name of this file close detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this file close detail.
	 *
	 * @return the user uuid of this file close detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this file close detail.
	 *
	 * @return the uuid of this file close detail
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
	 * Sets the closed by of this file close detail.
	 *
	 * @param closedBy the closed by of this file close detail
	 */
	@Override
	public void setClosedBy(long closedBy) {
		model.setClosedBy(closedBy);
	}

	/**
	 * Sets the closing movement ID of this file close detail.
	 *
	 * @param closingMovementId the closing movement ID of this file close detail
	 */
	@Override
	public void setClosingMovementId(long closingMovementId) {
		model.setClosingMovementId(closingMovementId);
	}

	/**
	 * Sets the closing remarks of this file close detail.
	 *
	 * @param closingRemarks the closing remarks of this file close detail
	 */
	@Override
	public void setClosingRemarks(String closingRemarks) {
		model.setClosingRemarks(closingRemarks);
	}

	/**
	 * Sets the company ID of this file close detail.
	 *
	 * @param companyId the company ID of this file close detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this file close detail.
	 *
	 * @param createDate the create date of this file close detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the file closed ID of this file close detail.
	 *
	 * @param fileClosedId the file closed ID of this file close detail
	 */
	@Override
	public void setFileClosedId(long fileClosedId) {
		model.setFileClosedId(fileClosedId);
	}

	/**
	 * Sets the file ID of this file close detail.
	 *
	 * @param fileId the file ID of this file close detail
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the group ID of this file close detail.
	 *
	 * @param groupId the group ID of this file close detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this file close detail.
	 *
	 * @param modifiedDate the modified date of this file close detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this file close detail.
	 *
	 * @param primaryKey the primary key of this file close detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reopen by of this file close detail.
	 *
	 * @param reopenBy the reopen by of this file close detail
	 */
	@Override
	public void setReopenBy(long reopenBy) {
		model.setReopenBy(reopenBy);
	}

	/**
	 * Sets the reopen date of this file close detail.
	 *
	 * @param reopenDate the reopen date of this file close detail
	 */
	@Override
	public void setReopenDate(Date reopenDate) {
		model.setReopenDate(reopenDate);
	}

	/**
	 * Sets the reopen remarks of this file close detail.
	 *
	 * @param reopenRemarks the reopen remarks of this file close detail
	 */
	@Override
	public void setReopenRemarks(String reopenRemarks) {
		model.setReopenRemarks(reopenRemarks);
	}

	/**
	 * Sets the user ID of this file close detail.
	 *
	 * @param userId the user ID of this file close detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this file close detail.
	 *
	 * @param userName the user name of this file close detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this file close detail.
	 *
	 * @param userUuid the user uuid of this file close detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this file close detail.
	 *
	 * @param uuid the uuid of this file close detail
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
	protected FileCloseDetailWrapper wrap(FileCloseDetail fileCloseDetail) {
		return new FileCloseDetailWrapper(fileCloseDetail);
	}

}