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
 *    
 */

package io.jetprocess.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.base.DocFileLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=io.jetprocess.model.DocFile",
	service = AopService.class
)
public class DocFileLocalServiceImpl extends DocFileLocalServiceBaseImpl {

public DocFile addDocFile(long groupId,String nature,String type,String subject,String category,String subCategory,String remarks,String reference,ServiceContext serviceContext) throws PortalException {
		
		System.out.println("Local Service method called ....");
		// get group from the groupId
		Group group = groupLocalService.getGroup(groupId);
		
		// get userId from the ServiceContext 
	   long userId = serviceContext.getUserId();
		// get user from the userId
	   User user =  userLocalService.getUser(userId);		
		
	   // Generate the new primary key 
	  long docFileId  =  counterLocalService.increment(DocFile.class.getName());
	  
	  // get docFile object from the docFileId
      DocFile docFile =  createDocFile(docFileId);	  
      // calling method getGeneratedFileNumber(docFile)
      String fileNumber =  docFileLocalService.getGenerateFileNumber(docFile);     
      // set the all values of docFile into the docFile object 
      docFile.setNature(nature);
      docFile.setType(type);
      docFile.setSubject(subject);
      docFile.setFileNumber(fileNumber);
      docFile.setCategory(category);
      docFile.setSubCategory(subCategory);
      docFile.setRemarks(remarks);
      docFile.setReference(reference);
      
      // set the audit fields 

      docFile.setGroupId(groupId);
      docFile.setCompanyId(group.getCompanyId());
      docFile.setCreateDate(serviceContext.getCreateDate(new Date()));
      docFile.setModifiedDate(serviceContext.getModifiedDate(new Date()));
      docFile.setUserId(userId);
      docFile.setUserName(user.getScreenName());
      
     docFile =  super.addDocFile(docFile);
      
		return docFile;	
		
	}

public DocFile updateDocFile(long docFileId, String nature,String type,String subject,String fileNumber,String category,String subCategory,String remarks,String reference,ServiceContext serviceContext) throws PortalException {
	DocFile docFile = getDocFile(docFileId);
	docFile.setNature(nature);
	docFile.setType(type);
	docFile.setSubject(subject);
	docFile.setFileNumber(fileNumber);
	docFile.setCategory(category);
	docFile.setSubCategory(subCategory);
	docFile.setRemarks(remarks);
	docFile.setReference(reference);
	docFile.setModifiedDate(serviceContext.getModifiedDate(new Date()));
    docFile = super.updateDocFile(docFile);
	return docFile;
	
}
 
public List<DocFile> getDocFileByGroupId(long groupId,int start,int end){
	return docFilePersistence.findBygroupId(groupId, start, end);
	
	
}	

// for generating the fileNumber .
public String getGenerateFileNumber(DocFile docfile) {		
	  long fileNumber1 = docfile.getDocFileId(); 
	  String number =String.valueOf(fileNumber1); 
	  String filenumber = 'F'+number;
       return filenumber;	 
}

@Override
public DocFile addDocFile(long groupId, String nature, String type, String fileNumber, String subject, String catagory,
		String subCategory, String remarks, String reference, ServiceContext serviceContext) throws PortalException {
	// TODO Auto-generated method stub
	return null;
}


}