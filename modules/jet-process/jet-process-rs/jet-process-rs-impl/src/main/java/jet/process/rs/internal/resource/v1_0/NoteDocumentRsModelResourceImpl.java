package jet.process.rs.internal.resource.v1_0;

import jet.process.rs.dto.v1_0.NoteDocumentRsModel;
import jet.process.rs.resource.v1_0.NoteDocumentRsModelResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.service.NoteDocumentLocalService;

/**
 * @author Admin
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/note-document-rs-model.properties",
	scope = ServiceScope.PROTOTYPE, service = NoteDocumentRsModelResource.class
)
public class NoteDocumentRsModelResourceImpl
	extends BaseNoteDocumentRsModelResourceImpl {
	
	@Override
	public NoteDocumentRsModel updateNoteDocument(
			NoteDocumentRsModel noteDocumentRsModel)
		throws Exception {
		       

		return null;
	}
	
	@Override
	public NoteDocumentRsModel createNoteDocument(
			NoteDocumentRsModel noteDocumentRsModel)
		throws Exception {
      
		
		return new NoteDocumentRsModel();
	}

	@Reference
	private NoteDocumentLocalService noteDocumentLocalService;
}