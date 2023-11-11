package br.com.metodosnumericos.Mocks;


import java.util.ArrayList;
import java.util.List;

public class XYZ2 {

    public static List<Double> results = new ArrayList<>();
    public static double valuesXYZ[][] = {
            { -7, 3, 2 },
            { 1, 3, -1 },
            { 1, 1, -3 }

    };

    public static List<Double> getResults() {
        results.clear();
        results.add(-2.0);
        results.add(3.0);
        results.add(-1.0);
        return results;

    }

    public static double[][] getValuesXYZ() {
        return valuesXYZ;
    }

}
