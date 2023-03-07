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

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;

import io.jetprocess.model.NoteDocument;
import io.jetprocess.service.base.NoteDocumentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.NoteDocument",
	service = AopService.class
)
public class NoteDocumentLocalServiceImpl
	extends NoteDocumentLocalServiceBaseImpl {
	
	public NoteDocument  addNoteDocument(String noteDocumentNumber , String subject , long createdBy , long subjectCategoryId ) {
		
		
		
		return null;
	}
	
	@Reference
	private CounterLocalService counterLocalService;
	
	
}