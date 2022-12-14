package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SENT_LIST }, service = MVCRenderCommand.class)
public class ReceiptSentListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("receipt sent render command");
		return "/receipt/sent_list.jsp";
	}

}