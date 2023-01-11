package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;


@Component(immediate = true, property = {
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
               "mvc.command.name=sendReceipt" 
		}, service = MVCActionCommand.class)

public class ReceiptSendActionCommand implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
	
		String urlvalue = ParamUtil.getString(actionRequest, "pageURL");

		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long receiptId = ParamUtil.get(actionRequest, "receiptId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");
		receiptMovementLocalService.saveSendReceipt(receiverId, senderId, receiptId, priority, dueDate, remark);

		try {
			actionResponse.sendRedirect(urlvalue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	
	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;
}
