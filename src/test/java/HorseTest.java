import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class HorseTest {

    @Test
    void nullNameException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 1));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\n"})
    void blankNameException(String invalidName) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(invalidName, 1, 1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void NegativeSpeedException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Pegasus", -1, 1));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void NegativeDistanceException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Pegasus", 1, -1));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName() {
        Horse horse = new Horse("Pegasus", 1, 1);
        String name = horse.getName();
        assertEquals("Pegasus", name);
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("Pegasus", 1, 1);
        double speed = horse.getSpeed();
        assertEquals(1, speed);
    }

    @Test
    void getDistance() {
        Horse horse = new Horse("Pegasus", 1, 1);
        double distance = horse.getDistance();
        assertEquals(1, distance);
    }

    @Test
    void getZeroDistance() {
        Horse horse = new Horse("Pegasus", 1);
        double distance = horse.getDistance();
        assertEquals(0, distance);
    }

    @Test
    void moveTest() {
        Horse horse = new Horse("Pegasus", 1, 1);
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)) {
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }




}