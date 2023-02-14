package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=receiptReceive" }, service = MVCResourceCommand.class)
public class AddFileCorrespondence implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		logger.info("receiptReceive....");
		long receiptId = ParamUtil.getLong(resourceRequest, "receiptId");
		long rmId = ParamUtil.getLong(resourceRequest, "rmId");
		Receipt receipt = null;
		try {
			receipt = receiptLocalService.getReceipt(receiptId);
		} catch (PortalException e) {
			logger.info(e);
		}
		if (receipt.getNature().equalsIgnoreCase("Electronic")) {
			boolean state = receiptMovementLocalService.saveReadMovement(receiptId, rmId);
			if (state == false) {
				SessionErrors.add(resourceRequest, "receipt-is-not-attachable");
				SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
		} else {
			boolean state = receiptMovementLocalService.saveReceiveMovement(receiptId, rmId);
			if (state == false) {
				SessionErrors.add(resourceRequest, "receive-not-available");
				SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
		}
		return false;
	}

	@Reference
	private ReceiptLocalService receiptLocalService;
	
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
