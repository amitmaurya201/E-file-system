package io.jetprocess.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

/**
 * @author Admin
 */
@Component(
		immediate = true, 
		property = { 
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=JetProcessWeb", "javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user" 
		}, 
		service = Portlet.class
)
public class JetProcessWebPortlet extends MVCPortlet {

	public void sendFile(ActionRequest actionRequest, ActionResponse actionResponse) {
		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long fileId = ParamUtil.get(actionRequest, "fileId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");
		 fLocalService.saveSendFile(receiverId, senderId, fileId, priority, dueDate,
		 remark);


	}

	public void sendReceipt(ActionRequest actionRequest, ActionResponse actionResponse) {
		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long receiptId = ParamUtil.get(actionRequest, "receiptId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");
		receiptMovementLocalService.saveSendReceipt(receiverId, senderId, receiptId,
		priority, dueDate, remark);

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		// For the first time set the user posr id in session
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession session = themeDisplay.getRequest().getSession();
//		HttpSession httpSession = PortalUtil.getHttpServletRequest(renderRequest).getSession();
		String userPostId = "1";
		if(session != null) {
			userPostId = (String) session.getAttribute("userPostId");
			if (userPostId == null || userPostId.isEmpty() || userPostId.equals("")) {
				session.setAttribute("userPostId", "1");
			}
			else {
				session.setAttribute("userPostId", userPostId);
			}
		}
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	FileMovementLocalService fLocalService;

	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;

	private static Log logger = LogFactoryUtil.getLog(JetProcessWebPortlet.class);
}
