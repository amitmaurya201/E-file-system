package io.jetprocess.docstoreimpl;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.URLCodec;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.docstore.DocStore;

@Component(immediate = true, service = DocStore.class)
public class DocStoreImpl implements DocStore {
	long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	@Override
	public long documentAndMediaFileUpload(long groupId, InputStream is, String title,String mimeType, String changeLog, long totalSpace, String description)throws PortalException, IOException {	
		//long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long documentAndMediaFileId = 0l;
		long userId = PrincipalThreadLocal.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setScopeGroupId(groupId);
		Folder mainFolder=null;
		Folder currentYearFolder=null;
		Folder currentMonthFolder =null;
		if(!isMainFolderExits(groupId)) {
			System.out.println("test");
			mainFolder	=createMainFolder(groupId);
			System.out.println("isMainFolderExits");
		}
			if(!isCurrentYearFolderExists(groupId)) {
				System.out.println("test1");
				List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId,parentFolderId);
				for(Folder jetProcessFolder:mainFolders) {
					currentYearFolder=createCurrentYearFolder(groupId, jetProcessFolder.getFolderId(), serviceContext);
				}
				
				System.out.println("isCurrentYearFolderExists");
			}
				if(!isCurrentMonthFolderExists(groupId)) {
					System.out.println("test2");
					Calendar cal = Calendar.getInstance();
					 int year = cal.get(Calendar.YEAR);
			        String yearFolderName = String.valueOf(year);
					List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, parentFolderId);
			    	for (Folder jetProcessFolder : mainFolders) {
			    		long jetProcessFolderId = jetProcessFolder.getFolderId();
			    		List<Folder> yearFolderList = DLAppServiceUtil.getFolders(groupId, jetProcessFolderId);
			    		for (Folder yearFolder : yearFolderList) {
			    			long yearFolderId = yearFolder.getFolderId();
			    			if(yearFolder.getName().equals(yearFolderName)) {
			    				currentMonthFolder = createCurrentMonthFolder(groupId, yearFolderId, serviceContext);
			    				FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", groupId, currentMonthFolder.getFolderId(), title, mimeType,title, description, "", changeLog, is, 0l, null, null, serviceContext);
								 documentAndMediaFileId = fileEntry.getFileEntryId();
								 System.out.println("isCurrentMonthFolderExists iffffffff");
			    			} 		
			    	}
			    }
					
			}else {
					System.out.println("test3");
					long currentReqMonthFolder=getCurrentMonthFolder(groupId);
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", groupId, currentReqMonthFolder, title, mimeType,title, description, "", changeLog, is, 0l, null, null, serviceContext);
					 documentAndMediaFileId = fileEntry.getFileEntryId();
					 System.out.println("isCurrentMonthFolderExists elseeeeeeee");
			}
				System.out.println(documentAndMediaFileId);

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
		StringBundler stringBundle = new StringBundler();
		try { 
			stringBundle.append("/documents/");
			stringBundle.append(fileEntry.getGroupId());
			stringBundle.append(StringPool.SLASH);
			stringBundle.append(fileEntry.getFolderId());
			stringBundle.append(StringPool.SLASH);
			stringBundle.append(URLCodec.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()), true));
			stringBundle.append("?version=");
			stringBundle.append(fileEntry.getFileVersion().getVersion());
			stringBundle.append("&amp;t="); 
			Date modifiedDate = fileEntry.getFileVersion().getModifiedDate();
			stringBundle.append(modifiedDate.getTime());	 
	
	}catch (Exception e) {
		logger.info(e.getMessage());
	}
		return stringBundle.toString();
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
		return  fileEntry.getFileEntryId();
	}
	private boolean isMainFolderExits(long groupId) throws PortalException {
		boolean mainFolderExists=false;
		//long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		System.out.println("inmainfolder");
		 String folderName= "Jet_Process";
		List<Folder> mainFolder = DLAppServiceUtil.getFolders(groupId, parentFolderId);
		System.out.println("mainFolder"+mainFolder);
		if(!mainFolder.isEmpty()) {
		 mainFolderExists=true;
		}
		return mainFolderExists;
	}
	private Folder createMainFolder(long groupId) throws PortalException {
		long userId = PrincipalThreadLocal.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setScopeGroupId(groupId);
        String folderName= "Jet_Process";
        Folder mainFolder  = DLAppServiceUtil.addFolder(groupId, parentFolderId,folderName, "", serviceContext);
			
		return mainFolder;
		
	}
	private boolean isCurrentYearFolderExists(long groupId) throws PortalException {
		boolean currentYearFolder=false;
		Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String yearFolderName = String.valueOf(year);
		List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, parentFolderId);
		System.out.println("mainFolders"+mainFolders);
		for (Folder jetProcessFolder : mainFolders) {
			long jetProcessFolderId = jetProcessFolder.getFolderId();
			System.out.println(jetProcessFolder.getName());
			List<Folder> yearFolderList = DLAppServiceUtil.getFolders(groupId, jetProcessFolderId);
			System.out.println("yearFolderList"+yearFolderList);
			for (Folder yearFolder : yearFolderList) {
				long yearFolderId = yearFolder.getFolderId();
				System.out.println("yearFolder"+yearFolder.getName());
				
				if(yearFolder.getName().equals(yearFolderName)) {
					System.out.println("true");
					currentYearFolder=true;
				}		
			}
			
		}
		System.out.println("currentYearFolder"+currentYearFolder);
		return currentYearFolder;
	}
	private Folder createCurrentYearFolder(long groupId,long mainFolderId, ServiceContext serviceContext) throws PortalException {
		Calendar cal = Calendar.getInstance();
      int year = cal.get(Calendar.YEAR);
        String yearFolderName = String.valueOf(year);
		Folder yearFolder  = DLAppServiceUtil.addFolder(groupId, mainFolderId, yearFolderName, "",serviceContext);
		return yearFolder;
		
	}
	private boolean isCurrentMonthFolderExists(long groupId) throws PortalException {
		boolean currentMonthFolder=false;
		Calendar cal = Calendar.getInstance();
		 int month = cal.get(Calendar.MONTH) + 1;
	        String monthFolderName = String.valueOf(month);
        	List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, parentFolderId);
	    	for (Folder jetProcessFolder : mainFolders) {
	    		long jetProcessFolderId = jetProcessFolder.getFolderId();
	    		List<Folder> yearFolderList = DLAppServiceUtil.getFolders(groupId, jetProcessFolderId);
	    		for (Folder yearFolder : yearFolderList) {
	    			long yearFolderId = yearFolder.getFolderId();
	    		List<Folder> monthFolderList = DLAppServiceUtil.getFolders(groupId, yearFolderId);
	    		System.out.println("monthFolderList"+monthFolderList);
	    		for(Folder monthFolder:monthFolderList) {
	    			System.out.println("month folderName"+monthFolder.getName());
	    			if(monthFolder.getName().equals(monthFolderName)) {
	    				System.out.println("true");
	    				currentMonthFolder=true;
	    			
	    			}	
	    		}
	    	}
	    }
	    System.out.println("currentMonthFolder"+currentMonthFolder);
	    return currentMonthFolder;
	    		
	}
	private Folder createCurrentMonthFolder(long groupId,long currentYearFolderId, ServiceContext serviceContext) throws PortalException {
		Calendar cal = Calendar.getInstance();
		 int month = cal.get(Calendar.MONTH) + 1;
	     String monthFolderName = String.valueOf(month);
		Folder monthFolder  = DLAppServiceUtil.addFolder(groupId, currentYearFolderId, monthFolderName, "",serviceContext);
		return monthFolder;
		
	}
	private long getCurrentMonthFolder(long groupId) throws PortalException {
		long reqFolderId=0l;
		Calendar cal = Calendar.getInstance();
		 int month = cal.get(Calendar.MONTH) + 1;
	     String monthFolderName = String.valueOf(month);
		List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, parentFolderId);
		for (Folder jetProcessFolder : mainFolders) {
			long jetProcessFolderId = jetProcessFolder.getFolderId();
			List<Folder> subFoldersList = DLAppServiceUtil.getFolders(groupId, jetProcessFolderId);
			for (Folder subFolders : subFoldersList) {
				long subFolderId = subFolders.getFolderId();
				List<Folder> lastFoldersList = DLAppServiceUtil.getFolders(groupId, subFolderId);
				for (Folder subSubFolders : lastFoldersList) {
					String  folderName = subSubFolders.getName();
					 if(folderName.equals(monthFolderName)) {
						 reqFolderId=subSubFolders.getFolderId();
						 
					 }

				}
			}
		}
		return reqFolderId;
	}
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
	
	  