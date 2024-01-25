package main.java;

public abstract class Measurement<T extends Unit> implements Comparable<Measurement<T>> {
    protected final double value;
    protected final T unit;

    public Measurement(double value, T unit) {
        if (unit == null || !unit.getClass().equals(getUnitClass())) {
            throw new IllegalArgumentException("Invalid unit: " + unit);
        }
        this.value = value;
        this.unit = unit;
    }

    public abstract double convertToBaseUnit();

    @Override
    public int compareTo(Measurement<T> other) {
        if (this.unit == other.unit) {
            return Double.compare(this.value, other.value);
        } else {
            double firstInBaseUnit = this.convertToBaseUnit();
            double secondInBaseUnit = other.convertToBaseUnit();
            return Double.compare(firstInBaseUnit, secondInBaseUnit);
        }
    }

    public abstract Measurement<T> add(Measurement<T> other);

    public abstract Measurement<T> subtract(Measurement<T> other);

    protected abstract Class<? extends Unit> getUnitClass();
}
