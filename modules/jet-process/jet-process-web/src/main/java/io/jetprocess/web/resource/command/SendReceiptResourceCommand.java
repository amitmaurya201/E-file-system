package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,

		"mvc.command.name=" + MVCCommandNames.RECEIPT_SEND_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class SendReceiptResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		long receiptMovementId = ParamUtil.getLong(resourceRequest, "receiptMovementId");
		boolean state = false;
		try {
			state = receiptMovementLocalService.pullBackedAlready(receiptMovementId);
			if (state == true) {
				long receiverId = ParamUtil.get(resourceRequest, "receiverId", 0);
				long senderId = ParamUtil.get(resourceRequest, "senderId", 0);
				long receiptId = ParamUtil.get(resourceRequest, "receiptId", 0);
				String remark = ParamUtil.getString(resourceRequest, "remark");
				SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
				Date dueDate = ParamUtil.getDate(resourceRequest, "dueDate", simpleformat);
				String priority = ParamUtil.getString(resourceRequest, "priorty");

				receiptMovementLocalService.saveSendReceipt(receiverId, senderId, receiptId, priority, dueDate, remark);
				resourceResponse.setContentType("text/html");
				PrintWriter out = resourceResponse.getWriter();
				out.println("Receipt send successfully");
				out.flush();
			} else if (state == false) {
				resourceResponse.setContentType("text/html");
				PrintWriter out = resourceResponse.getWriter();
				out.println("This receipt already pullbacked");
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

}
