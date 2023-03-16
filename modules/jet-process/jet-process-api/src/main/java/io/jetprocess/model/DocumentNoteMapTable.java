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
 * The table class for the &quot;JET_PROCESS_DocumentNoteMap&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMap
 * @generated
 */
public class DocumentNoteMapTable extends BaseTable<DocumentNoteMapTable> {

	public static final DocumentNoteMapTable INSTANCE =
		new DocumentNoteMapTable();

	public final Column<DocumentNoteMapTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Long> documentNoteMapId =
		createColumn(
			"documentNoteMapId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DocumentNoteMapTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Long> noteDocumentId =
		createColumn(
			"noteDocumentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Long> noteId = createColumn(
		"noteId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentNoteMapTable, Long> movementId = createColumn(
		"movementId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DocumentNoteMapTable() {
		super("JET_PROCESS_DocumentNoteMap", DocumentNoteMapTable::new);
	}

}