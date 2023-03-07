package io.jetprocess.web.render.file;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.render.FileViewDetailsHelper;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.EDIT_FILE_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ViewFileEditedRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		renderRequest.setAttribute("backPageURL", backPageURL);
		
		renderRequest.setAttribute("fileMovementId", fileMovementId);
		fileViewDetailsHelpler.setFileDetails(docFileId, renderRequest);
		return "/file/edit-file.jsp";
	}

@Reference	
private FileViewDetailsHelper fileViewDetailsHelpler;

}
