package jet.process.rs.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collections;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.ReceiptLocalService;
import jet.process.rs.dto.v1_0.ReceiptRsModel;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

/**
 * @author Admin
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/receipt-rs-model.properties", scope = ServiceScope.PROTOTYPE, service = ReceiptRsModelResource.class)
public class ReceiptRsModelResourceImpl extends BaseReceiptRsModelResourceImpl {
	@Override
	public Page<ReceiptRsModel> createReceipt(ReceiptRsModel receiptRsModel)
		throws Exception {
		long receiptId=counterLocalService.increment(Receipt.class.getName());
		System.out.println(receiptId);
		Receipt receipt = receiptLocalService.createReceipt(receiptId);
		System.out.println(receipt);
		receipt.setName(receiptRsModel.getName());
		receipt.setAddress(receiptRsModel.getAddress());
		receipt.setCountryId(receiptRsModel.getCountryId());
		receipt.setStateId(receiptRsModel.getStateId());
		receiptLocalService.addReceipt(receipt);
		ArrayList<ReceiptRsModel>receiptRsModels = new ArrayList<>();
		receiptRsModels.add(receiptRsModel);
		return Page.of(receiptRsModels);
	}
	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private ReceiptLocalService receiptLocalService;
	@Reference
	private UserLocalService userLocalService;
}