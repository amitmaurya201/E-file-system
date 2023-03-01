package io.jetprocess.web.resource.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name="+MVCCommandNames.REOPEN_FILE_RESOUCE_COMMAND }, service = MVCResourceCommand.class)
public class ReopenClosedFileResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		long fileId = ParamUtil.getLong(resourceRequest, "fileId");
		long closedFileId = ParamUtil.getLong(resourceRequest, "closedFileId");
		String reopenRemarks=ParamUtil.getString(resourceRequest, "reopenRemarks");
		long reopenBy = ParamUtil.getLong(resourceRequest, "userPostId");
		
		
		
		return false;
	}

}
