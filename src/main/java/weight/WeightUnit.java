package main.java.weight;

import main.java.Unit;

public enum WeightUnit implements Unit {
    G(1.0),
    KG(1000.0),
    MG(0.0001);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}
