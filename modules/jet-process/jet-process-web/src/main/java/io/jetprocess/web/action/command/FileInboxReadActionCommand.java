package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
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
		long fmId = ParamUtil.getLong(actionRequest, "fmId");
		String url = ParamUtil.getString(actionRequest, "backPageURL");


		try {
			boolean state = fileMovementLocalService.pullBackedAlready(fmId);
			if (state == false) {
				/*
				 * System.out.println("you can not read this file ");
				 * actionResponse.setRenderParameter("status", "error");
				 * actionResponse.setRenderParameter("result", "You can not read this file.");
				 */
				SessionErrors.add(actionRequest, "read-not-available");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				
			} else if (state == true) {
				System.out.println("fileId1 --:" + fileId1);

				List<FileMovement> fileMovement = fileMovementLocalService.getFileMovementByFileId(fileId1);
				for (FileMovement fileMovement2 : fileMovement) {
					if (fileMovement2.getFileId() == fileId1) {
						fileMovement2.setReadOn("read");
						fileMovementLocalService.updateFileMovement(fileMovement2);

					}
				}

			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			actionResponse.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
