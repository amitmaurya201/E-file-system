package io.jetprocess.web.render.notedocument;

import com.liferay.portal.kernel.exception.PortalException;
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
import io.jetprocess.model.NoteDocument;
import io.jetprocess.service.NoteDocumentLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_SEND_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class NoteDocumentSendRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long noteDocumentId = ParamUtil.getLong(renderRequest,"noteDocumentId");
		long noteId = ParamUtil.getLong(renderRequest,"noteId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		try {
			NoteDocument noteDocument = noteDocumentLocalService.getNoteDocument(noteDocumentId);
			List<UserPost> userPostList = userPostLocalService.getUserPostExceptGivenUserPostId(userPostId);
			renderRequest.setAttribute("userPostList", userPostList);
			renderRequest.setAttribute("noteId", noteId);
			renderRequest.setAttribute("noteDocumentId", noteDocument.getNoteDocumentId());
			renderRequest.setAttribute("backPageURL", backPageURL);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return "/note-document/note-document-send.jsp";
	}

	@Reference
	private UserPostLocalService userPostLocalService;
	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
}
