package com.hoa_app.model;

import java.io.Serializable;
import java.util.*;

public class Horse implements Serializable {

    private List<Double> position;
    private List<Double> velocity;
    private Map<Integer, List<Double>> memory;
    private Double fitness;
    private Random rand;
    private Integer D;
    private Integer M;
    private Double pMin;
    private Double pMax;
    private Double vMin;
    private Double vMax;
    private Double rank;

    public Horse(Random rand, Integer d, Integer m, Double pMin, Double pMax, Double vMin, Double vMax) {
        this.rand = rand;
        this.D = d;
        this.M = m;
        this.pMin = pMin;
        this.pMax = pMax;
        this.vMin = vMin;
        this.vMax = vMax;
        this.position = new ArrayList<>();
        for(int i = 0; i < this.D; i++) {
            double value = (pMax - pMin) * rand.nextDouble() + pMin;
            this.position.add(value);
        }
        this.velocity = new ArrayList<>();
        for(int i = 0; i < this.D; i++) {
            this.velocity.add(0.0);
        }
        this.memory = new HashMap<>();
        for(int i = 0; i < m; i++) {
            this.memory.put(i, new ArrayList<Double>());
        }
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public List<Double> getPosition() {
        return position;
    }

    public void setPosition(List<Double> position) {
        this.position = position;
    }

    public List<Double> getVelocity() {
        return velocity;
    }

    public void setVelocity(List<Double> velocity) {
        this.velocity = velocity;
    }

    public Map<Integer, List<Double>> getMemory() {
        return memory;
    }

    public void setMemory(Map<Integer, List<Double>> memory) {
        this.memory = memory;
    }

    public Double getFitness() {
        return fitness;
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }

    public Integer getD() {
        return D;
    }

    public void setD(Integer d) {
        D = d;
    }

    public Integer getM() {
        return M;
    }

    public void setM(Integer m) {
        M = m;
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

    public Double getpMin() {
        return pMin;
    }

    public void setpMin(Double pMin) {
        this.pMin = pMin;
    }

    public Double getpMax() {
        return pMax;
    }

    public void setpMax(Double pMax) {
        this.pMax = pMax;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
