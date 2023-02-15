package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,

		"mvc.command.name=" + MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND_POP_UP }, service = MVCRenderCommand.class)

public class ReceiptSendRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("receipt send render called");
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long receiptmovementId = ParamUtil.getLong(renderRequest, "receiptmovementId");
		renderRequest.setAttribute("receiptId", receiptId);
		renderRequest.setAttribute("receiptmovementId", receiptmovementId);
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
		try {
			List<UserPost> userPostList = userPostLocalService.getUserPostExceptGivenUserPostId(userPostId);
			renderRequest.setAttribute("userPostList", userPostList);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/receipt/send-receipt.jsp";
	}

	private Log logger = LogFactoryUtil.getLog(ReceiptSendRenderCommand.class); 
	
	@Reference
	private UserPostLocalService userPostLocalService;
	
}