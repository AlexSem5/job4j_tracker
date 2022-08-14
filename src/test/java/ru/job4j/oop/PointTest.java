package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    public void when000and111ThenDistance3d1dot732() {
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(1, 1, 1);
        double rsl = point1.distance3d(point2);
        double expected =  1.7320508075688772;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when010and131ThenDistance3d2dot449() {
        Point point1 = new Point(0, 1, 0);
        Point point2 = new Point(1, 3, 1);
        double rsl = point1.distance3d(point2);
        double expected =  2.449489742783178;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}