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

import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_CHECKER_ACTION_COMMAND }, service = MVCActionCommand.class)
public class SendFileActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		long userPostId = ParamUtil.getLong(actionRequest, "userPostId");
		boolean sendAvailable = false;
		try {
			sendAvailable = docFileLocalSerive.isFileAbleToSend(userPostId, docFileId);
			if (sendAvailable) {
				SessionMessages.add(actionRequest, "send-available");
				actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
						MVCCommandNames.FILE_SEND_RENDER_COMMAND);
				sendAvailable = true;
			} else {
				SessionErrors.add(actionRequest, "send-not-available");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
						MVCCommandNames.FILE_INBOX_RENDER_COMMAND);
				sendAvailable = false;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return sendAvailable;
	}

	@Reference
	private DocFileLocalService docFileLocalSerive;

}
