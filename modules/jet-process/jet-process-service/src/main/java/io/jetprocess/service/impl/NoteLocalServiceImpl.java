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

import io.jetprocess.model.Note;
import io.jetprocess.service.base.NoteLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.Note",
	service = AopService.class
)
public class NoteLocalServiceImpl extends NoteLocalServiceBaseImpl {


	/*
	 * // create Method for addNote in File public Note addNote(String content,long
	 * createdBy,String signature) {
	 * 
	 * long noteId = counterLocalService.increment(Note.class.getName()); Note note
	 * = createNote(noteId); note.setNoteId(noteId); note.setContent(content);
	 * note.setSignature(signature);
	 * 
	 * return note;
	 * 
	 * 
	 * }
	 * 
	 * // create Method for delete note
	 * 
	 * public Note deleteNote(long noteId) throws PortalException{ return
	 * super.deleteNote(noteId);
	 * 
	 * }
	 */
	
	
	
	
	
	


}