package org.alexside.examples.java.core.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsToAlignTask {
    @Test
    public void stepToAlignTest() {
        assertEquals(5, stepsToAlign(new int[]{3, 2, 1, 1, 2, 3, 1}));
        assertEquals(6, stepsToAlign(new int[]{4, 1, 4, 1}));
        assertEquals(0, stepsToAlign(new int[]{3, 3, 3}));
    }

    public int stepsToAlign(int[] arr) {
        final int mean = Arrays
                .stream(arr)
                .average()
                .stream()
                .mapToInt(d -> (int)Math.ceil(d))
                .sum();
        return Arrays
                .stream(arr)
                .reduce(0, (sum, cur)  -> sum + Math.abs(mean - cur));
    }
}