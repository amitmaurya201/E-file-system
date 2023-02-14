package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND_POP_UP }, 
service = MVCRenderCommand.class)

public class ReceiptSendRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		
		long receiptId =  ParamUtil.getLong(renderRequest, "receiptId");
		long receiptmovementId  = ParamUtil.getLong(renderRequest,"receiptmovementId");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession session = themeDisplay.getRequest().getSession();
		String sessionUserPostId = (String) session.getAttribute("userPostId");
		long userPostId = Long.parseLong(sessionUserPostId);
		try {
			List<UserPost> userPostList = userPostLocalService.getUserPostExceptGivenUserPostId(userPostId);
			renderRequest.setAttribute("userPostList", userPostList);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		renderRequest.setAttribute("receiptId", receiptId);
		renderRequest.setAttribute("receiptmovementId", receiptmovementId);
			return "/receipt/send-receipt.jsp";
	}
	
	@Reference
	private UserPostLocalService userPostLocalService;

}
