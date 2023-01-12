package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_INBOX_RECEIVE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class FileInboxReceiveActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		long fileId = ParamUtil.getLong(actionRequest, "fileId");
		long fmId = ParamUtil.getLong(actionRequest, "fmId");
		String url = ParamUtil.getString(actionRequest, "backPageURL");
		boolean state;
		try {
			state = fileMovementLocalService.saveReceiveMovement(fileId, fmId);

			if (state == false) {
				SessionErrors.add(actionRequest, "receive-not-available");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.FILE_INBOX_RENDER_COMMAND);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Reference
	private FileMovementLocalService fileMovementLocalService;
}