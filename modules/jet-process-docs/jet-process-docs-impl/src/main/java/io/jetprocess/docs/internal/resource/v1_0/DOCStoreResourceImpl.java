package io.jetprocess.docs.internal.resource.v1_0;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.docs.dto.v1_0.DOCStore;
import io.jetprocess.docs.resource.v1_0.DOCStoreResource;
import io.jetprocess.docstore.DocStore;

/**
 * @author Admin
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/doc-store.properties", scope = ServiceScope.PROTOTYPE, service = DOCStoreResource.class)
public class DOCStoreResourceImpl extends BaseDOCStoreResourceImpl {

	@Override
	public DOCStore tempFileUpload(MultipartBody multipartBody) throws Exception {
		BinaryFile binaryFile = multipartBody.getBinaryFile("document");
		String groupId = multipartBody.getValueAsString("groupId");
		long siteId = Long.parseLong(groupId);
		InputStream inputStream = binaryFile.getInputStream();
		String contentType = binaryFile.getContentType();
		long milliSeconds= Clock.systemDefaultZone().millis();
		String splitFileName[] = binaryFile.getFileName().split("[.]");
		String folderName = "JetProcessDocStore";
		String fileName = splitFileName[0]+milliSeconds+ "." +splitFileName[1];
		long tempFileId = documentStore.tempFileUpload(siteId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName, fileName, inputStream, contentType);
		String fileUrl=	documentStore.ViewDocumentAndMediaFile(tempFileId);
		DOCStore docStore = new DOCStore();
		docStore.setId(tempFileId);
		docStore.setDescription(fileUrl);
		return docStore;

	}

	@Reference
	private DocStore documentStore;

}