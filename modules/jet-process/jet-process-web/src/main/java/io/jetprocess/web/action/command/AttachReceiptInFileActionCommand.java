package io.jetprocess.web.action.command;

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

import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=AttachReceiptCorrespondence" }, service = MVCActionCommand.class)

public class AttachReceiptInFileActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		System.out.println("mera method----");
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		long userPostId = ParamUtil.getLong(actionRequest, "userPostId");
		long receiptMovementId = ParamUtil.getLong(actionRequest, "receiptMovementId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		long fileMovementId = ParamUtil.getLong(actionRequest, "fileMovementId");
		System.out.println("receiptid--------"+receiptId);
		System.out.println("docFileId--------"+docFileId);
		System.out.println("userPostId--------"+userPostId);
		System.out.println("receiptMovementId--------"+receiptMovementId);
		System.out.println("remarks--------"+remarks);
		System.out.println("fileMovementId--------"+fileMovementId);
		fileCorrReceiptLocalService.addReceiptInFile(receiptId, docFileId, userPostId, remarks, receiptMovementId,
					fileMovementId);
			logger.info("Rceipt successfully Attached..");

		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		
		actionResponse.sendRedirect(redirectURL);
		System.out.println("redirect--------"+redirectURL);
		System.out.println("sab badhiyaa chal gyaaa");

		
		
	}
	
	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;
	
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());

	@Reference
	private FileMovementLocalService fileMovementLocalService;

}
