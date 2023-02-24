package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.ReceiptListService;
import io.jetprocess.list.model.ReceiptMovementDTO;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.CorrespondencesInfoManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CORRESPONDENCES_INFO_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class CorrespondencesInfoRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("render method of correspoendences info");
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long corrFileId = ParamUtil.getLong(renderRequest, "corrFileId");
		DocFile docFile = null;
		try {
			receiptViewHelper.setRecieptDetails(receiptId, renderRequest, renderResponse);
			docFile = docFileLocalService.getDocFile(corrFileId);
			renderRequest.setAttribute("fileNumber", docFile.getFileNumber());
		} catch (PortalException e) {
			logger.info(e);
			e.printStackTrace();
		}
		setManagementToolbarAttributes(renderRequest, renderResponse);
		setReceiptMovementList(renderRequest);
		return "/file/correspondencesInfo.jsp";
	}

	private void setManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		CorrespondencesInfoManagementToolbarDisplayContext correspondencesInfoManagementToolbarDisplayContext = new CorrespondencesInfoManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("correspondencesInfoManagementToolbarDisplayContext",
				correspondencesInfoManagementToolbarDisplayContext);
	}

	private void setReceiptMovementList(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId", 0);
		List<ReceiptMovementDTO> receiptMovementList = new ArrayList();
		int count = recieptList.getAttachReceiptMovementListCount(receiptId, "");
		
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		if (receiptId != 0) {
			receiptMovementList = recieptList.getAttachReceiptMovementList(receiptId, "", start, end, "", "");
		}
		receiptMovementList.forEach(c -> logger.info(c));
		renderRequest.setAttribute("receiptMovementList", receiptMovementList);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("receiptMovementCount", count);

	}

	@Reference
	private ReceiptListService recieptList;

	@Reference
	private DocFileLocalService docFileLocalService;

	@Reference
	private Portal portal;

	@Reference
	private ReceiptViewHelper receiptViewHelper;
	
	private static Log logger = LogFactoryUtil.getLog(CorrespondencesInfoRenderCommand.class);

}
