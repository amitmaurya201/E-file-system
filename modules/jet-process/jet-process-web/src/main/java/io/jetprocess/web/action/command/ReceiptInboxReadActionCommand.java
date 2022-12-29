package io.jetprocess.web.action.command;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

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

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name=receiptReadAction" 
		}, 
		service = MVCActionCommand.class
)
public class ReceiptInboxReadActionCommand  implements MVCActionCommand {

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;
	
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
     long receiptId = ParamUtil.getLong(actionRequest, "receiptId1");
     long rmId = ParamUtil.getLong(actionRequest, "rmId");
     
     try {
		boolean state =  receiptMovementLocalService.pullBackedAlready(rmId);
		if(state == false) {
			
			System.out.println("you can not read this Receipt ");
			actionResponse.setRenderParameter("readStatus", "error");
			actionResponse.setRenderParameter("readResult", "You can not read this Receipt.");
		}else if(state == true) {
			System.out.println("ReceiptId at read--:"+receiptId);
			List<ReceiptMovement> receiptMovement = receiptMovementLocalService.getReceiptMovementByReceiptId(receiptId);
			for (ReceiptMovement receiptMovement2 : receiptMovement) {
				if(receiptMovement2.getReceiptId() == receiptId) {
					receiptMovement2.setReadOn("read");
					receiptMovementLocalService.updateReceiptMovement(receiptMovement2);
				}
			}
		}
		
	} catch (PortalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND);
		
		
		
		
		
		
		
		
		
		return false;
	}

}
