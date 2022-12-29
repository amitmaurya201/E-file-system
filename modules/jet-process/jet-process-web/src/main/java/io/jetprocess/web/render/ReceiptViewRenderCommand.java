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
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=/receiptView" }, service = MVCRenderCommand.class)
public class ReceiptViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		String currentURL = ParamUtil.getString(renderRequest, "backPageURL");

		Receipt receipt;
		try {
			receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
			renderRequest.setAttribute("receipt", receipt);
			renderRequest.setAttribute("CurrentURL", currentURL);

			
			Masterdata typeById = masterdataLocalService.getTypeById(receipt.getTypeId());
			renderRequest.setAttribute("typeValue", typeById.getValue());
			
			Masterdata deliveryModeById = masterdataLocalService.getDeliveryModeById(receipt.getDeliveryModeId());
			renderRequest.setAttribute("deliveryModeValue", deliveryModeById.getValue());
			
			Masterdata organizationById = masterdataLocalService.getOrganizationById(receipt.getOrganizationId());
			renderRequest.setAttribute("organizationValue", organizationById.getValue());
			
			if(receipt.getSubOrganizationId() != 0) {
			Masterdata subOrganizationById = masterdataLocalService
					.getSubOrganizationById(receipt.getSubOrganizationId());
			renderRequest.setAttribute("subOrganizationValue", subOrganizationById.getValue());
			}
			
			Masterdata receiptCategoryById = masterdataLocalService
					.getReceiptCategoryById(receipt.getReceiptCategoryId());
			renderRequest.setAttribute("receiptCategoryValue", receiptCategoryById.getValue());
			
			if(receipt.getReceiptSubCategoryId() != 0) {
			Masterdata receiptSubCategoryById = masterdataLocalService
					.getReceiptSubCategoryById(receipt.getReceiptSubCategoryId());
			renderRequest.setAttribute("receiptSubCategoryValue", receiptSubCategoryById.getValue());
			}
			// For User Post Table
			long userPostId = receipt.getUserPostId();
			UserPost userPost = userPostLocalService.getUserPost(userPostId);
			renderRequest.setAttribute("userPost", userPost);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/receipt/receipt_view.jsp";
	}

	@Reference
	private ReceiptLocalService receiptLocalService;

	@Reference
	private MasterdataLocalService masterdataLocalService;

	@Reference
	private UserPostLocalService userPostLocalService;
}
