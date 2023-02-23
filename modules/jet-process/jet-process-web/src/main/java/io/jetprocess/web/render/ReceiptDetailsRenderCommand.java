package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;


@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CORRESPONDENCES_RECEIPT_DETAIL_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ReceiptDetailsRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("render method of correspondence receipt detail");
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long corrFileId=ParamUtil.getLong(renderRequest, "corrFileId");
		DocFile docFile=null;
		try {
			receiptViewHelper.setRecieptDetails(receiptId, renderRequest, renderResponse);
			docFile = docFileLocalService.getDocFile(corrFileId);
			renderRequest.setAttribute("fileNumber", docFile.getFileNumber());
		} catch (PortalException e) {
			logger.info(e);
		}	
		return "/receipt/receipt-details.jsp";
	}
	
	@Reference
	private ReceiptViewHelper receiptViewHelper;
	
	@Reference
	private DocFileLocalService docFileLocalService;
	
	private static Log logger = LogFactoryUtil.getLog(ReceiptDetailsRenderCommand.class);
	
}
