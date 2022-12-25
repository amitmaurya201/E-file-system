package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.FileMovement;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=fileReceiveAction" }, service = MVCActionCommand.class)

public class FileInboxReceiveActionCommand implements MVCActionCommand {

	
	@Reference
	private FileMovementLocalService fileMovementLocalService;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		long fileId = ParamUtil.getLong(actionRequest, "fileId");

		System.out.println("fileId1 --:" + fileId);

		 List<FileMovement> fileMovement = fileMovementLocalService.getFileMovementByFileId(fileId);
		  for (FileMovement fileMovement2 : fileMovement) {
			  if(fileMovement2.getFileId() == fileId) {
				  fileMovement2.setReadOn("checked");;
				  fileMovementLocalService.updateFileMovement(fileMovement2);
				  
			  }
		}
		
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.FILE_INBOX_RENDER_COMMAND);

		return false;
		
		

	}
}
