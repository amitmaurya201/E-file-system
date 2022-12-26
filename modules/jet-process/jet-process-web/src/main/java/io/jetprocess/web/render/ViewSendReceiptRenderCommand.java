package io.jetprocess.web.render;

import com.liferay.captcha.recaptcha.ReCaptchaImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.model.DocFile;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.DocFileLocalServiceUtil;
import io.jetprocess.service.ReceiptLocalServiceUtil;
import io.jetprocess.service.ReceiptServiceUtil;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
			"mvc.command.name=" + MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND
			
		},
		service = MVCRenderCommand.class
	)

public class ViewSendReceiptRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		logger.info("receiptId---> "+receiptId);
		
		try {
			Receipt receiptId1=ReceiptLocalServiceUtil.getReceipt(receiptId);
			renderRequest.setAttribute("receipt", receiptId1);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return "/receipt/send.jsp";
	}
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
