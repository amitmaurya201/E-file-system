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
 * The table class for the &quot;JET_PROCESS_NoteDocMovement&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocMovement
 * @generated
 */
public class NoteDocMovementTable extends BaseTable<NoteDocMovementTable> {

	public static final NoteDocMovementTable INSTANCE =
		new NoteDocMovementTable();

	public final Column<NoteDocMovementTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Long> movementId = createColumn(
		"movementId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NoteDocMovementTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Long> receiverId = createColumn(
		"receiverId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Long> senderId = createColumn(
		"senderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Long> noteDocumentId =
		createColumn(
			"noteDocumentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<NoteDocMovementTable, Long> movementType = createColumn(
		"movementType", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private NoteDocMovementTable() {
		super("JET_PROCESS_NoteDocMovement", NoteDocMovementTable::new);
	}

}