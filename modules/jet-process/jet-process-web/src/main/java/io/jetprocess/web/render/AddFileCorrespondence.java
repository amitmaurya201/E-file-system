package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=/addCorrespondence" }, service = MVCRenderCommand.class)
public class AddFileCorrespondence implements MVCRenderCommand{
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("testrerer");
		long docFileId = ParamUtil.getLong(renderRequest, "corrFileId");
		System.out.println("id ->>>>>>>"+docFileId);
		renderRequest.setAttribute("docFileId", docFileId);
		return "/file/add-correspondence.jsp";
	}
}