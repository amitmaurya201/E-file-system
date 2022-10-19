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

package io.jetprocess.masterdata.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Masterdata}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Masterdata
 * @generated
 */
public class MasterdataWrapper
	extends BaseModelWrapper<Masterdata>
	implements Masterdata, ModelWrapper<Masterdata> {

	public MasterdataWrapper(Masterdata masterdata) {
		super(masterdata);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterdataId", getMasterdataId());
		attributes.put("referenceId", getReferenceId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String masterdataId = (String)attributes.get("masterdataId");

		if (masterdataId != null) {
			setMasterdataId(masterdataId);
		}

		String referenceId = (String)attributes.get("referenceId");

		if (referenceId != null) {
			setReferenceId(referenceId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public Masterdata cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the masterdata ID of this masterdata.
	 *
	 * @return the masterdata ID of this masterdata
	 */
	@Override
	public String getMasterdataId() {
		return model.getMasterdataId();
	}

	/**
	 * Returns the primary key of this masterdata.
	 *
	 * @return the primary key of this masterdata
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference ID of this masterdata.
	 *
	 * @return the reference ID of this masterdata
	 */
	@Override
	public String getReferenceId() {
		return model.getReferenceId();
	}

	/**
	 * Returns the value of this masterdata.
	 *
	 * @return the value of this masterdata
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the masterdata ID of this masterdata.
	 *
	 * @param masterdataId the masterdata ID of this masterdata
	 */
	@Override
	public void setMasterdataId(String masterdataId) {
		model.setMasterdataId(masterdataId);
	}

	/**
	 * Sets the primary key of this masterdata.
	 *
	 * @param primaryKey the primary key of this masterdata
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference ID of this masterdata.
	 *
	 * @param referenceId the reference ID of this masterdata
	 */
	@Override
	public void setReferenceId(String referenceId) {
		model.setReferenceId(referenceId);
	}

	/**
	 * Sets the value of this masterdata.
	 *
	 * @param value the value of this masterdata
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected MasterdataWrapper wrap(Masterdata masterdata) {
		return new MasterdataWrapper(masterdata);
	}

}