package main.java.length;

import main.java.Measurement;
import main.java.Unit;

import java.util.Objects;

public class Length extends Measurement<LengthUnit> {
    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    @Override
    public double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    @Override
    public Measurement<LengthUnit> add(Measurement<LengthUnit> other) {
        double resultValue = this.convertToBaseUnit() + other.convertToBaseUnit();
        double ans = resultValue / convertFactor(this.unit);
        return new Length(ans, this.unit);
    }

    @Override
    public Measurement<LengthUnit> subtract(Measurement<LengthUnit> other) {
        double result = this.convertToBaseUnit() - other.convertToBaseUnit();

        if (result < 0) {
            throw new IllegalArgumentException("Resulting length is negative, Invalid subtraction");
        }
        double ans = result / convertFactor(this.unit);
        return new Length(ans, this.unit);
    }

    private double convertFactor(LengthUnit targetUnit) {
        return targetUnit.getConversionFactor();
    }

    @Override
    protected Class<? extends Unit> getUnitClass() {
        return LengthUnit.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.value, value) == 0 && Objects.equals(unit, length.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
