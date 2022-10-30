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
 * This class is a wrapper for {@link DocFile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocFile
 * @generated
 */
public class DocFileWrapper
	extends BaseModelWrapper<DocFile>
	implements DocFile, ModelWrapper<DocFile> {

	public DocFileWrapper(DocFile docFile) {
		super(docFile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("docFileId", getDocFileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nature", getNature());
		attributes.put("type", getType());
		attributes.put("basicHeadId", getBasicHeadId());
		attributes.put("primaryHeadId", getPrimaryHeadId());
		attributes.put("secondaryHeadId", getSecondaryHeadId());
		attributes.put("tertiaryHeadId", getTertiaryHeadId());
		attributes.put("fileCodeId", getFileCodeId());
		attributes.put("subject", getSubject());
		attributes.put("fileNumber", getFileNumber());
		attributes.put("categoryId", getCategoryId());
		attributes.put("subCategoryId", getSubCategoryId());
		attributes.put("remarks", getRemarks());
		attributes.put("reference", getReference());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long docFileId = (Long)attributes.get("docFileId");

		if (docFileId != null) {
			setDocFileId(docFileId);
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

		String nature = (String)attributes.get("nature");

		if (nature != null) {
			setNature(nature);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long basicHeadId = (Long)attributes.get("basicHeadId");

		if (basicHeadId != null) {
			setBasicHeadId(basicHeadId);
		}

		Long primaryHeadId = (Long)attributes.get("primaryHeadId");

		if (primaryHeadId != null) {
			setPrimaryHeadId(primaryHeadId);
		}

		Long secondaryHeadId = (Long)attributes.get("secondaryHeadId");

		if (secondaryHeadId != null) {
			setSecondaryHeadId(secondaryHeadId);
		}

		Long tertiaryHeadId = (Long)attributes.get("tertiaryHeadId");

		if (tertiaryHeadId != null) {
			setTertiaryHeadId(tertiaryHeadId);
		}

		Long fileCodeId = (Long)attributes.get("fileCodeId");

		if (fileCodeId != null) {
			setFileCodeId(fileCodeId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String fileNumber = (String)attributes.get("fileNumber");

		if (fileNumber != null) {
			setFileNumber(fileNumber);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long subCategoryId = (Long)attributes.get("subCategoryId");

		if (subCategoryId != null) {
			setSubCategoryId(subCategoryId);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}

		Long year = (Long)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@Override
	public DocFile cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the basic head ID of this doc file.
	 *
	 * @return the basic head ID of this doc file
	 */
	@Override
	public long getBasicHeadId() {
		return model.getBasicHeadId();
	}

	/**
	 * Returns the category ID of this doc file.
	 *
	 * @return the category ID of this doc file
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this doc file.
	 *
	 * @return the company ID of this doc file
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this doc file.
	 *
	 * @return the create date of this doc file
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the doc file ID of this doc file.
	 *
	 * @return the doc file ID of this doc file
	 */
	@Override
	public long getDocFileId() {
		return model.getDocFileId();
	}

	/**
	 * Returns the file code ID of this doc file.
	 *
	 * @return the file code ID of this doc file
	 */
	@Override
	public long getFileCodeId() {
		return model.getFileCodeId();
	}

	/**
	 * Returns the file number of this doc file.
	 *
	 * @return the file number of this doc file
	 */
	@Override
	public String getFileNumber() {
		return model.getFileNumber();
	}

	/**
	 * Returns the group ID of this doc file.
	 *
	 * @return the group ID of this doc file
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this doc file.
	 *
	 * @return the modified date of this doc file
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nature of this doc file.
	 *
	 * @return the nature of this doc file
	 */
	@Override
	public String getNature() {
		return model.getNature();
	}

	/**
	 * Returns the primary head ID of this doc file.
	 *
	 * @return the primary head ID of this doc file
	 */
	@Override
	public long getPrimaryHeadId() {
		return model.getPrimaryHeadId();
	}

	/**
	 * Returns the primary key of this doc file.
	 *
	 * @return the primary key of this doc file
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference of this doc file.
	 *
	 * @return the reference of this doc file
	 */
	@Override
	public String getReference() {
		return model.getReference();
	}

	/**
	 * Returns the remarks of this doc file.
	 *
	 * @return the remarks of this doc file
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the secondary head ID of this doc file.
	 *
	 * @return the secondary head ID of this doc file
	 */
	@Override
	public long getSecondaryHeadId() {
		return model.getSecondaryHeadId();
	}

	/**
	 * Returns the sub category ID of this doc file.
	 *
	 * @return the sub category ID of this doc file
	 */
	@Override
	public long getSubCategoryId() {
		return model.getSubCategoryId();
	}

	/**
	 * Returns the subject of this doc file.
	 *
	 * @return the subject of this doc file
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the tertiary head ID of this doc file.
	 *
	 * @return the tertiary head ID of this doc file
	 */
	@Override
	public long getTertiaryHeadId() {
		return model.getTertiaryHeadId();
	}

	/**
	 * Returns the type of this doc file.
	 *
	 * @return the type of this doc file
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this doc file.
	 *
	 * @return the user ID of this doc file
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this doc file.
	 *
	 * @return the user name of this doc file
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this doc file.
	 *
	 * @return the user uuid of this doc file
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this doc file.
	 *
	 * @return the uuid of this doc file
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year of this doc file.
	 *
	 * @return the year of this doc file
	 */
	@Override
	public long getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the basic head ID of this doc file.
	 *
	 * @param basicHeadId the basic head ID of this doc file
	 */
	@Override
	public void setBasicHeadId(long basicHeadId) {
		model.setBasicHeadId(basicHeadId);
	}

	/**
	 * Sets the category ID of this doc file.
	 *
	 * @param categoryId the category ID of this doc file
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this doc file.
	 *
	 * @param companyId the company ID of this doc file
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this doc file.
	 *
	 * @param createDate the create date of this doc file
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the doc file ID of this doc file.
	 *
	 * @param docFileId the doc file ID of this doc file
	 */
	@Override
	public void setDocFileId(long docFileId) {
		model.setDocFileId(docFileId);
	}

	/**
	 * Sets the file code ID of this doc file.
	 *
	 * @param fileCodeId the file code ID of this doc file
	 */
	@Override
	public void setFileCodeId(long fileCodeId) {
		model.setFileCodeId(fileCodeId);
	}

	/**
	 * Sets the file number of this doc file.
	 *
	 * @param fileNumber the file number of this doc file
	 */
	@Override
	public void setFileNumber(String fileNumber) {
		model.setFileNumber(fileNumber);
	}

	/**
	 * Sets the group ID of this doc file.
	 *
	 * @param groupId the group ID of this doc file
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this doc file.
	 *
	 * @param modifiedDate the modified date of this doc file
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nature of this doc file.
	 *
	 * @param nature the nature of this doc file
	 */
	@Override
	public void setNature(String nature) {
		model.setNature(nature);
	}

	/**
	 * Sets the primary head ID of this doc file.
	 *
	 * @param primaryHeadId the primary head ID of this doc file
	 */
	@Override
	public void setPrimaryHeadId(long primaryHeadId) {
		model.setPrimaryHeadId(primaryHeadId);
	}

	/**
	 * Sets the primary key of this doc file.
	 *
	 * @param primaryKey the primary key of this doc file
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference of this doc file.
	 *
	 * @param reference the reference of this doc file
	 */
	@Override
	public void setReference(String reference) {
		model.setReference(reference);
	}

	/**
	 * Sets the remarks of this doc file.
	 *
	 * @param remarks the remarks of this doc file
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the secondary head ID of this doc file.
	 *
	 * @param secondaryHeadId the secondary head ID of this doc file
	 */
	@Override
	public void setSecondaryHeadId(long secondaryHeadId) {
		model.setSecondaryHeadId(secondaryHeadId);
	}

	/**
	 * Sets the sub category ID of this doc file.
	 *
	 * @param subCategoryId the sub category ID of this doc file
	 */
	@Override
	public void setSubCategoryId(long subCategoryId) {
		model.setSubCategoryId(subCategoryId);
	}

	/**
	 * Sets the subject of this doc file.
	 *
	 * @param subject the subject of this doc file
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the tertiary head ID of this doc file.
	 *
	 * @param tertiaryHeadId the tertiary head ID of this doc file
	 */
	@Override
	public void setTertiaryHeadId(long tertiaryHeadId) {
		model.setTertiaryHeadId(tertiaryHeadId);
	}

	/**
	 * Sets the type of this doc file.
	 *
	 * @param type the type of this doc file
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this doc file.
	 *
	 * @param userId the user ID of this doc file
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this doc file.
	 *
	 * @param userName the user name of this doc file
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this doc file.
	 *
	 * @param userUuid the user uuid of this doc file
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this doc file.
	 *
	 * @param uuid the uuid of this doc file
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year of this doc file.
	 *
	 * @param year the year of this doc file
	 */
	@Override
	public void setYear(long year) {
		model.setYear(year);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DocFileWrapper wrap(DocFile docFile) {
		return new DocFileWrapper(docFile);
	}

}