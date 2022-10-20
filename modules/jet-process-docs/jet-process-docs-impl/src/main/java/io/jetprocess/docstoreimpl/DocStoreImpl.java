package io.jetprocess.docstoreimpl;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.docstore.DocStore;

@Component(immediate = true, service = DocStore.class)
public class DocStoreImpl implements DocStore {
	@Override
	public long uploadFile(long groupId, InputStream is, String title, String mimeType, String changeLog,
			long totalSpace, String description) {
		long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long fileId = 0l;
		long userId = PrincipalThreadLocal.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setScopeGroupId(groupId);
		if (isFolderExist(groupId, folderId)) {
			long subFolderId = 0l;
			try {
				subFolderId = subFolderId(groupId);
			} catch (PortalException e1) {
				System.out.println("subfolderId exception");
				e1.printStackTrace();
			}
			if (subFolderId != 0) {
				try {
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", groupId, subFolderId, title, mimeType,
							title, description, "", changeLog, is, 0l, null, null, serviceContext);
					fileId = fileEntry.getFileEntryId();
				} catch (PortalException e) {
					System.out.println("creating file exception");
					e.printStackTrace();
				}

			} else {
				createFolder(groupId, folderId, description);
				try {
					subFolderId = subFolderId(groupId);
				} catch (PortalException e1) {
					System.out.println("subfolderId exception");
					e1.printStackTrace();
				}
				if (subFolderId != 0) {
					try {
						FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", groupId, subFolderId, title, mimeType,
								title, description, "", changeLog, is, 0l, null, null, serviceContext);
						fileId = fileEntry.getFileEntryId();
					} catch (PortalException e) {
						System.out.println("creating file exception");
						e.printStackTrace();
					}

				}

			}

		} else {
			createFolder(groupId, folderId, description);
			long subFolderId = 0l;
			try {
				subFolderId = subFolderId(groupId);
			} catch (PortalException e1) {
				System.out.println("subfolderId exception");
				e1.printStackTrace();
			}
			if (subFolderId != 0) {
				try {
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", groupId, subFolderId, title, mimeType,
							title, description, "", changeLog, is, 0l, null, null, serviceContext);
					fileId = fileEntry.getFileEntryId();
				} catch (PortalException e) {
					System.out.println("creating file exception");
					e.printStackTrace();
				}

			}

		}
		return fileId;
	}

	private boolean isFolderExist(long groupId, long folderId) {
		boolean folderExist = false;
		try {
			// DLAppServiceUtil.getFolder(groupId, folderId, name);
			List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, folderId);
			for (Folder subFolderList : mainFolders) {

				long subFolder = subFolderList.getFolderId();
				List<Folder> subFoldersList = DLAppServiceUtil.getFolders(groupId, subFolder);
				for (Folder subFolders : subFoldersList) {
					long subFolderId = subFolders.getFolderId();
					folderExist = true;
				}

				System.out.println("Folder is already Exist");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return folderExist;
	}

	private long subFolderId(long groupId) throws PortalException {
		long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long subFolderId = 0l;
		List<Folder> mainFolders = DLAppServiceUtil.getFolders(groupId, folderId);
		for (Folder subFolderList : mainFolders) {
			long subFolder = subFolderList.getFolderId();
			System.out.println(subFolder);
			List<Folder> subFoldersList = DLAppServiceUtil.getFolders(groupId, subFolder);
			for (Folder subFolders : subFoldersList) {
				subFolderId = subFolders.getFolderId();

			}

		}
		return subFolderId;
	}

	private void createFolder(long groupId, long folderId, String description) {
		long userId = PrincipalThreadLocal.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setScopeGroupId(groupId);
		Date date = new Date();
		int year = date.getYear();
		int currentYear = year + 1900;
		String parentFolderName = String.valueOf(currentYear);
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.addFolder(groupId, folderId, parentFolderName, description, serviceContext);
		} catch (PortalException e) {
			System.out.println("creating parentFoldeException");
			e.printStackTrace();
		}
		if (folder.getName() == parentFolderName) {
			long parentfolderId = folder.getFolderId();

			int month = date.getMonth() + 1;
			String subFolderName = String.valueOf(month);
			Folder folder1 = null;
			try {
				folder1 = DLAppServiceUtil.addFolder(groupId, parentfolderId, subFolderName, description,
						serviceContext);
			} catch (PortalException e) {
				System.out.println("creating subfolder exception");
				e.printStackTrace();
			}

		}
	}

	/*
	 * public void getAllFileLink(String groupId,String folderName){ long siteId =
	 * Long.parseLong(groupId); long userId = PrincipalThreadLocal.getUserId(); Long
	 * parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	 * 
	 * try { List<Folder> mainFolders = DLAppServiceUtil.getFolders(siteId,
	 * parentFolderId); for (Folder subFolderList : mainFolders) {
	 * 
	 * long mainFolderId = subFolderList.getFolderId(); List<DLFileEntry> ls =
	 * DLFileEntryLocalServiceUtil.getDLFileEntries(-1,-1);
	 * 
	 * FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
	 * InputStream inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(
	 * fileEntry.getPrimaryKey(), fileEntry.getVersion()); Photo photo =
	 * photoservice.getPhoto(id); String s =
	 * Base64.getEncoder().encodeToString(photo.getImage().getData()); byte[] decode
	 * = Base64.getDecoder().decode(s);
	 * 
	 * 
	 * } } }catch (Exception e) { e.printStackTrace(); }
	 */

	// }

}
