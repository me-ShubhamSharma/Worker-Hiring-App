package com.example.myproject;

import android.widget.EditText;

public class WorkDetails {
    String wname;
    String wemail;
    String wdesc;
    String wreq;
    String wphone;
    String wsalary;
    String wstartdate;
    String wloc;

    public WorkDetails(String wname, String wemail, String wdesc, String wreq, String wphone, String wsalary, String wstartdate, String wloc) {
        this.wname = wname;
        this.wemail = wemail;
        this.wdesc = wdesc;
        this.wreq = wreq;
        this.wphone = wphone;
        this.wsalary = wsalary;
        this.wstartdate = wstartdate;
        this.wloc = wloc;
    }

    public String getWname() {
        return wname;
    }

    public String getWemail() {
        return wemail;
    }

    public String getWdesc() {
        return wdesc;
    }

    public String getWreq() {
        return wreq;
    }

    public String getWphone() {
        return wphone;
    }

    public String getWsalary() {
        return wsalary;
    }

    public String getWstartdate() {
        return wstartdate;
    }

    public String getWloc() {
        return wloc;
    }
}
