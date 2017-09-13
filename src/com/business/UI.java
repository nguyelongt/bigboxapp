package com.business;

import static com.business.Utility.*;

public class UI {
    public static void title() {
        consolePrint("Welcome to the Big Box Application!\n");
    }

    public static void menuList() {
        consolePrint("\nCOMMAND MENU\n");
        consolePrint("List - List All Stores\n");
        consolePrint("Div - List All Stores for a Division\n");
        consolePrint("Sales - Sales Summary\n");
        consolePrint("Help - Show This Menu\n");
        consolePrint("Exit - Exit This Application\n");
    }



}
