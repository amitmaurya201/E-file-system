package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_ACTION_COMMAND }, service = MVCActionCommand.class)

public class NoteDocumentActionCommand implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		
		  String noteSubject = ParamUtil.getString(actionRequest, "noteSubject");
		  String subjectCategory = ParamUtil.getString(actionRequest, "subjectCategory");
		  Date createdOn = ParamUtil.getDate(actionRequest, "createdOn", null);
		  String content = ParamUtil.getString(actionRequest, "content");

		
		System.out.println("noteSubject---:"+noteSubject + "subjectCategory--: "+subjectCategory +"createdOn---:"+createdOn +"content---: "+content);
		
		
		
		
		
		
		return false;
	}

}
