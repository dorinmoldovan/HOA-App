package com.hoa_app.model;

import java.util.ArrayList;
import java.util.List;

public class Herd {

    private List<Horse> horses;
    private List<Double> center;

    public Herd(Horse horse) {
        this.horses = new ArrayList<Horse>();
        this.horses.add(horse);
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Double> getCenter() {
        return center;
    }

    public void setCenter(List<Double> center) {
        this.center = center;
    }

    public void computeRanks() {
        int k = horses.size();
        for(int i = 0; i < k; i++) {
            int range = 1;
            for(int j = 0; j < k; j++) {
                if(i != j) {
                    if (horses.get(i).getFitness() < horses.get(j).getFitness()) {
                        range++;
                    } else if (horses.get(i).getFitness() == horses.get(j).getFitness()) {
                        if (i < j) {
                            range++;
                        }
                    }
                }
            }
            double rank = range * 1.0 / k;
            horses.get(i).setRank(rank);
        }
    }

    public void computeHerdCenter() {
        center = new ArrayList<>();
        int D = horses.get(0).getD();
        for(int i = 0; i < D; i++) {
            center.add(0.0);
        }
        double denominator = 0.0;
        for(int i = 0; i < horses.size(); i++) {
            denominator = denominator + horses.get(i).getRank();
        }

        for(int j = 0; j < D; j++) {
            double value = 0.0;
            for(int i = 0; i < horses.size(); i++) {
                value = value + horses.get(i).getRank() * horses.get(i).getPosition().get(j) / denominator;
            }
            center.set(j, value);
        }
    }

    public Double computeDistanceToHerd(List<Double> position) {
        double distance = 0.0;

        for(int i = 0; i < position.size(); i++) {
            distance = distance + Math.pow(position.get(i) - this.center.get(i), 2);
        }
        distance = Math.sqrt(2);

        return distance;
    }
}
