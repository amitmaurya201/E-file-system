package jet.process.rs.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collections;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.model.DocFile;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.DocFileLocalServiceUtil;
import io.jetprocess.service.ReceiptLocalService;
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
	public Page<FileRsModel> createFile(FileRsModel fileRsModel)
		throws Exception {
		long docFileId = counterLocalService.increment(DocFile.class.getName());
		System.out.println(docFileId);
		DocFile docFile = docFileLocalService.createDocFile(docFileId);
		docFile.setBasicHeadId(fileRsModel.getBasicHeadId());
		docFile.setPrimaryHeadId(fileRsModel.getPrimaryHeadId());
		docFile.setNature(fileRsModel.getNature());
		docFileLocalService.addDocFile(docFile);
		System.out.println(docFile);
		ArrayList<FileRsModel> fileRsModels=new ArrayList<>();
		fileRsModels.add(fileRsModel);
		return Page.of(fileRsModels);
	}
	
	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private DocFileLocalService docFileLocalService;
	@Reference
	private UserLocalService userLocalService;
}