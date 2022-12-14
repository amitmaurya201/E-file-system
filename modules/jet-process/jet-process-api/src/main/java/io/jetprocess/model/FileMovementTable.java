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
 * The table class for the &quot;JET_PROCESS_FileMovement&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileMovement
 * @generated
 */
public class FileMovementTable extends BaseTable<FileMovementTable> {

	public static final FileMovementTable INSTANCE = new FileMovementTable();

	public final Column<FileMovementTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Long> fmId = createColumn(
		"fmId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileMovementTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Long> receiverId = createColumn(
		"receiverId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Long> senderId = createColumn(
		"senderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, String> priority = createColumn(
		"priority", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, String> dueDate = createColumn(
		"dueDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, String> remark = createColumn(
		"remark", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, String> readOn = createColumn(
		"readOn", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, String> receivedOn = createColumn(
		"receivedOn", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileMovementTable, String> pullBackRemark =
		createColumn(
			"pullBackRemark", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FileMovementTable() {
		super("JET_PROCESS_FileMovement", FileMovementTable::new);
	}

}