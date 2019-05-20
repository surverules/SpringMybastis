package com.parth.shon.models;

import org.springframework.stereotype.Component;

@Component
public class Address {

    private int aptnumber;
    private String aptname;
    private String city;
    private String state;
    private String moveinDate;

    public int getAptnumber() {
        return aptnumber;
    }

    public void setAptnumber(int aptnumber) {
        this.aptnumber = aptnumber;
    }

    public String getAptname() {
        return aptname;
    }

    public void setAptname(String aptname) {
        this.aptname = aptname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aptnumber=" + aptnumber +
                ", aptname='" + aptname + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", moveinDate='" + moveinDate + '\'' +
                '}';
    }

    public String getMoveinDate() {
        return moveinDate;
    }

    public void setMoveinDate(String moveinDate) {
        this.moveinDate = moveinDate;
    }
}
