package io.jet.process.user.post.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jet.process.user.post.web.constants.JetProcessUserPostWebPortletKeys;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=JetProcessUserPostWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + JetProcessUserPostWebPortletKeys.JETPROCESSUSERPOSTWEB,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=false" }, service = Portlet.class)
public class JetProcessUserPostWebPortlet extends MVCPortlet {

	@Reference
	UserPostLocalService userPostLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		List<UserPost> userPost = userPostLocalService.getUserPostList(userId);
		for (UserPost userPost2 : userPost) {
			renderRequest.setAttribute("userPostList", userPost);
		}

		User user = themeDisplay.getUser();
		HttpSession session = themeDisplay.getRequest().getSession();
		HttpServletRequest httpRequest = themeDisplay.getRequest();

		
		String userPostIdFromUrl = httpRequest.getParameter("userPost"); // from url
		logger.info("UserPostId from url: " + userPostIdFromUrl);
		if (userPostIdFromUrl != null) {
			session.setAttribute("userPostId", userPostIdFromUrl);
			logger.info("UserPostId is sent in the session : " + userPostIdFromUrl);
		} else {
			userPostIdFromUrl = (String) session.getAttribute("userPostId");
			logger.info("UserPostId from session : " + userPostIdFromUrl);
			if (userPostIdFromUrl == null) {
				List<UserPost> userPostList = userPostLocalService.getUserPostList(user.getUserId());
				if (!userPostList.isEmpty()) {
					UserPost userPosts = userPostList.get(0);
					long postId = userPosts.getPostId();
					session.setAttribute("userPostId", String.valueOf(postId));
					logger.info("User post id in session : " + String.valueOf(postId));

				}
				/*
				 * else { String errPage = "/error/error.jsp"; //
				 * logger.info("User Post is not available for the user :" + user.getUserId());
				 * renderRequest.setAttribute("noUserPostMsg", "label-no-user-post-msg");
				 * super.include(errPage, renderRequest, renderResponse); }
				 */
			}
		}

		super.doView(renderRequest, renderResponse);
	}

	private static Log logger = LogFactoryUtil.getLog(JetProcessUserPostWebPortlet.class);

}