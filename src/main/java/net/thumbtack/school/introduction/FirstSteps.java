package net.thumbtack.school.introduction;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FirstSteps {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return (xLeft <= x && x <= xRight) && (yTop <= y && y <= yBottom);
    }

    public int sum(int[] array) {
        return IntStream.of(array).sum();
    }

    public int mul(int[] array) {
        int total = 1;
        if (array.length == 0) {
            return 0;
        }
        for (int element : array) {
            total *= element;
        }
        return total;
    }

    public int min(int[] array) {
        if (array.length == 0) {
            return Integer.MAX_VALUE;
        }
        return Arrays.stream(array).min().getAsInt();
    }

    public int max(int[] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        return Arrays.stream(array).max().getAsInt();
    }

    public double average(int[] array) {
        if (array.length == 0) {
            return 0.0;
        }
        return IntStream.of(array).average().getAsDouble();
    }

    public boolean isSortedDescendant(int[] array) {
        if (array.length == 0) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        int temp;
        for (int i = 0; i <= array.length / 2 - 1; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        if (array.length == 0) {
            return true;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] element : matrix) {
            sum += sum(element);
        }
        return sum;
    }

    public int max(int[][] matrix) {
        if (matrix.length == 1) {
            return Integer.MIN_VALUE;
        }
        int temp;
        int max = matrix[0][0];
        for (int[] element : matrix) {
            temp = max(element);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        if (matrix.length == 0) {
            return max;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > max) {
                max = matrix[i][i];
            }
        }
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] element : matrix) {
            if (!isSortedDescendant(element)) {
                return false;
            }
        }
        return true;
    }
}
