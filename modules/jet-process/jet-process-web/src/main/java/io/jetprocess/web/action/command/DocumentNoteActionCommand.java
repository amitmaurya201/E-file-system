package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = {"javax.portlet.name="+JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name="+MVCCommandNames.CREATE_NOTE_DOCUMENT_RENDER_COMMAND}, service=MVCActionCommand.class)
public class DocumentNoteActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String subject =ParamUtil.getString(actionRequest, "noteSubject");
		
		long subCategory =ParamUtil.getLong(actionRequest, "subjectCategory");
		
		String createOn =ParamUtil.getString(actionRequest, "createdOn");
		
		String content =ParamUtil.getString(actionRequest, "content");
		
		LOGGER.info("subject: "+subject+" : "+subCategory+" : "+createOn+" : "+content);
		
		 
		
	}
	
	private Log LOGGER=LogFactoryUtil.getLog(DocumentNoteActionCommand.class);
	

}
