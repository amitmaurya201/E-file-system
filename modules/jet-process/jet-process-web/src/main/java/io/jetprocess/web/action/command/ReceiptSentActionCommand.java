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

import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.init-param.add-process-action-success-action=false",
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name=" + MVCCommandNames.PULL_BACK_RECEIPT_ACTION_COMMAND 
				}, 
		service = MVCActionCommand.class
)
public class ReceiptSentActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(actionRequest, "rmId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		long userPostId = ParamUtil.getLong(actionRequest, "senderId");
		Boolean pullBackAvailable = receiptMovementLocalService.isPullBackAvailable(receiptMovementId);
			if (pullBackAvailable) {
				logger.info("working");
				receiptMovementLocalService.pullBackReceiptMovement(receiptId, receiptMovementId, remarks, userPostId);
				SessionMessages.add(actionRequest, "pullback-available");
			} else {
				logger.info("already pull back");
				SessionErrors.add(actionRequest, "pullback-not-available");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
				MVCCommandNames.RECEIPT_SENT_RENDER_COMMAND);
	}

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
