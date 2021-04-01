package org.alexside.examples.java.core.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfPairsWithEvenSumsTask {
    @Test
    public void countOfPairsWithEvenSumsTest() {
        assertEquals(2, countOfPairsWithEvenSums(new int[]{4, 2, 5, 8, 7, 3, 7}));
        assertEquals(1, countOfPairsWithEvenSums(new int[]{14, 21, 16, 35, 22}));
        assertEquals(3, countOfPairsWithEvenSums(new int[]{5, 5, 5, 5, 5, 5}));
    }

    public int countOfPairsWithEvenSums(int[] arr) {
        if (arr.length < 2) return 0;
        int evenPairs = 0;
        for (int i=0; i < arr.length; i += 2) {
            int next = i + 1 >= arr.length ? 0 : i + 1;
            if ((arr[i] + arr[next]) % 2 == 0) {
                evenPairs++;
            }
        }
        return evenPairs;
    }
}
