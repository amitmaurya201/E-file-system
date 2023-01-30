package jet.process.rs.internal.resource.v1_0;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.util.MovementStatus;
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

		contextHttpServletResponse.setHeader("status", "success");
		contextHttpServletResponse.setHeader("result", "Successfully created");

		DocFile docFile = docFileLocalService.getDocFile();
		String fileNumber = null;
		String subject = fileRsModel.getSubject();
		if (fileRsModel.getType().equals("SFS")) {
			docFile.setBasicHeadId(0);
			docFile.setSecondaryHeadId(0);
			docFile.setPrimaryHeadId(0);
			docFile.setTertiaryHeadId(0);
			docFile.setYear(0);
			docFile.setFileCodeId(0);
			fileNumber = fileRsModel.getFileNumber();
			if (fileNumber.isEmpty()) {
				contextHttpServletResponse.setHeader("status", "error");
				contextHttpServletResponse.setHeader("result", "File number can not be empty");
				return null;
			}
			List<DocFile> docFileList = docFileLocalService.getDocFileList();
			for (DocFile docFileObj : docFileList) {
				if (fileNumber.equals(docFileObj.getFileNumber())) {
					System.out.println("Already exist number");
					contextHttpServletResponse.setHeader("status", "error");
					contextHttpServletResponse.setHeader("result", "File number already exists!");
					return null;
				} else {
					docFile.setFileNumber(fileNumber);
				}
			}

		} else {
			docFile.setBasicHeadId(fileRsModel.getBasicHeadId());
			docFile.setPrimaryHeadId(fileRsModel.getPrimaryHeadId());
			docFile.setSecondaryHeadId(fileRsModel.getSecondaryHeadId());
			docFile.setTertiaryHeadId(fileRsModel.getTertiaryHeadId());
			docFile.setYear(fileRsModel.getYear());
			docFile.setFileCodeId(fileRsModel.getFileCodeId());
			fileNumber = generateFileNumber(docFile.getDocFileId());
			docFile.setFileNumber(fileNumber);
		}
		if (subject.isEmpty()) {
			contextHttpServletResponse.setHeader("status", "error");
			contextHttpServletResponse.setHeader("result", "Subject can not be empty");
			return null;
		}

		docFile.setType(fileRsModel.getType());
		docFile.setSubject(fileRsModel.getSubject());
		docFile.setCategoryId(fileRsModel.getCategoryId());
		if (fileRsModel.getSubCategoryId() == null) {
			docFile.setSubCategoryId(0);
		} else if (fileRsModel.getSubCategoryId() != null) {
			docFile.setSubCategoryId(fileRsModel.getSubCategoryId());
		}
		docFile.setRemarks(fileRsModel.getRemarks());
		docFile.setReference(fileRsModel.getReference());
		fileRsModel.setFileNumber(fileNumber);
		docFile.setNature(fileRsModel.getNature());
		docFile.setUserPostId(fileRsModel.getUserPostId());
		docFile.setCurrentState(FileStatus.CREADTED);
		docFile.setCurrentlyWith(fileRsModel.getUserPostId());
		docFileLocalService.addDocFile(docFile);
		System.out.println("fileSaved---->>>>>>");
		fileMovementLocalService.saveFileMovement(fileRsModel.getUserPostId(), fileRsModel.getUserPostId(), docFile.getDocFileId(), "", "", "", false, FileStatus.CREADTED, MovementStatus.CREATED);
		contextHttpServletResponse.setHeader("status", "success");
		contextHttpServletResponse.setHeader("result", "File created successfully");
		return fileRsModel;
	}
	// update method for file update
	@Override
	public FileRsModel updateDocFile(FileRsModel fileRsModel) throws Exception {
		DocFile docFile = docFileLocalService.getDocFileByDocFileId(fileRsModel.getDocFileId());
		if(fileRsModel.getSubject()==null || fileRsModel.getSubject().isEmpty()) {
			return null;
			
		}
		docFile.setSubject(fileRsModel.getSubject());
		docFile.setCategoryId(fileRsModel.getCategoryId());
		
		if (fileRsModel.getSubCategoryId() == null) {
			docFile.setSubCategoryId(0);
		} else if (fileRsModel.getSubCategoryId() != null) {
			docFile.setSubCategoryId(fileRsModel.getSubCategoryId());
		}
		docFile.setRemarks(fileRsModel.getRemarks());
		docFile.setReference(fileRsModel.getReference());
		docFileLocalService.updateDocFile(docFile);

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