package com.rrWebservices.RRWebservices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundCustomException extends RuntimeException {
	
	private String resourceName;
    private String fieldName;
    private Object fieldValue;
    private String message;
    
    public ResourceNotFoundCustomException(String resourceName, String fieldName, Object fieldValue, String message) {
        super(String.format(message, resourceName, fieldName, fieldValue));
        this.resourceName	= resourceName;
        this.fieldName 		= fieldName;
        this.fieldValue 	= fieldValue;
        this.message 		= message;
    }
    
    public ResourceNotFoundCustomException(String string) {
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundCustomException() {
		// TODO Auto-generated constructor stub
	}

	public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
    
    public String getMessage() {
        return message;
    }
}
