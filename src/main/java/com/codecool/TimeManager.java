package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class TimeManager {
    final int commandIndex = 0;
    final int nameIndex = 1;
    private List<MyTimer> timerList = new ArrayList<>();

    public void handleChoice(String input) {


        String[] splitedInput = input.split(" ");
        String command = "default";
        String threadName = null;

        if (splitedInput.length == 2) {
            command = splitedInput[commandIndex];
            threadName = splitedInput[nameIndex];
        } else {
            command = splitedInput[commandIndex];
        }

        switch (command.toLowerCase()) {
            case "start":
                startTimer(threadName);
                break;
            case "stop":
                stopTimer(threadName);
                break;
            case "check":
                checkTimer();
                break;
            default:
                System.out.println("There is no such command");

        }
    }


    private void startTimer(String threadName) {

        for (MyTimer timer : timerList) {

            if (timer.getName().equalsIgnoreCase(threadName)) {
                timer.continueStart();
                break;
            }
        }

        MyTimer newTimer = new MyTimer(threadName);
        newTimer.start();
        timerList.add(newTimer);
    }

    private void stopTimer(String threadName) {
        for (MyTimer timer : timerList) {

            if (timer.getName().equalsIgnoreCase(threadName)) {
                timer.asleeped();
            }
        }
    }

    private void checkTimer() {
        for(MyTimer timer : timerList) {
            System.out.println(timer.myTimerToString());
        }
    }

    public String getAllTimers() {

    StringBuilder allTimersBuilder = new StringBuilder();

    for(MyTimer timer : timerList) {
            allTimersBuilder.append(timer.myTimerToString());
        }
        return allTimersBuilder.toString();
    }

    public void stopAllTimers() {

        for(MyTimer timer : timerList) {
            //timer.stoped();
            timer.interrupt();
        }
    }


}


