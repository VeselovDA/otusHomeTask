package com.example.util;

import java.util.Scanner;

public class ConsoleReader {
    private static Scanner in = new Scanner(System.in);
    public static String readConsole(){
        String str = in.nextLine();
       return str;
    }
}
