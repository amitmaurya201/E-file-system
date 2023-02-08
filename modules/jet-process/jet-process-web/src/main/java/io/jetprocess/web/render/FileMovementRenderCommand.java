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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.FileList;
import io.jetprocess.list.model.FileMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileMovementDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_MOVEMENT_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FileMovementRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");

		renderRequest.setAttribute("fileMovementId", fileMovementId);
		setManagementToolbarAttributes(renderRequest, renderResponse);
		setFileMovementList(renderRequest);
		return "/file/movement.jsp";
	}

	private void setManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		FileMovementDisplayContext fileMovementDisplayContext = new FileMovementDisplayContext(liferayPortletRequest,
				liferayPortletResponse, portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileMovementDisplayContext", fileMovementDisplayContext);
	}

	private void setFileMovementList(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession session = themeDisplay.getRequest().getSession();
		
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "modifiedDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");

		long docFileId = ParamUtil.getLong(renderRequest, "docFileId", 0);
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId", 0);
		
		int count = fileList.getFileMovementListCount(fileMovementId,docFileId, "");
		int preDelta = 0;
		String d = (String) session.getAttribute("preDelta");
		if (d != null) {
			preDelta = Integer.parseInt(d);
		}
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count, preDelta);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		session.setAttribute("preDelta", "" + delta + "");
		List<FileMovementDTO> fileMovementList = new ArrayList<>();
		if (docFileId != 0) {
			fileMovementList = fileList.getFileMovementList(fileMovementId,docFileId, "", start, end, "", "");
		}

		if (fileMovementList != null) {
			renderRequest.setAttribute("fileMovementList", fileMovementList);
		}
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("fileMovementCount", count);

	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal portal;
	@Reference
	private FileList fileList;

}
