package io.jetprocess.docstore;

import java.io.InputStream;

public interface DocStore {
	public long uploadFile(long groupId, InputStream is,String title,String mimeType,String changeLog,long totalSpace, String description);

}
