package com.hoa_app.algorithm;

import com.hoa_app.model.Horse;
import com.hoa_app.objective_functions.OF;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.SerializationUtils;

public class HOA {

    private Integer N;
    private Integer I;
    private Integer D;
    private Integer DSP;
    private Integer SSP;
    private Integer HDR;
    private Integer HMP;
    private Integer M;
    private OF of;
    private Double vMin;
    private Double vMax;
    private Double sd;

    public HOA(int n, int i, int d, int DSP, int SSP, int HDR, int HMP, int m, OF of) {
        this.N = n;
        this.I = i;
        this.D = d;
        this.DSP = DSP;
        this.SSP = SSP;
        this.HDR = HDR;
        this.HMP = HMP;
        this.M = m;
        this.of = of;
        this.vMin = -0.1;
        this.vMax = 0.1;
        this.sd = 1.0;
    }

    public List<Horse> generatePopulation() {
        List<Horse> population = new ArrayList<Horse>();
        for(int i = 0; i < this.N; i++) {
            Horse horse = new Horse(this.D, this.M, of.getMinValue(), of.getMaxValue(), this.vMin, this.vMax);
            population.add(horse);
        }
        return population;
    }

    public Result run() {
        Result result = new Result();

        double startTime = System.currentTimeMillis();
        List<Horse> population = generatePopulation();
        Horse gBest = null;

        for(int i = 0; i < population.size(); i++) {
            double fitness = of.compute(population.get(i).getPosition());
            population.get(i).setFitness(fitness);
            if(i == 0) {
                gBest =  (Horse) SerializationUtils.clone(population.get(i));
            } else {
                if(fitness < gBest.getFitness()) {
                    gBest =  (Horse) SerializationUtils.clone(population.get(i));
                }
            }
        }

        for(int i = 0; i < I; i++) {
            result.setLogs(result.getLogs() + "  Iteration " + (i + 1) + "\n");
        }

        double endTime = System.currentTimeMillis();
        double duration = endTime - startTime;
        result.setGlobalBest(gBest);
        result.setRunningTime(duration);

        return result;
    }

    public Integer getN() {
        return N;
    }

    public void setN(Integer n) {
        N = n;
    }

    public Integer getI() {
        return I;
    }

    public void setI(Integer i) {
        I = i;
    }

    public Integer getD() {
        return D;
    }

    public void setD(Integer d) {
        D = d;
    }

    public Integer getDSP() {
        return DSP;
    }

    public void setDSP(Integer DSP) {
        this.DSP = DSP;
    }

    public Integer getSSP() {
        return SSP;
    }

    public void setSSP(Integer SSP) {
        this.SSP = SSP;
    }

    public Integer getHDR() {
        return HDR;
    }

    public void setHDR(Integer HDR) {
        this.HDR = HDR;
    }

    public Integer getHMP() {
        return HMP;
    }

    public void setHMP(Integer HMP) {
        this.HMP = HMP;
    }

    public Integer getM() {
        return M;
    }

    public void setM(Integer m) {
        M = m;
    }

    public OF getOf() {
        return of;
    }

    public void setOf(OF of) {
        this.of = of;
    }

    public Double getvMin() {
        return vMin;
    }

    public void setvMin(Double vMin) {
        this.vMin = vMin;
    }

    public Double getvMax() {
        return vMax;
    }

    public void setvMax(Double vMax) {
        this.vMax = vMax;
    }

    public Double getSd() {
        return sd;
    }

    public void setSd(Double sd) {
        this.sd = sd;
    }
}
