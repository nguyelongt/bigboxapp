package com.database;

import com.business.Division;
import com.business.Store;

import java.util.ArrayList;
import java.util.HashMap;

public class BigBoxDB_Backup implements BigBoxDAO{

    private ArrayList<Store> stores = null;

    BigBoxDB_Backup() {
        setupArray();
    }

    private void setupArray() {
        HashMap<String, Division> divHMap = new HashMap<>();
        divHMap.put("001", new Division(1, "001", "Cincinnati Division",
                "1111 Division St.", "Cincinnati", "OH", 45555));
        divHMap.put("111", new Division(2, "111", "Louisville Division",
                "1222 Washington St.", "Louisville", "KY", 40205));

        stores = new ArrayList<>();
        stores.add(new Store(1, divHMap.get("001"), "00011", 25000, "Mason BigBox", "5711 Fields Ertel Rd.", "Mason", "OH", 45249));
        stores.add(new Store(2, divHMap.get("001"), "00255", 27500, "Downtown BigBox", "9330 Main St.", "Cincinnati", "OH", 45202));
        stores.add(new Store(3, divHMap.get("001"), "00172", 32555.55, "Goshen BigBox", "6777 Goshen Rd.", "Goshen", "OH", 45122));
        stores.add(new Store(4, divHMap.get("001"), "00075", 21425.37, "Bridgetown BigBox", "3888 Race Rd.", "Cincinnati", "OH", 45211));
        stores.add(new Store(5, divHMap.get("111"), "00001", 14432.77, "Louisville BigBox", "1111 Washington St.", "Louisville", "KY", 40206));
        stores.add(new Store(6, divHMap.get("111"), "00044", 17555.11, "Lawrenceburg BigBox", "8000 Liberty St.", "Louisville", "KY", 40204));

    }

    @Override
    public ArrayList<Store> listAllStores() {
        return stores;
    }

    @Override
    public ArrayList<Store> listAllStores(String d) {
       ArrayList<Store> storesInDivision = new ArrayList<>();
       for (Store s : stores) {
           if (s.getDivision().divisionNumber.equalsIgnoreCase(d)) {
               storesInDivision.add(s);
           }
       }
       return storesInDivision;
    }
}
