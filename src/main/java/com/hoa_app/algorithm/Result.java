package com.hoa_app.algorithm;

import com.hoa_app.model.Horse;

public class Result {

    private String logs;
    private Horse globalBest;
    private Double runningTime;

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

    public Double getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Double runningTime) {
        this.runningTime = runningTime;
    }
}
