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
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.ReceiptList;
import io.jetprocess.list.model.ReceiptListViewDto;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.AddCorrespondenceManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CORRESPONCE_FILE_RENDER }, service = MVCRenderCommand.class)
public class AddFileCorrespondenceRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("render page of add file correspondence method called ");
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		renderRequest.setAttribute("docFileId", docFileId);
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
		renderRequest.setAttribute("fileMovementId", fileMovementId);
		addFileToolbarAttributes(renderRequest, renderResponse);
		addFileListAttributes(renderRequest);
		return "/file/add-correspondence.jsp";
	}

	private void addFileListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		HttpSession session = themeDisplay.getRequest().getSession();
		long userPostId = Long.parseLong((String) session.getAttribute("userPostId"));
		long userPost = userPostId;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int count = _receiptList.getPutInFileListCount(userPost, keywords);
		int preDelta = 0;
		String d = (String) session.getAttribute("preDelta");
		if (d != null) {
			preDelta = Integer.parseInt(d);
		}
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count, preDelta);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		session.setAttribute("preDelta", "" + delta + "");
		List<ReceiptListViewDto> receiptList = _receiptList.getPutInFileList(userPost, keywords, start, end, "", "");
		receiptList.forEach(c -> logger
				.info(c.getReceiptId() + ", : " + c.isRead() + ", : file movement id :  " + c.getReceiptMovementId()));
		renderRequest.setAttribute("receiptFileList", receiptList);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("receiptCount", +count);
	}

	private void addFileToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		AddCorrespondenceManagementToolbarDisplayContext addCorrespondenceManagementToolbarDisplayContext = new AddCorrespondenceManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("addCorrespondenceManagementToolbarDisplayContext",
				addCorrespondenceManagementToolbarDisplayContext);
	}

	private static Log logger = LogFactoryUtil.getLog(AddFileCorrespondenceRenderCommand.class);

	@Reference
	private Portal _portal;

	@Reference
	private ReceiptList _receiptList;

}