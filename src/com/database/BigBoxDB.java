package com.database;
import com.business.Division;
import com.business.Store;
import dnl.utils.text.table.TextTable;
import java.util.ArrayList;

public class BigBoxDB {

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

    public void arrayList() {

        Object[][] array = new Object[stores.size()][];
        int i = 0;
        for (Store s : stores)
        {
            array[i] = new Object[9];
            array[i][0] = s.getId();
            array[i][1] = s.getDivision();
            array[i][2] = s.getStoreNumber();
            array[i][3] = s.getSales();
            array[i][4] = s.getName();
            array[i][5] = s.getAddress();
            array[i][6] = s.getCity();
            array[i][7] = s.getState();
            array[i][8] = s.getZip();
            i++;
        }

        String columnNames[] = {"ID", "Divisions", "Store Number", "Sales", "Name", "Address", "City", "State", "Zip"};
        TextTable tt = new TextTable(columnNames, array);
        tt.printTable();
    }
}
