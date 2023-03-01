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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DocFile service. Represents a row in the &quot;JET_PROCESS_DocFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>io.jetprocess.model.impl.DocFileModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>io.jetprocess.model.impl.DocFileImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocFile
 * @generated
 */
@ProviderType
public interface DocFileModel
	extends BaseModel<DocFile>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a doc file model instance should use the {@link DocFile} interface instead.
	 */

	/**
	 * Returns the primary key of this doc file.
	 *
	 * @return the primary key of this doc file
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this doc file.
	 *
	 * @param primaryKey the primary key of this doc file
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this doc file.
	 *
	 * @return the uuid of this doc file
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this doc file.
	 *
	 * @param uuid the uuid of this doc file
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the doc file ID of this doc file.
	 *
	 * @return the doc file ID of this doc file
	 */
	public long getDocFileId();

	/**
	 * Sets the doc file ID of this doc file.
	 *
	 * @param docFileId the doc file ID of this doc file
	 */
	public void setDocFileId(long docFileId);

	/**
	 * Returns the group ID of this doc file.
	 *
	 * @return the group ID of this doc file
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this doc file.
	 *
	 * @param groupId the group ID of this doc file
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this doc file.
	 *
	 * @return the company ID of this doc file
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this doc file.
	 *
	 * @param companyId the company ID of this doc file
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this doc file.
	 *
	 * @return the user ID of this doc file
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this doc file.
	 *
	 * @param userId the user ID of this doc file
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this doc file.
	 *
	 * @return the user uuid of this doc file
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this doc file.
	 *
	 * @param userUuid the user uuid of this doc file
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this doc file.
	 *
	 * @return the user name of this doc file
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this doc file.
	 *
	 * @param userName the user name of this doc file
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this doc file.
	 *
	 * @return the create date of this doc file
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this doc file.
	 *
	 * @param createDate the create date of this doc file
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this doc file.
	 *
	 * @return the modified date of this doc file
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this doc file.
	 *
	 * @param modifiedDate the modified date of this doc file
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nature of this doc file.
	 *
	 * @return the nature of this doc file
	 */
	@AutoEscape
	public String getNature();

	/**
	 * Sets the nature of this doc file.
	 *
	 * @param nature the nature of this doc file
	 */
	public void setNature(String nature);

	/**
	 * Returns the type of this doc file.
	 *
	 * @return the type of this doc file
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this doc file.
	 *
	 * @param type the type of this doc file
	 */
	public void setType(String type);

	/**
	 * Returns the basic head ID of this doc file.
	 *
	 * @return the basic head ID of this doc file
	 */
	public long getBasicHeadId();

	/**
	 * Sets the basic head ID of this doc file.
	 *
	 * @param basicHeadId the basic head ID of this doc file
	 */
	public void setBasicHeadId(long basicHeadId);

	/**
	 * Returns the primary head ID of this doc file.
	 *
	 * @return the primary head ID of this doc file
	 */
	public long getPrimaryHeadId();

	/**
	 * Sets the primary head ID of this doc file.
	 *
	 * @param primaryHeadId the primary head ID of this doc file
	 */
	public void setPrimaryHeadId(long primaryHeadId);

	/**
	 * Returns the secondary head ID of this doc file.
	 *
	 * @return the secondary head ID of this doc file
	 */
	public long getSecondaryHeadId();

	/**
	 * Sets the secondary head ID of this doc file.
	 *
	 * @param secondaryHeadId the secondary head ID of this doc file
	 */
	public void setSecondaryHeadId(long secondaryHeadId);

	/**
	 * Returns the tertiary head ID of this doc file.
	 *
	 * @return the tertiary head ID of this doc file
	 */
	public long getTertiaryHeadId();

	/**
	 * Sets the tertiary head ID of this doc file.
	 *
	 * @param tertiaryHeadId the tertiary head ID of this doc file
	 */
	public void setTertiaryHeadId(long tertiaryHeadId);

	/**
	 * Returns the file code ID of this doc file.
	 *
	 * @return the file code ID of this doc file
	 */
	public long getFileCodeId();

	/**
	 * Sets the file code ID of this doc file.
	 *
	 * @param fileCodeId the file code ID of this doc file
	 */
	public void setFileCodeId(long fileCodeId);

	/**
	 * Returns the subject of this doc file.
	 *
	 * @return the subject of this doc file
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this doc file.
	 *
	 * @param subject the subject of this doc file
	 */
	public void setSubject(String subject);

	/**
	 * Returns the file number of this doc file.
	 *
	 * @return the file number of this doc file
	 */
	@AutoEscape
	public String getFileNumber();

	/**
	 * Sets the file number of this doc file.
	 *
	 * @param fileNumber the file number of this doc file
	 */
	public void setFileNumber(String fileNumber);

	/**
	 * Returns the category ID of this doc file.
	 *
	 * @return the category ID of this doc file
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this doc file.
	 *
	 * @param categoryId the category ID of this doc file
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the sub category ID of this doc file.
	 *
	 * @return the sub category ID of this doc file
	 */
	public long getSubCategoryId();

	/**
	 * Sets the sub category ID of this doc file.
	 *
	 * @param subCategoryId the sub category ID of this doc file
	 */
	public void setSubCategoryId(long subCategoryId);

	/**
	 * Returns the remarks of this doc file.
	 *
	 * @return the remarks of this doc file
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this doc file.
	 *
	 * @param remarks the remarks of this doc file
	 */
	public void setRemarks(String remarks);

	/**
	 * Returns the reference of this doc file.
	 *
	 * @return the reference of this doc file
	 */
	@AutoEscape
	public String getReference();

	/**
	 * Sets the reference of this doc file.
	 *
	 * @param reference the reference of this doc file
	 */
	public void setReference(String reference);

	/**
	 * Returns the year of this doc file.
	 *
	 * @return the year of this doc file
	 */
	public long getYear();

	/**
	 * Sets the year of this doc file.
	 *
	 * @param year the year of this doc file
	 */
	public void setYear(long year);

	/**
	 * Returns the user post ID of this doc file.
	 *
	 * @return the user post ID of this doc file
	 */
	public long getUserPostId();

	/**
	 * Sets the user post ID of this doc file.
	 *
	 * @param userPostId the user post ID of this doc file
	 */
	public void setUserPostId(long userPostId);

	/**
	 * Returns the currently with of this doc file.
	 *
	 * @return the currently with of this doc file
	 */
	public long getCurrentlyWith();

	/**
	 * Sets the currently with of this doc file.
	 *
	 * @param currentlyWith the currently with of this doc file
	 */
	public void setCurrentlyWith(long currentlyWith);

	/**
	 * Returns the current state of this doc file.
	 *
	 * @return the current state of this doc file
	 */
	public int getCurrentState();

	/**
	 * Sets the current state of this doc file.
	 *
	 * @param currentState the current state of this doc file
	 */
	public void setCurrentState(int currentState);

	/**
	 * Returns the dealing head section ID of this doc file.
	 *
	 * @return the dealing head section ID of this doc file
	 */
	public long getDealingHeadSectionId();

	/**
	 * Sets the dealing head section ID of this doc file.
	 *
	 * @param dealingHeadSectionId the dealing head section ID of this doc file
	 */
	public void setDealingHeadSectionId(long dealingHeadSectionId);

	@Override
	public DocFile cloneWithOriginalValues();

}