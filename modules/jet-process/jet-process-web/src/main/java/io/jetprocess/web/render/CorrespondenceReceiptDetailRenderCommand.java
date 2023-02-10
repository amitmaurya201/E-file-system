package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;


@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CORRESPONDENCES_RECEIPT_DETAIL_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class CorrespondenceReceiptDetailRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long corrFileId=ParamUtil.getLong(renderRequest, "corrFileId");
		receiptViewHelper.setRecieptDetails(receiptId, renderRequest, renderResponse);
		DocFile docFile=null;
		try {
			docFile = docFileLocalService.getDocFile(corrFileId);
		} catch (PortalException e) {
			e.printStackTrace();
		}	
		renderRequest.setAttribute("fileNumber", docFile.getFileNumber());
		return "/receipt/correspondence-receipt-detail.jsp";
	}
	
	@Reference
	private ReceiptLocalService receiptLocalService; 
	
	@Reference
	private ReceiptViewHelper receiptViewHelper;
	
	@Reference
	private DocFileLocalService docFileLocalService;
	
}
