package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=detachReceipt" }, service = MVCResourceCommand.class)
public class DetachReceiptResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		System.out.println("Detaching Receipt....");
		long receiptId = ParamUtil.getLong(resourceRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(resourceRequest, "rmId");
		String detachRemark = ParamUtil.getString(resourceRequest, "remarks");
		String redirectURL = ParamUtil.getString(resourceRequest, "redirectURL");
		fileCorrReceiptLocalService.detachFileCorrReceipt(receiptId, receiptMovementId, detachRemark, 1);
		System.out.println("Receipt id: "+receiptId+", Receipt movement id : "+receiptMovementId+", remarks : "+detachRemark);
		System.out.println(redirectURL);
		return false;
	}
	
	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;

}
