package jet.process.rs.internal.resource.v1_0;

import jet.process.rs.dto.v1_0.ReceiptRsModel;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Collections;
import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;

/**
 * @author Admin
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/receipt-rs-model.properties", scope = ServiceScope.PROTOTYPE, service = ReceiptRsModelResource.class)
public class ReceiptRsModelResourceImpl extends BaseReceiptRsModelResourceImpl {
	@Override
	public Page<ReceiptRsModel> createReceipt(Integer groupId, Integer typeId, Integer tempfileEntryId,
			Integer deliveryModeId, String receivedOn, String letterDate, String referenceNumber, String modeNumber,
			Integer receiptCategoryId, Integer receiptSubCategoryId, String subject, String remarks, String name,
			String designation, String mobile, String email, String address, Integer countryId, Integer stateId,
			String pinCode, Integer organizationId, Integer subOrganizationId, String city, Integer userPostId)
			throws Exception {
		System.out.println("test");
		long userId = PrincipalThreadLocal.getUserId();
		System.out.println(userId);
		Group group = groupLocalService.getGroup(groupId);
		System.out.println(typeId);
		User user = userLocalService.getUser(userId);
		ServiceContext serviceContext = new ServiceContext();
		long receiptId = counterLocalService.increment();
		System.out.println(receiptId);
		Receipt receipt = receiptLocalService.createReceipt(receiptId);
		System.out.println(receipt);
		receipt.setAddress(address);
		receipt.setCity(city);
		receipt.setCountryId(Long.valueOf(countryId));
		receipt.setDeliveryModeId(Long.valueOf(deliveryModeId));
		receipt.setDesignation(designation);
		receipt.setEmail(email);
		receipt.setOrganizationId(Long.valueOf(organizationId));
		receipt.setStateId(Long.valueOf(stateId));
		receipt.setSubOrganizationId(Long.valueOf(subOrganizationId));
		receipt.setSubject(subject);
		receipt.setReceiptCategoryId(Long.valueOf(receiptCategoryId));
		receipt.setReceiptSubCategoryId(Long.valueOf(receiptSubCategoryId));
		receipt.setPinCode(pinCode);
		receipt.setUserPostId(Long.valueOf(userPostId));
		receipt.setMobile(mobile);
		receipt.setReferenceNumber(referenceNumber);
		receipt.setName(name);
		receipt.setTypeId(Long.valueOf(typeId));
		receipt.setRemarks(remarks);
		receipt.setLetterDate(letterDate);
		receipt.setReceivedOn(receivedOn);
		
		receipt.setModeNumber(modeNumber);
		receipt.setCreateDate(serviceContext.getCreateDate(new Date()));
		receipt.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		receiptLocalService.addReceipt(receipt);
		System.out.println(receipt.getAddress());
		return Page.of(Collections.emptyList());
	}
	@Reference
	private CounterLocalService counterLocalService;
	private ReceiptLocalService receiptLocalService;
	private UserLocalService userLocalService;
}