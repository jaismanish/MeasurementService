package test.java;

import main.java.length.Length;
import main.java.length.LengthUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    void testLengthWithValidUnitShouldNotThrowException() {
        assertDoesNotThrow(() -> {
            new Length(10, LengthUnit.CM);
        });
    }

    @Test
    public void testCompareLengthsInSameUnit() {
        Length Length1 = new Length(100, LengthUnit.CM);
        Length Length2 = new Length(150, LengthUnit.CM);

        assertTrue(Length1.compareTo(Length2) < 0);
        assertTrue(Length2.compareTo(Length1) > 0);
        assertEquals(Length1, Length1);
    }

    @Test
    public void testCompareLengthsInDifferentUnits() {
        Length Length1 = new Length(100, LengthUnit.CM);
        Length Length2 = new Length(1, LengthUnit.M);

        assertEquals(0, Length1.compareTo(Length2));
    }

    @Test
    public void testCompareLengthsInDifferentUnits2() {
        Length Length1 = new Length(1000, LengthUnit.M);
        Length Length2 = new Length(1, LengthUnit.KM);

        assertEquals(0, Length1.compareTo(Length2));
    }

    @Test
    public void testCompareLengthsInDifferentUnits3() {
        Length Length1 = new Length(2000, LengthUnit.M);
        Length Length2 = new Length(2, LengthUnit.KM);

        assertEquals(0, Length1.compareTo(Length2));
    }

    @Test
    public void testCompareLengthsInDifferentUnits4() {
        Length Length1 = new Length(1500, LengthUnit.M);
        Length Length2 = new Length(2, LengthUnit.KM);

        assertTrue(Length1.compareTo(Length2) < 0);
    }


    // Test cases for Length operations

    @Test
    void testCompareSameUnits(){
        Length Length1 = new Length(1, LengthUnit.M);
        Length Length2 = new Length(2, LengthUnit.M);
        assertNotEquals(Length1, Length2);
    }
    @Test
    void testCompareDiffUnits(){
        Length Length1 = new Length(1, LengthUnit.KM);
        Length Length2 = new Length(2, LengthUnit.M);
        assertNotEquals(Length1, Length2);
    }

    @Test
    void testAddLength_SameUnit() {
        Length Length1 = new Length(4, LengthUnit.CM);
        Length Length2 = new Length(2, LengthUnit.CM);
        Length actual = (Length) Length1.add(Length2);
        Length expected = new Length(6.0, LengthUnit.CM);
        assertEquals(expected, actual);
    }

    @Test
    void testSubtractLength_SameUnit() {
        Length Length1 = new Length(4, LengthUnit.CM);
        Length Length2 = new Length(2, LengthUnit.CM);
        Length actual = (Length) Length1.subtract(Length2);
        Length expected = new Length(2.0, LengthUnit.CM);
        assertEquals(expected,actual);
    }

    @Test
    void testSubtractLength_SameUnit_InvalidLength() {
        Length Length1 = new Length(4, LengthUnit.CM);
        Length Length2 = new Length(6, LengthUnit.CM);

        assertThrows(IllegalArgumentException.class, () -> {
            Length1.subtract(Length2);
        });
    }

    @Test
    void testAddLength_InDifferentUnit() {
        Length Length1 = new Length(4, LengthUnit.M);
        Length Length2 = new Length(2, LengthUnit.CM);
        Length actual = (Length) Length1.add(Length2);
        Length expected = new Length(4.02, LengthUnit.M);
        assertEquals(expected, actual);
    }
}
