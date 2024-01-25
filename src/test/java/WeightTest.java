package test.java;

import main.java.weight.Weight;
import main.java.weight.WeightUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeightTest {

    @Test
    public void testCompareWeightsInSameUnit() {
        Weight weight1 = new Weight(100, WeightUnit.G);
        Weight weight2 = new Weight(150, WeightUnit.G);

        assertTrue(weight1.compareTo(weight2) < 0);
        assertTrue(weight2.compareTo(weight1) > 0);
        assertEquals(1, weight2.compareTo(weight1));
    }

    @Test
    public void testCompareWeightsInDifferentUnits() {
        Weight weight1 = new Weight(100, WeightUnit.G);
        Weight weight2 = new Weight(150, WeightUnit.KG);

        assertTrue(weight1.compareTo(weight2) < 0);
        assertTrue(weight2.compareTo(weight1) > 0);
        assertEquals(0, weight1.compareTo(weight1));
    }

    @Test
    public void testCompareWeightsInDifferentUnits2() {
        Weight weight1 = new Weight(1000, WeightUnit.G);
        Weight weight2 = new Weight(1, WeightUnit.KG);

        assertTrue(weight1.compareTo(weight2) == 0);
    }

    @Test
    public void testCompareWeightsInDifferentUnits3() {
        Weight weight1 = new Weight(2000, WeightUnit.G);
        Weight weight2 = new Weight(2, WeightUnit.KG);

        assertTrue(weight1.compareTo(weight2) == 0);
    }

    @Test
    public void testCompareWeightsInDifferentUnits4() {
        Weight weight1 = new Weight(1500, WeightUnit.G);
        Weight weight2 = new Weight(2, WeightUnit.KG);

        assertTrue(weight1.compareTo(weight2) < 0);
    }

    @Test
    void testCompareSameUnits_ShouldReturnFalse() {
        Weight weight1 = new Weight(1, WeightUnit.G);
        Weight weight2 = new Weight(2, WeightUnit.G);
        assertFalse( weight1.equals(weight2));
    }

    @Test
    void testCompareDiffUnits_ShouldReturnFalse() {
        Weight weight1 = new Weight(1, WeightUnit.KG);
        Weight weight2 = new Weight(2, WeightUnit.G);
        assertThrows(AssertionError.class, () -> assertEquals(weight1, weight2));
    }

    @Test
    void testAddWeight_SameUnit() {
        Weight weight1 = new Weight(4, WeightUnit.G);
        Weight weight2 = new Weight(2, WeightUnit.G);
        Weight actual = (Weight) weight1.add(weight2);
        Weight expected = new Weight(6.0, WeightUnit.G);
        assertEquals(expected, actual);
    }

    @Test
    void testSubtractWeight_SameUnit() {
        Weight weight1 = new Weight(4, WeightUnit.G);
        Weight weight2 = new Weight(2, WeightUnit.G);
        Weight actual = (Weight) weight1.subtract(weight2);
        Weight expected = new Weight(2.0, WeightUnit.G);
        assertEquals(expected, actual);
    }

    @Test
    void testSubtractWeight_SameUnit_InvalidWeight() {
        Weight weight1 = new Weight(4, WeightUnit.G);
        Weight weight2 = new Weight(6, WeightUnit.G);

        assertThrows(IllegalArgumentException.class, () -> {
            weight1.subtract(weight2);
        });
    }
    @Test
    void testSubtractWeight_DiffUnit_InvalidWeight() {
        Weight weight1 = new Weight(4, WeightUnit.G);
        Weight weight2 = new Weight(6, WeightUnit.KG);

        assertThrows(IllegalArgumentException.class, () -> {
            weight1.subtract(weight2);
        });
    }

    @Test
    void testAddWeight_InDifferentUnit() {
        Weight weight1 = new Weight(4, WeightUnit.KG);
        Weight weight2 = new Weight(2, WeightUnit.G);
        Weight actual = (Weight) weight1.add(weight2);
        Weight expected = new Weight(4.002, WeightUnit.KG);
        assertEquals(expected, actual);
    }
}
