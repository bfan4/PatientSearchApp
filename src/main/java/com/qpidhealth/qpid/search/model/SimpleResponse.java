package com.qpidhealth.qpid.search.model;

/**
 * Created by Bo Fan on 2/22/2020.
 */

public class SimpleResponse {
    public static final String OK_STATUS = "ok";
    public static final String NO_PATIENT = "noPatient";
    
    private String status;
    private String message;
    private Object data;
    
    public static SimpleResponse success(Object data) {
        return new SimpleResponse( "ok", data);
    }
    
    public static SimpleResponse fail(String status) {
        return new SimpleResponse( status, "", null);
    }
    
    public static SimpleResponse fail(String status, String message) {
        return new SimpleResponse( status, message, null);
    }
    
    public SimpleResponse(String status, Object data) {
        this(status, "", data);
    }
    
    public SimpleResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
}

