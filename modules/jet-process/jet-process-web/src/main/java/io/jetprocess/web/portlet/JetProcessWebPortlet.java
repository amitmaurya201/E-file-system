package io.jetprocess.web.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
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

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.list.api.FileList;
import io.jetprocess.list.model.FileListViewDto;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.MasterdataLocalService;
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

		String urlvalue = ParamUtil.getString(actionRequest, "pageURL");

		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long fileId = ParamUtil.get(actionRequest, "fileId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");

		fLocalService.saveSendFile(receiverId, senderId, fileId, priority, dueDate, remark);

		try {
			actionResponse.sendRedirect(urlvalue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendReceipt(ActionRequest actionRequest, ActionResponse actionResponse) {
		String urlvalue = ParamUtil.getString(actionRequest, "pageURL");

		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long receiptId = ParamUtil.get(actionRequest, "receiptId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");
		receiptMovementLocalService.saveSendReceipt(receiverId, senderId, receiptId, priority, dueDate, remark);

		try {
			actionResponse.sendRedirect(urlvalue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// action method for getting docfileId and pullback remarks
	public void sentActionUrl(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {
		Long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		Long fileMovementId = ParamUtil.getLong(actionRequest, "fileMovementId");
		String pullBackRemark = ParamUtil.getString(actionRequest, "pullBackRemark");
		Boolean pullBackAvailable = fLocalService.isPullBackAvailable(fileMovementId);
		if (pullBackAvailable) {
			DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
			System.out.println("DocFileId--->" + docFile);
			fLocalService.pullBackFileMovement(docFileId, fileMovementId, pullBackRemark);

			Boolean active = isActive(docFileId);
			if (!active) {
				docFile.setCurrentState(FileStatus.CREADTED);
				docFileLocalService.updateDocFile(docFile);
			}
			SessionMessages.add(actionRequest, "pullback-available");
		} else {
			SessionErrors.add(actionRequest, "pullback-not-available");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

		/*
		 * FileMovement fileMovement = fLocalService.getFileMovement(fileMovementId);
		 * fileMovement.setPullBackRemark(pullBackRemark);
		 * System.out.println("pull back remarks"+pullBackRemark);
		 * fileMovement.setActive(false);
		 * fLocalService.updateFileMovement(fileMovement); DocFile docFile =
		 * docFileLocalService.getDocFileByDocFileId(fileMovement.getFileId()); if
		 * (docFile.getCurrentState() == FileStatus.IN_MOVEMENT) {
		 * docFile.setCurrentState(FileStatus.CREADTED);
		 * docFileLocalService.updateDocFile(docFile);
		 * System.out.println("--->>>current state --" +
		 * docFileLocalService.updateDocFile(docFile)); }
		 */
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.FILE_SENT_RENDER_COMMAND);
	}

	// method for getting active

	public Boolean isActive(long docFileId) {
		boolean state = false;
		List<FileMovement> fileMovementByDocFileIdList = fLocalService.getFileMovementByFileId(docFileId);
		for (FileMovement fileMovement : fileMovementByDocFileIdList) {
			if (!fileMovement.getActive()) {
				state = false;

			} else {
				state = true;
				break;
			}

		}
		return state;
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		HttpSession session = themeDisplay.getRequest().getSession();
		HttpServletRequest httpRequest = themeDisplay.getRequest();

		String userPost = (String) httpRequest.getAttribute("userPostId");
		// System.out.println("jetprocess-web -portlet"+userPost);
		// session.setAttribute("userPostId", userPost);

		if (userPost == null) {
			String sessionUserPostId = (String) session.getAttribute("userPostId");
			logger.info("UserPostId from session : " + sessionUserPostId);
			if (sessionUserPostId == null) {
				List<UserPost> userPostList = userPostService.getUserPostList(user.getUserId());
				if (!userPostList.isEmpty()) {
					UserPost userPosts = userPostList.get(0);
					long postId = userPosts.getPostId();
					session.setAttribute("userPostId", String.valueOf(postId));
					logger.info("User post id in session : " + String.valueOf(postId));

				} else {
					String errPage = "/error/error.jsp";
					// logger.info("User Post is not available for the user :" + user.getUserId());
					renderRequest.setAttribute("noUserPostMsg", "label-no-user-post-msg");
					super.include(errPage, renderRequest, renderResponse);
				}
			}
		}

		addFileListAttributes(renderRequest, renderResponse);
		addFileToolbarAttributes(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
	}

	private void addFileListAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		HttpSession session = themeDisplay.getRequest().getSession();
		HttpServletRequest httpRequest = themeDisplay.getRequest();
		String urlPost = httpRequest.getParameter("userPost");
		logger.info("urlPost from url in addfile list" + urlPost);
		if (urlPost != null) {
			session.setAttribute("userPostId", urlPost);
		}
		long userPostId = Long.parseLong((String) session.getAttribute("userPostId"));
		logger.info("userPostId in addfile list" + userPostId);
		long userPost = userPostId;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createdate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		// int count = masterdataLocalService.getFileCreatedByKeywordCount(userPost,
		// keywords);
		int count = fileList.getCountOfFileList(userPostId, keywords);
		if (delta * currentPage > count) {
			start = 0;
		}
		List<FileListViewDto> fileList1 = fileList.getFileList(userPostId, keywords, start, end, orderByCol,
				orderByType);
		// List<FileListViewDto> fileList =
		// masterdataLocalService.getFileCreatedByKeywords(userPost, keywords, start,
		// end,
		// orderByCol, orderByType);
		renderRequest.setAttribute("fileList", fileList1);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("fileCount", count);
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

	@Reference
	FileList fileList;

	private static Log logger = LogFactoryUtil.getLog(JetProcessWebPortlet.class);
}
