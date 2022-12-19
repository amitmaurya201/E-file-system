package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

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
import io.jetprocess.web.display.context.FileCorrespondenceManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=/PutInFile" }, service = MVCRenderCommand.class)
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
				renderRequest.setAttribute("docFileId",docFileId);
				renderRequest.setAttribute("docFileObj", docFile);
				
			} catch (PortalException e) {
				
			}
			addFileToolbarAttributes(renderRequest,renderResponse);
		
		return "/file/file-inner-view.jsp";
	}
	 private void addFileToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		FileCorrespondenceManagementToolbarDisplayContext fileCorrespondenceManagementToolbarDisplayContext = new FileCorrespondenceManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileCorrespondenceManagementToolbarDisplayContext", fileCorrespondenceManagementToolbarDisplayContext);

	}
	 
	 @Reference
	private Portal _portal;
	

}
