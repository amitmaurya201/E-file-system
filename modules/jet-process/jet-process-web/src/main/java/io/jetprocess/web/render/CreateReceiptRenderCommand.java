package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(
		immediate = true,
		property = {
				
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
			"mvc.command.name=/createReceipt"
		},
		service = MVCRenderCommand.class
	)
public class CreateReceiptRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("");
		
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		System.out.println("receiptId  " + receiptId);
		renderRequest.setAttribute("receiptId", receiptId);
		
		return "/receipt/create-receipt.jsp";
	}

	
	
	
}
