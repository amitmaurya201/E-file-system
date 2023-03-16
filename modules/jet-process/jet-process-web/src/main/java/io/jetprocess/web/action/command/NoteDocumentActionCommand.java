package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocumentNoteMap;
import io.jetprocess.model.NoteDocument;
import io.jetprocess.service.NoteDocumentLocalService;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.NOTE_DOCUMENT_ACTION_COMMAND }, service = MVCActionCommand.class)

public class NoteDocumentActionCommand implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		  long createdBy = ParamUtil.getLong(actionRequest, "CreatedBy");
		  String noteSubject = ParamUtil.getString(actionRequest, "noteSubject");
		  long subjectCategory = ParamUtil.getLong(actionRequest, "category");
		  Date createdOn = ParamUtil.getDate(actionRequest, "createdOn", null);
		  String content = ParamUtil.getString(actionRequest, "content");
          System.out.println("aasasasasas--------"+subjectCategory);
		
		System.out.println("noteSubject---:"+noteSubject + "subjectCategory--: "+subjectCategory +"createdOn---:"+createdOn +"content---: "+content +"createdBy---:"+createdBy);
		 DocumentNoteMap addNoteDocument = noteDocumentLocalService.addNoteDocument(noteSubject, subjectCategory, createdOn, content, createdBy);
		System.out.println("------chal gyaa-------");
		try {
			long noteDocId=addNoteDocument.getDocumentNoteMapId();
			addNoteDocument.getNoteId();
			addNoteDocument.getNoteDocumentId();
			NoteDocument noteDocument = noteDocumentLocalService.getNoteDocument(noteDocId);
			noteDocument.getSubjectCategoryId();
			Masterdata masterdata = masterdataLocalService.getCategoryById(noteDocument.getSubjectCategoryId());
			noteDocument.getSubjectCategoryId();
			actionResponse.setRenderParameter("subjectCategoryValue", ""+masterdata.getValue()+"");
			actionResponse.setRenderParameter("noteId", ""+addNoteDocument.getNoteId()+"");
			actionResponse.setRenderParameter("noteDocumentId",""+ addNoteDocument.getNoteDocumentId()+"");
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.NOTE_DOCUMENT_INNER_VIEW_RENDER_COMMAND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
	
	@Reference
	private NoteLocalService noteLocalService;
	
	@Reference
	private MasterdataLocalService masterdataLocalService; 
	
	private Log LOGGER=LogFactoryUtil.getLog(NoteDocumentActionCommand.class);
}
