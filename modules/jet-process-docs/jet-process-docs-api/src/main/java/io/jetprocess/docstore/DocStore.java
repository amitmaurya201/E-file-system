package io.jetprocess.docstore;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;

import java.io.IOException;
import java.io.InputStream;

public interface DocStore {

	public String downloadDocumentAndMediaFile(String groupId,long fileEntryId) throws PortalException,IOException;
	public void deleteTempFile(long fileEntryId) throws PortalException;
	public FileEntry getTempFile(long fileEntryId) throws PortalException;
	public long documentAndMediaFileUpload(long groupId,long fileEntryId, InputStream is, String title, String mimeType, String changeLog,long totalSpace, String description) throws PortalException, IOException;
	public String ViewDocumentAndMediaFile(long fileEntryId) throws PortalException,IOException;
	public long tempFileUpload(long siteId,long parentFolderId, String folderName, String fileName,InputStream inputStream,String contentType) throws PortalException;;
}
