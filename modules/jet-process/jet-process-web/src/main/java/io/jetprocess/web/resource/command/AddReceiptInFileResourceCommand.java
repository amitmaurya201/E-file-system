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
public class AddReceiptInFileResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		logger.info("fileReceive.... ......");
		long docFileId = ParamUtil.getLong(resourceRequest, "docfileId");
		long fileMovementId = ParamUtil.getLong(resourceRequest, "filemovementId");
		DocFile docfile = null;

		try {
			docfile = docfileLocalService.getDocFile(docFileId);

			boolean state;
			if (docfile.getNature().equalsIgnoreCase("Electronic")) {

				state = fileMovementLocalService.saveReadMovement(docFileId, fileMovementId);
                    System.out.println("read file sucessfully-----");
				if (state == false) {
					SessionErrors.add(resourceRequest, "file-is-not-attachable");
					SessionMessages.add(resourceRequest,
							PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				System.out.println("this file is pull backed----------");
				
				}
				else {
					  System.out.println("read file sucessfully--22222222---");
					
				}
			} else {
				state = fileMovementLocalService.saveReceiveMovement(docFileId, fileMovementId);
				if (state == false) {
					SessionErrors.add(resourceRequest, "file-is-not-attachable");
					SessionMessages.add(resourceRequest,
							PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					System.out.println("chal raha h 2222222");

				}
				else {
					System.out.println("Sucessfully--2222222----");	
				}
			}
			} catch (PortalException e) {
			logger.info(e);
		}

		return false;
	}

	
	@Reference
	private DocFileLocalService docfileLocalService;

	@Reference
	private FileMovementLocalService fileMovementLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
