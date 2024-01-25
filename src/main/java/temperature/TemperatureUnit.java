package main.java.temperature;

import main.java.Unit;

public enum TemperatureUnit implements Unit{
    CELSIUS,
    FAHRENHEIT,
    KELVIN;

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

}
