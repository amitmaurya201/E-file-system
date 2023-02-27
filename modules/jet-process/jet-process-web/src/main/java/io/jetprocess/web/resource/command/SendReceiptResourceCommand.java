package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name=" + MVCCommandNames.RECEIPT_SEND_RESOURCE_COMMAND 
				}, 
		service = MVCResourceCommand.class
)
public class SendReceiptResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		long receiptMovementId = ParamUtil.getLong(resourceRequest, "receiptmovementId");
		long receiverId = ParamUtil.get(resourceRequest, "receiverId", 0);
		long senderId = ParamUtil.get(resourceRequest, "senderId", 0);
		long receiptId = ParamUtil.get(resourceRequest, "receiptId", 0);
		String remark = ParamUtil.getString(resourceRequest, "remark");
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		Date dueDate = ParamUtil.getDate(resourceRequest, "dueDate", simpleformat);
		String priority = ParamUtil.getString(resourceRequest, "priorty");
		boolean state =false;
		try {
			resourceResponse.setContentType("text/html");
			PrintWriter out = resourceResponse.getWriter();
			state = receiptMovementLocalService.pullBackedAlready(receiptMovementId);
			if (state == true) {
				receiptMovementLocalService.saveSendReceipt(receiverId, senderId, receiptId, priority, dueDate, remark);
				out.println("Receipt send successfully");
			} else {
				out.println("This receipt already pullbacked");
			}
			out.flush();
		} catch (Exception e) {
			logger.info(e);
		}
		return state;
	}

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
