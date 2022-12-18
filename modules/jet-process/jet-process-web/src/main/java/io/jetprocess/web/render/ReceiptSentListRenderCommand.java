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
import io.jetprocess.masterdata.model.ReceiptMovementDTO;
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
		logger.info("user post id inside render : --" + userPostId);
		long userPost = userPostId;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createdate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		System.out.println("keywords on create render : " + keywords);
//		List<ReceiptMovementDTO> receiptList= MasterdataLocalServiceUtil.getReceiptSentList(userPost);
		List<ReceiptMovementDTO> receiptList = masterdataLocalService.getReceiptSendList(userPost, keywords, start, end,orderByCol, orderByType);
		logger.info("receiptList :=============== " + receiptList.size());
		receiptList.forEach(c->System.out.println(c));
		renderRequest.setAttribute("receiptList", receiptList);
		int count=masterdataLocalService.getReceiptSendList(userPost, keywords);
		renderRequest.setAttribute("receiptCount",count);
		renderRequest.setAttribute("delta",delta);
		System.out.println("orderByType-----> "+orderByType);
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

}