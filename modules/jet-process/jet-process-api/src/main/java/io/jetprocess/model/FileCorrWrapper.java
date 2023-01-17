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
 * This class is a wrapper for {@link FileCorr}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCorr
 * @generated
 */
public class FileCorrWrapper
	extends BaseModelWrapper<FileCorr>
	implements FileCorr, ModelWrapper<FileCorr> {

	public FileCorrWrapper(FileCorr fileCorr) {
		super(fileCorr);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fileCorrId", getFileCorrId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("docFileId", getDocFileId());
		attributes.put("receiptId", getReceiptId());
		attributes.put("userPostId", getUserPostId());
		attributes.put("correspondenceType", getCorrespondenceType());
		attributes.put("remarks", getRemarks());
		attributes.put("fileMovementId", getFileMovementId());
		attributes.put("receiptMovementId", getReceiptMovementId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fileCorrId = (Long)attributes.get("fileCorrId");

		if (fileCorrId != null) {
			setFileCorrId(fileCorrId);
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

		Long docFileId = (Long)attributes.get("docFileId");

		if (docFileId != null) {
			setDocFileId(docFileId);
		}

		Long receiptId = (Long)attributes.get("receiptId");

		if (receiptId != null) {
			setReceiptId(receiptId);
		}

		Long userPostId = (Long)attributes.get("userPostId");

		if (userPostId != null) {
			setUserPostId(userPostId);
		}

		String correspondenceType = (String)attributes.get(
			"correspondenceType");

		if (correspondenceType != null) {
			setCorrespondenceType(correspondenceType);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Long fileMovementId = (Long)attributes.get("fileMovementId");

		if (fileMovementId != null) {
			setFileMovementId(fileMovementId);
		}

		Long receiptMovementId = (Long)attributes.get("receiptMovementId");

		if (receiptMovementId != null) {
			setReceiptMovementId(receiptMovementId);
		}
	}

	@Override
	public FileCorr cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this file corr.
	 *
	 * @return the company ID of this file corr
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the correspondence type of this file corr.
	 *
	 * @return the correspondence type of this file corr
	 */
	@Override
	public String getCorrespondenceType() {
		return model.getCorrespondenceType();
	}

	/**
	 * Returns the create date of this file corr.
	 *
	 * @return the create date of this file corr
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the doc file ID of this file corr.
	 *
	 * @return the doc file ID of this file corr
	 */
	@Override
	public long getDocFileId() {
		return model.getDocFileId();
	}

	/**
	 * Returns the file corr ID of this file corr.
	 *
	 * @return the file corr ID of this file corr
	 */
	@Override
	public long getFileCorrId() {
		return model.getFileCorrId();
	}

	/**
	 * Returns the file movement ID of this file corr.
	 *
	 * @return the file movement ID of this file corr
	 */
	@Override
	public long getFileMovementId() {
		return model.getFileMovementId();
	}

	/**
	 * Returns the group ID of this file corr.
	 *
	 * @return the group ID of this file corr
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this file corr.
	 *
	 * @return the modified date of this file corr
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this file corr.
	 *
	 * @return the primary key of this file corr
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receipt ID of this file corr.
	 *
	 * @return the receipt ID of this file corr
	 */
	@Override
	public long getReceiptId() {
		return model.getReceiptId();
	}

	/**
	 * Returns the receipt movement ID of this file corr.
	 *
	 * @return the receipt movement ID of this file corr
	 */
	@Override
	public long getReceiptMovementId() {
		return model.getReceiptMovementId();
	}

	/**
	 * Returns the remarks of this file corr.
	 *
	 * @return the remarks of this file corr
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the user ID of this file corr.
	 *
	 * @return the user ID of this file corr
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user post ID of this file corr.
	 *
	 * @return the user post ID of this file corr
	 */
	@Override
	public long getUserPostId() {
		return model.getUserPostId();
	}

	/**
	 * Returns the user uuid of this file corr.
	 *
	 * @return the user uuid of this file corr
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this file corr.
	 *
	 * @return the uuid of this file corr
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
	 * Sets the company ID of this file corr.
	 *
	 * @param companyId the company ID of this file corr
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the correspondence type of this file corr.
	 *
	 * @param correspondenceType the correspondence type of this file corr
	 */
	@Override
	public void setCorrespondenceType(String correspondenceType) {
		model.setCorrespondenceType(correspondenceType);
	}

	/**
	 * Sets the create date of this file corr.
	 *
	 * @param createDate the create date of this file corr
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the doc file ID of this file corr.
	 *
	 * @param docFileId the doc file ID of this file corr
	 */
	@Override
	public void setDocFileId(long docFileId) {
		model.setDocFileId(docFileId);
	}

	/**
	 * Sets the file corr ID of this file corr.
	 *
	 * @param fileCorrId the file corr ID of this file corr
	 */
	@Override
	public void setFileCorrId(long fileCorrId) {
		model.setFileCorrId(fileCorrId);
	}

	/**
	 * Sets the file movement ID of this file corr.
	 *
	 * @param fileMovementId the file movement ID of this file corr
	 */
	@Override
	public void setFileMovementId(long fileMovementId) {
		model.setFileMovementId(fileMovementId);
	}

	/**
	 * Sets the group ID of this file corr.
	 *
	 * @param groupId the group ID of this file corr
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this file corr.
	 *
	 * @param modifiedDate the modified date of this file corr
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this file corr.
	 *
	 * @param primaryKey the primary key of this file corr
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receipt ID of this file corr.
	 *
	 * @param receiptId the receipt ID of this file corr
	 */
	@Override
	public void setReceiptId(long receiptId) {
		model.setReceiptId(receiptId);
	}

	/**
	 * Sets the receipt movement ID of this file corr.
	 *
	 * @param receiptMovementId the receipt movement ID of this file corr
	 */
	@Override
	public void setReceiptMovementId(long receiptMovementId) {
		model.setReceiptMovementId(receiptMovementId);
	}

	/**
	 * Sets the remarks of this file corr.
	 *
	 * @param remarks the remarks of this file corr
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the user ID of this file corr.
	 *
	 * @param userId the user ID of this file corr
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user post ID of this file corr.
	 *
	 * @param userPostId the user post ID of this file corr
	 */
	@Override
	public void setUserPostId(long userPostId) {
		model.setUserPostId(userPostId);
	}

	/**
	 * Sets the user uuid of this file corr.
	 *
	 * @param userUuid the user uuid of this file corr
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this file corr.
	 *
	 * @param uuid the uuid of this file corr
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
	protected FileCorrWrapper wrap(FileCorr fileCorr) {
		return new FileCorrWrapper(fileCorr);
	}

}