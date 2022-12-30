package io.jetprocess.web.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

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

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=/editReceipt" }, service = MVCRenderCommand.class)
public class EditReceiptRenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		if (receiptId != 0) {
			try {
				Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
				renderRequest.setAttribute("receipt", receipt);
				renderRequest.setAttribute("viewPdfUrl", receipt.getViewPdfUrl());

				Masterdata typeById = masterdataLocalService.getTypeById(receipt.getTypeId());
				renderRequest.setAttribute("typeValue", typeById.getValue());

				Masterdata deliveryModeById = masterdataLocalService.getDeliveryModeById(receipt.getDeliveryModeId());
				renderRequest.setAttribute("deliveryModeValue", deliveryModeById.getValue());

				Masterdata organizationById = masterdataLocalService.getOrganizationById(receipt.getOrganizationId());
				renderRequest.setAttribute("organizationValue", organizationById.getValue());
				
				List<Masterdata> subOrganizationList = masterdataLocalService.getSubOrgranizations(receipt.getOrganizationId());
		      // List<String>subOrganizationValue = new ArrayList<String>();
				/*
				 * for(Masterdata value :subOrganizationList) { String subOrgValue =
				 * value.getValue(); subOrganizationValue.add(subOrgValue);
				 * 
				 * } System.out.println("size"+subOrganizationValue.size());
				 */
				 
				renderRequest.setAttribute("subOrganizationList", subOrganizationList);
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
