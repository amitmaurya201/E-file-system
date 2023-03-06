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
 * The table class for the &quot;JET_PROCESS_NoteDocument&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocument
 * @generated
 */
public class NoteDocumentTable extends BaseTable<NoteDocumentTable> {

	public static final NoteDocumentTable INSTANCE = new NoteDocumentTable();

	public final Column<NoteDocumentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, Long> noteDocumentId = createColumn(
		"noteDocumentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NoteDocumentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, String> noteDocumentNumber =
		createColumn(
			"noteDocumentNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, String> subject = createColumn(
		"subject", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocumentTable, Long> subjectCategoryId =
		createColumn(
			"subjectCategoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private NoteDocumentTable() {
		super("JET_PROCESS_NoteDocument", NoteDocumentTable::new);
	}

}