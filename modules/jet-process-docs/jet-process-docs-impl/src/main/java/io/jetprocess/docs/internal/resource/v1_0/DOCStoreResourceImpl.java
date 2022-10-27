package io.jetprocess.docs.internal.resource.v1_0;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import java.io.InputStream;

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
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		InputStream inputStream = binaryFile.getInputStream();
		String contentType = binaryFile.getContentType();
		String fileName = binaryFile.getFileName();
		String folderName = "JetProcessDocStore";
		FileEntry fileEntry = DLAppServiceUtil.addTempFileEntry(siteId, parentFolderId, folderName, fileName,
				inputStream, contentType);
		DOCStore docStore = new DOCStore();
		docStore.setId(fileEntry.getFileEntryId());
		return docStore;

	}

	@Override
	public DOCStore uploadFile(MultipartBody multipartBody) throws Exception {
		BinaryFile binaryFile = multipartBody.getBinaryFile("document");
		String groupId = multipartBody.getValueAsString("groupId");
		long siteId = Long.parseLong(groupId);
		String description = multipartBody.getValueAsString("description");

		String fileName = binaryFile.getFileName();
		String contentType = binaryFile.getContentType();
		InputStream inputStream = binaryFile.getInputStream();
		String changeLog = "docStore";
		long fileId = documentStore.uploadFile(siteId, inputStream, fileName, contentType, changeLog, 0l, description);
		DOCStore docstore = new DOCStore();
		docstore.setId(fileId);
		return docstore;
	}
	@Override
	public DOCStore fetchFiles(MultipartBody multipartBody) throws Exception {
		String groupId = multipartBody.getValueAsString("groupId");
		//long siteId = Long.parseLong(groupId);
		long fileId = Long.parseLong(multipartBody.getValueAsString("fileId"));
		/*
		 * System.out.println("test"); FileEntry fileEntry =
		 * DLAppLocalServiceUtil.getFileEntry(50717); InputStream inputStream =
		 * DLFileEntryLocalServiceUtil.getFileAsStream(fileEntry.getPrimaryKey(),
		 * fileEntry.getVersion()); byte[] targetArray = new
		 * byte[inputStream.available()]; String fileContent =
		 * Base64.getEncoder().encodeToString(targetArray);
		 * System.out.println(fileContent); //byte[] decode =
		 * Base64.getDecoder().decode(fileContent); //OutputStream out = new
		 * OutputStream();
		 * 
		 * DOCStore docStore = new DOCStore(); docStore.setDocumentStream(fileContent);
		 */
		documentStore.getFile(groupId, fileId);
		return new DOCStore(); 
	}

	@Reference
	private DocStore documentStore;

}