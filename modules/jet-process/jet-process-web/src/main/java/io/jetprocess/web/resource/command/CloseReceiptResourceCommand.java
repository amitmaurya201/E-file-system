package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptCloseDetailLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name="+MVCCommandNames.CLOSE_RECEIPT_RESOURCE_COMMAND }, service = MVCResourceCommand.class)

public class CloseReceiptResourceCommand implements MVCResourceCommand  {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		
		long closingReceiptMovementId =	ParamUtil.getLong(resourceRequest, "rmId");
		long receiptId = ParamUtil.getLong(resourceRequest,"receiptId");
		String closingRemarks = ParamUtil.getString(resourceRequest,"closingRemarks");
		String userPostId = ParamUtil.getString(resourceRequest, "userPostId");
		System.out.println(":userPost id----->"+userPostId);
	    long closedBy = Long.parseLong(userPostId);
		System.out.println("closed By --->"+closedBy);
		try {
			receiptCloseDetailLocalService.addClosedReceiptDetails(receiptId, closedBy, closingRemarks, closingReceiptMovementId);
			resourceResponse.setContentType("text/html");
	        PrintWriter out = resourceResponse.getWriter();
	        out.println("Receipt close successfully");
	        out.flush();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}
	
	
	@Reference
	private ReceiptCloseDetailLocalService receiptCloseDetailLocalService;
	

}
