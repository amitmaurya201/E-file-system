package io.jetprocess.web.render;

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

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.MasterdataService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileInboxManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.FileManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.SendFileManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name="+MVCCommandNames.FILE_INBOX_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FileInboxRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		addFileInboxListAttributes(renderRequest);
		addFileInboxToolbarAttributes(renderRequest, renderResponse );
		
		return "/file/inbox.jsp";
	}
	
	
	private void addFileInboxListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		HttpSession session = themeDisplay.getRequest().getSession();
		long userPostId = Long.parseLong((String) session.getAttribute("userPostId"));
		String tt = (String) session.getAttribute("userPostId");
		logger.info("user post id inside render : --" + userPostId);
		long userPost = Long.parseLong(tt);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "receivedon");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		logger.info("order by : " + orderByCol +"  : order type : - "+orderByType);
		 List<FileMovementDTO> fileInboxList = masterdataLocalService.getFileInboxList(userPost, keywords, start, end,orderByCol, orderByType);
		logger.info("===========  Later ==========>" + fileInboxList);
		renderRequest.setAttribute("fileInboxList",fileInboxList);
		renderRequest.setAttribute("fileInboxCount",+masterdataLocalService.getFileInboxList(userPost, keywords));
		renderRequest.setAttribute("delta",delta);
	}

	/**
	 * Adds Clay management toolbar context object to the request.*
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addFileInboxToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		FileInboxManagementToolbarDisplayContext fileInboxManagementToolbarDisplayContext = new FileInboxManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileInboxManagementToolbarDisplayContext", fileInboxManagementToolbarDisplayContext);

	}
	
	
	
	private static Log logger = LogFactoryUtil.getLog(FileInboxRenderCommand.class);
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal _portal;

}


