package __cpu__;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CPU {

    /**
     * Add -Xmx8192m
     * Add -Xmx12000m
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        // double[] doubles = random.doubles(-10, 10).limit(100_000_000).toArray();
        List<Double> doubles = random.doubles(-10, 10).limit(300_000_000).boxed().collect(Collectors.toList());

        System.out.println(Runtime.getRuntime().freeMemory());
        Doubt doubter = new Doubt();
        System.out.println(doubter.add(doubles));
        System.out.println(Runtime.getRuntime().freeMemory());
    }

}

strictfp class Doubt {
    public double add(double... doubles) {
        double result = 0;
        if (doubles == null) {
            return result;
        }
        for (double d : doubles) {
            result += d;
        }
        return result;
    }

    public double add(List<Double> doubles) {
        double result = 0;
        if (doubles == null) {
            return result;
        }
        for (double d : doubles) {
            result += d;
        }
        return result;
    }
}
