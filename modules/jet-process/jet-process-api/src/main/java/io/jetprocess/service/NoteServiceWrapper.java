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
 * Provides a wrapper for {@link NoteService}.
 *
 * @author Brian Wing Shun Chan
 * @see NoteService
 * @generated
 */
public class NoteServiceWrapper
	implements NoteService, ServiceWrapper<NoteService> {

	public NoteServiceWrapper() {
		this(null);
	}

	public NoteServiceWrapper(NoteService noteService) {
		_noteService = noteService;
	}

	@Override
	public io.jetprocess.model.Note addNote(
		String content, long createdBy, String signature, long fileId) {

		return _noteService.addNote(content, createdBy, signature, fileId);
	}

	@Override
	public io.jetprocess.model.Note deleteNote(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteService.deleteNote(noteId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _noteService.getOSGiServiceIdentifier();
	}

	@Override
	public NoteService getWrappedService() {
		return _noteService;
	}

	@Override
	public void setWrappedService(NoteService noteService) {
		_noteService = noteService;
	}

	private NoteService _noteService;

}