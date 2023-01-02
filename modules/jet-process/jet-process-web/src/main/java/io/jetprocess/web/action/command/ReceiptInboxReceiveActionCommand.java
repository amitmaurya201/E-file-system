package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=receiptReceiveAction" }, service = MVCActionCommand.class)
public class ReceiptInboxReceiveActionCommand implements MVCActionCommand {

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	// for receive physical receipt

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long rmId = ParamUtil.getLong(actionRequest, "rmId");

		try {
			boolean state = receiptMovementLocalService.pullBackedAlready(rmId);
			logger.info("state   " + state);
			if (state == false) {

				logger.info("you can not receive this Receipt ");

				SessionErrors.add(actionRequest, "receive-not-available");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			} else if (state == true) {
				System.out.println("ReceiptId at Receive--:" + receiptId);
				List<ReceiptMovement> receiptMovement = receiptMovementLocalService
						.getReceiptMovementByReceiptId(receiptId);
				for (ReceiptMovement receiptMovement2 : receiptMovement) {
					if (receiptMovement2.getReceiptId() == receiptId) {
						receiptMovement2.setReceivedOn("receive");
						receiptMovementLocalService.updateReceiptMovement(receiptMovement2);
					}
				}
				SessionMessages.add(actionRequest, "receive-available");
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND);
		return false;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
