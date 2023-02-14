package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name=/set/user/post/action/url" 
		}, 
		service = MVCActionCommand.class
)
public class CreateFileListActionCommand extends BaseMVCActionCommand {

	private static Log logger = LogFactoryUtil.getLog(CreateFileListActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		// For the second time when user post is changed get attribute value from ajax
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession httpSession = themeDisplay.getRequest().getSession();
		//HttpSession httpSession = PortalUtil.getHttpServletRequest(actionRequest).getSession();
		String userPostId = ParamUtil.getString(actionRequest, "userPostId");
		logger.info("Changed User Post is : "+userPostId);
		if (userPostId == null || userPostId.isEmpty() || userPostId.equals("")) {
			httpSession.setAttribute("userPostId", "1");
		}
		else {
			httpSession.setAttribute("userPostId", userPostId);
		}
	}
	
		
}
