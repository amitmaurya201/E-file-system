package io.jetprocess.web.render;

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
				"mvc.command.name="+MVCCommandNames.REOPEN_FILE_POPUP_RENDER_COMMAND,
		},
		service = MVCRenderCommand.class
)
public class ReopenFileRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long fileId = ParamUtil.getLong(renderRequest, "fileId");
		long closedFileId = ParamUtil.getLong(renderRequest, "closedFileId");
		renderRequest.setAttribute("fileId", fileId);
		renderRequest.setAttribute("closedFileId", closedFileId);
		return "/file/reopen-file.jsp";
	}

}
