package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
			"mvc.command.name=" + MVCCommandNames.RECEIPT_SENT_LIST
		},
		service = MVCActionCommand.class
	)
public class ReceiptSentActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("receipt sent action command");
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.RECEIPT_SENT_LIST);
		
		
		
	
		System.out.println("--=-=-=-==");
	}

}
