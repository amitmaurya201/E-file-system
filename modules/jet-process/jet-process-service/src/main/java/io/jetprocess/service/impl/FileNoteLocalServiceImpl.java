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

import org.osgi.service.component.annotations.Component;

import io.jetprocess.exception.NoSuchFileNoteException;
import io.jetprocess.model.FileNote;
import io.jetprocess.service.base.FileNoteLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.FileNote", service = AopService.class)
public class FileNoteLocalServiceImpl extends FileNoteLocalServiceBaseImpl {
	
	public FileNote createFileNote() {
		long fileNoteId = counterLocalService.increment(FileNote.class.getName());
		return fileNoteLocalService.createFileNote(fileNoteId);
	}

	public void deleteFileNoteByNoteId(long noteId) throws NoSuchFileNoteException {
		FileNote fileNote = fileNotePersistence.findByNoteId(noteId);
		fileNoteLocalService.deleteFileNote(fileNote);
	}

	public FileNote getFileNoteByFilemovementId(long filemovementId) {
		FileNote fileNote = null;
		try {
			fileNote = fileNotePersistence.findByfilemovementId(filemovementId);
		} catch (NoSuchFileNoteException e) {
			e.printStackTrace();
		}
		return fileNote;
	}
}