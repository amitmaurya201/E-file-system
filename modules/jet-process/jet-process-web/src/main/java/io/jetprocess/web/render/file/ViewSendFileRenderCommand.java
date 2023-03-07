package io.jetprocess.web.render.file;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalServiceUtil;
import io.jetprocess.service.FileNoteLocalService;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ViewSendFileRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("ViewSendFileRenderCommand--->");
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);		
		try {
			DocFile docFile = DocFileLocalServiceUtil.getDocFile(docFileId);
			List<UserPost> userPostList = userPostLocalService.getUserPostExceptGivenUserPostId(userPostId);
			renderRequest.setAttribute("userPostList", userPostList);
			renderRequest.setAttribute("docFile", docFile);
			renderRequest.setAttribute("backPageURL", backPageURL);
			renderRequest.setAttribute("fileMovementId", fileMovementId);

		} catch (PortalException e) {
			logger.info(e.getMessage());
		}

		return "/file/send.jsp";
	}

	@Reference
	private NoteLocalService noteLocalService;
	@Reference
	private FileNoteLocalService fileNoteLocalService;
	
	@Reference
	private UserPostLocalService userPostLocalService; 

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
