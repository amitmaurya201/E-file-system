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
import io.jetprocess.model.ReceiptMovement;
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
	
	
	
	// action method for getting docfileId and pullback remarks
		public void sentActionUrl(ActionRequest actionRequest, ActionResponse actionResponse)
				throws IOException, PortletException, PortalException {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			HttpSession sessionUserPost = themeDisplay.getRequest().getSession();
			String userPosts = (String) sessionUserPost.getAttribute("userPostId");
			System.out.println("userPosts"+userPosts);
			long userpost = Long.parseLong(userPosts); 
			System.out.println("---->"+userpost);
			Long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
			Long fileMovementId = ParamUtil.getLong(actionRequest, "fileMovementId");
			String pullBackRemark = ParamUtil.getString(actionRequest, "pullBackRemark");
			//List<ReceiptMovement> receiptMovementList =  receiptMovementLocalService.getReceiptMovementByFileMovementId(fileMovementId);
			//System.out.println("receipt movement list --->>>"+receiptMovementList);
		//	if(receiptMovementList != null) {
				System.out.println("if condition -->");
			Boolean pullBackAvailable = fLocalService.isPullBackAvailable(fileMovementId);
			if (pullBackAvailable) {
				DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
				System.out.println("DocFileId--->" + docFile);
				docFile.setCurrentlyWith(userpost);
				fLocalService.pullBackFileMovement(docFileId, fileMovementId, pullBackRemark);
				docFile.setCurrentState(FileStatus.CREADTED);
				docFileLocalService.updateDocFile(docFile);
				System.out.println("After pull back--->"+docFileLocalService.updateDocFile(docFile));
				Boolean active = isActive(docFileId);
				if (!active) {
					docFile.setCurrentState(FileStatus.CREADTED);
					docFileLocalService.updateDocFile(docFile);
					System.out.println("in active-->"+docFileLocalService.updateDocFile(docFile));
				}
				SessionMessages.add(actionRequest, "pullback-available");
			} else {
				SessionErrors.add(actionRequest, "pullback-not-available");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
			
			List<ReceiptMovement> receiptMovementList =  receiptMovementLocalService.getReceiptMovementByFileMovementId(fileMovementId);
			System.out.println("receiptMovementList --->"+receiptMovementList);
			if(receiptMovementList != null) {
				// Iterate list of receipt 
				
				for (ReceiptMovement receiptMovement : receiptMovementList) {
					if(fileMovementId == receiptMovement.getFileInMovementId()) {
						System.out.println("with if condition-->");
					receiptMovement.setActive(false);
					receiptMovementLocalService.updateReceiptMovement(receiptMovement);
					}
					
				}	
			}
		/*
		 * else if(receiptMovementList != null) {
		 * 
		 * System.out.println("else part chalassss-->"); Boolean pullBackAvailable =
		 * fLocalService.isPullBackAvailable(fileMovementId); if (pullBackAvailable) {
		 * DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
		 * System.out.println("DocFileId--->" + docFile);
		 * docFile.setCurrentlyWith(userpost);
		 * fLocalService.pullBackFileMovement(docFileId, fileMovementId,
		 * pullBackRemark); docFile.setCurrentState(FileStatus.CREADTED);
		 * docFileLocalService.updateDocFile(docFile);
		 * System.out.println("After pull back--->"+docFileLocalService.updateDocFile(
		 * docFile)); Boolean active = isActive(docFileId); if (!active) {
		 * docFile.setCurrentState(FileStatus.CREADTED);
		 * docFileLocalService.updateDocFile(docFile);
		 * System.out.println("in active-->"+docFileLocalService.updateDocFile(docFile))
		 * ; } SessionMessages.add(actionRequest, "pullback-available"); } else {
		 * SessionErrors.add(actionRequest, "pullback-not-available");
		 * SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) +
		 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE); }
		 * 
		 */			
			/*
			 * // Iterate list of receipt
			 * 
			 * for (ReceiptMovement receiptMovement : receiptMovementList) {
			 * if(fileMovementId == receiptMovement.getFileInMovementId()) {
			 * receiptMovement.setActive(false);
			 * receiptMovementLocalService.updateReceiptMovement(receiptMovement); }
			 * 
			 * }
			 */
			System.out.println("without if condition --->");
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
