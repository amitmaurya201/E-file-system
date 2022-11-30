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
		Receipt receipt;
		try {
			receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
			renderRequest.setAttribute("receipt", receipt);
			Masterdata typeById = masterdataLocalService.getTypeById(receipt.getTypeId());
			Masterdata deliveryModeById = masterdataLocalService.getDeliveryModeById(receipt.getDeliveryModeId());
			Masterdata organizationById = masterdataLocalService.getOrganizationById(receipt.getOrganizationId());
			Masterdata subOrganizationById = masterdataLocalService
					.getSubOrganizationById(receipt.getSubOrganizationId());
			Masterdata receiptCategoryById = masterdataLocalService
					.getReceiptCategoryById(receipt.getReceiptCategoryId());
			Masterdata receiptSubCategoryById = masterdataLocalService
					.getReceiptSubCategoryById(receipt.getReceiptSubCategoryId());

			renderRequest.setAttribute("typeValue", typeById.getValue());
			renderRequest.setAttribute("deliveryModeValue", deliveryModeById.getValue());
			renderRequest.setAttribute("organizationValue", organizationById.getValue());
			renderRequest.setAttribute("subOrganizationValue", subOrganizationById.getValue());
			renderRequest.setAttribute("receiptCategoryValue", receiptCategoryById.getValue());
			renderRequest.setAttribute("receiptSubCategoryValue", receiptSubCategoryById.getValue());

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
