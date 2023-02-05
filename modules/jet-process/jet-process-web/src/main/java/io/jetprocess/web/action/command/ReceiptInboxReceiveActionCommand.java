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

@Component(immediate = true, property = { 
		 "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_INBOX_RECEIVE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class ReceiptInboxReceiveActionCommand implements MVCActionCommand {

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	// for receive physical receipt

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long rmId = ParamUtil.getLong(actionRequest, "rmId");
		String url = ParamUtil.getString(actionRequest, "backPageURL");

		System.out.println("receipt inbox.....");
		System.out.println("Enter by ashwani.....");
		System.out.println("receiptId-----"+receiptId);
		System.out.println("rmId-----"+rmId);
		
		boolean state = receiptMovementLocalService.saveReceiveMovement(receiptId , rmId);
		System.out.println("Enter by ashwani ---2");
		if (state == false) {


			SessionErrors.add(actionRequest, "receive-not-available");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		}
		try {
			actionResponse.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
