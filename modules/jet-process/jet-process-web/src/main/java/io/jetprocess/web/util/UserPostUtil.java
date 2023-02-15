package io.jetprocess.web.util;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpSession;

public class UserPostUtil {

	
	public static long getUserIdUsingSession(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession session = themeDisplay.getRequest().getSession();
		String sessionUserPostId = (String) session.getAttribute("userPostId");
		long userPostId = Long.parseLong(sessionUserPostId);
		return userPostId;
	}
}
