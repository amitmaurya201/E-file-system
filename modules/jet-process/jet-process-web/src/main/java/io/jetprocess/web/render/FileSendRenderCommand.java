package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_RENDER_COMMAND_POP_UP }, service = MVCRenderCommand.class)
public class FileSendRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	long fileId =  ParamUtil.getLong(renderRequest, "fileId");
	long fileMovementId  = ParamUtil.getLong(renderRequest,"fileMovementId");
	renderRequest.setAttribute("fileId", fileId);
	renderRequest.setAttribute("fileMovementId", fileMovementId);
		return "/file/send-file.jsp";	
	}

}
