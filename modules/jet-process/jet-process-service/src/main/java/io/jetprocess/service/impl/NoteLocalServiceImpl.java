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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.model.FileNote;
import io.jetprocess.model.Note;
import io.jetprocess.service.FileNoteLocalService;
import io.jetprocess.service.base.NoteLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.Note", service = AopService.class)
public class NoteLocalServiceImpl extends NoteLocalServiceBaseImpl {

	// create Method for addNote in File
	public Note addNote(String content, long createdBy, long fileId, long noteId, long fileMovementId, boolean hasYellowNote)
			throws PortalException {
		logger.info(" add note method called ");
		Note note = null;
		System.out.println("content--------"+content);
		System.out.println("note--------"+noteId);
		System.out.println("createdBy--------"+createdBy);
		System.out.println("fileId--------"+fileId);
		System.out.println("fileMovementId--------"+fileMovementId);
		System.out.println("hasYellowNote--------"+hasYellowNote);
		
			if (noteId == 0) {
				System.out.println("create note");
				long generateNoteId = counterLocalService.increment(Note.class.getName());
				note = createNote(generateNoteId);
				note.setNoteId(generateNoteId);
				note.setCreatedBy(createdBy);
				note.setContent(content);
				hasYellowNote(hasYellowNote, note);
				// set signatue in note
				UserPost userPost = userPostLocalService.getUserPost(createdBy);
				String userName = userPost.getUserName();
				String departmentName = userPost.getDepartmentName();
				String postMarking = userPost.getPostMarking();
				String sectionName = userPost.getSectionName();
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("userName", userName);
				jsonObject.put("postMarking", postMarking);
				jsonObject.put("sectionName", sectionName);
				jsonObject.put("departmentName", departmentName);
				String signature = jsonObject.toString();
				note.setSignature(signature);
				noteLocalService.addNote(note);
				System.out.println("success");
				FileNote fileNote = fileNoteLocalService.createFileNote();
				fileNote.setNoteId(generateNoteId);
				fileNote.setFileMovementId(fileMovementId);
				fileNote.setFileId(fileId);
				fileNote.setMovementType(MovementStatus.CREATED);
				fileNoteLocalService.addFileNote(fileNote);
			} else {
				System.out.println("update trrrrrrr");
				note = getNote(noteId);
				note.setContent(content);
				note = super.updateNote(note);
			}

		return note;
	}

	private void hasYellowNote(boolean hasYellowNote, Note note) {
		if(hasYellowNote) {
			note.setHasYellowNote(hasYellowNote);
			System.out.println(hasYellowNote);
		}
	}

	// create Method for Edit Note
	public Note editNote(long noteId, String content) throws PortalException {
		logger.info(" edit note method called ");
		Note note = getNote(noteId);
		note.setContent(content);
		note.setModifiedDate(new Date());
		note = super.updateNote(note);
		return note;
	}
	/*
	 * public Note addBlankNote(long fileId, long fileMovementId, long createdBy)
	 * throws PortalException { long generateNoteId =
	 * counterLocalService.increment(Note.class.getName()); Note note =
	 * createNote(generateNoteId); note.setNoteId(generateNoteId);
	 * note.setCreatedBy(createdBy); note.setContent(""); // set signatue in note
	 * UserPost userPost = userPostLocalService.getUserPost(createdBy); String
	 * userName = userPost.getUserName(); String departmentName =
	 * userPost.getDepartmentName(); String postMarking = userPost.getPostMarking();
	 * String sectionName = userPost.getSectionName(); JSONObject jsonObject =
	 * JSONFactoryUtil.createJSONObject(); jsonObject.put("userName", userName);
	 * jsonObject.put("postMarking", postMarking); jsonObject.put("sectionName",
	 * sectionName); jsonObject.put("departmentName", departmentName); String
	 * signature = jsonObject.toString(); note.setSignature(signature);
	 * noteLocalService.addNote(note); FileNote fileNote =
	 * fileNoteLocalService.createFileNote(); fileNote.setNoteId(generateNoteId);
	 * fileNote.setFileMovementId(fileMovementId); fileNote.setFileId(fileId);
	 * fileNoteLocalService.addFileNote(fileNote); return note;
	 * 
	 * 
	 * }
	 */

	@Reference
	private FileNoteLocalService fileNoteLocalService;
	
	@Reference
	private UserPostLocalService userPostLocalService;
	
	private static Log logger = LogFactoryUtil.getLog(NoteLocalServiceImpl.class);
}