package jet.process.rs.internal.resource.v1_0;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.exception.DuplicateFileNumberException;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileMovementLocalService;
import jet.process.rs.dto.v1_0.FileRsModel;
import jet.process.rs.resource.v1_0.FileRsModelResource;

/**
 * @author Admin
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/file-rs-model.properties", scope = ServiceScope.PROTOTYPE, service = FileRsModelResource.class)
public class FileRsModelResourceImpl extends BaseFileRsModelResourceImpl {
	@Override
	public FileRsModel createFile(FileRsModel fileRsModel) throws Exception {

		try {
			DocFile docFile = docFileLocalService.createDocFile(fileRsModel.getNature(), fileRsModel.getType(),
					fileRsModel.getBasicHeadId(), fileRsModel.getPrimaryHeadId(), fileRsModel.getSecondaryHeadId(),
					fileRsModel.getTertiaryHeadId(), fileRsModel.getFileCodeId(), fileRsModel.getSubject(),
					fileRsModel.getFileNumber(), fileRsModel.getCategoryId(), fileRsModel.getSubCategoryId(),
					fileRsModel.getRemarks(), fileRsModel.getReference(), fileRsModel.getYear(),
					fileRsModel.getUserPostId());
			fileRsModel.setFileNumber(docFile.getFileNumber());
		} catch (DuplicateFileNumberException e) {
			e.printStackTrace();
			if (e.getMessage() == "DuplicateFileNumber") {
				contextHttpServletResponse.setHeader("status", "error");
				contextHttpServletResponse.setHeader("result", "File number already exists");
				return null;
			}
		}
		contextHttpServletResponse.setHeader("status", "success");
		contextHttpServletResponse.setHeader("result", "File created successfully");
		return fileRsModel;
	}

	// update method for file update
	@Override
	public FileRsModel updateDocFile(FileRsModel fileRsModel) throws Exception {

		DocFile docFile = docFileLocalService.editDocFile(fileRsModel.getSubject(), fileRsModel.getDocFileId(),
				fileRsModel.getCategoryId(), fileRsModel.getSubCategoryId(), fileRsModel.getRemarks(),
				fileRsModel.getReference());
		if (docFile.getSubject() == null || docFile.getSubject().isEmpty()) {
			return null;
		}
		return fileRsModel;

	}

	private String generateFileNumber(long fileId) {
		String FileNumber = "F" + fileId;
		return FileNumber;
	}

	@Reference
	private DocFileLocalService docFileLocalService;
	@Reference
	private FileMovementLocalService fileMovementLocalService;

}