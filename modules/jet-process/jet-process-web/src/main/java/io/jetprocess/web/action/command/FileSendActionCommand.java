package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;


@Component(immediate = true, property = {
		
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
               "mvc.command.name=sendFile" 
		}, service = MVCActionCommand.class)
public class FileSendActionCommand  implements MVCActionCommand{

	@Reference
	FileMovementLocalService fileMovementLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		String urlvalue = ParamUtil.getString(actionRequest, "pageURL");

		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long fileId = ParamUtil.get(actionRequest, "fileId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String priority = ParamUtil.getString(actionRequest, "priorty");

		fileMovementLocalService.saveSendFile(receiverId, senderId, fileId, priority, dueDate, remark);

		try {
			actionResponse.sendRedirect(urlvalue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

}
