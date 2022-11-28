package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=/editReceipt" }, service = MVCRenderCommand.class)
public class EditReceiptRenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		System.out.println("-1");
		if (receiptId != 0) {
			System.out.println("-2");
			try {
				Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
				renderRequest.setAttribute("receipt", receipt);
				System.out.println("-23" + receipt.getUserPostId());
				System.out.println("-3" + receipt.getViewPdfUrl());
				renderRequest.setAttribute("viewPdfUrl", receipt.getViewPdfUrl());
//				renderRequest.setAttribute("receiptId", receipt.getReceiptId());
				System.out.println("-3");
				Masterdata typeById = masterdataLocalService.getTypeById(receipt.getTypeId());
				Masterdata deliveryModeById = masterdataLocalService.getDeliveryModeById(receipt.getDeliveryModeId());
				Masterdata organizationById = masterdataLocalService.getOrganizationById(receipt.getOrganizationId());
				Masterdata subOrganizationById = masterdataLocalService
						.getSubOrganizationById(receipt.getSubOrganizationId());
				Masterdata receiptCategoryById = masterdataLocalService
						.getReceiptCategoryById(receipt.getReceiptCategoryId());
				Masterdata receiptSubCategoryById = masterdataLocalService
						.getReceiptSubCategoryById(receipt.getReceiptSubCategoryId());
				Masterdata countryById = masterdataLocalService.getCountryById(receipt.getCountryId());
				Masterdata StateById = masterdataLocalService.getStateById(receipt.getStateId());
				System.out.println("-4");
				renderRequest.setAttribute("typeValue", typeById.getValue());
				renderRequest.setAttribute("deliveryModeValue", deliveryModeById.getValue());
				renderRequest.setAttribute("organizationValue", organizationById.getValue());
				renderRequest.setAttribute("subOrganizationValue", subOrganizationById.getValue());
				renderRequest.setAttribute("receiptCategoryValue", receiptCategoryById.getValue());
				renderRequest.setAttribute("receiptSubCategoryValue", receiptSubCategoryById.getValue());
				renderRequest.setAttribute("countryValue", countryById.getValue());
				renderRequest.setAttribute("stateValue", StateById.getValue());
				System.out.println("-4");
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "/receipt/edit-receipt.jsp";
	}

	@Reference
	private ReceiptLocalService receiptLocalService;

	@Reference
	private MasterdataLocalService masterdataLocalService;
}
