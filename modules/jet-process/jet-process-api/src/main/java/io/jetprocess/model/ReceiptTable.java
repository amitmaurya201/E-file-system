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
 * The table class for the &quot;JET_PROCESS_Receipt&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Receipt
 * @generated
 */
public class ReceiptTable extends BaseTable<ReceiptTable> {

	public static final ReceiptTable INSTANCE = new ReceiptTable();

	public final Column<ReceiptTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Long> receiptId = createColumn(
		"receiptId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ReceiptTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Date> createdOn = createColumn(
		"createdOn", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> deliveryMode = createColumn(
		"deliveryMode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Date> receivedOn = createColumn(
		"receivedOn", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Date> letterDate = createColumn(
		"letterDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> referenceNumber = createColumn(
		"referenceNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> modeNumber = createColumn(
		"modeNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> organisation = createColumn(
		"organisation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> category = createColumn(
		"category", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> subCategory = createColumn(
		"subCategory", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> subject = createColumn(
		"subject", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, String> document = createColumn(
		"document", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReceiptTable, Long> senderId = createColumn(
		"senderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ReceiptTable() {
		super("JET_PROCESS_Receipt", ReceiptTable::new);
	}

}