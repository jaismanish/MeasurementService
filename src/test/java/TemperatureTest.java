package test.java;

import main.java.temperature.Temperature;
import main.java.temperature.TemperatureUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void testTemperatureWithValidUnitShouldNotThrowException() {
        assertDoesNotThrow(() -> new Temperature(25, TemperatureUnit.CELSIUS));
    }

//    @Test
//    void testTemperatureConversionToCelsius() {
//        Temperature fahrenheitTemperature = new Temperature(32, TemperatureUnit.FAHRENHEIT);
//        assertEquals(0, fahrenheitTemperature.convertToCelsius(), 0.001);
//
//        Temperature kelvinTemperature = new Temperature(273.15, TemperatureUnit.KELVIN);
//        assertEquals(0, kelvinTemperature.convertToCelsius(), 0.001);
//    }

    @Test
    void testInvalidTemperatureCreation_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Temperature(25, null));
    }

    @Test
    void testTemperatureComparison() {
        Temperature celsiusTemperature = new Temperature(25, TemperatureUnit.CELSIUS);
        Temperature fahrenheitTemperature = new Temperature(77.01, TemperatureUnit.FAHRENHEIT);

        assertTrue(celsiusTemperature.compareTo(fahrenheitTemperature) < 0);
        assertTrue(fahrenheitTemperature.compareTo(celsiusTemperature) > 0);
        assertEquals(0, celsiusTemperature.compareTo(new Temperature(25, TemperatureUnit.CELSIUS)));
    }
}
