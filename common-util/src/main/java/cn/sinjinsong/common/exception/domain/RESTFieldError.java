package cn.sinjinsong.common.exception.domain;

import org.springframework.validation.FieldError;

public class RESTFieldError {
	private String field;
	private Object rejectedValue;
	private String message;
	
	public RESTFieldError(FieldError error) {
		this.field = error.getField();
		this.rejectedValue = error.getRejectedValue();
		this.message = error.getDefaultMessage();
	}
	
	public RESTFieldError(String field, Object rejectedValue, String message) {
		super();
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RESTFieldError [field=" + field + ", rejectedValue=" + rejectedValue + ", message=" + message + "]";
	}

	
}
