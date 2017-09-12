package com.business;

public class Store extends Facility {
    private String storeNumber;
    private double sales;
    private Division division;

    public Store(int id, Division division, String storeNumber, double sales, String name, String address, String city, String state, int zip) {
        super(id, name, address, city, state, zip);
        this.division = division;
        this.storeNumber = storeNumber;
        this.sales = sales;
    }


    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

}
