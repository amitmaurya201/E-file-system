package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalServiceUtil;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ViewSendFileRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		String currURL = ParamUtil.getString(renderRequest, "backPageURL");
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
				
		try {
			DocFile docFile = DocFileLocalServiceUtil.getDocFile(docFileId);
			renderRequest.setAttribute("docFile", docFile);
			renderRequest.setAttribute("currentURL", currURL);
			renderRequest.setAttribute("fileMovementId", fileMovementId);
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		return "/file/send.jsp";
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}