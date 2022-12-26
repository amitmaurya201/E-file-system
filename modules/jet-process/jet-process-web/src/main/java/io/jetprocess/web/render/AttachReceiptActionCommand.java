package io.jetprocess.web.render;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.model.FileCorr;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.FileCorrLocalService;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.ReceiptLocalServiceUtil;
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
	//	String redirect = ParamUtil.getString(actionRequest, "redirect");
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
		 }
		HttpSession httpSession = PortalUtil.getHttpServletRequest(actionRequest).getSession();
		//Receipt receipt = ReceiptLocalServiceUtil.getReceipt(receiptPK);
		httpSession.setAttribute("receiptCor", receipt );

	}

	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private FileCorrLocalService fileCorrLocalService;
	@Reference
	private ReceiptLocalService receiptLocalService;
	 

}




