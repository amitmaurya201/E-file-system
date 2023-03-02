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

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.REOPEN_FILE_RESOUCE_COMMAND }, service = MVCResourceCommand.class)
public class ReopenClosedFileResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		System.out.println("resource");
		long fileId = ParamUtil.getLong(resourceRequest, "fileId");
		long closedFileId = ParamUtil.getLong(resourceRequest, "closedFileId");
		long reopenBy = ParamUtil.getLong(resourceRequest, "userPostId");
		long reopenMovementId = ParamUtil.getLong(resourceRequest, "reopenMovementId");
		String reopenRemarks = ParamUtil.getString(resourceRequest, "reopenRemarks");
		System.out.println("resource   "+fileId +"  "+closedFileId + "  "+reopenBy+"  "+reopenMovementId+"  "+reopenRemarks );
		try {
			fileCloseDetailLocalService.reopenClosedFile(closedFileId, fileId, reopenMovementId, reopenBy,
					reopenRemarks);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Reference
	private FileCloseDetailLocalService fileCloseDetailLocalService;
}
