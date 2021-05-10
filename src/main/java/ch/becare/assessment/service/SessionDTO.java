package ch.becare.assessment.service;

import java.util.*;

public class SessionDTO {
    private String user;
    private Date begin;
    private Date end;
    private Map<String, Double> data;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Map<String, Double> getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
