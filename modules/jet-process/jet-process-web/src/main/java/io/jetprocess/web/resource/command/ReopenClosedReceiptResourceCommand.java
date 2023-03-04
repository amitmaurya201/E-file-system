package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptCloseDetailLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name="+MVCCommandNames.REOPEN_RECEIPT_RESOURCE_COMMAND}, service = MVCResourceCommand.class)

public class ReopenClosedReceiptResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
	long receiptId =  ParamUtil.getLong(resourceRequest, "reopenReceiptId");
	long closeReceiptId = ParamUtil.getLong(resourceRequest, "closedReceiptId");		
	long reopenedBy =ParamUtil.getLong(resourceRequest, "userPostId");
    String reopenRemarks =	ParamUtil.getString(resourceRequest, "reopenRemarks");
    Date reopenDate = new Date();  
		try { 
			receiptCloseDetailLocalService.addReopenReceiptDetails(receiptId, reopenedBy, reopenRemarks, closeReceiptId,
					reopenDate);
		} catch (PortalException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	@Reference
	private ReceiptCloseDetailLocalService receiptCloseDetailLocalService;
	
	private Log LOGGER=LogFactoryUtil.getLog(ReopenClosedReceiptResourceCommand.class);

}
