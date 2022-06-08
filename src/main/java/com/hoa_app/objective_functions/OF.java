package com.hoa_app.objective_functions;

import java.util.List;

public abstract class OF {
    private double minValue;
    private double maxValue;

    public OF(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public abstract double compute(List<Double> values);

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }
}
