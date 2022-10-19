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

package io.jetprocess.masterdata.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Masterdata_Masterdata&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Masterdata
 * @generated
 */
public class MasterdataTable extends BaseTable<MasterdataTable> {

	public static final MasterdataTable INSTANCE = new MasterdataTable();

	public final Column<MasterdataTable, String> masterdataId = createColumn(
		"masterdataId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<MasterdataTable, String> referenceId = createColumn(
		"referenceId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterdataTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private MasterdataTable() {
		super("Masterdata_Masterdata", MasterdataTable::new);
	}

}