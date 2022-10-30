package io.jetprocess.validator;

import java.util.List;

public interface FileValidator {
	
	public List<String> validate(String subject,String remarks,String reference);


}