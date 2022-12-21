package io.jetprocess.web.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.MasterdataLocalServiceUtil;
import io.jetprocess.masterdata.service.MasterdataService;
import io.jetprocess.masterdata.service.UserPostService;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileMovement;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileManagementToolbarDisplayContext;
import io.jetprocess.web.render.CreatedFileListRenderCommand;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=JetProcessWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/file/created-file-list.jsp",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class JetProcessWebPortlet extends MVCPortlet {
	// for Send file
	public void sendFile(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long fileId = ParamUtil.get(actionRequest, "fileId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");

		fLocalService.saveSendFile(receiverId, senderId, fileId, priority, dueDate, remark);

		actionResponse.setRenderParameter("mvcPath", "/file/created-file-list.jsp");

	}

	public void sendReceipt(ActionRequest actionRequest, ActionResponse actionResponse) {
		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long receiptId = ParamUtil.get(actionRequest, "receiptId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");
		receiptMovementLocalService.saveSendReceipt(receiverId, senderId, receiptId, priority, dueDate, remark);

		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_SENT_LIST);
	}

	// action method for getting docfileId and pullback remarks
	public void sentActionUrl(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {
		System.out.println("sentAction url");
		Long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		System.out.println("docFileId  Id " + docFileId);
		Long fileMovementId = ParamUtil.getLong(actionRequest, "fileMovementId");

		String pullBackRemark = ParamUtil.getString(actionRequest, "pullBackRemark");
		System.out.println("remarks-->" + pullBackRemark);

		FileMovement fileMovement = fLocalService.getFileMovement(fileMovementId);
		System.out.println("fileMovement id-->" + fileMovementId);
		System.out.println("--->  pullbackremarks -->" + pullBackRemark);

		fileMovement.setPullBackRemark(pullBackRemark);
		fileMovement.setActive(false);
		fLocalService.updateFileMovement(fileMovement);
		System.out.println("FileMovement data -->" + fLocalService.updateFileMovement(fileMovement));
		DocFile docFile = docFileLocalService.getDocFileByDocFileId(fileMovement.getFileId());
		System.out.println("currentState -->" + docFile.getCurrentState());
		if (docFile.getCurrentState() == 2) {
			docFile.setCurrentState(1);
			docFileLocalService.updateDocFile(docFile);
			System.out.println("--->>>current state --" + docFileLocalService.updateDocFile(docFile));
		}

		actionResponse.setRenderParameter("mvcPath", "/file/created-file-list.jsp");
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

	

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		HttpSession session = themeDisplay.getRequest().getSession();
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		HttpServletRequest httpRequest = themeDisplay.getRequest();
		String userPostIdFromUrl = httpRequest.getParameter("userPost"); // from url
//		String userPostId = ParamUtil.getString(renderRequest, "userPostId", "0");// from ajax
		logger.info("UserPostId from url: " + userPostIdFromUrl);
		if (userPostIdFromUrl != null) {
			session.setAttribute("userPostId", userPostIdFromUrl);
			logger.info("UserPostId is sent in the session : " + userPostIdFromUrl);
			
		} else {
			userPostIdFromUrl = (String) session.getAttribute("userPostId");
			logger.info("UserPostId from session : " + userPostIdFromUrl);
			if (userPostIdFromUrl == null) {
				List<UserPost> userPostList = userPostService.getUserPostList(user.getUserId());
				if (!userPostList.isEmpty()) {
					UserPost userPost = userPostList.get(0);
					long postId = userPost.getPostId();
					session.setAttribute("userPostId", String.valueOf(postId));
					logger.info("User post id in session : " + String.valueOf(postId));
					
				} else {
					String errPage = "/error/error.jsp";
					logger.info("User Post is not available for the user :" + user.getUserId());
					renderRequest.setAttribute("noUserPostMsg", "label-no-user-post-msg");
					super.include(errPage, renderRequest, renderResponse);
				}
			}
		}
		
		addFileListAttributes(renderRequest);
		addFileToolbarAttributes(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
		

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
		logger.info("user post id inside render : --" + userPostId);
		long userPost = userPostId;
		System.out.println("userpostid by amit" + userPost);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createdOn");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int count = masterdataLocalService.getFileCreatedByKeywordCount(userPost, keywords);
		if (delta * currentPage > count) {
			start = 0;
		}
		List<FileListViewDto> fileList = masterdataLocalService.getFileCreatedByKeywords(userPost, keywords, start, end,
				orderByCol, orderByType);
		logger.info("size of File :=============== " + fileList.size());
		renderRequest.setAttribute("fileList", fileList);
		logger.info("List------------" + fileList);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("fileCount", count);
		System.out.println("orderByType  --> " + orderByType + " ,orderByCol---> " + orderByCol);
	}

	private void addFileToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		FileManagementToolbarDisplayContext fileManagementToolbarDisplayContext = new FileManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileManagementToolbarDisplayContext", fileManagementToolbarDisplayContext);
	}

	@Reference
	private MasterdataService masterData;
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal _portal;
	@Reference
	private DocFileLocalService docFileLocalService;

	@Reference
	private MasterdataLocalService masterdataLocalSerive;

	@Reference
	private UserPostService userPostService;

	@Reference
	FileMovementLocalService fLocalService;

	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;

	private static Log logger = LogFactoryUtil.getLog(JetProcessWebPortlet.class);
}
