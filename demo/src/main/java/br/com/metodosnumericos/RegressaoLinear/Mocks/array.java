package br.com.metodosnumericos.RegressaoLinear.Mocks;

public class array {

    private static double[] listX = new double[4];
    private static double[] listY = new double[4];

    public static double[] getListX(){
        listX[0] = -1;
        listX[1] = -0.1;
        listX[2] = 0.2;
        listX[3] = 1;
        return listX;
    }


    public static double[] getListY(){
        listY[0] = 1;
        listY[1] = 1.099;
        listY[2] = 0.808;
        listY[3] = 1;
        return listY;
    }

    
    
}
