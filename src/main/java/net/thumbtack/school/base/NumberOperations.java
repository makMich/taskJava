package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {

    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        return null;
    }


    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(value - array[i]) <= eps) {
                return i;
            }
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        Double density = weight / volume;
        if (density >= min && density <= max) {
            return density;
        }
        return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        BigDecimal density = weight.divide(volume);
        return density.compareTo(min) > 0 && density.compareTo(max) < 0 ? density : null;
    }


}

