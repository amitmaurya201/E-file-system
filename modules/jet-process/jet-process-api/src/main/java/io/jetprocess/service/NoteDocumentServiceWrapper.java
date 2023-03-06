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
 * Provides a wrapper for {@link NoteDocumentService}.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocumentService
 * @generated
 */
public class NoteDocumentServiceWrapper
	implements NoteDocumentService, ServiceWrapper<NoteDocumentService> {

	public NoteDocumentServiceWrapper() {
		this(null);
	}

	public NoteDocumentServiceWrapper(NoteDocumentService noteDocumentService) {
		_noteDocumentService = noteDocumentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _noteDocumentService.getOSGiServiceIdentifier();
	}

	@Override
	public NoteDocumentService getWrappedService() {
		return _noteDocumentService;
	}

	@Override
	public void setWrappedService(NoteDocumentService noteDocumentService) {
		_noteDocumentService = noteDocumentService;
	}

	private NoteDocumentService _noteDocumentService;

}