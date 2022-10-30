
package io.jetprocess.util.validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.validator.FileValidator;


@Component(immediate = true, service = FileValidator.class)
public class FileValidatorImpl implements FileValidator{




	private boolean isSubjectValid(final String subject, List<String> errors) {
		boolean result = true;
		if (subject.isEmpty()) {
			errors.add("Pleace Enter subject");
			result = false;
		}
		return result;

	}

	private boolean isRemarksValid(final String remarks, List<String> errors) {
		boolean result = true;
		if (remarks.isEmpty()) {
			errors.add("Please Enter remarks");
			result = false;
		}
		return result;

	}

	private boolean isReferenceValid(final String reference, List<String> errors) {
		boolean result = true;
		if (reference.isEmpty()) {
			errors.add("Please Enter reference");
			result = false;
		}
		return result;

	}
	
	
	private void validator(final String subject, final String remarks,final String reference,
			final List<String> errors) {		
	
		isSubjectValid(subject,errors);
		isRemarksValid(remarks,errors);
		isReferenceValid(reference, errors);
		
		
	}


	@Override
	public List<String> validate(String subject, String remarks, String reference) {

		List<String> errors = new ArrayList<String>();
		validator(subject, remarks, reference, errors);
		
		
		return errors;
	}

	

	
		
	
}


