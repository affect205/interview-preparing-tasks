package org.alexside.examples.java.core.test;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfWeightsOfGraphEdgesTask {
    @Test
    public void sumOfWeightsOfGraphEdgesTest() {
        assertEquals(31, sumOfWeightsOfGraphEdges(5, new int[]{2, 2, 1, 4}, new int[]{1, 3, 4, 4}));
        assertEquals(5,  sumOfWeightsOfGraphEdges(3, new int[]{1}, new int[]{3}));
        assertEquals(10, sumOfWeightsOfGraphEdges(4, new int[]{1, 3}, new int[]{2, 4}));
    }

    public int sumOfWeightsOfGraphEdges(int n, int[] a, int[] b) {
        int[] graphValues = new int[n+1];
        for (int i=0; i < a.length; ++i) {
            graphValues[a[i]]++; graphValues[b[i]]++;
        }
        var valuer = new AtomicInteger(1);
        Map<Integer, Integer> graphValuesMap = IntStream
                .range(1, graphValues.length)
                .mapToObj(ndx -> new int[]{ndx, graphValues[ndx]})
                .sorted(comparingInt(arr -> arr[1]))
                .collect(toMap(arr -> arr[0], arr -> valuer.getAndIncrement(), (v1, v2) -> v1, LinkedHashMap::new));
        int sumOfEdgeWeights = 0;
        for (int i=0; i < a.length; ++i) {
            sumOfEdgeWeights += (graphValuesMap.getOrDefault(a[i], 0) + graphValuesMap.getOrDefault(b[i], 0));
        }
        return sumOfEdgeWeights;
    }
}