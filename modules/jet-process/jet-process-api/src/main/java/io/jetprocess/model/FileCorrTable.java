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
 * The table class for the &quot;JET_PROCESS_FileCorr&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileCorr
 * @generated
 */
public class FileCorrTable extends BaseTable<FileCorrTable> {

	public static final FileCorrTable INSTANCE = new FileCorrTable();

	public final Column<FileCorrTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Long> fileCorrId = createColumn(
		"fileCorrId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileCorrTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Long> docFileId = createColumn(
		"docFileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Long> receiptId = createColumn(
		"receiptId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, Long> userPostId = createColumn(
		"userPostId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrTable, String> correspondenceType =
		createColumn(
			"correspondenceType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private FileCorrTable() {
		super("JET_PROCESS_FileCorr", FileCorrTable::new);
	}

}