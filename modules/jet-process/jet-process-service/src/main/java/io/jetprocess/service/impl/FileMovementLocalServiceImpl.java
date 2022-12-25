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
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileMovement;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileMovementLocalService;
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
	 * 
	 * @param receiverId
	 * @param senderId
	 * @param fileId
	 * @param priority
	 * @param dueDate
	 * @param remark
	 */
	public void saveSendFile(long receiverId, long senderId, long fileId, String priority, String dueDate,
			String remark) {

		
		
		List<FileMovement> fileList = fileMovementLocalService.getFileMovements(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		FileMovement fileMov = fileList.stream().filter(file -> file.getFileId() == fileId).findAny().orElse(null);
	
		if (fileMov == null) {

			saveFileMovement(receiverId, senderId, fileId, priority, dueDate, remark);

		} else {
			
			Long maxFmId = masterdataLocalService.getMaximumFmIdByFileIdData(fileId);
			try {
				FileMovement fm;
				try {
					fm = fileMovementLocalService.getFileMovement(maxFmId);
					if (fm.getReceivedOn().isEmpty() && fm.getReadOn().isEmpty()) {
						
						DocFile docFile;
						try {
							docFile = docFileLocalService.getDocFile(fileId);
							if (docFile.getNature().equals("Electronic")) {

								fm.setReadOn("read");
								fileMovementLocalService.updateFileMovement(fm);
								saveFileMovement(receiverId,senderId, fileId, priority, dueDate, remark);

							} else if (docFile.getNature().equals("Physical")) {

								fm.setReceivedOn("receive");
								fileMovementLocalService.updateFileMovement(fm);
								saveFileMovement(receiverId,senderId, fileId, priority, dueDate, remark);

							}
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				}catch (PortalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally {
				
			}
			}
	}
			
       public List<FileMovement> getFileMovementByFileId(long fileId){
		
		return fileMovementPersistence.findByfileId(fileId);
	
       }
	
	// get Filemovement by fileMovementId
	public FileMovement getFileMovementById(long fmId) throws PortalException {

		FileMovement fileMovement = fileMovementLocalService.getFileMovement(fmId);
		return fileMovement;
	}

	void saveFileMovement(long receiverId, long senderId, long fileId, String priority, String dueDate, String remark
			) {

		long fmId = counterLocalService.increment(FileMovement.class.getName());
		FileMovement fm = fileMovementLocalService.createFileMovement(fmId);
		fm.setFmId(fmId);
		fm.setReceiverId(receiverId);
		fm.setSenderId(senderId);
		fm.setFileId(fileId);
		fm.setRemark(remark);
		fm.setPriority(priority);
		fm.setDueDate(dueDate);
		
		FileMovement fileMovement = fileMovementLocalService.addFileMovement(fm);
		if (fileMovement.getActive() != true) {
			fileMovement.setActive(true);
			fileMovementLocalService.updateFileMovement(fileMovement);
		}

		try {
			DocFile docFile = docFileLocalService.getDocFileByDocFileId(fileId);
			if (fileId == docFile.getDocFileId()) {
				docFile.setCurrentlyWith(receiverId);
				docFileLocalService.updateDocFile(docFile);
				if (Validator.isNotNull(docFile.getCurrentState())) {
					docFile.setCurrentState(2);
					docFileLocalService.updateDocFile(docFile);

				}
			} else {
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
	
	

	@Reference
	DocFileLocalService docFileLocalService;

	@Reference
	MasterdataLocalService masterdataLocalService;
}
