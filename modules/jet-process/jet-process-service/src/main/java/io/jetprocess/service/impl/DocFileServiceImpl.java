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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.base.DocFileServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=jet_process",
		"json.web.service.context.path=DocFile"
	},
	service = AopService.class
)
public class DocFileServiceImpl extends DocFileServiceBaseImpl {
	 // add sfsdocfile
		public JSONObject addSfsDocFile(long groupId, String nature, String type, String subject, long categoryId,
				long subCategoryId, String remarks, String reference, ServiceContext serviceContext) throws PortalException{
			System.out.println("impl service method called..");	
		
			return docFileLocalService.addSfsDocFile(groupId, nature, type, subject, categoryId, subCategoryId, remarks, reference, serviceContext);
				
	}
		// delete doc file
		public DocFile deleteDocFile(long docFileId) throws PortalException {
			DocFile docFile = docFileLocalService.getDocFile(docFileId);
			return docFileLocalService.deleteDocFile(docFile);
		}

		 // get all DocFile list 
			public List<DocFile> getDocFileList(){
				System.out.println("impl method called for getting list of docfiles ");
				return docFileLocalService.getDocFileList();
				
			}
			
		// add nonsfsdocfile 
			
			public JSONObject addNonSfsDocFile(long groupId, String nature, String type,long basicHeadId,long primaryHeadId,long secondaryHeadId,long tertiaryHeadId,long year,long fileCodeId, String subject, long categoryId,
		long subCategoryId, String remarks, String reference, ServiceContext serviceContext)  throws PortalException {
				System.out.println("nonsfs method call ho rha hai");
				return docFileLocalService.addNonSfsDocFile(groupId, nature, type, basicHeadId, primaryHeadId, secondaryHeadId, tertiaryHeadId, year, fileCodeId, subject, categoryId, subCategoryId, remarks, reference, serviceContext);		
				
			}
			
	
      // update SfsDocFile 
       public DocFile updateSfsDocFile(long docFileId, String nature, String type, String subject, long categoryId,
		long subCategoryId,String fileNumber, String remarks, String reference, ServiceContext serviceContext)
		throws PortalException {
			return docFileLocalService.updateSfsDocFile(docFileId, nature, type, subject, categoryId, subCategoryId, fileNumber, remarks, reference, serviceContext);
       }	
     
      // update NonSfsDocFile 
       
       public DocFile updateNonSfsDocFile(long docFileId,String nature ,String type,long basicHeadId,long primaryHeadId,long secondaryHeadId,long tertiaryHeadId, long year, long fileCodeId,String subject,String fileNumber,long categoryId,long subCategoryId,String remarks,String reference,ServiceContext serviceContext) throws PortalException{
		return docFileLocalService.updateNonSfsDocFile(docFileId, nature, type, basicHeadId, primaryHeadId, secondaryHeadId, tertiaryHeadId, year, fileCodeId, subject, fileNumber, categoryId, subCategoryId, remarks, reference, serviceContext);
 
       }
       
       
}