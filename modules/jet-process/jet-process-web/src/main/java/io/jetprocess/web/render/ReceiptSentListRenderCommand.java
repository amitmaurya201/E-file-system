package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=/receiptSentList" }, service = MVCRenderCommand.class)
public class ReceiptSentListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("---1----   ");
		Long userPostId = ParamUtil.getLong(renderRequest, "selectedUserPostId");
		System.out.println("---1----userPostId  --   " + userPostId);
		/*
		 * List<ReceiptSentListDto> receiptSentList =
		 * masterdataLocalService.getReceiptSentList(userPostId);
		 * System.out.println("---2----   " + receiptSentList);
		 * renderRequest.setAttribute("receiptSentList", receiptSentList); for
		 * (ReceiptSentListDto receiptSent : receiptSentList) {
		 * System.out.println("---3----   " + receiptSent); }
		 */
		return "/receipt/sent_list.jsp";
	}

	@Reference
	private MasterdataLocalService masterdataLocalService;
}
