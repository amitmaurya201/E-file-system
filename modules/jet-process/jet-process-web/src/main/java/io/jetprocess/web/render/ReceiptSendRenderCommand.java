package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

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
		
		renderRequest.setAttribute("receiptId", receiptId);
		renderRequest.setAttribute("receiptmovementId", receiptmovementId);
			return "/receipt/send-receipt.jsp";
	}

}
