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
		"mvc.command.name=fileReadAction" }, service = MVCActionCommand.class)
public class FileInboxReadActionCommand implements MVCActionCommand {

	@Reference
	private FileMovementLocalService fileMovementLocalService;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		long fileId1 = ParamUtil.getLong(actionRequest, "fileId1");

		System.out.println("fileId1 --:" + fileId1);

		 List<FileMovement> fileMovement = fileMovementLocalService.getFileMovementByFileId(fileId1);
		  for (FileMovement fileMovement2 : fileMovement) {
			  if(fileMovement2.getFileId() == fileId1) {
				  fileMovement2.setReceivedOn("checked");
				  fileMovementLocalService.updateFileMovement(fileMovement2);
				  
			  }
		}
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.FILE_INBOX_RENDER_COMMAND);

		return false;
	}

}
