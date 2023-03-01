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
 * The table class for the &quot;JET_PROCESS_FileCloseDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileCloseDetail
 * @generated
 */
public class FileCloseDetailTable extends BaseTable<FileCloseDetailTable> {

	public static final FileCloseDetailTable INSTANCE =
		new FileCloseDetailTable();

	public final Column<FileCloseDetailTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> fileClosedId = createColumn(
		"fileClosedId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileCloseDetailTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> closedBy = createColumn(
		"closedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, String> closingRemarks =
		createColumn(
			"closingRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Date> reopenDate = createColumn(
		"reopenDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, String> reopenRemarks =
		createColumn(
			"reopenRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> closedMovementId =
		createColumn(
			"closedMovementId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> reopenBy = createColumn(
		"reopenBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCloseDetailTable, Long> reopenMovementId =
		createColumn(
			"reopenMovementId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FileCloseDetailTable() {
		super("JET_PROCESS_FileCloseDetail", FileCloseDetailTable::new);
	}

}