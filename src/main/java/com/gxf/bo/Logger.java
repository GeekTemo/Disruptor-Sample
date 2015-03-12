package com.gxf.bo;

import java.util.Date;

/**
 * Created by GongXingFa on 2015/2/10.
 */
public class Logger {
    private String id;
    private String message;
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        if (time == null) {
            return new Date();
        }
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
