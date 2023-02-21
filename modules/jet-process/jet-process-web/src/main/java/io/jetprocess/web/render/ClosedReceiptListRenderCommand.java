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
import io.jetprocess.list.api.ReceiptList;
import io.jetprocess.list.model.ClosedReceiptDTO;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.ClosedReceiptManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_CLOSE_LIST_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ClosedReceiptListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("close receipt list renderer called");
		addClosedReceiptToolbarAttributes(renderRequest, renderResponse);
		setClosedReceiptListAttributes(renderRequest, renderResponse);
		return "/receipt/closed-receipt-list.jsp";
	}

	private void addClosedReceiptToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		HttpServletRequest httpServletRequest = portal.getHttpServletRequest(renderRequest);

		ClosedReceiptManagementToolbarDisplayContext closedReceiptManagementToolbarDisplayContext = new ClosedReceiptManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		renderRequest.setAttribute("closedReceiptManagementToolbarDisplayContext",
				closedReceiptManagementToolbarDisplayContext);
	}

	private void setClosedReceiptListAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		long closedBy = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "closedOn");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keyword = ParamUtil.getString(renderRequest, "keywords");
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		int count = receiptList.getClosedReceiptListCount(closedBy, keyword);
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		List<ClosedReceiptDTO> closedReceiptList = receiptList.getClosedReceiptList(closedBy, keyword, start, end,
				orderByCol, orderByType);
		renderRequest.setAttribute("closedReceiptList", closedReceiptList);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("closedReceiptCount", count);
	}

	private Log logger = LogFactoryUtil.getLog(ClosedReceiptListRenderCommand.class);

	@Reference
	private ReceiptList receiptList;

	@Reference
	private Portal portal;
}
