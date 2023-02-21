package io.jetprocess.web.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
				"mvc.command.name="+MVCCommandNames.RECEIPT_CLOSE_POP_UP
		},
		service = MVCRenderCommand.class
)
public class CloseReceiptRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long rmId = ParamUtil.getLong(renderRequest, "rmId");
	 long receiptId = ParamUtil.getLong(renderRequest,"receiptId");
	 String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
	 renderRequest.setAttribute("backPageURL", backPageURL);
	renderRequest.setAttribute("rmId", rmId);
	renderRequest.setAttribute("receiptId", receiptId);
		logger.info("close receipt called");
		// TODO Auto-generated method stub
		return "/receipt/close-receipt.jsp";
	}

	
	private Log logger = LogFactoryUtil.getLog(CloseReceiptRenderCommand.class);

	
}
