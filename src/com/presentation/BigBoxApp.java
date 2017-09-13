package com.presentation;

import com.business.Store;
import com.business.UI;
import com.database.BigBoxDAO;
import com.database.BigBoxFactory;
import dnl.utils.text.table.TextTable;

import java.util.ArrayList;

import static com.business.Utility.*;
import static com.business.Validator.*;

public abstract class BigBoxApp {

    private static BigBoxDAO dao;

    public static void main(String[] args) {
        UI.title();
        dao = BigBoxFactory.getBigBoxDAO();
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            UI.menuList();
            boolean isValid = false;
            while (!isValid) {
                String selection = getString("\nEnter a Command: ");
                if (selection.equalsIgnoreCase("list")) {
                    listAllStores();
                    isValid = true;
                } else if (selection.equalsIgnoreCase("div")) {
                    String divNbr = getString("Enter Division #: ");
                    listAllStores(divNbr);
                    isValid = true;
                } else if (selection.equalsIgnoreCase("help")) {
                    UI.menuList();
                    isValid = false;
                } else if (selection.equalsIgnoreCase("exit")) {
                    consolePrint("\nExiting Application....");
                    System.exit(0);
                } else {
                    consolePrint("Invalid selection. Try again.");
                }
            }
            choice = getString("\n\nContinue? ( Y / N ): ", "y", "n");
        }
        consolePrint("Exiting Application....");
    }

    private static void listAllStores() {
        ArrayList<Store> stores = dao.listAllStores();
        generateStoresReport(stores);
    }

    private static void listAllStores(String d) {
        ArrayList<Store> stores = dao.listAllStores(d);
        generateStoresReport(stores);
    }

    /**
     * Create a table layout and stores data into the table
     * row by row for 9 parameters
     * @param stores
     */
    private static void generateStoresReport(ArrayList<Store> stores) {
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
