package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;


@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name="+MVCCommandNames.FILE_SEND_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class SendFileResourceCommand implements MVCResourceCommand  {

	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
			
		long receiverId = ParamUtil.get(resourceRequest, "receiverId", 0);
		long senderId = ParamUtil.get(resourceRequest, "senderId", 0);
		long fileId = ParamUtil.get(resourceRequest, "fileId", 0);
		String remark = ParamUtil.getString(resourceRequest, "remark");
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		Date dueDate = ParamUtil.getDate(resourceRequest, "dueDate", simpleformat);
		String priority = ParamUtil.getString(resourceRequest, "priorty");
		boolean active = true;
		int currentState = FileStatus.IN_MOVEMENT;
		long movementType = MovementStatus.NORMAL;
		long fileMovementId = ParamUtil.getLong(resourceRequest, "fileMovementId");
		try {
			fileMovementLocalService.saveSendFile(receiverId, senderId, fileId, priority, dueDate, remark, active,
					currentState, movementType,fileMovementId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Reference
	private FileMovementLocalService fileMovementLocalService; 
}
