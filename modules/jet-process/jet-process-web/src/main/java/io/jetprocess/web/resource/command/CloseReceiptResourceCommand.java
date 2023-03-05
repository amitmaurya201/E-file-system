package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptCloseDetailLocalService;
//import io.jetprocess.service.ReceiptCloseDetailLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CLOSE_RECEIPT_RESOURCE_COMMAND }, service = MVCResourceCommand.class)

public class CloseReceiptResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		long closedMovementId = ParamUtil.getLong(resourceRequest, "rmId");
		long receiptId = ParamUtil.getLong(resourceRequest, "closeReceiptId");
		String closingRemarks = ParamUtil.getString(resourceRequest, "closingRemarks");
		String userPostId = ParamUtil.getString(resourceRequest, "userPostId");
		long closedBy = Long.parseLong(userPostId);
		LOGGER.info("receiptId--->"+receiptId+"reopenMovementId--->"+closedMovementId+"reopenedBy---->"+userPostId+"reopenRemarks--->"+closingRemarks);
		try {
			receiptCloseDetailLocalService.addClosedReceiptDetails(receiptId, closedBy, closingRemarks,
					closedMovementId);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Reference
	private ReceiptCloseDetailLocalService receiptCloseDetailLocalService;
	private Log LOGGER=LogFactoryUtil.getLog(CloseReceiptResourceCommand.class);
}
