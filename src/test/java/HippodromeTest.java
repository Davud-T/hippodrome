import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @Test
    void nullException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void emptyException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(Collections.emptyList()));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            horses.add(new Horse("Horse #" + i, i, i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (Horse horse : horses) {
            verify(horse).move();
        }
    }

    @Test
    void getWinner() {
        Horse horse1 = new Horse("1", 1, 11);
        Horse horse2 = new Horse("2", 1, 12);
        Horse horse3 = new Horse("3", 1, 13);
        Horse horse4 = new Horse("4", 1, 14);
        Horse horse5 = new Horse("5", 1, 15);

        List<Horse> horses = Arrays.asList(horse1, horse2, horse3, horse4, horse5);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horse5, hippodrome.getWinner());
    }


}