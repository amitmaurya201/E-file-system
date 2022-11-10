package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

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
		return "/receipt/create-receipt.jsp";
	}

	
	
	
}