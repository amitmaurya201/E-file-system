
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
	  
		// delete doc file
		public DocFile deleteDocFile(long docFileId) throws PortalException {
			DocFile docFile = docFileLocalService.getDocFile(docFileId);
			return docFileLocalService.deleteDocFile(docFile);
		}

		 // get all DocFile list 
			public List<DocFile> getDocFileList(){
				return docFileLocalService.getDocFileList();
				
			}
			
		  // add nonsfsdocfile 
			
			public JSONObject addDocFile(long groupId, String nature, String type,long basicHeadId,long primaryHeadId,long secondaryHeadId,long tertiaryHeadId,long year,long fileCodeId, String subject,String fileNumber, long categoryId,
		long subCategoryId, String remarks, String reference,long userPostId, ServiceContext serviceContext)  throws PortalException {
				return docFileLocalService.addDocFile(groupId, nature, type, basicHeadId, primaryHeadId, secondaryHeadId, tertiaryHeadId, year, fileCodeId, subject, fileNumber, categoryId, subCategoryId, remarks, reference, userPostId, serviceContext);
			}
			
	
         // update SfsDocFile 
       public DocFile updateDocFile(long docFileId, String subject, long categoryId,
		long subCategoryId, String remarks, String reference,long userPostId, ServiceContext serviceContext)
		throws PortalException {
			return docFileLocalService.updateDocFile(docFileId, subject, categoryId, subCategoryId, remarks, reference, userPostId, serviceContext);
           
}
         
          
       
}
