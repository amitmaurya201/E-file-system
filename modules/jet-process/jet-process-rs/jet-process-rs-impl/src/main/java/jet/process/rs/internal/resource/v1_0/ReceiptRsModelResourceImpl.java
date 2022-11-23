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
	private Masterdata typeById;
	private Masterdata deliveryModeById;
	private Masterdata organizationById;
	private Masterdata subOrganizationById;
	private Masterdata receiptCategoryById;
	private Masterdata receiptSubCategoryById;
	private Masterdata countryById;
	private Masterdata stateById;
	@Override
	public ReceiptRsModel createReceipt(ReceiptRsModel receiptRsModel) throws Exception {
		
		/*
		 * long receiptId = counterLocalService.increment(Receipt.class.getName());
		 * 
		 * Receipt receipt = receiptLocalService.createReceipt(receiptId);
		 */
		Receipt receipt = receiptLocalService.getReceiptByTempFileId(receiptRsModel.getTempFileId());
		receipt.setAddress(receiptRsModel.getAddress());	
		receipt.setCity(receiptRsModel.getCity());
		receipt.setCountryId(receiptRsModel.getCountryId());
		receipt.setDeliveryModeId(receiptRsModel.getDeliveryModeId());
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
		/*
		 * // file fields String changeLog = "docStore"; FileEntry fileEntry =
		 * docstore.getTempFile(receiptRsModel.getTempFileId()); String title =
		 * fileEntry.getFileName(); InputStream is = fileEntry.getContentStream();
		 * String mimeType = fileEntry.getMimeType(); String viewFileUrl = null; try {
		 * viewFileUrl =
		 * docstore.ViewDocumentAndMediaFile(receiptRsModel.getTempFileId()); } catch
		 * (IOException e1) {
		 * 
		 * e1.printStackTrace(); } long documentAndMediaFileId = 0l; try {
		 * documentAndMediaFileId = docstore.documentAndMediaFileUpload(20121,
		 * receiptRsModel.getTempFileId(), is, title, mimeType, changeLog, 0l, ""); }
		 * catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 * docstore.deleteTempFile(receiptRsModel.getTempFileId());
		 * 
		 * receipt.setDmFileId(documentAndMediaFileId);
		 * receipt.setViewPdfUrl(viewFileUrl);
		 */
		receiptLocalService.addReceipt(receipt);
		return receiptRsModel;
	}


	private String generateReceiptNumber(long receiptId) {
		String receiptNumber = "R" + receiptId;
		return receiptNumber;

	}

	
	
	
	@Override
	public ReceiptRsModel getReceiptByReceiptId(@NotNull Long receiptId) throws Exception {
		Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
		ReceiptRsModel receiptRsModel=new ReceiptRsModel();
		receiptRsModel.setReceiptId(receipt.getReceiptId());
		receiptRsModel.setAddress(receipt.getAddress());
		receiptRsModel.setCity(receipt.getCity());
		receiptRsModel.setCountryId(receipt.getCountryId());
		receiptRsModel.setDeliveryModeId(receipt.getDeliveryModeId());
		receiptRsModel.setDesignation(receipt.getDesignation());
		receiptRsModel.setEmail(receipt.getEmail());
		receiptRsModel.setLetterDate(receipt.getLetterDate());
		receiptRsModel.setMobile(receipt.getMobile());
		receiptRsModel.setModeNumber(receipt.getModeNumber());
		receiptRsModel.setName(receipt.getName());
		receiptRsModel.setOrganizationId(receipt.getOrganizationId());
		receiptRsModel.setPinCode(receipt.getPinCode());
		receiptRsModel.setReceiptCategoryId(receipt.getReceiptCategoryId());
		receiptRsModel.setReceiptSubCategoryId(receipt.getReceiptSubCategoryId());
		receiptRsModel.setReceivedOn(receipt.getReceivedOn());
		receiptRsModel.setReferenceNumber(receipt.getReferenceNumber());
		receiptRsModel.setRemarks(receipt.getRemarks());
		receiptRsModel.setStateId(receipt.getStateId());
		receiptRsModel.setSubOrganizationId(receipt.getSubOrganizationId());
		receiptRsModel.setSubject(receipt.getSubject());
		receiptRsModel.setTypeId(receipt.getTypeId());
		receiptRsModel.setUserPostId(receipt.getUserPostId());
		receiptRsModel.setViewPdfUrl(receipt.getViewPdfUrl());
		receiptRsModel.setDmFileId(receipt.getDmFileId());
		receiptRsModel.setReceiptNumber(receipt.getReceiptNumber());
		
		typeById = masterdataLocalService.getTypeById(receipt.getTypeId());
		deliveryModeById = masterdataLocalService.getDeliveryModeById(receipt.getDeliveryModeId());
		organizationById = masterdataLocalService.getOrganizationById(receipt.getOrganizationId());
		subOrganizationById = masterdataLocalService.getSubOrganizationById(receipt.getSubOrganizationId());
		receiptCategoryById = masterdataLocalService.getReceiptCategoryById(receipt.getReceiptCategoryId());
		receiptSubCategoryById = masterdataLocalService.getReceiptSubCategoryById(receipt.getReceiptSubCategoryId());
		countryById = masterdataLocalService.getCountryById(receipt.getCountryId());
		stateById = masterdataLocalService.getStateById(receipt.getStateId());

		receiptRsModel.setTypevalue(typeById.getValue());
		receiptRsModel.setDeliverymodevalue(deliveryModeById.getValue());
		receiptRsModel.setOrganizationvalue(organizationById.getValue());
		receiptRsModel.setSuborganizationvalue(subOrganizationById.getValue());
		receiptRsModel.setReceiptcategoryvalue(receiptCategoryById.getValue());
		receiptRsModel.setReceiptsubcategoryvalue(receiptSubCategoryById.getValue());
		receiptRsModel.setCountryvalue(countryById.getValue());
		receiptRsModel.setStatevalue(stateById.getValue());
		
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
