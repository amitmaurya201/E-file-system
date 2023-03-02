package io.jetprocess.web.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name="+JetProcessWebPortletKeys.JETPROCESSWEB,
			"mvc.command.name="+MVCCommandNames.FILE_CLOSE_RENDER_COMMAND
	},
	service = MVCRenderCommand.class
	
)
public class CloseFileRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
		 long fileId = ParamUtil.getLong(renderRequest,"docFileId");
		 String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		 renderRequest.setAttribute("backPageURL", backPageURL);
		renderRequest.setAttribute("fileMovementId", fileMovementId);
		renderRequest.setAttribute("fileId", fileId);
			logger.info("close receipt called");
			// TODO Auto-generated method stub
			return "/file/close-file.jsp";
	}
	
private Log logger = LogFactoryUtil.getLog(CloseFileRenderCommand.class);
}
