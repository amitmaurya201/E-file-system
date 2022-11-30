
package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=/FileViewDetails" }, service = MVCRenderCommand.class)
public class FileViewDetailsRenderCommand implements MVCRenderCommand {

	@Reference
	private MasterdataLocalService masterdataLocalService;

	@Reference
	private DocFileLocalService docFileLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		System.out.println("mvcRenderCommand" + docFileId);

		try {
			DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
			renderRequest.setAttribute("DocFile", docFile);
			Masterdata masterdata = masterdataLocalService.getBasic(docFile.getBasicHeadId());
			renderRequest.setAttribute("BasicHeadValue", masterdata.getValue());
			Masterdata masterdata1 = masterdataLocalService.getPrimary(docFile.getPrimaryHeadId());
			renderRequest.setAttribute("PrimaryHeadValue", masterdata1.getValue());
			Masterdata masterdata2 = masterdataLocalService.getSecondary(docFile.getSecondaryHeadId());
			renderRequest.setAttribute("SecondaryHeadValue", masterdata2.getValue());
			Masterdata masterdata3 = masterdataLocalService.getTertiary(docFile.getTertiaryHeadId());
			renderRequest.setAttribute("TertiaryHeadValue", masterdata3.getValue());
			Masterdata masterdata4 = masterdataLocalService.getFileById(docFile.getFileCodeId());
			renderRequest.setAttribute("FileCodeValue", masterdata4.getValue());
			Masterdata masterdata5 = masterdataLocalService.getCategoryById(docFile.getCategoryId());
			renderRequest.setAttribute("CategoryValue", masterdata5.getValue());
			Masterdata masterdata6 = masterdataLocalService.getSubCategoryById(docFile.getSubCategoryId());
			renderRequest.setAttribute("SubCategoryValue", masterdata6.getValue());
		} catch (PortalException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/file/details.jsp";
	}

}