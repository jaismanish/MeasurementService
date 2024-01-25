package test.java;

import main.java.volume.Volume;
import main.java.volume.VolumeUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {

    @Test
    void testVolumeWithValidUnitShouldNotThrowException() {
        assertDoesNotThrow(() -> {
            new Volume(10, VolumeUnit.ML);
        });
    }

    @Test
    public void testCompareVolumesInSameUnit() {
        Volume Volume1 = new Volume(100, VolumeUnit.ML);
        Volume Volume2 = new Volume(150, VolumeUnit.ML);

        assertTrue(Volume1.compareTo(Volume2) < 0);
        assertTrue(Volume2.compareTo(Volume1) > 0);
        assertEquals(Volume1, Volume1);
    }


    @Test
    public void testCompareVolumesInDifferentUnits2() {
        Volume Volume1 = new Volume(1000, VolumeUnit.L);
        Volume Volume2 = new Volume(1, VolumeUnit.KL);

        assertEquals(0, Volume1.compareTo(Volume2));
    }

    @Test
    public void testCompareVolumesInDifferentUnits3() {
        Volume Volume1 = new Volume(2000, VolumeUnit.L);
        Volume Volume2 = new Volume(2, VolumeUnit.KL);

        assertEquals(0, Volume1.compareTo(Volume2));
    }

    @Test
    public void testCompareVolumesInDifferentUnits4() {
        Volume Volume1 = new Volume(1500, VolumeUnit.L);
        Volume Volume2 = new Volume(2, VolumeUnit.KL);

        assertTrue(Volume1.compareTo(Volume2) < 0);
    }


    // Test cases for Volume operations

    @Test
    void testCompareSameUnits(){
        Volume Volume1 = new Volume(1, VolumeUnit.L);
        Volume Volume2 = new Volume(2, VolumeUnit.L);
        assertNotEquals(Volume1, Volume2);
    }
    @Test
    void testCompareDiffUnits(){
        Volume Volume1 = new Volume(1, VolumeUnit.KL);
        Volume Volume2 = new Volume(2, VolumeUnit.L);
        assertNotEquals(Volume1, Volume2);
    }

    @Test
    void testAddVolume_SameUnit() {
        Volume Volume1 = new Volume(4, VolumeUnit.ML);
        Volume Volume2 = new Volume(2, VolumeUnit.ML);
        Volume actual = (Volume) Volume1.add(Volume2);
        Volume expected = new Volume(6.0, VolumeUnit.ML);
        assertEquals(expected, actual);
    }

    @Test
    void testSubtractVolume_SameUnit() {
        Volume Volume1 = new Volume(4, VolumeUnit.ML);
        Volume Volume2 = new Volume(2, VolumeUnit.ML);
        Volume actual = (Volume) Volume1.subtract(Volume2);
        Volume expected = new Volume(2.0, VolumeUnit.ML);
        assertEquals(expected,actual);
    }

    @Test
    void testSubtractVolume_SameUnit_InvalidVolume() {
        Volume Volume1 = new Volume(4, VolumeUnit.ML);
        Volume Volume2 = new Volume(6, VolumeUnit.ML);

        assertThrows(IllegalArgumentException.class, () -> {
            Volume1.subtract(Volume2);
        });
    }

    @Test
    void testAddVolume_InDifferentUnit() {
        Volume Volume1 = new Volume(4, VolumeUnit.L);
        Volume Volume2 = new Volume(2, VolumeUnit.ML);
        Volume actual = (Volume) Volume1.add(Volume2);
        Volume expected = new Volume(4.002, VolumeUnit.L);
        assertEquals(expected, actual);
    }
}
