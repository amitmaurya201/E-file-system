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
		ServiceContext serviceContext = new ServiceContext();
		System.out.println("test");
		System.out.println(receiptRsModel.getCountryId()+ "..." +receiptRsModel.getOrganizationId());
		 Receipt receipt = receiptLocalService.getReceipt(); 
		
		  if(receiptRsModel.getSubject().isEmpty()||receiptRsModel.getName().isEmpty()||receiptRsModel.getAddress().isEmpty()||receiptRsModel.getDesignation().
		  isEmpty()) { return null; }
		 
	
		 String receiptNumber =generateReceiptNumber(receipt.getReceiptId()); 
		
		if (receiptRsModel.getTempFileId() != 0) {
			long dmFileId = receiptLocalService.getDmFileId(receiptRsModel.getTempFileId(),
					receiptRsModel.getGroupId());
			String viewFileUrl = docstore.ViewDocumentAndMediaFile(dmFileId);
			receipt.setViewPdfUrl(viewFileUrl);
			receipt.setDmFileId(dmFileId);
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
		 
	
		String nature = receiptRsModel.getNature();
		if (nature.equals("Electronic")) {
			System.out.println("createReceiptnature");
			if (receiptRsModel.getTempFileId() == 0) {
				return null;
			}

		}
		System.out.println(receiptRsModel.getSubOrganizationId());
		receipt.setSubOrganizationId(receiptRsModel.getSubOrganizationId());
		receipt.setStateId(receiptRsModel.getStateId());
		receipt.setReceiptSubCategoryId(receiptRsModel.getReceiptSubCategoryId());
		receipt.setCountryId(receiptRsModel.getCountryId());
		  receipt.setCity(receiptRsModel.getCity());
		  receipt.setMobile(receiptRsModel.getMobile());
		  receipt.setModeNumber(receiptRsModel.getModeNumber());
		  receipt.setEmail(receiptRsModel.getEmail());
		  receipt.setReferenceNumber(receiptRsModel.getReferenceNumber());
		  receipt.setPinCode(receiptRsModel.getPinCode());
		  receipt.setRemarks(receiptRsModel.getRemarks());
		 
		 receipt.setCurrentState(FileStatus.CREADTED); 
		 receipt.setCurrentlyWith(receiptRsModel.getUserPostId()); 
		 receiptLocalService.addReceipt(receipt); 
		/*
		 * receiptLocalService.createReceipt(receiptRsModel.getGroupId(),
		 * receiptRsModel.getTypeId() , receiptRsModel.getTempFileId(),
		 * receiptRsModel.getDeliveryModeId(), receiptRsModel.getNature(),
		 * receiptRsModel.getReceivedOn(), receiptRsModel.getLetterDate(),
		 * receiptRsModel.getReferenceNumber(), receiptRsModel.getModeNumber(),
		 * receiptRsModel.getReceiptCategoryId(),
		 * receiptRsModel.getReceiptSubCategoryId(), receiptRsModel.getSubject(),
		 * receiptRsModel.getRemarks(), receiptRsModel.getName(),
		 * receiptRsModel.getDesignation(), receiptRsModel.getMobile(),
		 * receiptRsModel.getEmail(), receiptRsModel.getAddress(),
		 * receiptRsModel.getCountryId(),receiptRsModel.getStateId(),
		 * receiptRsModel.getPinCode(), receiptRsModel.getOrganizationId(),
		 * receiptRsModel.getSubOrganizationId(), receiptRsModel.getCity(),
		 * receiptRsModel.getUserPostId(), serviceContext);
		 */
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
		String nature = receiptRsModel.getNature();
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
		}else {
			if(nature.equals("Electronic")) {
				receipt.setDmFileId(receipt.getDmFileId());
				 receipt.setViewPdfUrl(receipt.getViewPdfUrl());
			}
			else {
				receipt.setViewPdfUrl("");
				receipt.setDmFileId(0);
			}	
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

