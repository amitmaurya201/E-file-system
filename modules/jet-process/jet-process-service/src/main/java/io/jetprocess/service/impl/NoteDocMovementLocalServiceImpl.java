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

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.model.NoteDocMovement;
import io.jetprocess.model.NoteDocument;
import io.jetprocess.service.NoteDocumentLocalService;
import io.jetprocess.service.base.NoteDocMovementLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.NoteDocMovement", service = AopService.class)
public class NoteDocMovementLocalServiceImpl extends NoteDocMovementLocalServiceBaseImpl {

	public NoteDocMovement saveNoteDocumentMovement(long receiverId, long senderId, long noteDocumentId, String remarks,
			boolean active, long movementType) {
		long movementId = counterLocalService.increment(NoteDocMovement.class.getName());
		NoteDocMovement noteDocMovement = createNoteDocMovement(movementId);
		noteDocMovement.setReceiverId(receiverId);
		noteDocMovement.setSenderId(senderId);
		noteDocMovement.setNoteDocumentId(noteDocumentId);
		noteDocMovement.setRemarks(remarks);
		noteDocMovement.setActive(active);
		noteDocMovement.setMovementType(movementType);
		noteDocMovement = addNoteDocMovement(noteDocMovement);
		return noteDocMovement;
	}

	public NoteDocMovement sendNoteDocumentMovement(long receiverId, long senderId, long noteDocumentId,
			String remarks) {
		boolean active = true;
		long movementType = MovementStatus.NORMAL;
		NoteDocMovement noteDocumentMovement = null;
		try {
			NoteDocument noteDocument = noteDocumentLocalService.getNoteDocument(noteDocumentId);
			noteDocument.setCurrentState(FileStatus.IN_MOVEMENT);
			noteDocument.setCurrentlyWith(receiverId);
			noteDocumentLocalService.updateNoteDocument(noteDocument);
			noteDocumentMovement = saveNoteDocumentMovement(receiverId, senderId, noteDocumentId, remarks, active,
					movementType);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return noteDocumentMovement;
	}

	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
}