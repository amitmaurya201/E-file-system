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

		FileMovement fileMovement = fileMovementLocalService.getFileByFileId(fileId1);

		if (fileMovement.getFileId() == fileId1) {
			fileMovement.setReadOn("read");
			fileMovementLocalService.updateFileMovement(fileMovement);
		}

		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.FILE_INBOX_RENDER_COMMAND);

		return false;
	}

}
