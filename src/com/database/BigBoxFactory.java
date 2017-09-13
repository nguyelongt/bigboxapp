package com.database;

public class BigBoxFactory {
    public static BigBoxDAO getBigBoxDAO() {
        BigBoxDAO dao = new BigBoxDB();
        return dao;
    }
}
