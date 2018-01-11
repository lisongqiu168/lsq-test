package com.lsq.service.logmonitor;

import java.util.Date;

public class LogInfo implements java.io.Serializable{

    /**
     */
    private static final long serialVersionUID = 1L;
    
    private String methodName;
    private Date startTime;
    private Date endTime;
    private Long exeTime;
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Long getExeTime() {
        return exeTime;
    }
    public void setExeTime(Long exeTime) {
        this.exeTime = exeTime;
    }
    
    
    
    

}
