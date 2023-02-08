package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_DETAILS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ReceiptViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(renderRequest, "rmId");
		System.out.println("---------------rmid----------"+receiptMovementId);
		  String currentURL = ParamUtil.getString(renderRequest, "backPageURL");
		  renderRequest.setAttribute("CurrentURL", currentURL);
		 renderRequest.setAttribute("receiptMovementId", receiptMovementId);
		receiptViewHelper.setRecieptDetails(receiptId, renderRequest, renderResponse);
		return "/receipt/receipt_view.jsp";
	}

	@Reference
	private ReceiptViewHelper receiptViewHelper;

}
