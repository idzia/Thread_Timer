package com.codecool;

public class MyTimer extends Thread {
    private int time;
    private volatile boolean asleep;


    public MyTimer(String name) {
        super(name);
        this.asleep = false;
    }

    public int getTime(){
        return time;
    }


    public void asleeped() {
        this.asleep = true;
    }

    synchronized void continueStart() {
        this.asleep = false;
        notify();
    }

    public String myTimerToString() {

        StringBuilder timerStr = new StringBuilder();

        timerStr.append("Name: ");
        timerStr.append(getName());
        timerStr.append(" | Id: ");
        timerStr.append(getId());
        timerStr.append(" | Seconds: ");
        timerStr.append(getTime());
        timerStr.append("\n");

        return timerStr.toString();
    }


    public void run() {

        while(! this.interrupted()) {
            try {
                synchronized (this) {
                    if (asleep) {
                        wait();
                    }
                }
                this.sleep(1000);
                this.time++;

            } catch (InterruptedException e) {
                this.interrupt();
                System.out.println(getName() + " was interrupted");
            }

        }

    }


}
