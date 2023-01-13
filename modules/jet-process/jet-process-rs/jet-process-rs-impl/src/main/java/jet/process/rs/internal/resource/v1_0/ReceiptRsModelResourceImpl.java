package jet.process.rs.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.docstore.DocStore;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import jet.process.rs.dto.v1_0.ReceiptRsModel;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

/**
 * @author Admin
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/receipt-rs-model.properties", scope = ServiceScope.PROTOTYPE, service = ReceiptRsModelResource.class)
public class ReceiptRsModelResourceImpl extends BaseReceiptRsModelResourceImpl {

	@Override
	public ReceiptRsModel createReceipt(ReceiptRsModel receiptRsModel) throws Exception {
		Receipt receipt=receiptLocalService.createReceipt(receiptRsModel.getGroupId(), receiptRsModel.getTypeId(),
				receiptRsModel.getTempFileId(), receiptRsModel.getDeliveryModeId(), receiptRsModel.getNature(),
				receiptRsModel.getReceivedOn(), receiptRsModel.getLetterDate(), receiptRsModel.getReferenceNumber(),
				receiptRsModel.getModeNumber(), receiptRsModel.getReceiptCategoryId(),
				receiptRsModel.getReceiptSubCategoryId(), receiptRsModel.getSubject(), receiptRsModel.getRemarks(),
				receiptRsModel.getName(), receiptRsModel.getDesignation(), receiptRsModel.getMobile(),
				receiptRsModel.getEmail(), receiptRsModel.getAddress(), receiptRsModel.getCountryId(),
				receiptRsModel.getStateId(), receiptRsModel.getPinCode(), receiptRsModel.getOrganizationId(),
				receiptRsModel.getSubOrganizationId(), receiptRsModel.getCity(), receiptRsModel.getUserPostId()
				);
		receiptRsModel.setReceiptNumber(receipt.getReceiptNumber());
		return receiptRsModel;
	}

	@Override
	public ReceiptRsModel updateReceipt(ReceiptRsModel receiptRsModel) throws Exception {
		
		receiptLocalService.updateReceipt(receiptRsModel.getReceiptId(),receiptRsModel.getGroupId(), receiptRsModel.getTypeId(),
				receiptRsModel.getTempFileId(), receiptRsModel.getNature(),
				receiptRsModel.getReceivedOn(), receiptRsModel.getLetterDate(), receiptRsModel.getReferenceNumber(),
				receiptRsModel.getModeNumber(), receiptRsModel.getReceiptCategoryId(),
				receiptRsModel.getReceiptSubCategoryId(), receiptRsModel.getSubject(), receiptRsModel.getRemarks(),
				receiptRsModel.getName(), receiptRsModel.getDesignation(), receiptRsModel.getMobile(),
				receiptRsModel.getEmail(), receiptRsModel.getAddress(), receiptRsModel.getCountryId(),
				receiptRsModel.getStateId(), receiptRsModel.getPinCode(), receiptRsModel.getOrganizationId(),
				receiptRsModel.getSubOrganizationId(), receiptRsModel.getCity(), receiptRsModel.getUserPostId()
				);
		return receiptRsModel;
	}

	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private ReceiptLocalService receiptLocalService;



}
