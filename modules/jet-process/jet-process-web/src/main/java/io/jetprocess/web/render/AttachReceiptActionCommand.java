package io.jetprocess.web.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileCorrReceiptLocalService;
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
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		fileCorrReceiptLocalService.addReceiptInFile(receiptPK, docFileId, userPostId, remarks);
		System.out.println("working--------");
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		actionResponse.sendRedirect(redirectURL);
			
	}
	
	
	/*
	 * public Boolean isReceiptAttachable(long receiptId) throws PortalException {
	 * logger.info("attach method"); boolean attachable = false;
	 * List<ReceiptMovement> receiptMovementByReceiptId =
	 * receiptMovementLocalService .getReceiptMovementByReceiptId(receiptId); for
	 * (ReceiptMovement receiptMovement : receiptMovementByReceiptId) {
	 * logger.info("getPullBackRemark    " + receiptMovement.getPullBackRemark());
	 * Receipt receipt =
	 * receiptLocalService.getReceipt(receiptMovement.getReceiptId());
	 * logger.info("receipt.getCurrentState   " + receipt.getCurrentState()); if
	 * ((receiptMovement.getPullBackRemark().isEmpty()) &&
	 * (receipt.getAttachStatus().isEmpty()) && !receiptMovement.getActive() ){
	 * 
	 * logger.info("attachable true"); attachable = true; } else {
	 * logger.info("attachable false"); attachable = false; } } return attachable; }
	 */

	
	
    @Reference
    private FileCorrReceiptLocalService fileCorrReceiptLocalService;
	
	private ReceiptMovementLocalService receiptMovementLocalService;
	@Reference
	private MVCActionCommand mvcActionCommand;
	private Log logger = LogFactoryUtil.getLog(this.getClass());
	 

}




