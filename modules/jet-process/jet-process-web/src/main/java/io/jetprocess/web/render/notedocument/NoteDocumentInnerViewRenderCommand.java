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

import io.jetprocess.model.NoteDocument;
import io.jetprocess.service.NoteDocumentLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.render.file.ClosedFileListRenderCommand;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_INNER_VIEW_RENDER_COMMAND }, service = MVCRenderCommand.class)

public class NoteDocumentInnerViewRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("NoteDocumentInnerViewRenderCommand------>");	
		String categoryValue = ParamUtil.getString(renderRequest, "CategoryValue");
		String date = ParamUtil.getString(renderRequest, "CreatedOn");
		String noteDocumentNumber = ParamUtil.getString(renderRequest, "NoteDocumentNumber");
		String subject = ParamUtil.getString(renderRequest, "Subject");
		String content = ParamUtil.getString(renderRequest, "Content");
		renderRequest.setAttribute("categoryValue", categoryValue);
		renderRequest.setAttribute("date", date);
		renderRequest.setAttribute("noteDocumentNumber", noteDocumentNumber);
		renderRequest.setAttribute("subject", subject);
		renderRequest.setAttribute("content", content);
		
		

		
		
		return "/note-document/note-inner-view.jsp";
	}

	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
	
	private Log logger = LogFactoryUtil.getLog(ClosedFileListRenderCommand.class);

}
