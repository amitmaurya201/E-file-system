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

import io.jetprocess.list.api.ReceiptList;
import io.jetprocess.list.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.MasterdataLocalServiceUtil;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.SendReceiptManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SENT_LIST }, service = MVCRenderCommand.class)
public class ReceiptSentListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		
		addFileListAttributes(renderRequest);
		addFileToolbarAttributes(renderRequest, renderResponse);
		
		return "/receipt/sent_list.jsp";
	}
	
	
	private void addFileListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		HttpSession session = themeDisplay.getRequest().getSession();
		long userPostId = Long.parseLong((String) session.getAttribute("userPostId"));
		long userPost = userPostId;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "sentOn");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		
		String keywords = ParamUtil.getString(renderRequest, "keywords");
//		int count=masterdataLocalService.getReceiptSendList(userPost, keywords);
		int count=_receiptList.getReceiptSentListCount(userPostId, keywords);
		int preDelta=0;
		String d=(String) session.getAttribute("oldDelta");
		if(d!=null) {
			preDelta=Integer.parseInt(d);
			
		}
		if(delta !=preDelta) {
			if(delta*currentPage  > count) {
				if(delta*(currentPage-1)  > count) {
					currentPage = getCurrentPage(currentPage, preDelta, count);
				}
				start = delta*(currentPage-1);
			} else if(delta <preDelta) {
					start = delta*(currentPage-1);
			}else {
				
				start=0;
			}
			
		} else if(delta*(currentPage-1)  > count) {
			currentPage = getCurrentPage(currentPage, preDelta, count);
			start = delta*(currentPage-1);
		}
		
		if(start < 0) {
			start = 0;
		}
		
		session.setAttribute("oldDelta", ""+delta+"");
//		List<ReceiptMovementDTO> receiptList = masterdataLocalService.getReceiptSendList(userPost, keywords, start, end,orderByCol, orderByType);
		List<ReceiptMovementDTO> receiptList =_receiptList.getReceiptSentList(userPostId, keywords, start, end, orderByCol, orderByType);
		receiptList.forEach(c->System.out.println(c));
		renderRequest.setAttribute("receiptList", receiptList);
		renderRequest.setAttribute("receiptCount",count);
		renderRequest.setAttribute("delta",delta);
	}
	
	private static int getCurrentPage(int currentPage, int delta, int count) {
		currentPage = currentPage-1;
		
		if(delta*currentPage  < count) {
			return currentPage;
		} else {
			return getCurrentPage(currentPage, delta, count);
		}
	
}

	
	/**
	 * Adds Clay management toolbar context object to the request.*
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addFileToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		SendReceiptManagementToolbarDisplayContext sendReceiptManagementToolbarDisplayContext = new SendReceiptManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("sendReceiptManagementToolbarDisplayContext", sendReceiptManagementToolbarDisplayContext);

	}

	private static Log logger = LogFactoryUtil.getLog(CreatedFileListRenderCommand.class);
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal _portal;
	@Reference
	ReceiptList _receiptList;
}