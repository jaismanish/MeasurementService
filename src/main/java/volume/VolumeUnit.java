package main.java.volume;

import main.java.Unit;

public enum VolumeUnit implements Unit {
    KL(1000),
    L(1),
    ML(0.001);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}
