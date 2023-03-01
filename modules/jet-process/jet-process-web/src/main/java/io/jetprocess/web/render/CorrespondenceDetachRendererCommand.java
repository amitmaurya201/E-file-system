package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.Corr_RECEIPT_DETACH_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class CorrespondenceDetachRendererCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long rmId = ParamUtil.getLong(renderRequest, "rmId");
		System.out.println("rmId : "+rmId);
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		System.out.println("receiptId : "+receiptId);
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		renderRequest.setAttribute("backPageURL", backPageURL);
		renderRequest.setAttribute("rmId", rmId);
		renderRequest.setAttribute("receiptId", receiptId);

		return "/file/correspondence-detach.jsp";
	}
}
