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

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.FileList;
import io.jetprocess.list.model.FileListViewDto;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.PutInFileManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.PUTINFILE_RENDER_COMMAND }, service = MVCRenderCommand.class)

public class PutInFileRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(renderRequest, "receiptMovementId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		renderRequest.setAttribute("backPageURL", backPageURL);
		renderRequest.setAttribute("receiptId", receiptId);
		renderRequest.setAttribute("receiptMovementId", receiptMovementId);
		addFileToolbarAttributes(renderRequest, renderResponse);
		addFileListAttributes(renderRequest);


		return "/receipt/put_in_a_file.jsp";
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
		 long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		 String type = null;
		 try {
			Receipt receipt = receiptLocalService.getReceipt(receiptId);
			type = receipt.getNature();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 int count =_fileList.getPutInFileReceiptCount(type,userPost, keywords);

		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");
		List<FileListViewDto> fileList = _fileList.getPutInFileReceipt(type,userPostId, keywords, start, end, "", "");
		renderRequest.setAttribute("fileList", fileList);
		renderRequest.setAttribute("delta", delta); //
		renderRequest.setAttribute("fileCount", +count);
	}

	private void addFileToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		PutInFileManagementToolbarDisplayContext putInFileManagementToolbarDisplayContext = new PutInFileManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("putInFileManagementToolbarDisplayContext",
				putInFileManagementToolbarDisplayContext);
	}

	private static Log logger = LogFactoryUtil.getLog(PutInFileRenderCommand.class);

	@Reference
	private Portal _portal;

	@Reference
	private FileList _fileList;
	
	@Reference
	private ReceiptLocalService receiptLocalService;

}
