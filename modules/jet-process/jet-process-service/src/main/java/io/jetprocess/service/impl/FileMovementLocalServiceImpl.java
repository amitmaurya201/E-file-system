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
import com.liferay.portal.kernel.util.Validator;

import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileMovement;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.base.FileMovementLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.FileMovement", service = AopService.class)
public class FileMovementLocalServiceImpl extends FileMovementLocalServiceBaseImpl {
	
	/**
	 * create save send file method
	 * @param receiverId
	 * @param senderId
	 * @param fileId
	 * @param priority
	 * @param dueDate
	 * @param remark
	 */
	public void saveSendFile(long receiverId, long senderId, long fileId, String priority, String dueDate,
			String remark) {
		long fmId = counterLocalService.increment(FileMovement.class.getName());
		FileMovement fm = fileMovementLocalService.createFileMovement(fmId);
		fm.setFmId(fmId);
		fm.setReceiverId(receiverId);
		fm.setSenderId(senderId);
		fm.setFileId(fileId);
		fm.setRemark(remark);
		fm.setPriority(priority);
		fm.setDueDate(dueDate);
		fileMovementLocalService.addFileMovement(fm);

		try {
			DocFile docFile=docFileLocalService.getDocFileByDocFileId(fileId);
			if(fileId==docFile.getDocFileId()) {
				docFile.setCurrentlyWith(receiverId);
				docFileLocalService.updateDocFile(docFile);
				if(Validator.isNotNull(docFile.getCurrentState())) {
					docFile.setCurrentState(2);
					docFileLocalService.updateDocFile(docFile);
				}
			}else {
				System.out.println("fileId not valid");
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

	}
	
	
	public FileMovement getFileByFileId(long fileId) {
		
		return fileMovementPersistence.fetchByfileId(fileId);
	}
	
	
	// get Filemovement by fileMovementId 
		public FileMovement getFileMovementById(long fmId) throws PortalException {
			
			  FileMovement fileMovement = fileMovementLocalService.getFileMovement(fmId);
			  return fileMovement;
				}
		

	@Reference
	DocFileLocalService docFileLocalService;
	
	
}