package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.exception.PortalException;
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
		long fmId = ParamUtil.getLong(actionRequest, "fmId");
		System.out.println("fileMovement Id"+fmId);
		
	   try {
		boolean state =	fileMovementLocalService.pullBackedAlready(fmId);
		if(state==false) {
			System.out.println("you can not receive this file ");
			actionResponse.setRenderParameter("receiveStatus", "error");
			actionResponse.setRenderParameter("receiveResult", "You can not receive this file.");
		}else if(state==true) {
			System.out.println("fileId1 --:" + fileId);

			 List<FileMovement> fileMovement = fileMovementLocalService.getFileMovementByFileId(fileId);
			  for (FileMovement fileMovement2 : fileMovement) {
				  if(fileMovement2.getFileId() == fileId) {
					  fileMovement2.setReceivedOn("receive");
					  fileMovementLocalService.updateFileMovement(fileMovement2);
					  
				  }
			}
			
		}
	} catch (PortalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.FILE_INBOX_RENDER_COMMAND);

		return false;
		
		

	}
}
