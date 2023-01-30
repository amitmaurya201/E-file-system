package io.jetprocess.web.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=AttachFileCorrespondence" }, service = MVCActionCommand.class)
public class AttachReceiptActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("attach receipt");
		long receiptPK = ParamUtil.getLong(actionRequest, "receipt");
		long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		long userPostId = ParamUtil.getLong(actionRequest, "userPostId");
		long receiptMovementId = ParamUtil.getLong(actionRequest, "receiptMovementId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		System.out.println("status : ");
		boolean status=receiptMovementLocalService.isReceiptAttachable(receiptPK, receiptMovementId);
		System.out.println("status -----> : "+status);
		fileCorrReceiptLocalService.addReceiptInFile(receiptPK, docFileId, userPostId, remarks);
		/*
		 * if(status==true) {
		 * 
		 * fileCorrReceiptLocalService.addReceiptInFile(receiptPK, docFileId,
		 * userPostId, remarks); System.out.println("working--------");
		 * 
		 * 
		 * } else { SessionErrors.add(actionRequest, "receipt-is-not-attachable");
		 * SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) +
		 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE); }
		 */
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		actionResponse.sendRedirect(redirectURL);
		

		
		
		
		
		
		
	}

	@Reference
	private ReceiptLocalService receiptLocalService;
	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;
	@Reference
	private MVCActionCommand mvcActionCommand;
	private Log logger = LogFactoryUtil.getLog(this.getClass());

}

