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
 * The table class for the &quot;JET_PROCESS_ReceiptCloseDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetail
 * @generated
 */
public class ReceiptCloseDetailTable
	extends BaseTable<ReceiptCloseDetailTable> {

	public static final ReceiptCloseDetailTable INSTANCE =
		new ReceiptCloseDetailTable();

	public final Column<ReceiptCloseDetailTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Long> ReceiptClosedId =
		createColumn(
			"ReceiptClosedId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ReceiptCloseDetailTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Long> receiptId = createColumn(
		"receiptId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Long> closedBy = createColumn(
		"closedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, String> closingRemarks =
		createColumn(
			"closingRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Date> reopenDate =
		createColumn(
			"reopenDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, String> reopenRemarks =
		createColumn(
			"reopenRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Long>
		closingReceiptMovementId = createColumn(
			"closingReceiptMovementId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ReceiptCloseDetailTable, Long> reopenBy = createColumn(
		"reopenBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ReceiptCloseDetailTable() {
		super("JET_PROCESS_ReceiptCloseDetail", ReceiptCloseDetailTable::new);
	}

}