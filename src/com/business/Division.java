package com.business;

public class Division extends Facility {
    public String divisionNumber;

    public Division(int id, String divisionNumber, String name, String address, String city, String state, int zip) {
        super(id, name, address, city, state, zip);
        this.divisionNumber = divisionNumber;
    }

    public String getDivisionNumber() {
        return divisionNumber;
    }

    public void setDivisionNumber() {
        this.divisionNumber = divisionNumber;
    }

    @Override
    public String toString() {
        return divisionNumber;
    }
}
