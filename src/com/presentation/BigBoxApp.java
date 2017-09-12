package com.presentation;

import com.business.UI;
import com.database.BigBoxDB;

import static com.business.Utility.*;
import static com.business.Validator.*;

public abstract class BigBoxApp {

    public static void main(String[] args) {
        UI.title();

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            UI.menuList();
            boolean isValid = false;
            while (!isValid) {
                String selection = getString("\nEnter a Command: ");
                if (selection.equalsIgnoreCase("list")) {
                    BigBoxDB bbdb = new BigBoxDB();
                    bbdb.arrayList();
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
}
