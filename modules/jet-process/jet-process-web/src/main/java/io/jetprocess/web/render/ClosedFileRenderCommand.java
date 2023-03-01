package io.jetprocess.web.render;

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
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.FileListService;
import io.jetprocess.list.model.ClosedFileDTO;
import io.jetprocess.list.model.ClosedReceiptDTO;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.ClosedFileManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.ClosedReceiptManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_CLOSE_LIST_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ClosedFileRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("close file list renderer called");
		//addClosedFileToolbarAttributes(renderRequest, renderResponse);
	//	setClosedFileListAttributes(renderRequest, renderResponse);
		return "/file/closed-file-list.jsp";
	}
	
	private void setClosedFileListAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		long closedBy = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "closedOn");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keyword = ParamUtil.getString(renderRequest, "keywords");
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		int count = fileListService.getClosedFileListCount(closedBy, keyword);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		List<ClosedFileDTO> closedFileList = fileListService.getFileClosedList(closedBy, keyword, start, end,
				orderByCol, orderByType);
		renderRequest.setAttribute("closedFileList", closedFileList);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("closedFileCount", count);
	}
	
	private void addClosedFileToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		HttpServletRequest httpServletRequest = portal.getHttpServletRequest(renderRequest);

		ClosedFileManagementToolbarDisplayContext closedFileManagementToolbarDisplayContext = new ClosedFileManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		renderRequest.setAttribute("closedFileManagementToolbarDisplayContext",
				closedFileManagementToolbarDisplayContext);
	}
	
	private FileListService fileListService;

	private Log logger = LogFactoryUtil.getLog(ClosedReceiptListRenderCommand.class);

	@Reference
	private Portal portal;

}
