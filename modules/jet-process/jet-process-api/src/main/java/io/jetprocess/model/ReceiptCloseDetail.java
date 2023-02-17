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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ReceiptCloseDetail service. Represents a row in the &quot;JET_PROCESS_ReceiptCloseDetail&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetailModel
 * @generated
 */
@ImplementationClassName("io.jetprocess.model.impl.ReceiptCloseDetailImpl")
@ProviderType
public interface ReceiptCloseDetail
	extends PersistedModel, ReceiptCloseDetailModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>io.jetprocess.model.impl.ReceiptCloseDetailImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ReceiptCloseDetail, Long>
		RECEIPT_CLOSED_ID_ACCESSOR = new Accessor<ReceiptCloseDetail, Long>() {

			@Override
			public Long get(ReceiptCloseDetail receiptCloseDetail) {
				return receiptCloseDetail.getReceiptClosedId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ReceiptCloseDetail> getTypeClass() {
				return ReceiptCloseDetail.class;
			}

		};

}