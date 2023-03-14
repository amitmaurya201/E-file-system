package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.NoteDocMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_SEND_ACTION_COMMAND }, service = MVCActionCommand.class)
public class SendNoteDocumentActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long noteDocumentId = ParamUtil.getLong(actionRequest, "noteDocumentId");
		long receiverId = ParamUtil.getLong(actionRequest, "receiverId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		long userPostId = ParamUtil.getLong(actionRequest, "senderId");
		noteDocMovementLocalService.sendNoteDocumentMovement(receiverId, userPostId, noteDocumentId, remarks);
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
				MVCCommandNames.CREATED_LIST_NOTE_DOCUMENT_RENDER_COMMAND);
	}

	@Reference
	private NoteDocMovementLocalService noteDocMovementLocalService;
}
