package io.jetprocess.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
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

import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.MasterdataLocalServiceUtil;
import io.jetprocess.masterdata.service.UserPostService;
import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=JetProcessWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class JetProcessWebPortlet extends MVCPortlet {

	public void sendFile(ActionRequest actionRequest, ActionResponse actionResponse) {
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

		actionResponse.setRenderParameter("mvcPath", "/receipt/created-receipt-list.jsp");
	}

	// action method for getting  docfileId  and pullback remarks
	public void sentActionUrl(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {
		System.out.println("sentAction url");
		Long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		System.out.println("DocFile  Id " + docFileId);
		String remark = ParamUtil.getString(actionRequest, "pullBackRemark");
		System.out.println("remarks-->" + remark);
	
			DocFile docFile =  docFileLocalService.getDocFileByDocFileId(docFileId);
			System.out.println("docFileid====>"+docFile);
		    System.out.println("currentState [--->"+docFile.getCurrentState());
		    if(docFile.getCurrentState() == 2) {
		    	docFile.setCurrentState(1);
		    	docFile.setActive(true);
		    	docFileLocalService.updateDocFile(docFile);
		    	System.out.println("updated Code"+docFileLocalService.updateDocFile(docFile));
					
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
			super.doView(renderRequest, renderResponse);
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
					super.doView(renderRequest, renderResponse);
				} else {
					String errPage = "/error/error.jsp";
					logger.info("User Post is not available for the user :" + user.getUserId());
					renderRequest.setAttribute("noUserPostMsg", "label-no-user-post-msg");
					super.include(errPage, renderRequest, renderResponse);
				}
			}
		}

	}

	
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
