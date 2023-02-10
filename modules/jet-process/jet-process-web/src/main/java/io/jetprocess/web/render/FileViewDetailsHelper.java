package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.constant.util.FileConstants;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;

@Component(immediate = true, service = FileViewDetailsHelper.class)
public class FileViewDetailsHelper {
	
	
	public void setFileDetails(long docFileId ,RenderRequest renderRequest) {
		try {

			DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
			renderRequest.setAttribute("DocFile", docFile);

			if (docFile.getType().equalsIgnoreCase(FileConstants.NON_SFS_TYPE)) {
				Masterdata basicHeadValue = masterdataLocalService.getBasic(docFile.getBasicHeadId());
				renderRequest.setAttribute("BasicHeadValue", basicHeadValue.getValue());
				Masterdata primaryHeadValue = masterdataLocalService.getPrimary(docFile.getPrimaryHeadId());
				renderRequest.setAttribute("PrimaryHeadValue", primaryHeadValue.getValue());
				Masterdata secondaryHeadValue = masterdataLocalService.getSecondary(docFile.getSecondaryHeadId());
				renderRequest.setAttribute("SecondaryHeadValue", secondaryHeadValue.getValue());
				Masterdata tertiaryHeadValue = masterdataLocalService.getTertiary(docFile.getTertiaryHeadId());
				if(Validator.isNull(tertiaryHeadValue)) {
					renderRequest.setAttribute("TertiaryHeadValue", "");
				}else {
					renderRequest.setAttribute("TertiaryHeadValue", tertiaryHeadValue.getValue());

				}
				Masterdata fileCodeValue = masterdataLocalService.getFileById(docFile.getFileCodeId());
				renderRequest.setAttribute("FileCodeValue", fileCodeValue.getValue());
				if (docFile.getCategoryId() != 0) {
					Masterdata categoryValue = masterdataLocalService.getCategoryById(docFile.getCategoryId());
					renderRequest.setAttribute("CategoryValue", categoryValue.getValue());
				} 
				if (docFile.getSubCategoryId() != 0) {
					Masterdata subCategoryValue = masterdataLocalService.getSubCategoryById(docFile.getSubCategoryId());
					renderRequest.setAttribute("SubCategoryValue", subCategoryValue.getValue());
				}
			} else {
				if (docFile.getCategoryId() != 0) {
					Masterdata sfsCategoryValue = masterdataLocalService.getCategoryById(docFile.getCategoryId());
					renderRequest.setAttribute("SfsCategoryValue", sfsCategoryValue.getValue());
				}
				if (docFile.getSubCategoryId() != 0) {
					Masterdata sfsSubCategoryValue = masterdataLocalService.getSubCategoryById(docFile.getSubCategoryId());
					renderRequest.setAttribute("SfsSubCategoryValue", sfsSubCategoryValue.getValue());
				}

			}
		} catch (PortalException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Reference
	private DocFileLocalService docFileLocalService;
	@Reference
	private MasterdataLocalService masterdataLocalService;
	
	
	

}
