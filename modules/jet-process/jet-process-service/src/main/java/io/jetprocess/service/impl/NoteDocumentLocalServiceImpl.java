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

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.core.util.NoteDocumentStatus;
import io.jetprocess.model.DocumentNoteMap;
import io.jetprocess.model.Note;
import io.jetprocess.model.NoteDocument;
import io.jetprocess.service.DocumentNoteMapLocalService;
import io.jetprocess.service.NoteDocMovementLocalServiceUtil;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.service.base.NoteDocumentLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.NoteDocument", service = AopService.class)
public class NoteDocumentLocalServiceImpl extends NoteDocumentLocalServiceBaseImpl {

	public DocumentNoteMap addNoteDocument(String noteSubject, long noteCategoryId, Date createdOn, String content,
			long createdBy) {

		long noteDocumentId = counterLocalService.increment(NoteDocument.class.getName());
		NoteDocument noteDocument = createNoteDocument(noteDocumentId);
		noteDocument.setCreatedBy(createdBy);
		noteDocument.setSubject(noteSubject);
		noteDocument.setSubjectCategoryId(noteCategoryId);
		noteDocument.setCreateDate(createdOn);
		noteDocument.setNoteDocumentNumber(generateNoteDocumentNumber(noteDocumentId));
		noteDocument.setCurrentlyWith(createdBy);
		noteDocument.setCurrentState(NoteDocumentStatus.CREADTED);
		addNoteDocument(noteDocument);
		long noteId = counterLocalService.increment(Note.class.getName());
		Note note = noteLocalService.createNote(noteId);
		note.setContent(content);
		note.setCreatedBy(createdBy);
		noteLocalService.addNote(note);
		long documentNoteMapId = counterLocalService.increment(DocumentNoteMap.class.getName());
		DocumentNoteMap documentNoteMap = documentNoteMapLocalService.createDocumentNoteMap(documentNoteMapId);
		documentNoteMap.setNoteId(noteId);
		documentNoteMap.setNoteDocumentId(noteDocumentId);
		documentNoteMapLocalService.addDocumentNoteMap(documentNoteMap);
		NoteDocMovementLocalServiceUtil.saveNoteDocumentMovement(createdBy, createdBy, noteDocumentId, "", false,
				MovementStatus.CREATED);
		return documentNoteMap;
	}

	public Note updateNoteDocument(long noteId, String content) throws PortalException {
		System.out.println(noteId);
		System.out.println("content" + content);
		Note note = noteLocalService.getNote(noteId);
		note.setContent(content);
		noteLocalService.updateNote(note);
		return note;

	}

	public String generateNoteDocumentNumber(long noteDocumentId) {
		String noteDocumentNumber = "N" + noteDocumentId;
		return noteDocumentNumber;
	}

	@Reference
	private NoteLocalService noteLocalService;

	@Reference
	private DocumentNoteMapLocalService documentNoteMapLocalService;

}