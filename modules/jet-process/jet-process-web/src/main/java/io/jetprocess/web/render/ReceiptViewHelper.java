package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;

@Component(immediate = true, service = ReceiptViewHelper.class)
public class ReceiptViewHelper {

	public void setRecieptDetails(long receiptId, RenderRequest renderRequest, RenderResponse renderResponse) {
		Receipt receipt;
		try {
			receipt = receiptLocalService.getReceipt(receiptId);
			renderRequest.setAttribute("receipt", receipt);

			Masterdata typeById = masterdataLocalService.getTypeById(receipt.getTypeId());
			renderRequest.setAttribute("typeValue", typeById.getValue());

			Masterdata deliveryModeById = masterdataLocalService.getDeliveryModeById(receipt.getDeliveryModeId());
			renderRequest.setAttribute("deliveryModeValue", deliveryModeById.getValue());

			Masterdata organizationById = masterdataLocalService.getOrganizationById(receipt.getOrganizationId());
			renderRequest.setAttribute("organizationValue", organizationById.getValue());

			if (receipt.getSubOrganizationId() != 0) {
				Masterdata subOrganizationById = masterdataLocalService
						.getSubOrganizationById(receipt.getSubOrganizationId());
				renderRequest.setAttribute("subOrganizationValue", subOrganizationById.getValue());
			}
			Masterdata receiptCategoryById = masterdataLocalService
					.getReceiptCategoryById(receipt.getReceiptCategoryId());
			renderRequest.setAttribute("receiptCategoryValue", receiptCategoryById.getValue());

			if (receipt.getReceiptSubCategoryId() != 0) {
				Masterdata receiptSubCategoryById = masterdataLocalService
						.getReceiptSubCategoryById(receipt.getReceiptSubCategoryId());
				renderRequest.setAttribute("receiptSubCategoryValue", receiptSubCategoryById.getValue());
			}
			if (receipt.getCountryId() != 0) {
				Masterdata countryById = masterdataLocalService.getCountryById(receipt.getCountryId());
				renderRequest.setAttribute("countryValue", countryById.getValue());
			}
			if (receipt.getStateId() != 0) {
				Masterdata StateById = masterdataLocalService.getStateById(receipt.getStateId());
				renderRequest.setAttribute("stateValue", StateById.getValue());
			}
			// For User Post Table
			long userPostId = receipt.getUserPostId();
			UserPost userPost = userPostLocalService.getUserPost(userPostId);
			renderRequest.setAttribute("userPost", userPost);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Reference
	private ReceiptLocalService receiptLocalService;

	@Reference
	private MasterdataLocalService masterdataLocalService;

	@Reference
	private UserPostLocalService userPostLocalService;
}