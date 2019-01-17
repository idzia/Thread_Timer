package com.codecool;

import java.util.Scanner;

public class App {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        TimeManager timeManager = new TimeManager();
        consoleInfo();
        String command = input.nextLine();

        while (!((command.toLowerCase()).equals("exit"))) {
            timeManager.handleChoice(command);
            consoleInfo();
            command = input.nextLine();
        }


        String allTimers = timeManager.getAllTimers();
        consoleInfo(allTimers);
        timeManager.stopAllTimers();

    }

    public static void consoleInfo() {
        System.out.println("-= Command? =-");
    }

    public static void consoleInfo(String info) {
        System.out.println(info);
    }
}
