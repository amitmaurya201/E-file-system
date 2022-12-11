package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
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
import io.jetprocess.masterdata.service.MasterdataService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileManagementToolbarDisplayContext;
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
		
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 3);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		logger.info("currentPage: "+currentPage+"  delta: "+delta+"  start: "+start+"  end: "+end);

		HttpSession session = themeDisplay.getRequest().getSession();
		String userPostId =  (String) session.getAttribute("userPostId");
		long userPost = userPostId != null ? Long.parseLong(userPostId) : 1;
		List<ReceiptMovementDTO>  receiptMovementList = masterdataLocalService.getReceiptMovementDTOListByUserPostId(userPost);  
		renderRequest.setAttribute("receiptMovementList", receiptMovementList);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("receiptMovementCount",+receiptMovementList.size());
		
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	
	@Reference
	private MasterdataLocalService masterdataLocalService;
	
	@Reference
	private Portal portal;

}
