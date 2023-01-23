package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
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
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptLocalServiceUtil;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.CorrespondencesInfoManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.ReceiptMovementDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CORRESPONDENCES_INFO_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class CorrespondencesInfoRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		System.out.println("CorrespondencesInfoRenderCommand : ---------> ");
		long receiptId=ParamUtil.getLong(renderRequest, "receiptId");
		System.out.println("receiptId : "+receiptId);
		Receipt receipt=null;
		try {
			receipt = receiptLocalService.getReceipt(receiptId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		setManagementToolbarAttributes(renderRequest,renderResponse );
		setReceiptMovementList(renderRequest);
//		List<ReceiptMovementDTO> receiptMovementList = recieptList.getReceiptMovementList(receiptId, "", 0, 10, "", "");
		
		System.out.println("    "+receipt);
//		receiptMovementList.forEach(c->System.out.println(c));
		renderRequest.setAttribute("receipt", receipt);
//		renderRequest.setAttribute("receiptMovementList", receiptMovementList);
		return "/file/correspondencesInfo.jsp";
	}
	
	private void setManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		CorrespondencesInfoManagementToolbarDisplayContext correspondencesInfoManagementToolbarDisplayContext = new CorrespondencesInfoManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("correspondencesInfoManagementToolbarDisplayContext", correspondencesInfoManagementToolbarDisplayContext);
	}

	private void setReceiptMovementList(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 2);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId", 0);
		List<ReceiptMovementDTO>  receiptMovementList = new ArrayList();
		HttpSession session = themeDisplay.getRequest().getSession(); 

		int count=recieptList.getReceiptMovementListCount(receiptId, "");
		int preDelta=0;
		String d=(String) session.getAttribute("preDelta");
		if(d!=null) {
			preDelta=Integer.parseInt(d);
		}
			Map<String, Integer> paginationConfig=Pagination.getOffset(delta, currentPage, count, preDelta);
			start=paginationConfig.get("start");
			currentPage=paginationConfig.get("currentPage");
		session.setAttribute("preDelta", ""+delta+"");
		
		if(receiptId != 0) {
			receiptMovementList = 	recieptList.getReceiptMovementList(receiptId, 0, "", start, end, "", "");
		}
		System.out.println("start : "+start+" , End : "+end);
		renderRequest.setAttribute("receiptMovementList", receiptMovementList);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("receiptMovementCount",+count);
		
	}
	
	
	
	@Reference
	private ReceiptLocalService receiptLocalService ;
	@Reference
	private ReceiptList recieptList;
	@Reference
	private Portal portal;

}


