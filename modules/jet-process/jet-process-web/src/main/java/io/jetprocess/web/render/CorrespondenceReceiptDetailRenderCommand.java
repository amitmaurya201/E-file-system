package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;


@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CORRESPONDENCES_RECEIPT_DETAIL_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class CorrespondenceReceiptDetailRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("view");
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		receiptViewHelper.setRecieptDetails(receiptId, renderRequest, renderResponse);
		return "/receipt/correspondence-receipt-detail.jsp";
	}
	
	@Reference
	private ReceiptLocalService receiptLocalService; 
	
	@Reference
	private ReceiptViewHelper receiptViewHelper;
	
}
