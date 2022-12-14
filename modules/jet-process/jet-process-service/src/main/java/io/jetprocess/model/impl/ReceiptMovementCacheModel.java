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

import io.jetprocess.model.ReceiptMovement;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReceiptMovement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReceiptMovementCacheModel
	implements CacheModel<ReceiptMovement>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReceiptMovementCacheModel)) {
			return false;
		}

		ReceiptMovementCacheModel receiptMovementCacheModel =
			(ReceiptMovementCacheModel)object;

		if (rmId == receiptMovementCacheModel.rmId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rmId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rmId=");
		sb.append(rmId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", receiverId=");
		sb.append(receiverId);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", receiptId=");
		sb.append(receiptId);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", remark=");
		sb.append(remark);
		sb.append(", readOn=");
		sb.append(readOn);
		sb.append(", receivedOn=");
		sb.append(receivedOn);
		sb.append(", pullBackRemark=");
		sb.append(pullBackRemark);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReceiptMovement toEntityModel() {
		ReceiptMovementImpl receiptMovementImpl = new ReceiptMovementImpl();

		if (uuid == null) {
			receiptMovementImpl.setUuid("");
		}
		else {
			receiptMovementImpl.setUuid(uuid);
		}

		receiptMovementImpl.setRmId(rmId);
		receiptMovementImpl.setGroupId(groupId);
		receiptMovementImpl.setCompanyId(companyId);
		receiptMovementImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			receiptMovementImpl.setCreateDate(null);
		}
		else {
			receiptMovementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			receiptMovementImpl.setModifiedDate(null);
		}
		else {
			receiptMovementImpl.setModifiedDate(new Date(modifiedDate));
		}

		receiptMovementImpl.setReceiverId(receiverId);
		receiptMovementImpl.setSenderId(senderId);
		receiptMovementImpl.setReceiptId(receiptId);

		if (priority == null) {
			receiptMovementImpl.setPriority("");
		}
		else {
			receiptMovementImpl.setPriority(priority);
		}

		if (dueDate == null) {
			receiptMovementImpl.setDueDate("");
		}
		else {
			receiptMovementImpl.setDueDate(dueDate);
		}

		if (remark == null) {
			receiptMovementImpl.setRemark("");
		}
		else {
			receiptMovementImpl.setRemark(remark);
		}

		if (readOn == null) {
			receiptMovementImpl.setReadOn("");
		}
		else {
			receiptMovementImpl.setReadOn(readOn);
		}

		if (receivedOn == null) {
			receiptMovementImpl.setReceivedOn("");
		}
		else {
			receiptMovementImpl.setReceivedOn(receivedOn);
		}

		if (pullBackRemark == null) {
			receiptMovementImpl.setPullBackRemark("");
		}
		else {
			receiptMovementImpl.setPullBackRemark(pullBackRemark);
		}

		receiptMovementImpl.resetOriginalValues();

		return receiptMovementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		rmId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		receiverId = objectInput.readLong();

		senderId = objectInput.readLong();

		receiptId = objectInput.readLong();
		priority = objectInput.readUTF();
		dueDate = objectInput.readUTF();
		remark = objectInput.readUTF();
		readOn = objectInput.readUTF();
		receivedOn = objectInput.readUTF();
		pullBackRemark = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(rmId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(receiverId);

		objectOutput.writeLong(senderId);

		objectOutput.writeLong(receiptId);

		if (priority == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(priority);
		}

		if (dueDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dueDate);
		}

		if (remark == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remark);
		}

		if (readOn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(readOn);
		}

		if (receivedOn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivedOn);
		}

		if (pullBackRemark == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pullBackRemark);
		}
	}

	public String uuid;
	public long rmId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long receiverId;
	public long senderId;
	public long receiptId;
	public String priority;
	public String dueDate;
	public String remark;
	public String readOn;
	public String receivedOn;
	public String pullBackRemark;

}