package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name="+MVCCommandNames.RECEIPT_REOPEN_POP_UP
		},
		service = MVCRenderCommand.class)
public class ReceiptReopenRenderCommand   implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	
	    long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
	    long reopenMovementId = ParamUtil.getLong(renderRequest, "reopenMovementId");
	    System.out.println("receiptId --->"+receiptId+"reopenMovementId--->"+reopenMovementId);
		
		renderRequest.setAttribute("receiptId", receiptId);
		renderRequest.setAttribute("reopenMovementId", reopenMovementId);
	    
		return "/receipt/reopen-receipt.jsp";
	}

}
