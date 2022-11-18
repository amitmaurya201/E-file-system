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
		long docFileId = counterLocalService.increment(DocFile.class.getName());
		System.out.println(docFileId);
		String fileId = generateFileNumber(docFileId);
		DocFile docFile = docFileLocalService.createDocFile(docFileId);
		docFile.setBasicHeadId(fileRsModel.getBasicHeadId());
		docFile.setPrimaryHeadId(fileRsModel.getPrimaryHeadId());
		docFile.setNature(fileRsModel.getNature());
		docFile.setSubject(fileRsModel.getSubject());
		docFile.setFileCodeId(fileRsModel.getFileCodeId());
		docFile.setSecondaryHeadId(fileRsModel.getSecondaryHeadId());
		docFile.setTertiaryHeadId(fileRsModel.getTertiaryHeadId());
		docFile.setFileNumber(fileId);
		docFile.setType(fileRsModel.getType());
		docFile.setRemarks(fileRsModel.getRemarks());
		docFile.setReference(fileRsModel.getReference());
		docFile.setCategoryId(fileRsModel.getCategoryId());
		docFile.setSubCategoryId(fileRsModel.getSubCategoryId());
		docFile.setUserPostId(fileRsModel.getUserPostId());
        docFileLocalService.addDocFile(docFile);
		System.out.println(docFile);
		return  fileRsModel;
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