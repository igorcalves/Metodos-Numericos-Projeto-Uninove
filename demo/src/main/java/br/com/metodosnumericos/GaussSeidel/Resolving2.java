package br.com.metodosnumericos.GaussSeidel;

import java.util.ArrayList;
import java.util.List;

import br.com.metodosnumericos.Mocks.XYZ2;

public class Resolving2 {

    private List<Double> r = new ArrayList<>();

    double rX = 0;
    double rY = 0;
    double rZ = 0;
    double valuesXYZ[][] = XYZ2.getValuesXYZ();

    final double v1X = XYZ2.getResults().get(0);
    final double v2X = valuesXYZ[0][1] * -1;
    final double v3X = valuesXYZ[0][2] * -1;
    final double divX = valuesXYZ[0][0];

    final double v1Y = XYZ2.getResults().get(1);
    final double v2Y = valuesXYZ[1][0] * -1;
    final double v3Y = valuesXYZ[1][2] * -1;
    final double divY = valuesXYZ[1][1];

    final double v1Z = XYZ2.getResults().get(2);
    final double v2Z = valuesXYZ[2][0] * -1;
    final double v3Z = valuesXYZ[2][1] * -1;
    final double divZ = valuesXYZ[2][2];

    public void run() {
        isolateAll(0.5, 0.5, 0.5, 0);

    }

    public void isolateAll(double x, double y, double z, int stop) {
        if (stop == 9)
            return;

        double resultX = 0;
        double resultY = 0;
        double resultZ = 0;

        resultX = (v1X + (v2X * y) + (v3X * z)) / divX;

        resultY = (v1Y + (v2Y * x) + (v3Y * z)) / divY;

        resultZ = (v1Z + (v2Z * x) + (v3Z * y)) / divZ;

        System.out.println(stop + " " + "X = " + resultX + " Y = " + resultY + " Z = " + resultZ
                + " DX = " + String.format("%.15f", (resultX - x))
                + " DY = " + String.format("%.15f", (resultY - y))
                + " DZ = " + String.format("%.15f", (resultZ - z)));

        stop++;
        isolateAll(resultX, resultY, resultZ, stop);

    }

}
