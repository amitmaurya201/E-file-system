package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.service.MasterdataLocalService;
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
		System.out.println("receipt sent action command");
		Long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		System.out.println("receipt sent " + receiptId);
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		ReceiptMovement receiptMovement = receiptMovementLocalService.getReceiptMovementByReceiptId(receiptId);
		if(receiptMovement.getReceiptId() == receiptId ) {
			receiptMovement.setPullBackRemark(remarks);
			receiptMovementLocalService.updateReceiptMovement(receiptMovement);
		}
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.RECEIPT_SENT_LIST);
	}

	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;
}
