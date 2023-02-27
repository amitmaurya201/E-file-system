package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class SendFileResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		long fileMovementId = ParamUtil.getLong(resourceRequest, "fileMovementId");
		long receiverId = ParamUtil.get(resourceRequest, "receiverId", 0);
		long senderId = ParamUtil.get(resourceRequest, "senderId", 0);
		long fileId = ParamUtil.get(resourceRequest, "fileId", 0);
		String remark = ParamUtil.getString(resourceRequest, "remark");
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		Date dueDate = ParamUtil.getDate(resourceRequest, "dueDate", simpleformat);
		String priority = ParamUtil.getString(resourceRequest, "priorty");
		try {
			boolean state = fileMovementLocalService.pullBackedAlready(fileMovementId);
			resourceResponse.setContentType("text/html");
			PrintWriter out = resourceResponse.getWriter();
			if (state == true) {
					fileMovementLocalService.saveSendFile(receiverId, senderId, fileId, priority, dueDate, remark);					
					out.println("File send successfully");					
				
			} else  {
				
				out.println("This file is already pullbacked");			
			}
			out.flush();
		} catch (PortalException |IOException e) {
			logger.info(e);
			
		} 
		return false;
	}

	@Reference
	private FileMovementLocalService fileMovementLocalService;
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
