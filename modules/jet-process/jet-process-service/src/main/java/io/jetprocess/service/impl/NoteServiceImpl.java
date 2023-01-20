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

import javax.portlet.ActionRequest;

import io.jetprocess.model.Note;
import io.jetprocess.service.base.NoteServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

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
	public Note addNote(String content, long createdBy,long fileId) throws PortalException {
		return noteLocalService.addNote(content, createdBy,fileId);
	}
	// delete note method 
	public Note deleteNote(long noteId) throws PortalException {
		return noteLocalService.deleteNote(noteId);
	}
	// Create Method for EditNote 
	
	public Note editNote(long noteId, String content) throws PortalException {
		return noteLocalService.editNote(noteId,content);	
	}
	
	
	
	
}