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
import io.jetprocess.list.api.ReceiptListService;
import io.jetprocess.list.model.ReceiptMovementDTO;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.ReceiptInboxManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ReceiptInboxRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("receipt inbox render command called ");
		setReceiptInboxListAttributes(renderRequest);
		setReceiptInboxToolbarAttributes(renderRequest, renderResponse);
		return "/receipt/inbox.jsp";
	}

	/***
	 * 
	 * Adds File list related attributes to the request.**
	 * 
	 * @param renderRequest
	 */
	private void setReceiptInboxListAttributes(RenderRequest renderRequest) {
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "modifieddate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int count = _receiptList.getReceiptInboxListCount(userPostId, keywords);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		List<ReceiptMovementDTO> receiptInboxList = _receiptList.getReceiptInboxList(userPostId, keywords, start, end,
				orderByCol, orderByType);
		renderRequest.setAttribute("receiptInboxList", receiptInboxList);
		renderRequest.setAttribute("inboxReceiptCount", count);
		renderRequest.setAttribute("delta", delta);
	}

	/**
	 * Adds Clay management toolbar context object to the request.*
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void setReceiptInboxToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		 HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(renderRequest);
		ReceiptInboxManagementToolbarDisplayContext receiptInboxManagementToolbarDisplayContext = new ReceiptInboxManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,httpServletRequest);
		renderRequest.setAttribute("receiptInboxManagementToolbarDisplayContext",
				receiptInboxManagementToolbarDisplayContext);
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private Portal _portal;

	@Reference
	private ReceiptListService _receiptList;
}