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
import io.jetprocess.web.render.file.ClosedFileListRenderCommand;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_INNER_VIEW_RENDER_COMMAND }, service = MVCRenderCommand.class)

public class NoteDocumentInnerViewRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("NoteDocumentInnerViewRenderCommand------>");	
		return "/note-document/note-inner-view.jsp";
	}

	private Log logger = LogFactoryUtil.getLog(ClosedFileListRenderCommand.class);

}
