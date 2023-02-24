package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.ReceiptListService;
import io.jetprocess.list.model.ReceiptListViewDto;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.AddCorrespondenceManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

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

		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		String natureType = null;
		try {
			DocFile docfile = docFileLocalService.getDocFile(docFileId);
			natureType = docfile.getNature();

			int count = _receiptList.getPutInFileListCount(natureType, userPostId, keywords);

			Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
			start = paginationConfig.get("start");
			currentPage = paginationConfig.get("currentPage");
			List<ReceiptListViewDto> receiptList = _receiptList.getPutInFileList(natureType, userPostId, keywords, start, end,
					"", "");
			receiptList.forEach(c -> logger.info(
					c.getReceiptId() + ", : " + c.isRead() + ", : file movement id :  " + c.getReceiptMovementId()));
			renderRequest.setAttribute("receiptFileList", receiptList);
			renderRequest.setAttribute("delta", delta);
			renderRequest.setAttribute("receiptCount", +count);
			renderRequest.setAttribute("userPostId", userPostId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
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
	private ReceiptListService _receiptList;

	@Reference
	private DocFileLocalService docFileLocalService;

}