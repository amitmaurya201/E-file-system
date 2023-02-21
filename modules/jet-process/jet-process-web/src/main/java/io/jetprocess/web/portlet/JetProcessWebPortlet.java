package io.jetprocess.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
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

import io.jetprocess.list.api.FileList;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.MasterdataService;
import io.jetprocess.masterdata.service.UserPostService;
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
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0"
		}, service = Portlet.class)
public class JetProcessWebPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		HttpSession session = themeDisplay.getRequest().getSession();
		HttpServletRequest httpRequest = themeDisplay.getRequest();
		String userPost = (String) httpRequest.getAttribute("userPostId");
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
					renderRequest.setAttribute("noUserPostMsg", "label-no-user-post-msg");
					super.include(errPage, renderRequest, renderResponse);
				}
			}
		}

		super.doView(renderRequest, renderResponse);
	}


	@Reference
	private UserPostService userPostService;

	

	private static Log logger = LogFactoryUtil.getLog(JetProcessWebPortlet.class);
}
