package io.jetprocess.web.render.notedocument;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_MOVEMENT_LIST_RENDER_COMMAND }, service = MVCRenderCommand.class)

public class NoteDocumentMovementRenderCommand implements MVCRenderCommand{
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	
		logger.info("NoteDocumentMovementRenderCommand------>");
		return "/note-document/note-document-movement.jsp";
	}

	private Log logger = LogFactoryUtil.getLog(NoteDocumentInboxRenderCommand.class);


}
