package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
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
import io.jetprocess.web.portlet.JetProcessWebPortlet;

@Component(immediate = true, property = { 
		 "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=receiptReadAction" }, service = MVCActionCommand.class)
public class ReceiptInboxReadActionCommand implements MVCActionCommand {

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		logger.info("receipt inbox read action command");
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId1");
		long rmId = ParamUtil.getLong(actionRequest, "rmId");
		String url = ParamUtil.getString(actionRequest, "backPageURL");

		
		try {
			boolean state = receiptMovementLocalService.pullBackedAlready(rmId);
			logger.info("state   " + state);
			if (state == false) {

				logger.info("you can not read this Receipt ");
				
				SessionErrors.add(actionRequest, "read-not-available");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} else if (state == true) {
				System.out.println("ReceiptId at read--:" + receiptId);
				List<ReceiptMovement> receiptMovement = receiptMovementLocalService
						.getReceiptMovementByReceiptId(receiptId);
				for (ReceiptMovement receiptMovement2 : receiptMovement) {
					if (receiptMovement2.getReceiptId() == receiptId) {
						receiptMovement2.setReadOn("read");
						receiptMovementLocalService.updateReceiptMovement(receiptMovement2);
					}
				}
//				SessionMessages.add(actionRequest, "read-available");
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			actionResponse.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND);
		return false;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
