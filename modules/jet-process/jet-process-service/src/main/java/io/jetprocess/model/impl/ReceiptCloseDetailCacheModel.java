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

package io.jetprocess.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import io.jetprocess.model.ReceiptCloseDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReceiptCloseDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReceiptCloseDetailCacheModel
	implements CacheModel<ReceiptCloseDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReceiptCloseDetailCacheModel)) {
			return false;
		}

		ReceiptCloseDetailCacheModel receiptCloseDetailCacheModel =
			(ReceiptCloseDetailCacheModel)object;

		if (ReceiptClosedId == receiptCloseDetailCacheModel.ReceiptClosedId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ReceiptClosedId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ReceiptClosedId=");
		sb.append(ReceiptClosedId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", receiptId=");
		sb.append(receiptId);
		sb.append(", closedBy=");
		sb.append(closedBy);
		sb.append(", closingRemarks=");
		sb.append(closingRemarks);
		sb.append(", reopenDate=");
		sb.append(reopenDate);
		sb.append(", reopenRemarks=");
		sb.append(reopenRemarks);
		sb.append(", closingReceiptMovementId=");
		sb.append(closingReceiptMovementId);
		sb.append(", reopenBy=");
		sb.append(reopenBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReceiptCloseDetail toEntityModel() {
		ReceiptCloseDetailImpl receiptCloseDetailImpl =
			new ReceiptCloseDetailImpl();

		if (uuid == null) {
			receiptCloseDetailImpl.setUuid("");
		}
		else {
			receiptCloseDetailImpl.setUuid(uuid);
		}

		receiptCloseDetailImpl.setReceiptClosedId(ReceiptClosedId);
		receiptCloseDetailImpl.setGroupId(groupId);
		receiptCloseDetailImpl.setCompanyId(companyId);
		receiptCloseDetailImpl.setUserId(userId);

		if (userName == null) {
			receiptCloseDetailImpl.setUserName("");
		}
		else {
			receiptCloseDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			receiptCloseDetailImpl.setCreateDate(null);
		}
		else {
			receiptCloseDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			receiptCloseDetailImpl.setModifiedDate(null);
		}
		else {
			receiptCloseDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		receiptCloseDetailImpl.setReceiptId(receiptId);
		receiptCloseDetailImpl.setClosedBy(closedBy);

		if (closingRemarks == null) {
			receiptCloseDetailImpl.setClosingRemarks("");
		}
		else {
			receiptCloseDetailImpl.setClosingRemarks(closingRemarks);
		}

		if (reopenDate == Long.MIN_VALUE) {
			receiptCloseDetailImpl.setReopenDate(null);
		}
		else {
			receiptCloseDetailImpl.setReopenDate(new Date(reopenDate));
		}

		if (reopenRemarks == null) {
			receiptCloseDetailImpl.setReopenRemarks("");
		}
		else {
			receiptCloseDetailImpl.setReopenRemarks(reopenRemarks);
		}

		receiptCloseDetailImpl.setClosingReceiptMovementId(
			closingReceiptMovementId);
		receiptCloseDetailImpl.setReopenBy(reopenBy);

		receiptCloseDetailImpl.resetOriginalValues();

		return receiptCloseDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ReceiptClosedId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		receiptId = objectInput.readLong();

		closedBy = objectInput.readLong();
		closingRemarks = objectInput.readUTF();
		reopenDate = objectInput.readLong();
		reopenRemarks = objectInput.readUTF();

		closingReceiptMovementId = objectInput.readLong();

		reopenBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ReceiptClosedId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(receiptId);

		objectOutput.writeLong(closedBy);

		if (closingRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(closingRemarks);
		}

		objectOutput.writeLong(reopenDate);

		if (reopenRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reopenRemarks);
		}

		objectOutput.writeLong(closingReceiptMovementId);

		objectOutput.writeLong(reopenBy);
	}

	public String uuid;
	public long ReceiptClosedId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long receiptId;
	public long closedBy;
	public String closingRemarks;
	public long reopenDate;
	public String reopenRemarks;
	public long closingReceiptMovementId;
	public long reopenBy;

}