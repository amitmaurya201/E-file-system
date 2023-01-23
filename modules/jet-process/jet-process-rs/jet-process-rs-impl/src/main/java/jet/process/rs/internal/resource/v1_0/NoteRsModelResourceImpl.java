package jet.process.rs.internal.resource.v1_0;

import jet.process.rs.dto.v1_0.NoteRsModel;
import jet.process.rs.resource.v1_0.NoteRsModelResource;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.model.Note;
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
		System.out.println("noteRs");
		Note note = noteLocalService.addNote(noteRsModel.getContent(), noteRsModel.getCreatedBy(), noteRsModel.getFileId(), noteRsModel.getNoteId());
		long noteId = note.getNoteId();
		System.out.println(noteId);
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
		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	@Reference
	private NoteLocalService noteLocalService;
}