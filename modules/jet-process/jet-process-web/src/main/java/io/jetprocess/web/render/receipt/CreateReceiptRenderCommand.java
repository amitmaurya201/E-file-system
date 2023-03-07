package io.jetprocess.web.render.receipt;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CREATE_RECEIPT_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class CreateReceiptRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("CreateReceiptRenderCommand---->");
		long userPost = UserPostUtil.getUserIdUsingSession(renderRequest);
		renderRequest.setAttribute("postId", userPost);
		return "/receipt/create-receipt.jsp";
	}
	
	private Log logger = LogFactoryUtil.getLog(CreateReceiptRenderCommand.class);

}