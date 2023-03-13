package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.NoteDocumentLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name="+MVCCommandNames.NOTE_DOCUMENT_UPDATE_RESOURCE_COMMAND }, service = MVCResourceCommand.class)

public class NoteDocumentResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
	
		long noteId = ParamUtil.getLong(resourceRequest, "noteId");
		String content =  ParamUtil.getString(resourceRequest, "content");
		try {
			noteDocumentLocalService.updateNoteDocument(noteId, content);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
}
