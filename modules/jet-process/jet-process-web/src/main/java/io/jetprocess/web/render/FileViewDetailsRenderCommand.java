
package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_DETAILS_RENDER_COMMAND}, service = MVCRenderCommand.class)
public class FileViewDetailsRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		String currentURL = ParamUtil.getString(renderRequest, "backPageURL");
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");

		renderRequest.setAttribute("fileMovementId", fileMovementId);
		renderRequest.setAttribute("CurrentURL", currentURL);
		fileViewDetailsHelper.setFileDetails(docFileId, renderRequest);
		return "/file/details.jsp";
	}

	@Reference
	FileViewDetailsHelper  fileViewDetailsHelper;

}