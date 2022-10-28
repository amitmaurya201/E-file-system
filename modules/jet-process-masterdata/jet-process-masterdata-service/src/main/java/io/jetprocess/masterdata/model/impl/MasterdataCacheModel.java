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

package io.jetprocess.masterdata.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import io.jetprocess.masterdata.model.Masterdata;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Masterdata in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MasterdataCacheModel
	implements CacheModel<Masterdata>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterdataCacheModel)) {
			return false;
		}

		MasterdataCacheModel masterdataCacheModel =
			(MasterdataCacheModel)object;

		if (masterdataId.equals(masterdataCacheModel.masterdataId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterdataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{masterdataId=");
		sb.append(masterdataId);
		sb.append(", referenceId=");
		sb.append(referenceId);
		sb.append(", value=");
		sb.append(value);
		sb.append(", code=");
		sb.append(code);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Masterdata toEntityModel() {
		MasterdataImpl masterdataImpl = new MasterdataImpl();

		if (masterdataId == null) {
			masterdataImpl.setMasterdataId("");
		}
		else {
			masterdataImpl.setMasterdataId(masterdataId);
		}

		if (referenceId == null) {
			masterdataImpl.setReferenceId("");
		}
		else {
			masterdataImpl.setReferenceId(referenceId);
		}

		if (value == null) {
			masterdataImpl.setValue("");
		}
		else {
			masterdataImpl.setValue(value);
		}

		if (code == null) {
			masterdataImpl.setCode("");
		}
		else {
			masterdataImpl.setCode(code);
		}

		masterdataImpl.resetOriginalValues();

		return masterdataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterdataId = objectInput.readUTF();
		referenceId = objectInput.readUTF();
		value = objectInput.readUTF();
		code = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (masterdataId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(masterdataId);
		}

		if (referenceId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referenceId);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}
	}

	public String masterdataId;
	public String referenceId;
	public String value;
	public String code;

}