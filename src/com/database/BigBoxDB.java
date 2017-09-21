package com.database;
import com.business.Division;
import com.business.Store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class BigBoxDB implements BigBoxDAO{

    private ArrayList<Store> stores = null;
    HashMap<Integer, Division> divisionIdMap = new HashMap<>();

    BigBoxDB() {
        try {
            DatabaseUtility.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            DatabaseUtility dbutil = new DatabaseUtility();
            dbutil.sqlScriptRunner();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        populateDivision();
    }


    public void populateDivision() {
        String sqlQuery = "SELECT * FROM Divisions";
        try (PreparedStatement ps = DatabaseUtility.connection.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                int divID = rs.getInt(1);
                String divNumber = rs.getString(2);
                String name = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String state = rs.getString(6);
                Integer zip = rs.getInt(7);
                Division d = new Division(divID, divNumber, name, address, city, state, zip);
                divisionIdMap.put(divID, d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        @Override
        public ArrayList<Store> listAllStores () {
            ArrayList<Store> storesInDivision = new ArrayList<>();
            String sqlQuery = "SELECT * FROM Stores";
            try (PreparedStatement ps = DatabaseUtility.connection.prepareStatement(sqlQuery);
                 ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int divID = rs.getInt(2);
                    Division d = divisionIdMap.get(divID);
                    String storeNbr = rs.getString(3);
                    double sales = rs.getDouble(4);
                    String name = rs.getString(5);
                    String address = rs.getString(6);
                    String city = rs.getString(7);
                    String state = rs.getString(8);
                    Integer zip = rs.getInt(9);
                    Store s = new Store(id, d, storeNbr, sales, name, address, city, state, zip);
                    storesInDivision.add(s);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return storesInDivision;
        }

    @Override
    public ArrayList<Store> listAllStores(String d) {
        return null;
    }

}
