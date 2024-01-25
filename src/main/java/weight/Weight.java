package main.java.weight;

import main.java.Measurement;
import main.java.Unit;

import java.util.Objects;

public class Weight extends Measurement<WeightUnit> {
    public Weight(double value, WeightUnit unit) {
        super(value, unit);
    }

    @Override
    public double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    @Override
    public Measurement<WeightUnit> add(Measurement<WeightUnit> other) {
        double resultValue = this.convertToBaseUnit() + other.convertToBaseUnit();
        double ans = resultValue / convertFactor(this.unit);
        return new Weight(ans, this.unit);
    }

    @Override
    public Measurement<WeightUnit> subtract(Measurement<WeightUnit> other) {
        double result = this.convertToBaseUnit() - other.convertToBaseUnit();

        if (result < 0) {
            throw new IllegalArgumentException("Resulting weight is negative, Invalid subtraction");
        }
        double ans = result / convertFactor(this.unit);
        return new Weight(ans, this.unit);
    }

    private double convertFactor(WeightUnit targetUnit) {
        return targetUnit.getConversionFactor();
    }

    @Override
    protected Class<? extends Unit> getUnitClass() {
        return WeightUnit.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return Double.compare(weight.value, value) == 0 && Objects.equals(unit, weight.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
