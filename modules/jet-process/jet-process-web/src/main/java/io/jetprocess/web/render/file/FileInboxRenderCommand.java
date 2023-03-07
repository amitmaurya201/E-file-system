package io.jetprocess.web.render.file;

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
import io.jetprocess.list.model.FileMovementDTO;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileInboxManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_INBOX_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FileInboxRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("file inbox called-->");
		setFileInboxListAttributes(renderRequest);
		setFileInboxToolbarAttributes(renderRequest, renderResponse);
		return "/file/inbox.jsp";
	}

	private void setFileInboxListAttributes(RenderRequest renderRequest) {
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "modifieddate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int fileInboxCount = _fileList.getFileInboxListCount(userPostId, keywords);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, fileInboxCount);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		List<FileMovementDTO> fileInboxList = _fileList.getFileInboxList(userPostId, keywords, start, end, orderByCol,
				orderByType);
		renderRequest.setAttribute("fileInboxList", fileInboxList);
		renderRequest.setAttribute("fileInboxCount", +fileInboxCount);
		renderRequest.setAttribute("delta", delta);
	}

	/**
	 * Adds Clay management toolbar context object to the request.*
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void setFileInboxToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(renderRequest);

		FileInboxManagementToolbarDisplayContext fileInboxManagementToolbarDisplayContext = new FileInboxManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		renderRequest.setAttribute("fileInboxManagementToolbarDisplayContext",
				fileInboxManagementToolbarDisplayContext);
	}

	private static Log logger = LogFactoryUtil.getLog(FileInboxRenderCommand.class);

	@Reference
	private Portal _portal;

	@Reference
	private FileListService _fileList;
}