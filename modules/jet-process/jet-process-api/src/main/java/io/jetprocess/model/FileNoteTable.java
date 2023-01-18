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
 * The table class for the &quot;JET_PROCESS_FileNote&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileNote
 * @generated
 */
public class FileNoteTable extends BaseTable<FileNoteTable> {

	public static final FileNoteTable INSTANCE = new FileNoteTable();

	public final Column<FileNoteTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Long> fileNoteId = createColumn(
		"fileNoteId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileNoteTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Long> fileMovementId = createColumn(
		"fileMovementId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Long> noteId = createColumn(
		"noteId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileNoteTable, Long> movementType = createColumn(
		"movementType", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FileNoteTable() {
		super("JET_PROCESS_FileNote", FileNoteTable::new);
	}

}