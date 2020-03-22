package com.company;

public class Car {
    private int v0;
    private int x0;
    private int ap;
    private int an;

    public Car(int v0, int x0, int ap, int an) {
        this.v0 = v0;
        this.x0 = x0;
        this.ap = ap;
        this.an = an;
    }


    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getV0() {
        return v0;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public void setV0(int v0) {
        this.v0 = v0;
    }
}
