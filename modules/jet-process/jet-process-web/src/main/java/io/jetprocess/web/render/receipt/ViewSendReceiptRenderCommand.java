package io.jetprocess.web.render.receipt;

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
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalServiceUtil;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ViewSendReceiptRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("ViewSendReceiptRenderCommand--->");
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		long receiptMovementId = ParamUtil.getLong(renderRequest, "receiptMovementId");		
		long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);	
		logger.info("receiptId---> " + receiptId);
		try {
			List<UserPost> userPostList = userPostLocalService.getUserPostExceptGivenUserPostId(userPostId);
			renderRequest.setAttribute("userPostList", userPostList);
			Receipt receiptId1 = ReceiptLocalServiceUtil.getReceipt(receiptId);
			renderRequest.setAttribute("receipt", receiptId1);
			renderRequest.setAttribute("receiptMovementId", receiptMovementId);
			renderRequest.setAttribute("backPageURL", backPageURL);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return "/receipt/send.jsp";
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	
	@Reference
	private UserPostLocalService userPostLocalService; 
	
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService; 
}