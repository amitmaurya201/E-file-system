package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name="+MVCCommandNames.DETACH_RECEIPT }, service = MVCActionCommand.class)
public class DetachReceiptActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("Detaching Receipt  action command....");
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(actionRequest, "rmId");
		String detachRemark = ParamUtil.getString(actionRequest, "remarks");
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		fileCorrReceiptLocalService.detachFileCorrReceipt(receiptId, receiptMovementId, detachRemark, 1);
		System.out.println("Receipt id: "+receiptId+", Receipt movement id : "+receiptMovementId+", remarks : "+detachRemark);
		System.out.println(redirectURL);
		actionResponse.sendRedirect(redirectURL);

	}
	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;

}
