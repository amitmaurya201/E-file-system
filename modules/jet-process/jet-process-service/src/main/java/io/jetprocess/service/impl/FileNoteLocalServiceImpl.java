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

import java.util.List;

import io.jetprocess.exception.NoSuchFileNoteException;
import io.jetprocess.model.FileNote;
import io.jetprocess.service.base.FileNoteLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.FileNote",
	service = AopService.class
)
public class FileNoteLocalServiceImpl extends FileNoteLocalServiceBaseImpl {
	public FileNote createFileNote() {
		  long fileNoteId = counterLocalService.increment(FileNote.class.getName());
		  FileNote fileNote = fileNoteLocalService.createFileNote(fileNoteId);
		return fileNote;
	}
	 public FileNote  getNoteByFileIdAndUserpostId(long fileId, long noteId) throws NoSuchFileNoteException   {
		FileNote fileNote= fileNotePersistence.findByFileIdAndNoteId(fileId, noteId);
			 return fileNote;
		 }
	 
	public void deleteFileNoteByNoteId(long noteId) throws NoSuchFileNoteException {
		FileNote fileNote = fileNotePersistence.findByNoteId(noteId);
		fileNoteLocalService.deleteFileNote(fileNote);
		
	}

	 public List<FileNote> getFileNoteListByFileId(long fileId){
			List<FileNote> fileNoteList = fileNotePersistence.findByFileNoteListByFileId(fileId);
			  return fileNoteList;
		   }

}