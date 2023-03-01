package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.FileCloseDetailLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(
		immediate =true,
		property= {
				"javax.portlet.name="+JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name="+MVCCommandNames.CLOSE_FILE_RESOURCE_COMMAND
			},service = MVCResourceCommand.class)
public class CloseFileResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		long closedMovementId =	ParamUtil.getLong(resourceRequest, "fileMovementId");
		long fileId = ParamUtil.getLong(resourceRequest,"fileId");
		String closingRemarks = ParamUtil.getString(resourceRequest,"closingRemarks");
		String userPostId = ParamUtil.getString(resourceRequest, "userPostId");
	    long closedBy = Long.parseLong(userPostId);
		System.out.println("closedMovementId"+closedMovementId+"fileId"+fileId);
		try {
			fileCloseDetailLocalService.addCloseFileDetail(fileId, closedBy, closingRemarks, closedMovementId);
			System.out.println("in closefileresource command");
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return false;
	
	}
@Reference
private FileCloseDetailLocalService fileCloseDetailLocalService;
	

}
