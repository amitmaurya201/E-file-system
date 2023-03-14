package io.jetprocess.web.render.notedocument;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.NoteDocumentListService;
import io.jetprocess.list.model.NoteDocumentMovementDTO;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.NoteDocumentMovementManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_MOVEMENT_LIST_RENDER_COMMAND }, service = MVCRenderCommand.class)

public class NoteDocumentMovementRenderCommand implements MVCRenderCommand{
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	

		logger.info("NoteDocumentMovementRenderCommand------>");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		renderRequest.setAttribute("backPageURL", backPageURL);
		setNoteDocumentMovementListAttributes(renderRequest);
		setNoteDocumentMovementManagementToolbarAttributes(renderRequest, renderResponse);
		return "/note-document/note-document-movement.jsp";
	}
	
	private void setNoteDocumentMovementListAttributes(RenderRequest renderRequest) {

		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createdOn");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		long noteDocumentId = ParamUtil.getLong(renderRequest,"noteDocumentId");
		long noteId = ParamUtil.getLong(renderRequest,"noteId");

		int noteDocumentMovementListCount = noteDocumentListService.getNoteDocumentMovementListCount(noteDocumentId, keywords);
		System.out.println("noteDocumentCount--->" + noteDocumentMovementListCount);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, noteDocumentMovementListCount);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");


		List<NoteDocumentMovementDTO> noteDocumentMovementList = noteDocumentListService.getNoteDocumentMovementList(noteDocumentId, keywords, start, end, orderByCol, orderByType);	
		renderRequest.setAttribute("noteDocumentMovementList", noteDocumentMovementList);
		renderRequest.setAttribute("noteDocumentMovementListCount", +noteDocumentMovementListCount);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("noteDocumentId", noteDocumentId);
		renderRequest.setAttribute("noteId", noteId);
	}
	
	
	private void setNoteDocumentMovementManagementToolbarAttributes(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		NoteDocumentMovementManagementToolbarDisplayContext noteDocumentMovementManagementToolbarDisplayContext = new NoteDocumentMovementManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("noteDocumentManagementToolbarDisplayContext",
				noteDocumentMovementManagementToolbarDisplayContext);
	}

	private Log logger = LogFactoryUtil.getLog(NoteDocumentMovementRenderCommand.class);

	@Reference
	private Portal _portal;
	
	@Reference
	private NoteDocumentListService noteDocumentListService;

}
