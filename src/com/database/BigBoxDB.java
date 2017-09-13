package com.database;
import com.business.Division;
import com.business.Store;
import java.util.ArrayList;

public class BigBoxDB implements BigBoxDAO{

    private ArrayList<Store> stores = new ArrayList<>();

    public BigBoxDB() {
        setupArray();
    }

    private void setupArray() {
        Division[] divisions = new Division[2];
        divisions[0] = new Division(1, "001", "Cincinnati Division",
                "1111 Division St.", "Cincinnati", "OH", 45555);
        divisions[1] = new Division(2, "111", "Louisville Division",
                "1222 Washington St.", "Louisville", "KY", 40205);

        stores.add(new Store(1, divisions[0], "00011", 25000, "Mason BigBox", "5711 Fields Ertel Rd.", "Mason", "OH", 45249));
        stores.add(new Store(2, divisions[0], "00255", 27500, "Downtown BigBox", "9330 Main St.", "Cincinnati", "OH", 45202));
        stores.add(new Store(3, divisions[0], "00172", 32555.55, "Goshen BigBox", "6777 Goshen Rd.", "Goshen", "OH", 45122));
        stores.add(new Store(4, divisions[0], "00075", 21425.37, "Bridgetown BigBox", "3888 Race Rd.", "Cincinnati", "OH", 45211));
        stores.add(new Store(5, divisions[1], "00001", 14432.77, "Louisville BigBox", "1111 Washington St.", "Louisville", "KY", 40206));
        stores.add(new Store(6, divisions[1], "00044", 17555.11, "Lawrenceburg BigBox", "8000 Liberty St.", "Louisville", "KY", 40204));

    }

    @Override
    public ArrayList<Store> listAllStores() {
        return stores;
    }

    @Override
    public ArrayList<Store> listAllStores(String d) {
       ArrayList<Store> storesInDivision = new ArrayList<Store>();
       for (Store s : stores) {
           if (s.getDivision().divisionNumber.equalsIgnoreCase(d)) {
               storesInDivision.add(s);
           }
       }
       return storesInDivision;
    }
}
