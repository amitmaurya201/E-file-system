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
 * The table class for the &quot;JET_PROCESS_ReceiptMovement&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptMovement
 * @generated
 */
public class ReceiptMovementTable extends BaseTable<ReceiptMovementTable> {

	public static final ReceiptMovementTable INSTANCE =
		new ReceiptMovementTable();

	public final Column<ReceiptMovementTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Long> rmId = createColumn(
		"rmId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ReceiptMovementTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Long> receiverId = createColumn(
		"receiverId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Long> senderId = createColumn(
		"senderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, Long> receiptId = createColumn(
		"receiptId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, String> priority = createColumn(
		"priority", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, String> dueDate = createColumn(
		"dueDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptMovementTable, String> remark = createColumn(
		"remark", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ReceiptMovementTable() {
		super("JET_PROCESS_ReceiptMovement", ReceiptMovementTable::new);
	}

}