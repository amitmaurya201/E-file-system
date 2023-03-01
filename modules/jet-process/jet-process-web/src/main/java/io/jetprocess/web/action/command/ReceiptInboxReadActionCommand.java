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
		"mvc.command.name=" + MVCCommandNames.RECEIPT_INBOX_READ_ACTION_COMMAND }, service = MVCActionCommand.class)
public class ReceiptInboxReadActionCommand implements MVCActionCommand {

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		logger.info("ReceiptActionReadActionCommand------>" );
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(actionRequest, "receiptMovementId");
		String url = ParamUtil.getString(actionRequest, "backPageURL");
		boolean state = false;
		try {
			state = receiptMovementLocalService.saveReadMovement(receiptId, receiptMovementId);
			if (state == false) {
				SessionErrors.add(actionRequest, "read-not-available");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
			actionResponse.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
