package main.java.length;

import main.java.Unit;

public enum LengthUnit implements Unit {
    CM(0.01),
    MM(0.001),
    M(1.0),
    KM(1000.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}
