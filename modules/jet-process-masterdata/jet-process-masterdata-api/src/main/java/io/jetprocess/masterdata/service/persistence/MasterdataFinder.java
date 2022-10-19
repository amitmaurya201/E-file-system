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

package io.jetprocess.masterdata.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface MasterdataFinder {

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCategories();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubCategories(long categoryId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata> getType();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getDeliveryMode();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getFileCode();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getBasicHeads();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getPrimaryHeads(long basicHeadId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSecondaryHeads(long primaryHeadId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTeritaryHeads(long secondaryHeadsId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getOrganization();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubOrganization(long organizationId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptCategory();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptSubCategory(long receiptCategoryId);

}