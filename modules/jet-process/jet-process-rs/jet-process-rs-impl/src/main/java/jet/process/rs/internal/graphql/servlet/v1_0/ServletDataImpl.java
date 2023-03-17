package jet.process.rs.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import jet.process.rs.internal.graphql.mutation.v1_0.Mutation;
import jet.process.rs.internal.graphql.query.v1_0.Query;
import jet.process.rs.resource.v1_0.FileRsModelResource;
import jet.process.rs.resource.v1_0.NoteDocumentRsModelResource;
import jet.process.rs.resource.v1_0.NoteRsModelResource;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Admin
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setFileRsModelResourceComponentServiceObjects(
			_fileRsModelResourceComponentServiceObjects);
		Mutation.setNoteDocumentRsModelResourceComponentServiceObjects(
			_noteDocumentRsModelResourceComponentServiceObjects);
		Mutation.setNoteRsModelResourceComponentServiceObjects(
			_noteRsModelResourceComponentServiceObjects);
		Mutation.setReceiptRsModelResourceComponentServiceObjects(
			_receiptRsModelResourceComponentServiceObjects);

		Query.setReceiptRsModelResourceComponentServiceObjects(
			_receiptRsModelResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/jet-process-rs-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FileRsModelResource>
		_fileRsModelResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<NoteDocumentRsModelResource>
		_noteDocumentRsModelResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<NoteRsModelResource>
		_noteRsModelResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ReceiptRsModelResource>
		_receiptRsModelResourceComponentServiceObjects;

}