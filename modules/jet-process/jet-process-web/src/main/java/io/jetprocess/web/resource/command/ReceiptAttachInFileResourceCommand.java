package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.FileMovement;
import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name="+MVCCommandNames.ATTACH_RECEIPT_IN_FILE_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class ReceiptAttachInFileResourceCommand implements MVCResourceCommand  {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		logger.info("Attaching receipt..In File...");
		long receiptId = ParamUtil.getLong(resourceRequest, "receiptId");
		long docFileId = ParamUtil.getLong(resourceRequest, "docFileId");
		long userPostId = ParamUtil.getLong(resourceRequest, "userPostId");
		long receiptMovementId = ParamUtil.getLong(resourceRequest, "receiptMovementId");
		String remarks = ParamUtil.getString(resourceRequest, "remarks");
		long fileMovementId = ParamUtil.getLong(resourceRequest, "fileMovementId");
		try {
			FileMovement fileMovement = fileMovementLocalService.getFileMovement(fileMovementId);
			if(fileMovement.getMovementType() == 0 && fileMovement.getActive() == false ) {
				fileCorrReceiptLocalService.addReceiptInFile(receiptId, docFileId, userPostId, remarks, receiptMovementId,
						fileMovementId);
				resourceResponse.setContentType("text/html");
		        PrintWriter out = resourceResponse.getWriter();
		        out.println("Rceipt successfully Attached..");
		        out.flush();
		        logger.info("Rceipt successfully Attached..");
			}else  {
				if(fileMovement.getMovementType() == 1 && fileMovement.getActive() == true) {
					fileCorrReceiptLocalService.addReceiptInFile(receiptId, docFileId, userPostId, remarks, receiptMovementId,
							fileMovementId);	
					resourceResponse.setContentType("text/html");
			        PrintWriter out = resourceResponse.getWriter();
			        out.println("Rceipt successfully Attached..");
			        out.flush();
			        logger.info("Rceipt successfully Attached..1111");
				}else {
					resourceResponse.setContentType("text/html");
			        PrintWriter out = resourceResponse.getWriter();
			        out.println("Rceipt is not Attached (File Allready pullbacked )");
			        out.flush();
					/*
					 * SessionErrors.add(resourceRequest, "file-is-not-attachable");
					 * SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest)
					 * + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					 */
					logger.info("file is not attachable..");
				}
				
			}
			
			
		} catch (PortalException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return false;
	}

	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;
	
	@Reference
	private FileMovementLocalService fileMovementLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
