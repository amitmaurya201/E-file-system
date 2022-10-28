package io.jetprocess.docstore;

import com.liferay.portal.kernel.exception.PortalException;

import java.io.IOException;
import java.io.InputStream;

public interface DocStore {
	public long uploadFile(long groupId, InputStream is,String title,String mimeType,String changeLog,long totalSpace, String description) throws PortalException ;
	public String getFile(String groupId,long fileEntryId) throws PortalException,IOException;
	public String viewFile(String groupId,long fileEntryId) throws PortalException, IOException;
}
