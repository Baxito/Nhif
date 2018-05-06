package com.example.miriam.tibakwanza;

/**
 * Created by HOT_admin on 08/02/2018.
 */

public class Model {

    private String from; //= {"2min","10min","20min","50min","1hr","2hrs","5hrs","6hrs","8hrs","15hrs","20hrs","1day","2days","3days"};
    private String info; //= {"Health Facts","NHIF updates","Health insurance education to all","Cost reviews on NHIF funds","Health Facts","New Health facilities","Types of NHIF cards beneficiaries","Information to all","Health Facts","Coverage in diseases","Health Facilities",};

    public Model(String from, String info){
        this.from = from;
        this.info = info;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
