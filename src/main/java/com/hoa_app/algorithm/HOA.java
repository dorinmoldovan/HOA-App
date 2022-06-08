package com.hoa_app.algorithm;

import com.hoa_app.objective_functions.OF;

public class HOA {

    private int N;
    private int I;
    private int D;
    private int DSP;
    private int SSP;
    private int HDR;
    private int HMP;
    private int M;
    private OF of;

    public HOA(int n, int i, int d, int DSP, int SSP, int HDR, int HMP, int m, OF of) {
        N = n;
        I = i;
        D = d;
        this.DSP = DSP;
        this.SSP = SSP;
        this.HDR = HDR;
        this.HMP = HMP;
        M = m;
        this.of = of;
    }

    public Result run() {
        Result result = new Result();

        for(int i = 0; i < I; i++) {
            result.setLogs(result.getLogs() + "  Iteration " + (i + 1) + "\n");
        }

        return result;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getI() {
        return I;
    }

    public void setI(int i) {
        I = i;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getDSP() {
        return DSP;
    }

    public void setDSP(int DSP) {
        this.DSP = DSP;
    }

    public int getSSP() {
        return SSP;
    }

    public void setSSP(int SSP) {
        this.SSP = SSP;
    }

    public int getHDR() {
        return HDR;
    }

    public void setHDR(int HDR) {
        this.HDR = HDR;
    }

    public int getHMP() {
        return HMP;
    }

    public void setHMP(int HMP) {
        this.HMP = HMP;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public OF getOf() {
        return of;
    }

    public void setOf(OF of) {
        this.of = of;
    }
}
