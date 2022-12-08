package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.masterdata.model.ReceiptMovementListDTO;
import io.jetprocess.masterdata.service.MasterdataLocalServiceUtil;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=/receiptInBox" }, service = MVCRenderCommand.class)
public class ReceiptInboxRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		  List<ReceiptMovementListDTO> inboxList =
		  MasterdataLocalServiceUtil.getReceiptInboxList(1); for
		  (ReceiptMovementListDTO receiptMovementListDTO : inboxList) {
		  System.out.println("receipt id"+receiptMovementListDTO.getCreatedDate()); }
		 
				
		return "/receipt/inbox.jsp";
	}

}
