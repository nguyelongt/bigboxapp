package com.database;

import com.business.Store;

import java.util.ArrayList;

public interface BigBoxReader {
    ArrayList<Store> listAllStores();
    ArrayList<Store> listAllStores(String d);
}
