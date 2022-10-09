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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Receipt service. Represents a row in the &quot;JET_PROCESS_Receipt&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ReceiptModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReceiptImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptImpl
 * @generated
 */
@JSON(strict = true)
public class ReceiptModelImpl
	extends BaseModelImpl<Receipt> implements ReceiptModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a receipt model instance should use the <code>Receipt</code> interface instead.
	 */
	public static final String TABLE_NAME = "JET_PROCESS_Receipt";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"receiptId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"createdOn", Types.TIMESTAMP}, {"type_", Types.VARCHAR},
		{"deliveryMode", Types.VARCHAR}, {"receivedOn", Types.TIMESTAMP},
		{"letterDate", Types.TIMESTAMP}, {"referenceNumber", Types.VARCHAR},
		{"modeNumber", Types.VARCHAR}, {"organisation", Types.VARCHAR},
		{"category", Types.VARCHAR}, {"subCategory", Types.VARCHAR},
		{"subject", Types.VARCHAR}, {"remarks", Types.VARCHAR},
		{"document", Types.VARCHAR}, {"senderId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("receiptId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdOn", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliveryMode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("receivedOn", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("letterDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("referenceNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modeNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("organisation", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("category", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subCategory", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("remarks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("document", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("senderId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table JET_PROCESS_Receipt (uuid_ VARCHAR(75) null,receiptId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,createdOn DATE null,type_ VARCHAR(75) null,deliveryMode VARCHAR(75) null,receivedOn DATE null,letterDate DATE null,referenceNumber VARCHAR(75) null,modeNumber VARCHAR(75) null,organisation VARCHAR(75) null,category VARCHAR(75) null,subCategory VARCHAR(75) null,subject VARCHAR(75) null,remarks VARCHAR(75) null,document VARCHAR(75) null,senderId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table JET_PROCESS_Receipt";

	public static final String ORDER_BY_JPQL = " ORDER BY receipt.category ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY JET_PROCESS_Receipt.category ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long RECEIPTID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CATEGORY_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ReceiptModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _receiptId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReceiptId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _receiptId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Receipt.class;
	}

	@Override
	public String getModelClassName() {
		return Receipt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Receipt, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Receipt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Receipt, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Receipt)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Receipt, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Receipt, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Receipt)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Receipt, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Receipt, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Receipt, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Receipt, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Receipt, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Receipt, Object>>();
		Map<String, BiConsumer<Receipt, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Receipt, ?>>();

		attributeGetterFunctions.put("uuid", Receipt::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Receipt, String>)Receipt::setUuid);
		attributeGetterFunctions.put("receiptId", Receipt::getReceiptId);
		attributeSetterBiConsumers.put(
			"receiptId", (BiConsumer<Receipt, Long>)Receipt::setReceiptId);
		attributeGetterFunctions.put("groupId", Receipt::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Receipt, Long>)Receipt::setGroupId);
		attributeGetterFunctions.put("companyId", Receipt::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Receipt, Long>)Receipt::setCompanyId);
		attributeGetterFunctions.put("userId", Receipt::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Receipt, Long>)Receipt::setUserId);
		attributeGetterFunctions.put("userName", Receipt::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Receipt, String>)Receipt::setUserName);
		attributeGetterFunctions.put("createDate", Receipt::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Receipt, Date>)Receipt::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Receipt::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Receipt, Date>)Receipt::setModifiedDate);
		attributeGetterFunctions.put("createdOn", Receipt::getCreatedOn);
		attributeSetterBiConsumers.put(
			"createdOn", (BiConsumer<Receipt, Date>)Receipt::setCreatedOn);
		attributeGetterFunctions.put("type", Receipt::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<Receipt, String>)Receipt::setType);
		attributeGetterFunctions.put("deliveryMode", Receipt::getDeliveryMode);
		attributeSetterBiConsumers.put(
			"deliveryMode",
			(BiConsumer<Receipt, String>)Receipt::setDeliveryMode);
		attributeGetterFunctions.put("receivedOn", Receipt::getReceivedOn);
		attributeSetterBiConsumers.put(
			"receivedOn", (BiConsumer<Receipt, Date>)Receipt::setReceivedOn);
		attributeGetterFunctions.put("letterDate", Receipt::getLetterDate);
		attributeSetterBiConsumers.put(
			"letterDate", (BiConsumer<Receipt, Date>)Receipt::setLetterDate);
		attributeGetterFunctions.put(
			"referenceNumber", Receipt::getReferenceNumber);
		attributeSetterBiConsumers.put(
			"referenceNumber",
			(BiConsumer<Receipt, String>)Receipt::setReferenceNumber);
		attributeGetterFunctions.put("modeNumber", Receipt::getModeNumber);
		attributeSetterBiConsumers.put(
			"modeNumber", (BiConsumer<Receipt, String>)Receipt::setModeNumber);
		attributeGetterFunctions.put("organisation", Receipt::getOrganisation);
		attributeSetterBiConsumers.put(
			"organisation",
			(BiConsumer<Receipt, String>)Receipt::setOrganisation);
		attributeGetterFunctions.put("category", Receipt::getCategory);
		attributeSetterBiConsumers.put(
			"category", (BiConsumer<Receipt, String>)Receipt::setCategory);
		attributeGetterFunctions.put("subCategory", Receipt::getSubCategory);
		attributeSetterBiConsumers.put(
			"subCategory",
			(BiConsumer<Receipt, String>)Receipt::setSubCategory);
		attributeGetterFunctions.put("subject", Receipt::getSubject);
		attributeSetterBiConsumers.put(
			"subject", (BiConsumer<Receipt, String>)Receipt::setSubject);
		attributeGetterFunctions.put("remarks", Receipt::getRemarks);
		attributeSetterBiConsumers.put(
			"remarks", (BiConsumer<Receipt, String>)Receipt::setRemarks);
		attributeGetterFunctions.put("document", Receipt::getDocument);
		attributeSetterBiConsumers.put(
			"document", (BiConsumer<Receipt, String>)Receipt::setDocument);
		attributeGetterFunctions.put("senderId", Receipt::getSenderId);
		attributeSetterBiConsumers.put(
			"senderId", (BiConsumer<Receipt, Long>)Receipt::setSenderId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getReceiptId() {
		return _receiptId;
	}

	@Override
	public void setReceiptId(long receiptId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_receiptId = receiptId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalReceiptId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("receiptId"));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public Date getCreatedOn() {
		return _createdOn;
	}

	@Override
	public void setCreatedOn(Date createdOn) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdOn = createdOn;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	@JSON
	@Override
	public String getDeliveryMode() {
		if (_deliveryMode == null) {
			return "";
		}
		else {
			return _deliveryMode;
		}
	}

	@Override
	public void setDeliveryMode(String deliveryMode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_deliveryMode = deliveryMode;
	}

	@JSON
	@Override
	public Date getReceivedOn() {
		return _receivedOn;
	}

	@Override
	public void setReceivedOn(Date receivedOn) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_receivedOn = receivedOn;
	}

	@JSON
	@Override
	public Date getLetterDate() {
		return _letterDate;
	}

	@Override
	public void setLetterDate(Date letterDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_letterDate = letterDate;
	}

	@JSON
	@Override
	public String getReferenceNumber() {
		if (_referenceNumber == null) {
			return "";
		}
		else {
			return _referenceNumber;
		}
	}

	@Override
	public void setReferenceNumber(String referenceNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_referenceNumber = referenceNumber;
	}

	@JSON
	@Override
	public String getModeNumber() {
		if (_modeNumber == null) {
			return "";
		}
		else {
			return _modeNumber;
		}
	}

	@Override
	public void setModeNumber(String modeNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modeNumber = modeNumber;
	}

	@JSON
	@Override
	public String getOrganisation() {
		if (_organisation == null) {
			return "";
		}
		else {
			return _organisation;
		}
	}

	@Override
	public void setOrganisation(String organisation) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_organisation = organisation;
	}

	@JSON
	@Override
	public String getCategory() {
		if (_category == null) {
			return "";
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_category = category;
	}

	@JSON
	@Override
	public String getSubCategory() {
		if (_subCategory == null) {
			return "";
		}
		else {
			return _subCategory;
		}
	}

	@Override
	public void setSubCategory(String subCategory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subCategory = subCategory;
	}

	@JSON
	@Override
	public String getSubject() {
		if (_subject == null) {
			return "";
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subject = subject;
	}

	@JSON
	@Override
	public String getRemarks() {
		if (_remarks == null) {
			return "";
		}
		else {
			return _remarks;
		}
	}

	@Override
	public void setRemarks(String remarks) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_remarks = remarks;
	}

	@JSON
	@Override
	public String getDocument() {
		if (_document == null) {
			return "";
		}
		else {
			return _document;
		}
	}

	@Override
	public void setDocument(String document) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_document = document;
	}

	@JSON
	@Override
	public long getSenderId() {
		return _senderId;
	}

	@Override
	public void setSenderId(long senderId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_senderId = senderId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Receipt.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Receipt.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Receipt toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Receipt>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReceiptImpl receiptImpl = new ReceiptImpl();

		receiptImpl.setUuid(getUuid());
		receiptImpl.setReceiptId(getReceiptId());
		receiptImpl.setGroupId(getGroupId());
		receiptImpl.setCompanyId(getCompanyId());
		receiptImpl.setUserId(getUserId());
		receiptImpl.setUserName(getUserName());
		receiptImpl.setCreateDate(getCreateDate());
		receiptImpl.setModifiedDate(getModifiedDate());
		receiptImpl.setCreatedOn(getCreatedOn());
		receiptImpl.setType(getType());
		receiptImpl.setDeliveryMode(getDeliveryMode());
		receiptImpl.setReceivedOn(getReceivedOn());
		receiptImpl.setLetterDate(getLetterDate());
		receiptImpl.setReferenceNumber(getReferenceNumber());
		receiptImpl.setModeNumber(getModeNumber());
		receiptImpl.setOrganisation(getOrganisation());
		receiptImpl.setCategory(getCategory());
		receiptImpl.setSubCategory(getSubCategory());
		receiptImpl.setSubject(getSubject());
		receiptImpl.setRemarks(getRemarks());
		receiptImpl.setDocument(getDocument());
		receiptImpl.setSenderId(getSenderId());

		receiptImpl.resetOriginalValues();

		return receiptImpl;
	}

	@Override
	public Receipt cloneWithOriginalValues() {
		ReceiptImpl receiptImpl = new ReceiptImpl();

		receiptImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		receiptImpl.setReceiptId(
			this.<Long>getColumnOriginalValue("receiptId"));
		receiptImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		receiptImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		receiptImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		receiptImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		receiptImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		receiptImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		receiptImpl.setCreatedOn(
			this.<Date>getColumnOriginalValue("createdOn"));
		receiptImpl.setType(this.<String>getColumnOriginalValue("type_"));
		receiptImpl.setDeliveryMode(
			this.<String>getColumnOriginalValue("deliveryMode"));
		receiptImpl.setReceivedOn(
			this.<Date>getColumnOriginalValue("receivedOn"));
		receiptImpl.setLetterDate(
			this.<Date>getColumnOriginalValue("letterDate"));
		receiptImpl.setReferenceNumber(
			this.<String>getColumnOriginalValue("referenceNumber"));
		receiptImpl.setModeNumber(
			this.<String>getColumnOriginalValue("modeNumber"));
		receiptImpl.setOrganisation(
			this.<String>getColumnOriginalValue("organisation"));
		receiptImpl.setCategory(
			this.<String>getColumnOriginalValue("category"));
		receiptImpl.setSubCategory(
			this.<String>getColumnOriginalValue("subCategory"));
		receiptImpl.setSubject(this.<String>getColumnOriginalValue("subject"));
		receiptImpl.setRemarks(this.<String>getColumnOriginalValue("remarks"));
		receiptImpl.setDocument(
			this.<String>getColumnOriginalValue("document"));
		receiptImpl.setSenderId(this.<Long>getColumnOriginalValue("senderId"));

		return receiptImpl;
	}

	@Override
	public int compareTo(Receipt receipt) {
		int value = 0;

		value = getCategory().compareTo(receipt.getCategory());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Receipt)) {
			return false;
		}

		Receipt receipt = (Receipt)object;

		long primaryKey = receipt.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Receipt> toCacheModel() {
		ReceiptCacheModel receiptCacheModel = new ReceiptCacheModel();

		receiptCacheModel.uuid = getUuid();

		String uuid = receiptCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			receiptCacheModel.uuid = null;
		}

		receiptCacheModel.receiptId = getReceiptId();

		receiptCacheModel.groupId = getGroupId();

		receiptCacheModel.companyId = getCompanyId();

		receiptCacheModel.userId = getUserId();

		receiptCacheModel.userName = getUserName();

		String userName = receiptCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			receiptCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			receiptCacheModel.createDate = createDate.getTime();
		}
		else {
			receiptCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			receiptCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			receiptCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date createdOn = getCreatedOn();

		if (createdOn != null) {
			receiptCacheModel.createdOn = createdOn.getTime();
		}
		else {
			receiptCacheModel.createdOn = Long.MIN_VALUE;
		}

		receiptCacheModel.type = getType();

		String type = receiptCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			receiptCacheModel.type = null;
		}

		receiptCacheModel.deliveryMode = getDeliveryMode();

		String deliveryMode = receiptCacheModel.deliveryMode;

		if ((deliveryMode != null) && (deliveryMode.length() == 0)) {
			receiptCacheModel.deliveryMode = null;
		}

		Date receivedOn = getReceivedOn();

		if (receivedOn != null) {
			receiptCacheModel.receivedOn = receivedOn.getTime();
		}
		else {
			receiptCacheModel.receivedOn = Long.MIN_VALUE;
		}

		Date letterDate = getLetterDate();

		if (letterDate != null) {
			receiptCacheModel.letterDate = letterDate.getTime();
		}
		else {
			receiptCacheModel.letterDate = Long.MIN_VALUE;
		}

		receiptCacheModel.referenceNumber = getReferenceNumber();

		String referenceNumber = receiptCacheModel.referenceNumber;

		if ((referenceNumber != null) && (referenceNumber.length() == 0)) {
			receiptCacheModel.referenceNumber = null;
		}

		receiptCacheModel.modeNumber = getModeNumber();

		String modeNumber = receiptCacheModel.modeNumber;

		if ((modeNumber != null) && (modeNumber.length() == 0)) {
			receiptCacheModel.modeNumber = null;
		}

		receiptCacheModel.organisation = getOrganisation();

		String organisation = receiptCacheModel.organisation;

		if ((organisation != null) && (organisation.length() == 0)) {
			receiptCacheModel.organisation = null;
		}

		receiptCacheModel.category = getCategory();

		String category = receiptCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			receiptCacheModel.category = null;
		}

		receiptCacheModel.subCategory = getSubCategory();

		String subCategory = receiptCacheModel.subCategory;

		if ((subCategory != null) && (subCategory.length() == 0)) {
			receiptCacheModel.subCategory = null;
		}

		receiptCacheModel.subject = getSubject();

		String subject = receiptCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			receiptCacheModel.subject = null;
		}

		receiptCacheModel.remarks = getRemarks();

		String remarks = receiptCacheModel.remarks;

		if ((remarks != null) && (remarks.length() == 0)) {
			receiptCacheModel.remarks = null;
		}

		receiptCacheModel.document = getDocument();

		String document = receiptCacheModel.document;

		if ((document != null) && (document.length() == 0)) {
			receiptCacheModel.document = null;
		}

		receiptCacheModel.senderId = getSenderId();

		return receiptCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Receipt, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Receipt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Receipt, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Receipt)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Receipt, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Receipt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Receipt, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Receipt)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Receipt>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Receipt.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _receiptId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private Date _createdOn;
	private String _type;
	private String _deliveryMode;
	private Date _receivedOn;
	private Date _letterDate;
	private String _referenceNumber;
	private String _modeNumber;
	private String _organisation;
	private String _category;
	private String _subCategory;
	private String _subject;
	private String _remarks;
	private String _document;
	private long _senderId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Receipt, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Receipt)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("receiptId", _receiptId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("createdOn", _createdOn);
		_columnOriginalValues.put("type_", _type);
		_columnOriginalValues.put("deliveryMode", _deliveryMode);
		_columnOriginalValues.put("receivedOn", _receivedOn);
		_columnOriginalValues.put("letterDate", _letterDate);
		_columnOriginalValues.put("referenceNumber", _referenceNumber);
		_columnOriginalValues.put("modeNumber", _modeNumber);
		_columnOriginalValues.put("organisation", _organisation);
		_columnOriginalValues.put("category", _category);
		_columnOriginalValues.put("subCategory", _subCategory);
		_columnOriginalValues.put("subject", _subject);
		_columnOriginalValues.put("remarks", _remarks);
		_columnOriginalValues.put("document", _document);
		_columnOriginalValues.put("senderId", _senderId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("type_", "type");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("receiptId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("createdOn", 256L);

		columnBitmasks.put("type_", 512L);

		columnBitmasks.put("deliveryMode", 1024L);

		columnBitmasks.put("receivedOn", 2048L);

		columnBitmasks.put("letterDate", 4096L);

		columnBitmasks.put("referenceNumber", 8192L);

		columnBitmasks.put("modeNumber", 16384L);

		columnBitmasks.put("organisation", 32768L);

		columnBitmasks.put("category", 65536L);

		columnBitmasks.put("subCategory", 131072L);

		columnBitmasks.put("subject", 262144L);

		columnBitmasks.put("remarks", 524288L);

		columnBitmasks.put("document", 1048576L);

		columnBitmasks.put("senderId", 2097152L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Receipt _escapedModel;

}