package com.hoa_app.model;

import java.util.List;
import java.util.Map;

public class Horse {

    private List<Double> position;
    private List<Double> velocity;
    private Map<Integer, List<Double>> memory;
    private Double fitness;

    public Horse(List<Double> position, List<Double> velocity, Map<Integer, List<Double>> memory, Double fitness) {
        this.position = position;
        this.velocity = velocity;
        this.memory = memory;
        this.fitness = fitness;
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
}
