package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SENT_LIST }, service = MVCActionCommand.class)
public class ReceiptSentActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("action of pull back");

		Long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		Long rmId = ParamUtil.getLong(actionRequest, "rmId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		Boolean pullBackAvailable = receiptMovementLocalService.isPullBackAvailable(rmId);
			if (pullBackAvailable) {
				logger.info("working");
				Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
				receiptMovementLocalService.pullBackReceiptMovement(receiptId, rmId, remarks);
				Boolean active = receiptMovementLocalService.isActive(receiptId);
				if (!active) {
					receipt.setCurrentState(FileStatus.CREADTED);
					receiptLocalService.updateReceipt(receipt);
				} else {
					logger.info("pull back in inbox");
				}
				SessionMessages.add(actionRequest, "pullback-available");
			} else {
				logger.info("already pull back");
				
				SessionErrors.add(actionRequest, "pullback-not-available");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
	
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.RECEIPT_SENT_LIST);
	}

	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;
	@Reference
	ReceiptLocalService receiptLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
