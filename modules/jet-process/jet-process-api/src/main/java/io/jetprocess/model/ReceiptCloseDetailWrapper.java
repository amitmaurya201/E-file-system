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
 * This class is a wrapper for {@link ReceiptCloseDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetail
 * @generated
 */
public class ReceiptCloseDetailWrapper
	extends BaseModelWrapper<ReceiptCloseDetail>
	implements ModelWrapper<ReceiptCloseDetail>, ReceiptCloseDetail {

	public ReceiptCloseDetailWrapper(ReceiptCloseDetail receiptCloseDetail) {
		super(receiptCloseDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ReceiptClosedId", getReceiptClosedId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("receiptId", getReceiptId());
		attributes.put("closedBy", getClosedBy());
		attributes.put("closingRemarks", getClosingRemarks());
		attributes.put("reopenDate", getReopenDate());
		attributes.put("reopenRemarks", getReopenRemarks());
		attributes.put("closedMovementId", getClosedMovementId());
		attributes.put("reopenMovementId", getReopenMovementId());
		attributes.put("reopenBy", getReopenBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ReceiptClosedId = (Long)attributes.get("ReceiptClosedId");

		if (ReceiptClosedId != null) {
			setReceiptClosedId(ReceiptClosedId);
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

		Long receiptId = (Long)attributes.get("receiptId");

		if (receiptId != null) {
			setReceiptId(receiptId);
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

		Long closedMovementId = (Long)attributes.get("closedMovementId");

		if (closedMovementId != null) {
			setClosedMovementId(closedMovementId);
		}

		Long reopenMovementId = (Long)attributes.get("reopenMovementId");

		if (reopenMovementId != null) {
			setReopenMovementId(reopenMovementId);
		}

		Long reopenBy = (Long)attributes.get("reopenBy");

		if (reopenBy != null) {
			setReopenBy(reopenBy);
		}
	}

	@Override
	public ReceiptCloseDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the closed by of this receipt close detail.
	 *
	 * @return the closed by of this receipt close detail
	 */
	@Override
	public long getClosedBy() {
		return model.getClosedBy();
	}

	/**
	 * Returns the closed movement ID of this receipt close detail.
	 *
	 * @return the closed movement ID of this receipt close detail
	 */
	@Override
	public long getClosedMovementId() {
		return model.getClosedMovementId();
	}

	/**
	 * Returns the closing remarks of this receipt close detail.
	 *
	 * @return the closing remarks of this receipt close detail
	 */
	@Override
	public String getClosingRemarks() {
		return model.getClosingRemarks();
	}

	/**
	 * Returns the company ID of this receipt close detail.
	 *
	 * @return the company ID of this receipt close detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this receipt close detail.
	 *
	 * @return the create date of this receipt close detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this receipt close detail.
	 *
	 * @return the group ID of this receipt close detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this receipt close detail.
	 *
	 * @return the modified date of this receipt close detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this receipt close detail.
	 *
	 * @return the primary key of this receipt close detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receipt closed ID of this receipt close detail.
	 *
	 * @return the receipt closed ID of this receipt close detail
	 */
	@Override
	public long getReceiptClosedId() {
		return model.getReceiptClosedId();
	}

	/**
	 * Returns the receipt ID of this receipt close detail.
	 *
	 * @return the receipt ID of this receipt close detail
	 */
	@Override
	public long getReceiptId() {
		return model.getReceiptId();
	}

	/**
	 * Returns the reopen by of this receipt close detail.
	 *
	 * @return the reopen by of this receipt close detail
	 */
	@Override
	public long getReopenBy() {
		return model.getReopenBy();
	}

	/**
	 * Returns the reopen date of this receipt close detail.
	 *
	 * @return the reopen date of this receipt close detail
	 */
	@Override
	public Date getReopenDate() {
		return model.getReopenDate();
	}

	/**
	 * Returns the reopen movement ID of this receipt close detail.
	 *
	 * @return the reopen movement ID of this receipt close detail
	 */
	@Override
	public long getReopenMovementId() {
		return model.getReopenMovementId();
	}

	/**
	 * Returns the reopen remarks of this receipt close detail.
	 *
	 * @return the reopen remarks of this receipt close detail
	 */
	@Override
	public String getReopenRemarks() {
		return model.getReopenRemarks();
	}

	/**
	 * Returns the user ID of this receipt close detail.
	 *
	 * @return the user ID of this receipt close detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this receipt close detail.
	 *
	 * @return the user name of this receipt close detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this receipt close detail.
	 *
	 * @return the user uuid of this receipt close detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this receipt close detail.
	 *
	 * @return the uuid of this receipt close detail
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
	 * Sets the closed by of this receipt close detail.
	 *
	 * @param closedBy the closed by of this receipt close detail
	 */
	@Override
	public void setClosedBy(long closedBy) {
		model.setClosedBy(closedBy);
	}

	/**
	 * Sets the closed movement ID of this receipt close detail.
	 *
	 * @param closedMovementId the closed movement ID of this receipt close detail
	 */
	@Override
	public void setClosedMovementId(long closedMovementId) {
		model.setClosedMovementId(closedMovementId);
	}

	/**
	 * Sets the closing remarks of this receipt close detail.
	 *
	 * @param closingRemarks the closing remarks of this receipt close detail
	 */
	@Override
	public void setClosingRemarks(String closingRemarks) {
		model.setClosingRemarks(closingRemarks);
	}

	/**
	 * Sets the company ID of this receipt close detail.
	 *
	 * @param companyId the company ID of this receipt close detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this receipt close detail.
	 *
	 * @param createDate the create date of this receipt close detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this receipt close detail.
	 *
	 * @param groupId the group ID of this receipt close detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this receipt close detail.
	 *
	 * @param modifiedDate the modified date of this receipt close detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this receipt close detail.
	 *
	 * @param primaryKey the primary key of this receipt close detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receipt closed ID of this receipt close detail.
	 *
	 * @param ReceiptClosedId the receipt closed ID of this receipt close detail
	 */
	@Override
	public void setReceiptClosedId(long ReceiptClosedId) {
		model.setReceiptClosedId(ReceiptClosedId);
	}

	/**
	 * Sets the receipt ID of this receipt close detail.
	 *
	 * @param receiptId the receipt ID of this receipt close detail
	 */
	@Override
	public void setReceiptId(long receiptId) {
		model.setReceiptId(receiptId);
	}

	/**
	 * Sets the reopen by of this receipt close detail.
	 *
	 * @param reopenBy the reopen by of this receipt close detail
	 */
	@Override
	public void setReopenBy(long reopenBy) {
		model.setReopenBy(reopenBy);
	}

	/**
	 * Sets the reopen date of this receipt close detail.
	 *
	 * @param reopenDate the reopen date of this receipt close detail
	 */
	@Override
	public void setReopenDate(Date reopenDate) {
		model.setReopenDate(reopenDate);
	}

	/**
	 * Sets the reopen movement ID of this receipt close detail.
	 *
	 * @param reopenMovementId the reopen movement ID of this receipt close detail
	 */
	@Override
	public void setReopenMovementId(long reopenMovementId) {
		model.setReopenMovementId(reopenMovementId);
	}

	/**
	 * Sets the reopen remarks of this receipt close detail.
	 *
	 * @param reopenRemarks the reopen remarks of this receipt close detail
	 */
	@Override
	public void setReopenRemarks(String reopenRemarks) {
		model.setReopenRemarks(reopenRemarks);
	}

	/**
	 * Sets the user ID of this receipt close detail.
	 *
	 * @param userId the user ID of this receipt close detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this receipt close detail.
	 *
	 * @param userName the user name of this receipt close detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this receipt close detail.
	 *
	 * @param userUuid the user uuid of this receipt close detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this receipt close detail.
	 *
	 * @param uuid the uuid of this receipt close detail
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
	protected ReceiptCloseDetailWrapper wrap(
		ReceiptCloseDetail receiptCloseDetail) {

		return new ReceiptCloseDetailWrapper(receiptCloseDetail);
	}

}