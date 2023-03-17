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

package io.jetprocess.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.model.Note;
import io.jetprocess.service.base.NoteServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=jet_process",
		"json.web.service.context.path=Note"
	},
	service = AopService.class
)
public class NoteServiceImpl extends NoteServiceBaseImpl {
	
	// addnote method 
	public Note addNote(String content, long createdBy,long fileId, long noteId,long fileMovementId, boolean hasYellowNote) throws PortalException {
		logger.info("add note method called");
		return noteLocalService.addNote(content, createdBy, fileId, noteId, fileMovementId, hasYellowNote);
	}
	// delete note method 
	public Note deleteNote(long noteId) throws PortalException {
		logger.info("delete note method called");
		return noteLocalService.deleteNote(noteId);
	}
	
	// Create Method for EditNote 
	public Note editNote(long noteId, String content, long updatedBy) throws PortalException {
		logger.info("edit note method called");
		return noteLocalService.editNote(noteId,content,updatedBy);	
	}
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}