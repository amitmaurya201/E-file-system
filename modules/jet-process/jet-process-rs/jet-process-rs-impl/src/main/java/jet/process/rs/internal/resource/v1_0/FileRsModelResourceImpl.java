package jet.process.rs.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import jet.process.rs.dto.v1_0.FileRsModel;
import jet.process.rs.resource.v1_0.FileRsModelResource;

/**
 * @author Admin
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/file-rs-model.properties",
	scope = ServiceScope.PROTOTYPE, service = FileRsModelResource.class
)
public class FileRsModelResourceImpl extends BaseFileRsModelResourceImpl {
	@Override
	public FileRsModel createFile(FileRsModel fileRsModel) throws Exception {
		DocFile docFile = docFileLocalService.getDocFile();
		String fileNumber = fileRsModel.getFileNumber();
		if (!fileNumber.isEmpty()) {
			docFile.setFileNumber(fileNumber);
		} else {
			fileNumber = generateFileNumber(docFile.getDocFileId());
			docFile.setFileNumber(fileNumber);
		}
		docFile.setNature(fileRsModel.getNature());
		if (fileRsModel.getType().equals("SFS")) {
			docFile.setBasicHeadId(0);
			docFile.setSecondaryHeadId(0);
			docFile.setPrimaryHeadId(0);
			docFile.setTertiaryHeadId(0);
			docFile.setYear(0);
			docFile.setFileCodeId(0);
		} else {
			docFile.setBasicHeadId(fileRsModel.getBasicHeadId());
			docFile.setPrimaryHeadId(fileRsModel.getPrimaryHeadId());
			docFile.setSecondaryHeadId(fileRsModel.getSecondaryHeadId());
			docFile.setTertiaryHeadId(fileRsModel.getTertiaryHeadId());
			docFile.setYear(fileRsModel.getYear());
			docFile.setFileCodeId(fileRsModel.getFileCodeId());
		}
		docFile.setType(fileRsModel.getType());
		docFile.setSubject(fileRsModel.getSubject());
		docFile.setCategoryId(fileRsModel.getCategoryId());
		docFile.setSubCategoryId(fileRsModel.getSubCategoryId());
		docFile.setRemarks(fileRsModel.getRemarks());
		docFile.setReference(fileRsModel.getReference());
		docFile.setUserPostId(fileRsModel.getUserPostId());
		docFile.setCurrentState(1);
		docFileLocalService.addDocFile(docFile);
		return fileRsModel;
}
	
	// update method for file update 
	@Override
		public FileRsModel updateDocFile(FileRsModel fileRsModel) throws Exception {
		
		
		DocFile docFile =  docFileLocalService.getDocFileByDocFileId(fileRsModel.getDocFileId());
		
		docFile.setSubject(fileRsModel.getSubject());
		docFile.setCategoryId(fileRsModel.getCategoryId());
		docFile.setSubCategoryId(fileRsModel.getSubCategoryId());
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
	private CounterLocalService counterLocalService;
	@Reference
	private DocFileLocalService docFileLocalService;
	@Reference
	private UserLocalService userLocalService;
}