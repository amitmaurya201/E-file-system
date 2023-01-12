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
import io.jetprocess.list.api.ReceiptList;
import io.jetprocess.list.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.ReceiptMovementDisplayContext;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
			"mvc.command.name="+MVCCommandNames.RECEIPT_MOVEMENT_RENDER_COMMAND
		},
		service = MVCRenderCommand.class
	)
public class ReceiptMovementRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		setReceiptMovementList(renderRequest);
		setManagementToolbarAttributes(renderRequest, renderResponse);
		return "/receipt/movement.jsp";
	}
	
	private void setManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		ReceiptMovementDisplayContext receiptMovementDisplayContext = new ReceiptMovementDisplayContext(liferayPortletRequest, liferayPortletResponse, portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("receiptMovementDisplayContext", receiptMovementDisplayContext);
	}

	private void setReceiptMovementList(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId", 0);
		List<ReceiptMovementDTO>  receiptMovementList = new ArrayList();
		HttpSession session = themeDisplay.getRequest().getSession(); 

		int count=receiptList.getReceiptMovementListCount(receiptId, "");
		int preDelta=0;
		String d=(String) session.getAttribute("preDelta");
		if(d!=null) {
			preDelta=Integer.parseInt(d);
		}
		if(delta !=preDelta) {
			Map<String, Integer> paginationConfig=Pagination.getOffset(delta, currentPage, count, preDelta);
			start=paginationConfig.get("start");
			currentPage=paginationConfig.get("currentPage");
			}
		session.setAttribute("preDelta", ""+delta+"");
		
		if(receiptId != 0) {
			receiptMovementList = 	receiptList.getReceiptMovementList(receiptId, "", start, end, "", "");
		}
		
		if(receiptMovementList != null) {
			renderRequest.setAttribute("receiptMovementList", receiptMovementList);
		}
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("receiptMovementCount",+count);
		
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal portal;
	@Reference
	ReceiptList receiptList;
}
