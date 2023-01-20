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

import com.liferay.portal.kernel.exception.PortalException;

import io.jetprocess.model.Note;

/**
 * Provides the remote service utility for Note. This utility wraps
 * <code>io.jetprocess.service.impl.NoteServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NoteService
 * @generated
 */
public class NoteServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.NoteServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Note addNote(String content, long createdBy, long fileId)
		throws PortalException {

		return getService().addNote(content, createdBy, fileId);
	}

	public static Note deleteNote(long noteId) throws PortalException {
		return getService().deleteNote(noteId);
	}

	public static Note editNote(long noteId, String content)
		throws PortalException {

		return getService().editNote(noteId, content);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static NoteService getService() {
		return _service;
	}

	private static volatile NoteService _service;

}