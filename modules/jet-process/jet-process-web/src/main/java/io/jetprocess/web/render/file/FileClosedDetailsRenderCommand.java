package io.jetprocess.web.render.file;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.render.FileViewDetailsHelper;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_CLOSE_DETAILS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FileClosedDetailsRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		logger.info("file close details render command called---->");
		
		long fileId = ParamUtil.getLong(renderRequest, "fileId");
	try {
		DocFile docFile = 	docFileLocalService.getDocFile(fileId);
		renderRequest.setAttribute("docFile", docFile);
		fileViewDetailsHelper.setFileDetails(fileId, renderRequest);
	} catch (PortalException e) {
	
		e.printStackTrace();
	}

		return "/file/file-closed-details.jsp";
	}

	
	private static Log logger = LogFactoryUtil.getLog(FileClosedDetailsRenderCommand.class);

	@Reference
	private DocFileLocalService docFileLocalService;
	
	@Reference
	private FileViewDetailsHelper  fileViewDetailsHelper;
}
