package com.hoa_app.algorithm;

import com.hoa_app.model.Horse;

public class Result {

    private String logs;
    private Horse globalBest;
    private double runningTime;

    public Result() {
        this.logs = "";
    }

    public Result(String logs, Horse globalBest, double runningTime) {
        this.logs = logs;
        this.globalBest = globalBest;
        this.runningTime = runningTime;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public Horse getGlobalBest() {
        return globalBest;
    }

    public void setGlobalBest(Horse globalBest) {
        this.globalBest = globalBest;
    }

    public double getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(double runningTime) {
        this.runningTime = runningTime;
    }
}
