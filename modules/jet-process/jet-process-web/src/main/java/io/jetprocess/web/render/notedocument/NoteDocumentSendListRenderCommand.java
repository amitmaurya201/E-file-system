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
import io.jetprocess.web.display.context.NoteDocSentManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.SEND_LIST_NOTE_DOCUMENT_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class NoteDocumentSendListRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("NoteDocumentSendListRenderCommand------>");
		setNoteDocumentSentListAttributes(renderRequest);
		setNoteDocumentSentManagementToolbarAttributes(renderRequest, renderResponse);
		
		return "/note-document/send-note-document-list.jsp";
	}

	private void setNoteDocumentSentListAttributes(RenderRequest renderRequest) {

		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createdOn");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		logger.info("NoteDocumentSendListRenderCommand------>");
		int noteDocumentSentCount = _noteDocumentList.getNoteDocumentSentListCount(userPostId, keywords);
		logger.info("NoteDocumentSendListRenderCommand------>"+noteDocumentSentCount);
		System.out.println("noteDocumentCount--->" + noteDocumentSentCount);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, noteDocumentSentCount);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");

		List<NoteDocumentMovementDTO> noteDocumentSentList = _noteDocumentList.getNoteDocumentSentList(userPostId, keywords, start, end, orderByCol, orderByType);
		logger.info("NoteDocumentSendListRenderCommand------>"+noteDocumentSentList);
		System.out.println("noteDocumentList--->" + noteDocumentSentList);
		renderRequest.setAttribute("noteDocumentList", noteDocumentSentList);
		renderRequest.setAttribute("noteDocumentCount", +noteDocumentSentCount);
		renderRequest.setAttribute("delta", delta);
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */

	private void setNoteDocumentSentManagementToolbarAttributes(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		NoteDocSentManagementToolbarDisplayContext noteDocSentManagementToolbarDisplayContext = new NoteDocSentManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("noteDocSentManagementToolbarDisplayContext",
				noteDocSentManagementToolbarDisplayContext);
	}

	@Reference
	private NoteDocumentListService _noteDocumentList;

	@Reference
	private Portal _portal;

	
	private Log logger = LogFactoryUtil.getLog(NoteDocumentSendListRenderCommand.class);

}
