package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=/FileInnerViewDetails" }, service = MVCRenderCommand.class)
public class FileInnerView implements MVCRenderCommand {
	@Reference
	private MasterdataLocalService masterdataLocalService;

	@Reference
	private DocFileLocalService docFileLocalService;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		System.out.println("docFileid   "+docFileId);
		System.out.println("mvcRenderCommand" + docFileId);

			try {
				DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
				//System.out.println(docFile.getNature());
				renderRequest.setAttribute("nature",docFile.getNature() );
			} catch (PortalException e) {
				
			}
			
		return "/file/file-inner-view.jsp";
	}
	
	
	

}
