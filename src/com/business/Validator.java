package com.business;

import java.util.Scanner;

public class Validator {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String prompt) {
        String s = "";
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }

    public static String getString(String prompt, String s1, String s2) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getString(prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                System.out.println("Error! Entry must be '" + s1 + "' or '" +
                        s2 + "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
}
