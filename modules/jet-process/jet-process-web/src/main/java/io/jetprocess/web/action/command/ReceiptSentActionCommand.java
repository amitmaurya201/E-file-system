package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SENT_LIST }, service = MVCActionCommand.class)
public class ReceiptSentActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		Long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		Long rmId = ParamUtil.getLong(actionRequest, "rmId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
		receiptMovementLocalService.pullBackReceiptMovement(receiptId, rmId, remarks);
		Boolean active = isActive(receiptId);
		if (!active) {
			receipt.setCurrentState(FileStatus.CREADTED);
			receiptLocalService.updateReceipt(receipt);
		}
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.RECEIPT_SENT_LIST);
	}

	public Boolean isActive(long receiptId) {
		boolean state = false;
		List<ReceiptMovement> receiptMovementByReceiptIdList = receiptMovementLocalService
				.getReceiptMovementByReceiptId(receiptId);

		for (ReceiptMovement receiptMovementByReceiptId : receiptMovementByReceiptIdList) {
			if (!receiptMovementByReceiptId.getActive()) {
				  state = false;
			} else {
				state=true;
				break;
			}
		}
		return state;
	}

	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;
	@Reference
	ReceiptLocalService receiptLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
