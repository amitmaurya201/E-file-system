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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Date;

import javax.portlet.ActionRequest;

import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.exception.NoSuchFileNoteException;
import io.jetprocess.exception.NoSuchNoteException;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.model.FileNote;
import io.jetprocess.model.Note;
import io.jetprocess.service.FileNoteLocalService;
import io.jetprocess.service.base.NoteLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.Note",
	service = AopService.class
)
public class NoteLocalServiceImpl extends NoteLocalServiceBaseImpl {

	  // create Method for addNote in File 
	public Note addNote(String content, long createdBy, long fileId, long noteId, long fileMovementId ) throws PortalException {
	
		if(content != null && !content.trim().isEmpty()) {
		Note note =null;
		if(noteId==0) {
			System.out.println("created");
			 long generateNoteId = counterLocalService.increment(Note.class.getName()); 	
			 note = createNote(generateNoteId);
			  note.setNoteId(generateNoteId);
			  note.setCreatedBy(createdBy);
			  note.setContent(content);
			  UserPost userPost = userPostLocalService.getUserPost(createdBy);
			  String userName = userPost.getUserName();
			  String departmentName =  userPost.getDepartmentName();
			  String postMarking =  userPost.getPostMarking();
			  JSONObject jsonObject = JSONFactoryUtil.createJSONObject(); 
			  jsonObject.put("userName", userName);
			  jsonObject.put("departmentName", departmentName);
			  jsonObject.put("postMarking", postMarking);
			  String signature = jsonObject.toString();
			 
			  note.setSignature(signature);
			  noteLocalService.addNote(note);
			  FileNote fileNote = fileNoteLocalService.createFileNote();
			  fileNote.setNoteId(generateNoteId);
			  fileNote.setFileMovementId(fileMovementId);
			  fileNote.setFileId(fileId);
			  fileNote.setMovementType(MovementStatus.CREATED);
			  fileNoteLocalService.addFileNote(fileNote);		
	   }else {
		   System.out.println("update");
			 note= getNote(noteId);
			note.setContent(content);
			note = super.updateNote(note);  
		   
	   }
		
		   return note;
		}else {
			return null;
		}
	
	  }
	  // create Method for Edit Note 
	  public Note editNote(long noteId, String content) throws PortalException {
		  Note note = getNote(noteId);
		  note.setContent(content);
		  note.setModifiedDate(new Date());
		  note = super.updateNote(note);
		  return note;	  
	  }
	  public Note getNoteByUserPostId(long userPostId) throws NoSuchNoteException {
			 Note  note = notePersistence.findByuserPostId(userPostId); 
			 return note;	
		 }
	 
 @Reference
 FileNoteLocalService fileNoteLocalService;
 @Reference 
 UserPostLocalService userPostLocalService;
}