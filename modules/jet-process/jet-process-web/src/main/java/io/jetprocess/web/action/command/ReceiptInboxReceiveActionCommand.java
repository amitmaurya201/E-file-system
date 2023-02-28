package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_INBOX_RECEIVE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class ReceiptInboxReceiveActionCommand implements MVCActionCommand {
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	// for receive physical receipt

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(actionRequest, "receiptMovementId");
		String url = ParamUtil.getString(actionRequest, "backPageURL");
		logger.info(receiptId + "    " + receiptMovementId);
		boolean state = false;
		try {
			state = receiptMovementLocalService.saveReceiveMovement(receiptId, receiptMovementId);
			if (state == false) {
				SessionErrors.add(actionRequest, "receive-not-available");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
			actionResponse.sendRedirect(url);
		} catch (IOException e) {
			logger.info(e);
		}
		return state;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
