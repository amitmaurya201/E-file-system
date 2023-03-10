package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.NoteDocumentLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_ACTION_COMMAND }, service = MVCActionCommand.class)

public class NoteDocumentActionCommand implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		  long createdBy = ParamUtil.getLong(actionRequest, "CreatedBy");
		  String noteSubject = ParamUtil.getString(actionRequest, "noteSubject");
		  long subjectCategory = ParamUtil.getLong(actionRequest, "categoryId");
		  Date createdOn = ParamUtil.getDate(actionRequest, "createdOn", null);
		  String content = ParamUtil.getString(actionRequest, "content");

		
		System.out.println("noteSubject---:"+noteSubject + "subjectCategory--: "+subjectCategory +"createdOn---:"+createdOn +"content---: "+content +"createdBy---:"+createdBy);
		noteDocumentLocalService.addNoteDocument(noteSubject, 2, createdOn, content, createdBy);
		System.out.println("------chal gyaa-------");
		try {
			actionResponse.sendRedirect("mvcRenderCommandName", MVCCommandNames.CREATED_LIST_NOTE_DOCUMENT_RENDER_COMMAND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
}
