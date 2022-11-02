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
 * The table class for the &quot;Masterdata_UserPost&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserPost
 * @generated
 */
public class UserPostTable extends BaseTable<UserPostTable> {

	public static final UserPostTable INSTANCE = new UserPostTable();

	public final Column<UserPostTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserPostTable, String> userPostId = createColumn(
		"userPostId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<UserPostTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserPostTable, Long> postId = createColumn(
		"postId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserPostTable, Long> sectionId = createColumn(
		"sectionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserPostTable, Long> description = createColumn(
		"description", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserPostTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserPostTable, String> shortName = createColumn(
		"shortName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private UserPostTable() {
		super("Masterdata_UserPost", UserPostTable::new);
	}

}