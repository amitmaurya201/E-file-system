package io.jetprocess.docstoreimpl;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.URLCodec;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import io.jetprocess.docstore.DocStore;

@Component(immediate = true, service = DocStore.class)
public class DocStoreImpl implements DocStore {
	
	@Override
	public long documentAndMediaFileUpload(long groupId, long fileEntryId, InputStream is, String title,String mimeType, String changeLog, long totalSpace, String description)throws PortalException, IOException {	
		long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long documentAndMediaFileId = 0l;
		long userId = PrincipalThreadLocal.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		
		serviceContext.setScopeGroupId(groupId);
		if(!isFolderExist(groupId, folderId)) {
			createFolder(groupId, folderId, description);
			long subFolderId = subFolderId(groupId);
			FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", groupId, subFolderId, title, mimeType,title, description, "", changeLog, is, 0l, null, null, serviceContext);
			 documentAndMediaFileId = fileEntry.getFileEntryId();
		
		}
		else {
			
		long subFolderId = subFolderId(groupId);
		FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", groupId, subFolderId, title, mimeType,title, description, "", changeLog, is, 0l, null, null, serviceContext);
		 documentAndMediaFileId = fileEntry.getFileEntryId();}
		return documentAndMediaFileId;
	}


	@Override
	public String downloadDocumentAndMediaFile(String groupId,long fileEntryId) throws PortalException, IOException {
		long siteId= Long.parseLong(groupId);
		FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
		Group group = GroupLocalServiceUtil.getGroup(siteId);
		Company company = CompanyLocalServiceUtil.getCompany(group.getCompanyId());
		String portalURL = PortalUtil.getPortalURL(company.getVirtualHostname(), PortalUtil.getPortalLocalPort(false), false);
		String url = portalURL + "/c/document_library/get_file?uuid=" + fileEntry.getUuid() + "&amp;groupId=" + fileEntry.getGroupId();	
		return url;
	}
	@Override
	public String ViewDocumentAndMediaFile(long fileEntryId) throws PortalException, IOException {
		FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
		StringBundler sb = new StringBundler();
		try { 
			sb.append("/documents/");
			sb.append(fileEntry.getGroupId());
			sb.append(StringPool.SLASH);
			sb.append(fileEntry.getFolderId());
			sb.append(StringPool.SLASH);
			sb.append(URLCodec.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()), true));
			sb.append("?version=");
			sb.append(fileEntry.getFileVersion().getVersion());
			sb.append("&amp;t="); 
			Date modifiedDate = fileEntry.getFileVersion().getModifiedDate();
			sb.append(modifiedDate.getTime());	 
	
	}catch (Exception e) {
		e.printStackTrace();
	}
		return sb.toString();
}


	@Override
	public void deleteTempFile(long fileEntryId) throws PortalException {
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
		long groupId =fileEntry.getGroupId();
		long folderId=fileEntry.getFolderId();
		String fileName = fileEntry.getFileName();
	    String folderName = "JetProcessDocStore";
		DLAppServiceUtil.deleteTempFileEntry(groupId, folderId, folderName, fileName);
		
	}

	@Override
	public FileEntry getTempFile(long fileEntryId) throws PortalException {
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
		return fileEntry;
	}

	@Override
	public long tempFileUpload(long siteId, long parentFolderId, String folderName, String fileName, InputStream inputStream, String contentType) throws PortalException {
		FileEntry fileEntry = DLAppServiceUtil.addTempFileEntry(siteId, parentFolderId, folderName, fileName,inputStream, contentType);
		long tempFileId = fileEntry.getFileEntryId();
	
		return tempFileId;
	}


	private boolean isFolderExist(long groupId, long folderId) {
		boolean folderExist = false;
		try {
			List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, folderId);
			for (Folder subFolderList : mainFolders) {

				long subFolder = subFolderList.getFolderId();
				List<Folder> subFoldersList = DLAppServiceUtil.getFolders(groupId, subFolder);
				for (Folder subFolders : subFoldersList) {
					long subFolderId = subFolders.getFolderId();
					
					folderExist = true;
				}
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return folderExist;
	}

	private long subFolderId(long groupId) throws PortalException {
		long reqFolderId=0l;
		List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		for (Folder subFolderList : mainFolders) {
			long subFolder = subFolderList.getFolderId();
			List<Folder> subFoldersList = DLAppServiceUtil.getFolders(groupId, subFolder);
			for (Folder subFolders : subFoldersList) {
				long subFolderId = subFolders.getFolderId();
			
				List<Folder> lastFoldersList = DLAppServiceUtil.getFolders(groupId, subFolderId);
				for (Folder subSubFolders : lastFoldersList) {
					 reqFolderId = subSubFolders.getFolderId();

				}
			}
		}
		return reqFolderId;
	}

	private void createFolder(long groupId, long folderId, String description) {
		long userId = PrincipalThreadLocal.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setScopeGroupId(groupId);
		 Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
		
        String folderName= "Jet_Process";
        Folder folder1 = null;
        try {
        	folder1 = DLAppServiceUtil.addFolder(groupId, folderId,folderName, description, serviceContext);
			
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if (folder1.getName().equals(folderName)) {
			long firstFolderId = folder1.getFolderId();
		  String yearFolderName = String.valueOf(year);
		  Folder folder2 = null;
		try {
			folder2 = DLAppServiceUtil.addFolder(groupId, firstFolderId, yearFolderName, description, serviceContext);
			
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if (folder2.getName().equals(yearFolderName)) {
			long secondFolderId = folder2.getFolderId();
			String monthFolderName = String.valueOf(month);
			
			try {
				folder1 = DLAppServiceUtil.addFolder(groupId, secondFolderId, monthFolderName, description,
						serviceContext);
				
			} catch (PortalException e) {	
				e.printStackTrace();
			}

		}
	}
	}
}
	
	  