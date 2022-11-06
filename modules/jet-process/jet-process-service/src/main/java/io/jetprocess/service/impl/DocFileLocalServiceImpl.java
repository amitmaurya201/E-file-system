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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.base.DocFileLocalServiceBaseImpl;
import io.jetprocess.validator.FileValidator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.DocFile",
	service = AopService.class
)
public class DocFileLocalServiceImpl extends DocFileLocalServiceBaseImpl {
	
	
	@Reference
	private FileValidator fileValidator;
	
		// delete
		public DocFile deleteDocFile(DocFile docFile) {
			return super.deleteDocFile(docFile);
		}
        
		// get list of docfiles
		public List<DocFile> getDocFileList() {
			return super.getDocFiles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		}

		public JSONObject addDocFile(long groupId, String nature, String type,long basicHeadId,long primaryHeadId,long secondaryHeadId,long tertiaryHeadId,long year,long fileCodeId, String subject,String fileNumber, long categoryId,
		long subCategoryId, String remarks, String reference, long userPostId, ServiceContext serviceContext) throws PortalException {
			
			List<String> errors =fileValidator.validate(subject, remarks, reference);
	
			     System.out.println("list of Errors "+errors);
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				if (errors.size() > 0) {
					jsonObject.put("errorList", errors);
					System.out.println("error list of json" + jsonObject.getString("errorList").toCharArray().toString());
					return jsonObject;
				}

			Group group = groupLocalService.getGroup(groupId);
			
			// get userId from the ServiceContext
			long userId = serviceContext.getUserId();
			// get user from the userId
			User user = userLocalService.getUser(userId);

			// Generate the new primary key
			long docFileId = counterLocalService.increment(DocFile.class.getName());

			// get docFile object from the docFileId
			DocFile docFile = createDocFile(docFileId);
   
			if(!fileNumber.isEmpty()) {
				docFile.setFileNumber(fileNumber);
				
			}else {
				
				fileNumber = getGenerateFileNumber(docFile);
				docFile.setFileNumber(fileNumber);
				
			}
			
	//   	String fileNumber = getGenerateFileNumber(docFile);
			
			docFile.setNature(nature);
			docFile.setType(type);
			docFile.setSubject(subject);
			//docFile.setFileNumber(fileNumber);
			docFile.setBasicHeadId(basicHeadId);
			docFile.setPrimaryHeadId(primaryHeadId);
			docFile.setSecondaryHeadId(secondaryHeadId);
			docFile.setTertiaryHeadId(tertiaryHeadId);
			docFile.setYear(year);
			docFile.setFileCodeId(fileCodeId);
			docFile.setCategoryId(categoryId);
			docFile.setSubCategoryId(subCategoryId);
			docFile.setRemarks(remarks);
			docFile.setReference(reference);
            docFile.setUserPostId(userPostId);
           
			// set the audit fields

			docFile.setGroupId(groupId);
			docFile.setCompanyId(group.getCompanyId());
			docFile.setCreateDate(serviceContext.getCreateDate(new Date()));
			System.out.println("createDate is .... " + docFile.getCreateDate());

			docFile.setModifiedDate(serviceContext.getModifiedDate(new Date()));
			docFile.setUserId(userId);
			docFile.setUserName(user.getScreenName());
			
			docFile = super.addDocFile(docFile);

			jsonObject.put("nature", docFile.getNature());
			jsonObject.put("type", docFile.getType());
			jsonObject.put("subject", docFile.getSubject());
			
			jsonObject.put("basicHeadId", docFile.getBasicHeadId());
			jsonObject.put("primaryHeadId", docFile.getPrimaryHeadId());
			jsonObject.put("secondaryHeadId", docFile.getSecondaryHeadId());
			
			
			jsonObject.put("tertiaryHeadId", docFile.getTertiaryHeadId());
			jsonObject.put("year", docFile.getYear());
			jsonObject.put("fileCodeId", docFile.getFileCodeId());
			
			jsonObject.put("categoryId", docFile.getCategoryId());
			jsonObject.put("fileNumber", docFile.getFileNumber());
			jsonObject.put("subCategoryId", docFile.getSubCategoryId());
			jsonObject.put("remarks", docFile.getRemarks());
			jsonObject.put("reference", docFile.getReference());
			jsonObject.put("groupId", docFile.getGroupId());
			jsonObject.put("companyId", docFile.getCompanyId());
			jsonObject.put("createdDate", docFile.getCreateDate());
			jsonObject.put("modifiedDate", docFile.getModifiedDate());
			jsonObject.put("userId", docFile.getUserId());
			jsonObject.put("userName", docFile.getUserName());
            jsonObject.put("userPostId", docFile.getUserPostId());
			
			return jsonObject;
			
		}
		
		
		// Update Method for DocFile 
		public DocFile updateDocFile(long docFileId ,String subject,long categoryId,long subCategoryId,String remarks,String reference,long userPostId, ServiceContext serviceContext) throws PortalException {
		DocFile docFile = getDocFile(docFileId);
		docFile.setSubject(subject);
		docFile.setCategoryId(categoryId);
		docFile.setSubCategoryId(subCategoryId);
		docFile.setRemarks(remarks);
		docFile.setReference(reference);
		docFile.setUserPostId(userPostId);
		docFile.setModifiedDate(serviceContext.getModifiedDate(new Date()));	
		docFile = super.updateDocFile(docFile);	
			return docFile;
			
		}


		// for generating the fileNumber .
			public String getGenerateFileNumber(DocFile docfile) {
				long fileNumber1 = docfile.getDocFileId();
				String number = String.valueOf(fileNumber1);
				String filenumber = 'F' + number;
				return filenumber;
			}
		

}
