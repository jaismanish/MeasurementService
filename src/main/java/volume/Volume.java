package main.java.volume;

import main.java.Measurement;
import main.java.Unit;

import java.util.Objects;

public class Volume extends Measurement<VolumeUnit> {
    public Volume(double value, VolumeUnit unit) {
        super(value, unit);
    }

    @Override
    public double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    @Override
    public Measurement<VolumeUnit> add(Measurement<VolumeUnit> other) {
        double resultValue = this.convertToBaseUnit() + other.convertToBaseUnit();
        double ans = resultValue / convertFactor(this.unit);
        return new Volume(ans, this.unit);
    }

    @Override
    public Measurement<VolumeUnit> subtract(Measurement<VolumeUnit> other) {
        double result = this.convertToBaseUnit() - other.convertToBaseUnit();

        if (result < 0) {
            throw new IllegalArgumentException("Resulting volume is negative, Invalid subtraction");
        }
        double ans = result / convertFactor(this.unit);
        return new Volume(ans, this.unit);
    }

    private double convertFactor(VolumeUnit targetUnit) {
        return targetUnit.getConversionFactor();
    }

    @Override
    protected Class<? extends Unit> getUnitClass() {
        return VolumeUnit.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return Double.compare(volume.value, value) == 0 && Objects.equals(unit, volume.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
