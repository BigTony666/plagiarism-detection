package com.Michelle.PD.utils;

public enum Logger {
    
    INSTANCE;
    
    private Logger(){}
    
    public Logger getInstance() {
        return INSTANCE;
    }
    
    public void error(String msg) {
        System.err.println(msg);
    }
    
    public void info(String msg) {
        System.out.println(msg);
    }
}
