package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptCloseDetailLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CLOSE_RECEIPT_ACTION_COMMAND }, service = MVCActionCommand.class)

public class CloseReceiptActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
	
	long closingReceiptMovementId =	ParamUtil.getLong(actionRequest, "rmId");
	long receiptId = ParamUtil.getLong(actionRequest,"receiptId");
	String closingRemarks = ParamUtil.getString(actionRequest,"closingRemarks");
	long closedBy = ParamUtil.getLong(actionRequest, "userPostsVal");
	System.out.println("closed By --->"+closedBy);
	receiptCloseDetailLocalService.addClosedReceiptDetails(receiptId, closedBy, closingRemarks, closingReceiptMovementId);
	
	System.out.println("closed receipt here 0--->");
	
	}
	
	@Reference
	private ReceiptCloseDetailLocalService receiptCloseDetailLocalService;
	

}
