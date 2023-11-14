package br.com.metodosnumericos.GaussSeidel;

import java.util.List;

import br.com.metodosnumericos.Mocks.XYZ;

public class Resolving {

    double rX = 0;
    double rY = 0;
    double rZ = 0;

    double valuesXYZ [][]= XYZ.getValuesXYZ();

    

    public void isolateAll(double x, double y,double z,int stop,double[][] valuesXYZ,List<Double> XYZ){
        
    final double v1X = XYZ.get(0);
    final double v2X = valuesXYZ[0][1] * -1;
    final double v3X =  valuesXYZ[0][2] * -1;
    final double divX =  valuesXYZ[0][0];

    final double v1Y = XYZ.get(1);
    final double v2Y = valuesXYZ[1][0] * -1;
    final double v3Y = valuesXYZ[1][2] * -1;
    final double divY = valuesXYZ[1][1];

    final double v1Z = XYZ.get(2);
    final double v2Z = valuesXYZ[2][0] * -1;
    final double v3Z = valuesXYZ[2][1] * -1;
    final double divZ = valuesXYZ[2][2];
        
        if(stop == 50 ) return;

        double resultX = 0;
        double resultY = 0;
        double resultZ = 0;



        resultX = (v1X + (v2X * y) + (v3X * z)) / divX;

        resultY = (v1Y + (v2Y * x) + (v3Y * z)) / divY;

        resultZ = (v1Z + (v2Z * x) + (v3Z * y)) / divZ;


        System.out.println(
            "X = " + resultX +
            " Y = " + resultY +
            " Z = " + resultZ +
            " DX = " + String.format("%.15f", (resultX - x))+
            " DY = " + String.format("%.15f", (resultY - y)) +
            " DZ = " + String.format("%.15f", (resultZ - z)));

        stop ++;
        isolateAll(resultX, resultY, resultZ, stop,valuesXYZ,XYZ);
        

    }





    
}
