package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.FileMovement;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=receiveAction" }, service = MVCActionCommand.class)

public class FileInboxReceiveActionCommand implements MVCActionCommand {

	
	@Reference
	private FileMovementLocalService fileMovementLocalService;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		long fileId = ParamUtil.getLong(actionRequest, "fileId");

		System.out.println("fileId1 --:" + fileId);

		FileMovement fileMovement = fileMovementLocalService.getFileByFileId(fileId);
	
		if (fileMovement.getFileId() == fileId) {
			fileMovement.setReceivedOn("receive");
			fileMovementLocalService.updateFileMovement(fileMovement);
		}
		
		actionResponse.setRenderParameter("mvcPath", "/file/inbox.jsp");

		return false;
		
		

	}
}
