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
 * The base model interface for the DocumentNoteMap service. Represents a row in the &quot;JET_PROCESS_DocumentNoteMap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>io.jetprocess.model.impl.DocumentNoteMapModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>io.jetprocess.model.impl.DocumentNoteMapImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMap
 * @generated
 */
@ProviderType
public interface DocumentNoteMapModel
	extends BaseModel<DocumentNoteMap>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a document note map model instance should use the {@link DocumentNoteMap} interface instead.
	 */

	/**
	 * Returns the primary key of this document note map.
	 *
	 * @return the primary key of this document note map
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this document note map.
	 *
	 * @param primaryKey the primary key of this document note map
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this document note map.
	 *
	 * @return the uuid of this document note map
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this document note map.
	 *
	 * @param uuid the uuid of this document note map
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the document note map ID of this document note map.
	 *
	 * @return the document note map ID of this document note map
	 */
	public long getDocumentNoteMapId();

	/**
	 * Sets the document note map ID of this document note map.
	 *
	 * @param documentNoteMapId the document note map ID of this document note map
	 */
	public void setDocumentNoteMapId(long documentNoteMapId);

	/**
	 * Returns the group ID of this document note map.
	 *
	 * @return the group ID of this document note map
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this document note map.
	 *
	 * @param groupId the group ID of this document note map
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this document note map.
	 *
	 * @return the company ID of this document note map
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this document note map.
	 *
	 * @param companyId the company ID of this document note map
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this document note map.
	 *
	 * @return the user ID of this document note map
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this document note map.
	 *
	 * @param userId the user ID of this document note map
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this document note map.
	 *
	 * @return the user uuid of this document note map
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this document note map.
	 *
	 * @param userUuid the user uuid of this document note map
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this document note map.
	 *
	 * @return the user name of this document note map
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this document note map.
	 *
	 * @param userName the user name of this document note map
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this document note map.
	 *
	 * @return the create date of this document note map
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this document note map.
	 *
	 * @param createDate the create date of this document note map
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this document note map.
	 *
	 * @return the modified date of this document note map
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this document note map.
	 *
	 * @param modifiedDate the modified date of this document note map
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the note document ID of this document note map.
	 *
	 * @return the note document ID of this document note map
	 */
	public long getNoteDocumentId();

	/**
	 * Sets the note document ID of this document note map.
	 *
	 * @param noteDocumentId the note document ID of this document note map
	 */
	public void setNoteDocumentId(long noteDocumentId);

	/**
	 * Returns the note ID of this document note map.
	 *
	 * @return the note ID of this document note map
	 */
	public long getNoteId();

	/**
	 * Sets the note ID of this document note map.
	 *
	 * @param noteId the note ID of this document note map
	 */
	public void setNoteId(long noteId);

	/**
	 * Returns the movement ID of this document note map.
	 *
	 * @return the movement ID of this document note map
	 */
	public long getMovementId();

	/**
	 * Sets the movement ID of this document note map.
	 *
	 * @param movementId the movement ID of this document note map
	 */
	public void setMovementId(long movementId);

	@Override
	public DocumentNoteMap cloneWithOriginalValues();

}