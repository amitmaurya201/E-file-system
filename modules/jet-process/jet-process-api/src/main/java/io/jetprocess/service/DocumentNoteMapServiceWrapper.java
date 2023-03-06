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

package io.jetprocess.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentNoteMapService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMapService
 * @generated
 */
public class DocumentNoteMapServiceWrapper
	implements DocumentNoteMapService, ServiceWrapper<DocumentNoteMapService> {

	public DocumentNoteMapServiceWrapper() {
		this(null);
	}

	public DocumentNoteMapServiceWrapper(
		DocumentNoteMapService documentNoteMapService) {

		_documentNoteMapService = documentNoteMapService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentNoteMapService.getOSGiServiceIdentifier();
	}

	@Override
	public DocumentNoteMapService getWrappedService() {
		return _documentNoteMapService;
	}

	@Override
	public void setWrappedService(
		DocumentNoteMapService documentNoteMapService) {

		_documentNoteMapService = documentNoteMapService;
	}

	private DocumentNoteMapService _documentNoteMapService;

}