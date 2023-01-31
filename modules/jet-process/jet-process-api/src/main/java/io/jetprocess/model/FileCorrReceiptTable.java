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
 * The table class for the &quot;JET_PROCESS_FileCorrReceipt&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrReceipt
 * @generated
 */
public class FileCorrReceiptTable extends BaseTable<FileCorrReceiptTable> {

	public static final FileCorrReceiptTable INSTANCE =
		new FileCorrReceiptTable();

	public final Column<FileCorrReceiptTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> fileCorrReceiptId =
		createColumn(
			"fileCorrReceiptId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileCorrReceiptTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> docFileId = createColumn(
		"docFileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> receiptId = createColumn(
		"receiptId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> userPostId = createColumn(
		"userPostId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> receiptMovementId =
		createColumn(
			"receiptMovementId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, String> correspondenceType =
		createColumn(
			"correspondenceType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileCorrReceiptTable, Long> fileMovementId =
		createColumn(
			"fileMovementId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FileCorrReceiptTable() {
		super("JET_PROCESS_FileCorrReceipt", FileCorrReceiptTable::new);
	}

}