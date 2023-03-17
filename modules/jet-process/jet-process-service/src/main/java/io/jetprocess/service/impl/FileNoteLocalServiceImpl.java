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
import io.jetprocess.core.util.MovementStatus;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.exception.NoSuchFileNoteException;
import io.jetprocess.model.FileNote;
import io.jetprocess.model.Note;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.service.base.FileNoteLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.FileNote", service = AopService.class)
public class FileNoteLocalServiceImpl extends FileNoteLocalServiceBaseImpl {
	
	public FileNote addFileNote(String content, long createdBy, long fileId, long noteId, long fileMovementId,boolean hasYellowNote) {
		 FileNote fileNote = null;
		 Note note;
		try {
			if(noteId==0) {
				note=noteLocalService.createNote(content, createdBy, hasYellowNote);
				fileNote=createFileNote(counterLocalService.increment(FileNote.class.getName()));
				fileNote.setNoteId(note.getNoteId());
				fileNote.setFileMovementId(fileMovementId); fileNote.setFileId(fileId);
				fileNote.setMovementType(MovementStatus.CREATED);
				addFileNote(fileNote);
				
			}
			else {
				fileNote=getFileNote(noteId);
				note=noteLocalService.editNote(noteId, content, createdBy);
				fileNote.setModifiedDate(new Date());
				updateFileNote(fileNote);
				
			}
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return fileNote; 
		  
	   }


	public void deleteFileNoteByNoteId(long noteId) throws NoSuchFileNoteException {
		logger.info("delete FileNoteByNoteId method called");
		FileNote fileNote = fileNotePersistence.findByNoteId(noteId);
		fileNoteLocalService.deleteFileNote(fileNote);
	}

	public List <FileNote> getFileNoteListByFilemovementId(long fileMovementId){
	  List<FileNote> fileNoteList =  fileNotePersistence.findByfilemovementId(fileMovementId);
	 return fileNoteList;
	}
	
	@Reference
	private NoteLocalService noteLocalService;
	private static Log logger = LogFactoryUtil.getLog(FileNoteLocalServiceImpl.class);

}