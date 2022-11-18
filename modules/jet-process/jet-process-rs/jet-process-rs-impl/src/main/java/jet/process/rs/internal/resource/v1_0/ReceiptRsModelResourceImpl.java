package jet.process.rs.internal.resource.v1_0;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.docstore.DocStore;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jet.process.rs.dto.v1_0.ReceiptRsModel;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

/**
 * @author Admin
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/receipt-rs-model.properties", scope = ServiceScope.PROTOTYPE, service = ReceiptRsModelResource.class)
public class ReceiptRsModelResourceImpl extends BaseReceiptRsModelResourceImpl {
	@Override
	public ReceiptRsModel createReceipt(ReceiptRsModel receiptRsModel) throws Exception {
		long receiptId = counterLocalService.increment(Receipt.class.getName());
		System.out.println(receiptId);
		System.out.println(receiptRsModel.getTempfileId());
		String number = generateReceiptNumber(receiptId);
		Receipt receipt = receiptLocalService.createReceipt(receiptId);
		System.out.println(receipt);
		// file fields
		String changeLog = "docStore";
		FileEntry fileEntry = docstore.getTempFile(receiptRsModel.getTempfileId());
		System.out.println(fileEntry);

		String title = fileEntry.getFileName();

		InputStream is = fileEntry.getContentStream();
		String mimeType = fileEntry.getMimeType();
		String viewFileUrl = null;
		try {
			viewFileUrl = docstore.ViewDocumentAndMediaFile(receiptRsModel.getTempfileId());
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		System.out.println(viewFileUrl);
		long documentAndMediaFileId = 0l;
		try {
			documentAndMediaFileId = docstore.documentAndMediaFileUpload(20121, receiptRsModel.getTempfileId(), is,
					title, mimeType, changeLog, 0l, "");
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(documentAndMediaFileId);
		docstore.deleteTempFile(receiptRsModel.getTempfileId());
		System.out.println("test");
		receipt.setName(receiptRsModel.getName());
		receipt.setAddress(receiptRsModel.getAddress());
		receipt.setCountryId(receiptRsModel.getCountryId());
		receipt.setStateId(receiptRsModel.getStateId());
		receipt.setCity(receiptRsModel.getCity());
		receipt.setDeliveryModeId(receiptRsModel.getDeliveryModeId());
		receipt.setDesignation(receiptRsModel.getDesignation());
		receipt.setEmail(receiptRsModel.getEmail());
		receipt.setMobile(receiptRsModel.getMobile());
		receipt.setOrganizationId(receiptRsModel.getOrganizationId());
		receipt.setPinCode(receiptRsModel.getPinCode());
		receipt.setModeNumber(receiptRsModel.getModeNumber());
		receipt.setReceiptCategoryId(receiptRsModel.getReceiptCategoryId());
		receipt.setReceiptSubCategoryId(receiptRsModel.getReceiptSubCategoryId());
		receipt.setReceivedOn(receiptRsModel.getReceivedOn());
		receipt.setLetterDate(receiptRsModel.getLetterDate());
		receipt.setDmFileId(documentAndMediaFileId);
		receipt.setUserPostId(receiptRsModel.getUserPostId());
		receipt.setReceiptNumber(number);
		receiptLocalService.addReceipt(receipt);
		return receiptRsModel;
	}

	private String generateReceiptNumber(long receiptId) {
		String receiptNumber = "R" + receiptId;
		return receiptNumber;

	}

	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private ReceiptLocalService receiptLocalService;
	@Reference
	private UserLocalService userLocalService;
	@Reference
	private DocStore docstore;
}
