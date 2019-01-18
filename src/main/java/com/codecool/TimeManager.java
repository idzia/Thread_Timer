package com.codecool;

import java.util.*;

public class TimeManager {
    final int commandIndex = 0;
    final int nameIndex = 1;
    private Map<String, MyTimer> timerMap = new HashMap<>();

    public void handleChoice(String input) {


        String[] splitedInput = input.split(" ");
        String command = splitedInput[commandIndex];
        String threadName = "";

        if (splitedInput.length == 2) {
            threadName = splitedInput[nameIndex];
        }

        switch (command.toLowerCase()) {
            case "start":
                startTimer(threadName);
                break;
            case "stop":
                stopTimer(threadName);
                break;
            case "check":
                checkTimer(threadName);
                break;
            default:
                System.out.println("There is no such command");

        }
    }


    private void startTimer(String threadName) {

        if (timerMap.get(threadName) == null) {
            MyTimer newTimer = new MyTimer(threadName);
            newTimer.start();
            timerMap.put(threadName, newTimer);
        } else {
            timerMap.get(threadName).continueStart();
        }
    }

    private void stopTimer(String threadName) {

        if (timerMap.get(threadName) != null) {
            timerMap.get(threadName).asleeped();
        } else if (threadName.equals("")) {
            for (MyTimer timer : timerMap.values()) {
                timer.asleeped();
            }
        } else {
           throw new NullPointerException("There is no thread with this name");
        }
    }

    private void checkTimer(String threadName) {

        if (timerMap.get(threadName) != null) {
            System.out.println(timerMap.get(threadName).myTimerToString());
        } else if (threadName.equals("")) {
            for (MyTimer timer : timerMap.values()) {
                System.out.println(timer.myTimerToString());
            }
        } else {
            throw new NullPointerException("There is no thread with this name");
        }

    }

    public String getAllTimers() {

    StringBuilder allTimersBuilder = new StringBuilder();

        for (MyTimer timer : timerMap.values()) {
            allTimersBuilder.append(timer.myTimerToString());
        }
        return allTimersBuilder.toString();
    }

    public void stopAllTimers() {

        for (MyTimer timer : timerMap.values()) {
            timer.interrupt();
        }
    }


}


