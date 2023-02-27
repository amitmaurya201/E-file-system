package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.DocFile;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=fileReceive" }, service = MVCResourceCommand.class)
public class AddReceiptCorrespondence implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		logger.info("fileReceive.... Resource url ......");
		long docFileId = ParamUtil.getLong(resourceRequest, "docfileId");
		long fileMovementId = ParamUtil.getLong(resourceRequest, "filemovementId");
		DocFile docfile = null;
		try {
			docfile = docfileLocalService.getDocFile(docFileId);
		} catch (PortalException e) {
			logger.info(e);
		}
		if (docfile.getNature().equalsIgnoreCase("Electronic")) {
		
			try {
				boolean 	state = fileMovementLocalService.saveReadMovement(docFileId, fileMovementId);
				if (state == false) {
					SessionErrors.add(resourceRequest, "file-is-not-attachable");
					SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			boolean state;
			try {
				state = fileMovementLocalService.saveReceiveMovement(docFileId, fileMovementId);
				if (state == false) {
					SessionErrors.add(resourceRequest, "receive-not-available");
					SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Reference
	private DocFileLocalService docfileLocalService;
	
	@Reference
	private FileMovementLocalService fileMovementLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
