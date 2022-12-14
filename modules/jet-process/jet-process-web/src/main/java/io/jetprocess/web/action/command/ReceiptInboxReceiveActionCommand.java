package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name=" 
		}, 
		service = MVCActionCommand.class
)
public class ReceiptInboxReceiveActionCommand implements MVCActionCommand{

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService; 
	
	// for receive physical receipt
	
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		
		ReceiptMovement receiptMovement = receiptMovementLocalService.getReceiptMovementByReceiptId(receiptId);
		if(receiptMovement.getReceiptId() == receiptId ) {
			receiptMovement.setReceivedOn("receive");
			receiptMovementLocalService.updateReceiptMovement(receiptMovement);
		}
		
		actionResponse.setRenderParameter("mvcPath", "/receipt/inbox.jsp");
		
		
		
		
		
		return false;
	}

}
