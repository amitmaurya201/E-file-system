package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.exception.NoSuchNoteException;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileNote;
import io.jetprocess.model.Note;
import io.jetprocess.service.DocFileLocalServiceUtil;
import io.jetprocess.service.FileNoteLocalService;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.service.persistence.NotePersistence;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ViewSendFileRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		String currURL = ParamUtil.getString(renderRequest, "backPageURL");
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
		long userPostId = ParamUtil.getLong(renderRequest, "userPostId");
		List<FileNote> fileNoteList = fileNoteLocalService.getFileNoteListByFileId(docFileId);
		System.out.println("fileNoteList-->"+fileNoteList);
		if (fileNoteList == null || fileNoteList.isEmpty()) {
			System.out.println("if part --->");
			try {
				DocFile docFile = DocFileLocalServiceUtil.getDocFile(docFileId);
				renderRequest.setAttribute("docFile", docFile);
				renderRequest.setAttribute("currentURL", currURL);
				renderRequest.setAttribute("fileMovementId", fileMovementId);
				renderRequest.setAttribute("noteId", 0L);
			} catch (PortalException e) {
				logger.info(e.getMessage());
			}
			
		} else  if(!fileNoteList.isEmpty() || fileNoteList != null){
			System.out.println("else part");	

Note note = null;
try {
	note = noteLocalService.getNoteByUserPostId(userPostId);
	System.out.println("note object when note id null" + note);
	System.out.println("note ki id " + note.getNoteId());
} catch (NoSuchNoteException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

try {
	DocFile docFile = DocFileLocalServiceUtil.getDocFile(docFileId);
	renderRequest.setAttribute("docFile", docFile);
	renderRequest.setAttribute("currentURL", currURL);
	renderRequest.setAttribute("fileMovementId", fileMovementId);
	renderRequest.setAttribute("noteId", note.getNoteId());
} catch (PortalException e) {
	logger.info(e.getMessage());
}

			
			

		}

		return "/file/send.jsp";
	}

	@Reference
	private NoteLocalService noteLocalService;
	@Reference
	private FileNoteLocalService fileNoteLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
