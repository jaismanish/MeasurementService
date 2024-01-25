package main.java.temperature;

import main.java.Measurement;
import main.java.Unit;

import java.util.Objects;

public class Temperature extends Measurement<TemperatureUnit> {
    public Temperature(double value, TemperatureUnit unit) {
        super(value, unit);
    }

    @Override
    public double convertToBaseUnit() {
        switch (unit) {
            case CELSIUS:
                return value;
            case FAHRENHEIT:
                return (value - 32) * 5 / 9;
            case KELVIN:
                return value - 273.15;
            default:
                throw new IllegalArgumentException("Invalid temperature unit: " + unit);
        }
    }

    @Override
    public Measurement<TemperatureUnit> add(Measurement<TemperatureUnit> other) {
        throw new UnsupportedOperationException("Cannot add temperatures");
    }

    @Override
    public Measurement<TemperatureUnit> subtract(Measurement<TemperatureUnit> other) {
        throw new UnsupportedOperationException("Cannot subtract temperatures");
    }

    @Override
    protected Class<? extends Unit> getUnitClass() {
        return TemperatureUnit.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature temperature = (Temperature) o;
        return Double.compare(temperature.value, value) == 0 && Objects.equals(unit, temperature.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
