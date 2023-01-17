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

package io.jetprocess.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the content column in Note.
 *
 * @author Brian Wing Shun Chan
 * @see Note
 * @generated
 */
public class NoteContentBlobModel {

	public NoteContentBlobModel() {
	}

	public NoteContentBlobModel(long noteId) {
		_noteId = noteId;
	}

	public NoteContentBlobModel(long noteId, Blob contentBlob) {
		_noteId = noteId;
		_contentBlob = contentBlob;
	}

	public long getNoteId() {
		return _noteId;
	}

	public void setNoteId(long noteId) {
		_noteId = noteId;
	}

	public Blob getContentBlob() {
		return _contentBlob;
	}

	public void setContentBlob(Blob contentBlob) {
		_contentBlob = contentBlob;
	}

	private long _noteId;
	private Blob _contentBlob;

}