package io.jetprocess.web.render;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalServiceUtil;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=AttachFileCorrespondence"}, service = MVCActionCommand.class)
public class AttachReceiptActionCommand extends BaseMVCActionCommand {
	@Override
	protected  void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {	
		String receiptPK =  ParamUtil.getString(actionRequest, "receipt");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		System.out.println("redirect---"+redirect);
		/*
		 * long fileCorrReceiptId = counterLocalService.increment();
		 * System.out.println(fileCorrReceiptId); FileCorrReceipt fileCorrReceipt =
		 * fileCorrReceiptLocalService.createFileCorrReceipt(fileCorrReceiptId);
		 * fileCorrReceipt.setReceiptId(Long.parseLong(receiptPK));
		 * fileCorrReceiptLocalService.addFileCorrReceipt(fileCorrReceipt);
		 */
		
	   
		  HttpSession httpSession = PortalUtil.getHttpServletRequest(actionRequest).getSession(); 
			Receipt receipt = ReceiptLocalServiceUtil.getReceipt(Long.parseLong(receiptPK));
			
			 httpSession.setAttribute("receiptCor",receipt);
			// httpSession.setAttribute("fileCorrReceiptList", fileCorrReceiptslist);
			// sendRedirect(actionRequest,actionResponse,redirect);
	     // actionResponse.getRenderParameters().setValue("jspPage", "/file/file-inner-view.jsp");
				
		}
	@Reference
	private CounterLocalService counterLocalService;
	/*
	 * @Reference private FileCorrReceiptLocalService fileCorrReceiptLocalService;
	 */
		
	}



