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
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.NoteDocumentManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name="
				+ MVCCommandNames.CREATED_LIST_NOTE_DOCUMENT_RENDER_COMMAND }, service = MVCRenderCommand.class)

public class CreatedNoteDocumentListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("CreatedNoteDocumentListRenderCommand called----->");

		logger.info("created-recipt-list.jsp -- called");

		 setCreatedNoteDocumentListAttributes(renderRequest);
		 setCreatedNoteDocumentManagementToolbarAttributes(renderRequest,
		 renderResponse);
		return "/note-document/created-note-document-list.jsp";
	}

	private void setCreatedNoteDocumentListAttributes(RenderRequest renderRequest) {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "modifieddate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");

		int noteDocumentCount = _noteDocumentList.getNoteDocumentListCount(userPostId, keywords);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, noteDocumentCount);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");

		List<NoteDocumentDTO> noteDocumentList = _noteDocumentList.getNoteDocumentCreatedList(userPostId, keywords,
				start, end, orderByCol, orderByType);

		renderRequest.setAttribute("noteDocumentList", noteDocumentList);
		renderRequest.setAttribute("noteDocumentCount", +noteDocumentCount);
		renderRequest.setAttribute("delta", delta);
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */

	private void setCreatedNoteDocumentManagementToolbarAttributes(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		NoteDocumentManagementToolbarDisplayContext noteDocumentManagementToolbarDisplayContext = new NoteDocumentManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("NoteDocumentManagementToolbarDisplayContext",
				noteDocumentManagementToolbarDisplayContext);
	}

	@Reference
	private NoteDocumentListService _noteDocumentList;

	@Reference
	private Portal _portal;

	private Log logger = LogFactoryUtil.getLog(CreatedNoteDocumentListRenderCommand.class);

}
