package jet.process.rs.internal.resource.v1_0;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.docstore.DocStore;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import jet.process.rs.dto.v1_0.ReceiptRsModel;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

/**
 * @author Admin
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/receipt-rs-model.properties", scope = ServiceScope.PROTOTYPE, service = ReceiptRsModelResource.class)
public class ReceiptRsModelResourceImpl extends BaseReceiptRsModelResourceImpl {
	
	@Override
	public ReceiptRsModel createReceipt(ReceiptRsModel receiptRsModel) throws Exception {

		System.out.println("create receipt");
		Receipt receipt = receiptLocalService.getReceipt();
	    // Receipt receipt = receiptLocalService.getReceiptByTempFileId(receiptRsModel.getTempFileId(),receiptRsModel.getGroupId());
		long dmFileId = receiptLocalService.getDmFileId(receiptRsModel.getTempFileId(), receiptRsModel.getGroupId());
		String viewFileUrl = docstore.ViewDocumentAndMediaFile(dmFileId);
		System.out.println(viewFileUrl);
		receipt.setAddress(receiptRsModel.getAddress());
		System.out.println("test1");
		receipt.setCity(receiptRsModel.getCity());
		System.out.println("test1");
		receipt.setCountryId(receiptRsModel.getCountryId());
		System.out.println("test1");
		receipt.setDeliveryModeId(receiptRsModel.getDeliveryModeId());
		System.out.println("test1");
		receipt.setDesignation(receiptRsModel.getDesignation());
		System.out.println("test1");
		receipt.setEmail(receiptRsModel.getEmail());
		System.out.println("test1");
		receipt.setLetterDate(receiptRsModel.getLetterDate());
		System.out.println("test1");
		receipt.setMobile(receiptRsModel.getMobile());
		System.out.println("test1");
		receipt.setModeNumber(receiptRsModel.getModeNumber());
		System.out.println("test6666");
		receipt.setName(receiptRsModel.getName());
		receipt.setOrganizationId(receiptRsModel.getOrganizationId());
		System.out.println("test1");
		receipt.setPinCode(receiptRsModel.getPinCode());
		System.out.println("test1");
		receipt.setReceiptCategoryId(receiptRsModel.getReceiptCategoryId());
		System.out.println("test1");
		receipt.setReceiptSubCategoryId(receiptRsModel.getReceiptSubCategoryId());
		System.out.println("test1");
		receipt.setReceivedOn(receiptRsModel.getReceivedOn());
		System.out.println("test1");
		receipt.setReferenceNumber(receiptRsModel.getReferenceNumber());
		System.out.println("test1");
		receipt.setRemarks(receiptRsModel.getRemarks());
		System.out.println("test1");
		receipt.setStateId(receiptRsModel.getStateId());
		System.out.println("test1");
		receipt.setSubOrganizationId(receiptRsModel.getSubOrganizationId());
		System.out.println("test1");
		receipt.setSubject(receiptRsModel.getSubject());
		System.out.println("test1");
		receipt.setTypeId(receiptRsModel.getTypeId());
		System.out.println("test1");
		receipt.setUserPostId(receiptRsModel.getUserPostId());
		receipt.setDmFileId(dmFileId);
		System.out.println("test1");
		receipt.setViewPdfUrl(viewFileUrl);
		System.out.println("nature"+receiptRsModel.getNature());
		receipt.setNature(receiptRsModel.getNature());
		receipt.setCurrentState(CurrentState.created.name());
		receiptLocalService.addReceipt(receipt);
		return receiptRsModel;
	}


	private String generateReceiptNumber(long receiptId) {
		String receiptNumber = "R" + receiptId;
		return receiptNumber;

	}

	/*
	 * @Override public ReceiptRsModel getReceiptByReceiptId(@NotNull Long
	 * receiptId) throws Exception { Receipt receipt =
	 * receiptLocalService.getReceiptByReceiptId(receiptId); ReceiptRsModel
	 * receiptRsModel=new ReceiptRsModel();
	 * receiptRsModel.setReceiptId(receipt.getReceiptId());
	 * receiptRsModel.setAddress(receipt.getAddress());
	 * receiptRsModel.setCity(receipt.getCity());
	 * receiptRsModel.setCountryId(receipt.getCountryId());
	 * receiptRsModel.setDeliveryModeId(receipt.getDeliveryModeId());
	 * receiptRsModel.setDesignation(receipt.getDesignation());
	 * receiptRsModel.setEmail(receipt.getEmail());
	 * receiptRsModel.setLetterDate(receipt.getLetterDate());
	 * receiptRsModel.setMobile(receipt.getMobile());
	 * receiptRsModel.setModeNumber(receipt.getModeNumber());
	 * receiptRsModel.setName(receipt.getName());
	 * receiptRsModel.setOrganizationId(receipt.getOrganizationId());
	 * receiptRsModel.setPinCode(receipt.getPinCode());
	 * receiptRsModel.setReceiptCategoryId(receipt.getReceiptCategoryId());
	 * receiptRsModel.setReceiptSubCategoryId(receipt.getReceiptSubCategoryId());
	 * receiptRsModel.setReceivedOn(receipt.getReceivedOn());
	 * receiptRsModel.setReferenceNumber(receipt.getReferenceNumber());
	 * receiptRsModel.setRemarks(receipt.getRemarks());
	 * receiptRsModel.setStateId(receipt.getStateId());
	 * receiptRsModel.setSubOrganizationId(receipt.getSubOrganizationId());
	 * receiptRsModel.setSubject(receipt.getSubject());
	 * receiptRsModel.setTypeId(receipt.getTypeId());
	 * receiptRsModel.setUserPostId(receipt.getUserPostId());
	 * receiptRsModel.setViewPdfUrl(receipt.getViewPdfUrl());
	 * receiptRsModel.setDmFileId(receipt.getDmFileId());
	 * receiptRsModel.setReceiptNumber(receipt.getReceiptNumber());
	 * 
	 * typeById = masterdataLocalService.getTypeById(receipt.getTypeId());
	 * deliveryModeById =
	 * masterdataLocalService.getDeliveryModeById(receipt.getDeliveryModeId());
	 * organizationById =
	 * masterdataLocalService.getOrganizationById(receipt.getOrganizationId());
	 * subOrganizationById =
	 * masterdataLocalService.getSubOrganizationById(receipt.getSubOrganizationId())
	 * ; receiptCategoryById =
	 * masterdataLocalService.getReceiptCategoryById(receipt.getReceiptCategoryId())
	 * ; receiptSubCategoryById =
	 * masterdataLocalService.getReceiptSubCategoryById(receipt.
	 * getReceiptSubCategoryId()); countryById =
	 * masterdataLocalService.getCountryById(receipt.getCountryId()); stateById =
	 * masterdataLocalService.getStateById(receipt.getStateId());
	 * 
	 * receiptRsModel.setTypevalue(typeById.getValue());
	 * receiptRsModel.setDeliverymodevalue(deliveryModeById.getValue());
	 * receiptRsModel.setOrganizationvalue(organizationById.getValue());
	 * receiptRsModel.setSuborganizationvalue(subOrganizationById.getValue());
	 * receiptRsModel.setReceiptcategoryvalue(receiptCategoryById.getValue());
	 * receiptRsModel.setReceiptsubcategoryvalue(receiptSubCategoryById.getValue());
	 * receiptRsModel.setCountryvalue(countryById.getValue());
	 * receiptRsModel.setStatevalue(stateById.getValue());
	 * 
	 * return receiptRsModel; }
	 */

	@Override
	public ReceiptRsModel updateReceipt(ReceiptRsModel receiptRsModel) throws Exception {
		System.out.println("update test");
		Receipt receipt = receiptLocalService.getReceiptUpdate(receiptRsModel.getReceiptId());
		
		System.out.println("test1");
		receipt.setAddress(receiptRsModel.getAddress());
		System.out.println("test2");
		receipt.setCity(receiptRsModel.getCity());
		System.out.println("test3");
		receipt.setCountryId(receiptRsModel.getCountryId());
		System.out.println("test4");
		receipt.setDesignation(receiptRsModel.getDesignation());
		System.out.println("test5");
		receipt.setEmail(receiptRsModel.getEmail());
		System.out.println("test6");
		receipt.setLetterDate(receiptRsModel.getLetterDate());
		System.out.println("test7");
		receipt.setMobile(receiptRsModel.getMobile());
		System.out.println("test8");
		receipt.setModeNumber(receiptRsModel.getModeNumber());
		System.out.println("test9");
		receipt.setName(receiptRsModel.getName());
		receipt.setOrganizationId(receiptRsModel.getOrganizationId());
		System.out.println("test10");
		receipt.setPinCode(receiptRsModel.getPinCode());
		System.out.println("test11");
		receipt.setReceiptCategoryId(receiptRsModel.getReceiptCategoryId());
		System.out.println("test12");
		receipt.setReceiptSubCategoryId(receiptRsModel.getReceiptSubCategoryId());
		System.out.println("test13");
		receipt.setReceivedOn(receiptRsModel.getReceivedOn());
		System.out.println("test14");
		receipt.setReferenceNumber(receiptRsModel.getReferenceNumber());
		System.out.println("test15");
		receipt.setRemarks(receiptRsModel.getRemarks());
		System.out.println("test15");
		receipt.setStateId(receiptRsModel.getStateId());
		System.out.println("test16");
		receipt.setSubOrganizationId(receiptRsModel.getSubOrganizationId());
		System.out.println("test17");
		receipt.setSubject(receiptRsModel.getSubject());
		System.out.println("test18");
		receipt.setTypeId(receiptRsModel.getTypeId());
		System.out.println("test19");
		receipt.setUserPostId(receiptRsModel.getUserPostId());
		System.out.println("test20");
		long dmFileId =receiptRsModel.getDmFileId(); 
		System.out.println(dmFileId);
		//receiptLocalService.getDmFileId(receiptRsModel.getTempFileId(), receiptRsModel.getGroupId());
		//System.out.println(dmFileId);
		if(dmFileId!=receipt.getDmFileId()) {
			receipt.setDmFileId(dmFileId);
			System.out.println("dmFileId saved ");
			
		}
		System.out.println("dmFileId1 saved ");
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
