package jet.process.rs.internal.resource.v1_0;

import jet.process.rs.dto.v1_0.NoteRsModel;
import jet.process.rs.resource.v1_0.NoteRsModelResource;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.model.Note;
import io.jetprocess.service.FileNoteLocalService;
import io.jetprocess.service.NoteLocalService;

/**
 * @author Admin
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/note-rs-model.properties",
	scope = ServiceScope.PROTOTYPE, service = NoteRsModelResource.class
)
public class NoteRsModelResourceImpl extends BaseNoteRsModelResourceImpl {
	@Override
	public NoteRsModel createNote(NoteRsModel noteRsModel) throws Exception {
		Note note = noteLocalService.addNote(noteRsModel.getContent(), noteRsModel.getCreatedBy(), noteRsModel.getFileId(), noteRsModel.getNoteId(),noteRsModel.getFileMovementId());
		long noteId = note.getNoteId();
		noteRsModel.setNoteId(noteId);
		return noteRsModel;
	}
	@Override
	public NoteRsModel editNote(NoteRsModel noteRsModel) throws Exception {
		noteLocalService.editNote(noteRsModel.getNoteId(), noteRsModel.getContent());
		return noteRsModel;
	}
	@Override
	public Response deleteNote(Long noteId)throws Exception {
		noteLocalService.deleteNote(noteId);
		fileNoteLocalService.deleteFileNoteByNoteId(noteId);
		Response.ResponseBuilder responseBuilder = Response.ok();
		System.out.println(responseBuilder.build());
		return responseBuilder.build();
	}

	@Reference
	private NoteLocalService noteLocalService;
	@Reference
	private FileNoteLocalService fileNoteLocalService;
}