package com.hoa_app.algorithm;

import com.hoa_app.model.*;
import com.hoa_app.objective_functions.OF;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
    private Random rand;

    public HOA(int n, int i, int d, int DSP, int SSP, int HDR, int HMP, int m, double vMin, double vMax, double sd, OF of) {
        this.N = n;
        this.I = i;
        this.D = d;
        this.DSP = DSP;
        this.SSP = SSP;
        this.HDR = HDR;
        this.HMP = HMP;
        this.M = m;
        this.of = of;
        this.vMin = vMin;
        this.vMax = vMax;
        this.sd = sd;
        this.rand = new Random(System.currentTimeMillis());
    }

    public List<Horse> generatePopulation() {
        List<Horse> population = new ArrayList<Horse>();
        for(int i = 0; i < this.N; i++) {
            Horse horse = new Horse(rand, this.D, this.HMP, of.getMinValue(), of.getMaxValue(), this.vMin, this.vMax);
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

        int noDominantStallions = (N * DSP) / 100;
        int noSingleStallions = (N * SSP) / 100;
        int noDistributedHorses = (N * HDR) / 100;

        List<Herd> herds = new ArrayList<>();
        List<Horse> singleStallions = new ArrayList<>();

        for(int i = 0; i < I; i++) {
            if((i % M) == 0) {

                population.sort(new Comparator<Horse>() {
                    @Override
                    public int compare(Horse o1, Horse o2) {
                        return o1.getFitness().compareTo(o2.getFitness());
                    }
                });

                herds = new ArrayList<>();
                singleStallions = new ArrayList<>();
                List<Horse> distributedHorses = new ArrayList<>();

                for(int j = 0; j < population.size(); j++) {
                    if(j < noDominantStallions) {
                        Horse leaderStallion = population.get(j);
                        Herd herd = new Herd(leaderStallion);
                        herds.add(herd);
                    } else if(j < (noDominantStallions + noSingleStallions)) {
                        Horse singleStallion = population.get(j);
                        singleStallions.add(singleStallion);
                    } else if(j >= N - noDistributedHorses) {
                        Horse distributedHorse = population.get(j);
                        distributedHorses.add(distributedHorse);
                    } else {
                        int herdIndex = rand.nextInt(herds.size());
                        herds.get(herdIndex).getHorses().add(population.get(j));
                    }
                }

                for(int j = 0; j < distributedHorses.size(); j++) {
                    List<Double> position = new ArrayList<Double>();
                    for(int k = 0; k < this.D; k++) {
                        double value = (of.getMaxValue() - of.getMinValue()) * rand.nextDouble() + of.getMinValue();
                        position.add(value);
                    }
                    double fitness = of.compute(position);
                    distributedHorses.get(j).setPosition(position);
                    distributedHorses.get(j).setFitness(fitness);
                    if(fitness < gBest.getFitness()) {
                        gBest = (Horse) SerializationUtils.clone(distributedHorses.get(j));
                    }
                }
            }

            for(int j = 0; j < population.size(); j++) {
                population.get(j).setRank(0.0);
            }

            for(int j = 0; j < herds.size(); j++) {
                herds.get(j).computeRanks();
            }

            for(int j = 0; j < herds.size(); j++) {
                herds.get(j).computeHerdCenter();
            }

            for(int j = 0; j < herds.size(); j++) {
                for(int k = 0; k < herds.get(j).getHorses().size(); k++) {
                    Horse currentHorse = herds.get(j).getHorses().get(k);
                    currentHorse.computeVelocity(herds.get(j).getCenter(), currentHorse.getRank());
                }
            }

            for(int j = 0; j < singleStallions.size(); j++) {
                Horse currentHorse = singleStallions.get(j);
                int nearestHerdIndex = 0;
                double distanceToNearestHerd = herds.get(0).computeDistanceToHerd(currentHorse.getPosition());
                for(int k = 1; k < herds.size(); k++) {
                    double distanceToHerd = herds.get(k).computeDistanceToHerd(currentHorse.getPosition());
                    if(distanceToHerd < distanceToNearestHerd) {
                        distanceToNearestHerd = distanceToHerd;
                        nearestHerdIndex = k;
                    }
                }
                currentHorse.computeVelocity(herds.get(nearestHerdIndex).getCenter(), rand.nextDouble());
            }

            for(int j = 0; j < population.size(); j++) {
                Horse currentHorse = population.get(j);
                currentHorse.computePosition();
            }

            for(int j = 0; j < population.size(); j++) {
                Horse currentHorse = population.get(j);
                currentHorse.computeMemory(sd);
            }

            for(int j = 0; j < population.size(); j++) {
                Horse currentHorse = population.get(j);
                List<Double> position = population.get(j).getPosition();
                double fitness = this.of.compute(currentHorse.getPosition());
                for(int k = 0; k < currentHorse.getMemory().keySet().size(); k++) {
                    List<Double> memoryRow = currentHorse.getMemory().get(k);
                    double memFitness = this.of.compute(memoryRow);
                    if(memFitness < fitness) {
                        fitness = memFitness;
                        position = memoryRow;
                    }
                }
                currentHorse.setFitness(fitness);
                currentHorse.setPosition(position);

                if(fitness < gBest.getFitness()) {
                    gBest = (Horse) SerializationUtils.clone(currentHorse);
                }
            }

            for(int j = 0; j < population.size(); j++) {
                population.get(j).setRank(0.0);
            }

            for(int j = 0; j < herds.size(); j++) {
                herds.get(j).computeRanks();
            }

            for(int j = 0; j < herds.size(); j++) {
                herds.get(j).computeHerdCenter();
            }

            for(int j = 0; j < singleStallions.size(); j++) {
                Horse currentHorse = singleStallions.get(j);
                int nearestHerdIndex = 0;
                double distanceToNearestHerd = herds.get(0).computeDistanceToHerd(currentHorse.getPosition());
                for(int k = 1; k < herds.size(); k++) {
                    double distanceToHerd = herds.get(k).computeDistanceToHerd(currentHorse.getPosition());
                    if(distanceToHerd < distanceToNearestHerd) {
                        distanceToNearestHerd = distanceToHerd;
                        nearestHerdIndex = k;
                    }
                }
                Horse nearestHerdStallion = herds.get(nearestHerdIndex).getHorses().get(0);
                if(currentHorse.getFitness() < nearestHerdStallion.getFitness()) {
                    Horse currentHorseClone = (Horse) SerializationUtils.clone(currentHorse);
                    Horse nearestHerdStallionClone = (Horse) SerializationUtils.clone(nearestHerdStallion);
                    nearestHerdStallion = currentHorseClone;
                    currentHorse = nearestHerdStallionClone;
                }
            }

            result.setLogs(result.getLogs() + "  Iteration " + (i + 1) + "\n");
            result.setLogs(result.getLogs() + "  GBest = " + gBest.getFitness() + "\n");
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

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }
}
