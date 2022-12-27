package jet.process.rs.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalService;
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
		Receipt receipt = receiptLocalService.getReceipt();
		if(receiptRsModel.getSubject().isEmpty()||receiptRsModel.getName().isEmpty()||receiptRsModel.getAddress().isEmpty()||receiptRsModel.getDesignation().isEmpty()) {
			return null;	
		}
		
		String receiptNumber =generateReceiptNumber(receipt.getReceiptId());
		if(receiptRsModel.getTempFileId()!=0) {
		long dmFileId = receiptLocalService.getDmFileId(receiptRsModel.getTempFileId(), receiptRsModel.getGroupId());
		String viewFileUrl = docstore.ViewDocumentAndMediaFile(dmFileId);
		receipt.setViewPdfUrl(viewFileUrl);
		receipt.setDmFileId(dmFileId);
		}
	
		if(receiptRsModel.getSubOrganizationId() == null) {
			receipt.setSubOrganizationId(0);
		}else if(receiptRsModel.getSubOrganizationId() != null) {
		receipt.setSubOrganizationId(receiptRsModel.getSubOrganizationId());
		}
		if(receiptRsModel.getStateId() == null ) {
			receipt.setStateId(0); 
		}else if(receiptRsModel.getStateId() != null) {
			receipt.setStateId(receiptRsModel.getStateId());
		}
		receipt.setSubject(receiptRsModel.getSubject());
		receipt.setTypeId(receiptRsModel.getTypeId());
		receipt.setUserPostId(receiptRsModel.getUserPostId());
		receipt.setReceiptNumber(receiptNumber);
		receipt.setNature(receiptRsModel.getNature());
		receiptRsModel.setReceiptNumber(receiptNumber);
		receipt.setAddress(receiptRsModel.getAddress());
		receipt.setDeliveryModeId(receiptRsModel.getDeliveryModeId());
		receipt.setDesignation(receiptRsModel.getDesignation());
		receipt.setName(receiptRsModel.getName());
	
		receipt.setOrganizationId(receiptRsModel.getOrganizationId());
		receipt.setReceiptCategoryId(receiptRsModel.getReceiptCategoryId());
		receipt.setReceivedOn(receiptRsModel.getReceivedOn());
		receipt.setLetterDate(receiptRsModel.getLetterDate());
	
		if(receiptRsModel.getReceiptSubCategoryId() == null) {
			System.out.println("if subcategory-------");
			receipt.setReceiptSubCategoryId(0);	
					
		}else {
			System.out.println("else subcategory-------");
			receipt.setReceiptSubCategoryId(receiptRsModel.getReceiptSubCategoryId());	
		}
		
		if(receiptRsModel.getCountryId() == null) {
			receipt.setCountryId(0);	
					
		}else {
			receipt.setCountryId(receiptRsModel.getCountryId());	
		}
		receipt.setCity(receiptRsModel.getCity());
		receipt.setMobile(receiptRsModel.getMobile());
		receipt.setModeNumber(receiptRsModel.getModeNumber());
		receipt.setEmail(receiptRsModel.getEmail());
		receipt.setReferenceNumber(receiptRsModel.getReferenceNumber());
		receipt.setPinCode(receiptRsModel.getPinCode());
		receipt.setRemarks(receiptRsModel.getRemarks());
		receipt.setCurrentState(FileStatus.CREADTED);
		receiptLocalService.addReceipt(receipt);
		return receiptRsModel;
	}

	
	private String generateReceiptNumber(long receiptId) {
		String receiptNumber = "R" + receiptId;
		return receiptNumber;
	}
	
	@Override
	public ReceiptRsModel updateReceipt(ReceiptRsModel receiptRsModel) throws Exception {
		
		long dmFileId =0l;
		String viewFileUrl= null;
		Receipt receipt = receiptLocalService.getReceiptUpdate(receiptRsModel.getReceiptId());
		receipt.setAddress(receiptRsModel.getAddress());
		receipt.setCity(receiptRsModel.getCity());
		receipt.setCountryId(receiptRsModel.getCountryId());
		receipt.setDesignation(receiptRsModel.getDesignation());
		receipt.setEmail(receiptRsModel.getEmail());
		receipt.setLetterDate(receiptRsModel.getLetterDate());
		receipt.setMobile(receiptRsModel.getMobile());
		receipt.setModeNumber(receiptRsModel.getModeNumber());
		receipt.setName(receiptRsModel.getName());
		receipt.setOrganizationId(receiptRsModel.getOrganizationId());
		receipt.setPinCode(receiptRsModel.getPinCode());
		receipt.setReceiptCategoryId(receiptRsModel.getReceiptCategoryId());
		receipt.setReceiptSubCategoryId(receiptRsModel.getReceiptSubCategoryId());
		receipt.setReceivedOn(receiptRsModel.getReceivedOn());
		receipt.setReferenceNumber(receiptRsModel.getReferenceNumber());
		receipt.setRemarks(receiptRsModel.getRemarks());
		receipt.setStateId(receiptRsModel.getStateId());
		receipt.setSubOrganizationId(receiptRsModel.getSubOrganizationId());
		receipt.setSubject(receiptRsModel.getSubject());
		receipt.setTypeId(receiptRsModel.getTypeId());
		receipt.setUserPostId(receiptRsModel.getUserPostId());
		long tempFileId = receiptRsModel.getTempFileId();
		System.out.println("tempFileId"+tempFileId);
		if(tempFileId!=0) {
			 dmFileId = receiptLocalService.getDmFileId(receiptRsModel.getTempFileId(), receiptRsModel.getGroupId());
			 viewFileUrl = docstore.ViewDocumentAndMediaFile(dmFileId);
			 receipt.setViewPdfUrl(viewFileUrl);
			 receipt.setDmFileId(dmFileId);
		}
		else {
			receipt.setViewPdfUrl("");
			receipt.setDmFileId(0);
			
		}
		receiptLocalService.updateReceipt(receipt);
		return receiptRsModel;
	}

	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private ReceiptLocalService receiptLocalService;
	@Reference
	private UserLocalService userLocalService;
	@Reference
	private DocStore docstore;
	@Reference
	private MasterdataLocalService masterdataLocalService;
}

