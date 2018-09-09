package com.vport.system.exception;

public class MessageException extends Exception{
    private String mString;
    
    public MessageException(String mString) {
        this.mString = mString;
    }

    public String getmString() {
        return mString;
    }

    public void setmString(String mString) {
        this.mString = mString;
    }
    
    
}
