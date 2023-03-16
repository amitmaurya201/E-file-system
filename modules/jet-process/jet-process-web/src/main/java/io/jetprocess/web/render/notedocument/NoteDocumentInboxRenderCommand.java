package io.jetprocess.web.render.notedocument;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.NoteDocumentListService;
import io.jetprocess.list.model.NoteDocumentDTO;
import io.jetprocess.list.model.NoteDocumentMovementDTO;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.NoteDocumentInboxManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.NoteDocumentManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.INBOX_LIST_NOTE_DOCUMENT_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class NoteDocumentInboxRenderCommand  implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("NoteDocumentInboxRenderCommand------->");
		setNoteDocumentInboxListAttributes(renderRequest);
	
		setNoteDocumentInboxListManagementToolbarAttributes(renderRequest,renderResponse);
		return "/note-document/inbox-note-document-list.jsp";
	}

	
	private void setNoteDocumentInboxListAttributes(RenderRequest renderRequest) {

		System.out.println("inside inboxListAttribute");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");

		int noteDocumentInboxCount = _noteDocumentList.getNoteDocumentInboxListCount(userPostId,keywords);
		System.out.println("noteDocumentInboxCount--->" + noteDocumentInboxCount);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, noteDocumentInboxCount);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");

		List<NoteDocumentMovementDTO> noteDocumentInboxList = _noteDocumentList.getNoteDocumentInboxList(userPostId, keywords, start, end, orderByCol, orderByType);

		System.out.println("noteDocumentInboxList--->" + noteDocumentInboxList);
		renderRequest.setAttribute("noteDocumentInboxList", noteDocumentInboxList);
		renderRequest.setAttribute("noteDocumentInboxCount", +noteDocumentInboxCount);
		renderRequest.setAttribute("delta", delta);
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */

	private void setNoteDocumentInboxListManagementToolbarAttributes(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		System.out.println("inside inboxlistmanagementToolbarAttributes---->");
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		NoteDocumentInboxManagementToolbarDisplayContext noteDocumentInboxManagementToolbarDisplayContext = new NoteDocumentInboxManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("NoteDocumentInboxManagementToolbarDisplayContext",
				noteDocumentInboxManagementToolbarDisplayContext);
	}

	@Reference
	private NoteDocumentListService _noteDocumentList;

	@Reference
	private Portal _portal;

	@Reference
	private UserPostLocalService userPostLocalService;

	private Log logger = LogFactoryUtil.getLog(NoteDocumentInboxRenderCommand.class);

}

