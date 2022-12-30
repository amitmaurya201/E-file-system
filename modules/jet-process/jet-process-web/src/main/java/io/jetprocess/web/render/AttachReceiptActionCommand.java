package io.jetprocess.web.render;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=AttachFileCorrespondence" }, service = MVCActionCommand.class)
public class AttachReceiptActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long receiptPK = ParamUtil.getLong(actionRequest, "receipt");
		long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		long userPostId = ParamUtil.getLong(actionRequest, "userPostId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		// String redirect = ParamUtil.getString(actionRequest, "redirect");
		long fileCorrId = counterLocalService.increment();
		FileCorr fileCorr = fileCorrLocalService.createFileCorr(fileCorrId);
		fileCorr.setReceiptId(receiptPK);
		fileCorr.setDocFileId(docFileId);
		fileCorr.setUserPostId(userPostId);
		fileCorr.setCorrespondenceType(FileStatus.RECEIPT_TYPE);
		fileCorr.setRemarks(remarks);
		fileCorrLocalService.addFileCorr(fileCorr);
		Receipt receipt = receiptLocalService.getReceipt(receiptPK);
		Boolean attachable = isReceiptAttachable(receiptPK);
		logger.info("attachable "+attachable );
		if (attachable) {
			logger.info("attachable in loop ");
			if (Validator.isNotNull(receipt)) {
				receipt.setAttachStatus(FileStatus.ATTACH_STATUS);
				receiptLocalService.updateReceipt(receipt);
			}
		} else {
			logger.info("attachable else loop ");
		}
		HttpSession httpSession = PortalUtil.getHttpServletRequest(actionRequest).getSession();
		// Receipt receipt = ReceiptLocalServiceUtil.getReceipt(receiptPK);
		httpSession.setAttribute("receiptCor", receipt);

	}

	public Boolean isReceiptAttachable(long receiptId) throws PortalException {
		logger.info("attach method");
		boolean attachable = false;

		List<ReceiptMovement> receiptMovementByReceiptId = receiptMovementLocalService
				.getReceiptMovementByReceiptId(receiptId);
		for (ReceiptMovement receiptMovement : receiptMovementByReceiptId) {
			logger.info("getPullBackRemark    " + receiptMovement.getPullBackRemark());
			Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptMovement.getReceiptId());
			logger.info("receipt.getCurrentState   " + receipt.getCurrentState());
			if ((receiptMovement.getPullBackRemark().isEmpty()) && (receipt.getCurrentState() == 1)) {

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

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
