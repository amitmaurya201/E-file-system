package io.jetprocess.web.render.notedocument;

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

import io.jetprocess.model.Note;
import io.jetprocess.model.NoteDocument;
import io.jetprocess.service.NoteDocumentLocalService;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_INNER_VIEW_RENDER_COMMAND }, service = MVCRenderCommand.class)

public class NoteDocumentInnerViewRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("NoteDocumentInnerViewRenderCommand------>");
		long noteDocumentId = ParamUtil.getLong(renderRequest, "noteDocumentId");
		long noteId = ParamUtil.getLong(renderRequest, "noteId");
		String subjectCategoryValue = ParamUtil.getString(renderRequest, "subjectCategoryValue");
		renderRequest.setAttribute("subjectCategoryValue", subjectCategoryValue);
		try {
			NoteDocument noteDocument = noteDocumentLocalService.getNoteDocument(noteDocumentId);
			renderRequest.setAttribute("noteDocumentObj", noteDocument);
			Note note = noteLocalService.getNote(noteId);
			renderRequest.setAttribute("noteObj", note);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return "/note-document/note-inner-view.jsp";
	}

	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
	
	@Reference
	private NoteLocalService noteLocalService;
	
	private Log logger = LogFactoryUtil.getLog(NoteDocumentInnerViewRenderCommand.class);

}
