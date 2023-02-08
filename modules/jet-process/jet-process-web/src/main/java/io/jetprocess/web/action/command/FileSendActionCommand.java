package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.util.MovementStatus;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(
	immediate = true, 
	property = { 
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_ACTION_COMMAND 
		}, 
	service = MVCActionCommand.class
)
public class FileSendActionCommand extends BaseMVCActionCommand {

	@Reference
	FileMovementLocalService fileMovementLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String urlvalue = ParamUtil.getString(actionRequest, "pageURL");
		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long fileId = ParamUtil.get(actionRequest, "fileId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		Date dueDate = ParamUtil.getDate(actionRequest, "dueDate", simpleformat);
		String priority = ParamUtil.getString(actionRequest, "priorty");
		boolean active = true;
		int currentState = FileStatus.IN_MOVEMENT;
		long movementType = MovementStatus.NORMAL;
		try {
			fileMovementLocalService.saveSendFile(receiverId, senderId, fileId, priority, dueDate, remark, active,
					currentState, movementType);
			actionResponse.sendRedirect(urlvalue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
