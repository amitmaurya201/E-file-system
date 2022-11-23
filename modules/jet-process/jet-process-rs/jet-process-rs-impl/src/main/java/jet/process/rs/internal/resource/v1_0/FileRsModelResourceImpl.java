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
		 DocFile docFile=docFileLocalService.getDocFile();
		//long docFileId = counterLocalService.increment(DocFile.class.getName());
		//System.out.println(docFileId);
		System.out.println(fileRsModel.getBasicHeadId());
		System.out.println(fileRsModel.getPrimaryHeadId());
		System.out.println(fileRsModel.getPrimaryHeadId());
		System.out.println(fileRsModel.getNature());
		//String fileId = generateFileNumber(docFileId);
		//DocFile docFile = docFileLocalService.createDocFile(docFileId);
		docFile.setBasicHeadId(fileRsModel.getBasicHeadId());
		docFile.setPrimaryHeadId(fileRsModel.getPrimaryHeadId());
		docFile.setNature(fileRsModel.getNature());
		docFile.setSubject(fileRsModel.getSubject());
		System.out.println("test1");
		docFile.setFileCodeId(fileRsModel.getFileCodeId());
		System.out.println("test2");
		docFile.setSecondaryHeadId(fileRsModel.getSecondaryHeadId());
		System.out.println("test3");
		docFile.setTertiaryHeadId(fileRsModel.getTertiaryHeadId());
		System.out.println("test4");
		//docFile.setFileNumber(fileId);
		docFile.setType(fileRsModel.getType());
		System.out.println("test5");
		docFile.setRemarks(fileRsModel.getRemarks());
		System.out.println("test6");
		docFile.setReference(fileRsModel.getReference());
		System.out.println("test7");
		docFile.setCategoryId(fileRsModel.getCategoryId());
		System.out.println("test8");
		docFile.setSubCategoryId(fileRsModel.getSubCategoryId());
		System.out.println("test9");
		docFile.setUserPostId(fileRsModel.getUserPostId());
		System.out.println("test10");
		docFile.setYear(fileRsModel.getYear());
		System.out.println("test11");
        docFileLocalService.addDocFile(docFile);
        System.out.println("test12");
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