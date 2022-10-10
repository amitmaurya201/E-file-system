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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;JET_PROCESS_ContactDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetail
 * @generated
 */
public class ContactDetailTable extends BaseTable<ContactDetailTable> {

	public static final ContactDetailTable INSTANCE = new ContactDetailTable();

	public final Column<ContactDetailTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, Long> contactDetailId =
		createColumn(
			"contactDetailId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ContactDetailTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> minDeptOth = createColumn(
		"minDeptOth", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> designation = createColumn(
		"designation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> mobile = createColumn(
		"mobile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> country = createColumn(
		"country", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> district = createColumn(
		"district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactDetailTable, String> pinCode = createColumn(
		"pinCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ContactDetailTable() {
		super("JET_PROCESS_ContactDetail", ContactDetailTable::new);
	}

}