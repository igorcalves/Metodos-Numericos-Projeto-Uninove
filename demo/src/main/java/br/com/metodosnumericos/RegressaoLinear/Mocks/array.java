package br.com.metodosnumericos.RegressaoLinear.Mocks;

public class array {

    private static double[] listX = new double[6];
    private static double[] listY = new double[6];

    public static double[] getListX(){
        listX[0] = 1;
        listX[1] = 2;
        listX[2] = 3;
        listX[3] = 4;
        listX[4] = 5;
        listX[5] = 6;


        return listX;
    }


    public static double[] getListY(){
        listY[0] = 80.5;
        listY[1] = 81.6;
        listY[2] = 82.1;
        listY[3] = 83.7;
        listY[4] = 83.9;
        listY[5] = 85;
        return listY;
    }

    
    
}
