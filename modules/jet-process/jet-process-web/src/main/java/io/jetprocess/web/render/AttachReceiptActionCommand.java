package io.jetprocess.web.render;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.model.FileCorr;
import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.FileCorrLocalService;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptLocalServiceUtil;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=AttachFileCorrespondence" }, service = MVCActionCommand.class)
public class AttachReceiptActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("attach receipt");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long receiptPK = ParamUtil.getLong(actionRequest, "receipt");
		long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		long userPostId = ParamUtil.getLong(actionRequest, "userPostId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		logger .info("receiptPK====" + receiptPK+ "docFileId====" +docFileId+ "userPostId====" +userPostId);
	
		long fileCorrId = counterLocalService.increment();
		FileCorr fileCorr = fileCorrLocalService.createFileCorr(fileCorrId);
		fileCorr.setReceiptId(receiptPK);
		fileCorr.setDocFileId(docFileId);
		fileCorr.setUserPostId(userPostId);
		fileCorr.setCorrespondenceType(FileStatus.RECEIPT_TYPE);
		fileCorr.setRemarks(remarks);
		fileCorrLocalService.addFileCorr(fileCorr);	
		Receipt receipt = receiptLocalService.getReceipt(receiptPK);
		 if(Validator.isNotNull(receipt)) {
		receipt.setAttachStatus(FileStatus.ATTACH_STATUS);
		receiptLocalService.updateReceipt(receipt);
		 String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		  actionResponse.sendRedirect(redirectURL);
		  }			
	}
	
	public Boolean isReceiptAttachable(long receiptId) throws PortalException {
		logger.info("attach method");
		boolean attachable = false;
		List<ReceiptMovement> receiptMovementByReceiptId = receiptMovementLocalService
				.getReceiptMovementByReceiptId(receiptId);
		for (ReceiptMovement receiptMovement : receiptMovementByReceiptId) {
			logger.info("getPullBackRemark    " + receiptMovement.getPullBackRemark());
			Receipt receipt = receiptLocalService.getReceipt(receiptMovement.getReceiptId());
			logger.info("receipt.getCurrentState   " + receipt.getCurrentState());
			if ((receiptMovement.getPullBackRemark().isEmpty()) && (receipt.getAttachStatus().isEmpty()) && !receiptMovement.getActive() ){

				logger.info("attachable true");
				attachable = true;
			} else {
				logger.info("attachable false");
				attachable = false;
			}
		}
		return attachable;
	}

	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private FileCorrLocalService fileCorrLocalService;
	@Reference
	private ReceiptLocalService receiptLocalService;
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;
	@Reference
	private MVCActionCommand mvcActionCommand;
	private Log logger = LogFactoryUtil.getLog(this.getClass());
	 

}




