package net.thumbtack.school.matrix;

import java.util.*;
import java.util.stream.Collectors;

public class MatrixNonSimilarRows {
    private List<int[]> matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = new ArrayList<>();
        this.matrix.addAll(Arrays.asList(matrix));
    }

    public List<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> matrixToCopy = new HashMap<>();
        for (int[] array : this.matrix) {
            matrixToCopy.put(new HashSet<>(Arrays.stream(array).boxed().collect(Collectors.toSet())), array);
        }
        return new ArrayList<>(matrixToCopy.values());
    }
}

