package br.com.metodosnumericos.Mocks;

import java.util.ArrayList;
import java.util.List;

public class array {


    private static List<Double> listX = new ArrayList<>();
    private static List<Double> listY = new ArrayList<>();

    public static List<Double> getListX(){
        listX.add(2.0);
        listX.add(2.0);
        listX.add(2.0);
        listX.add(2.0);
        listX.add(2.0);
        listX.add(3.0);
        listX.add(3.0);
        listX.add(3.0);
        listX.add(3.0);
        listX.add(3.0);
        listX.add(3.0);
        listX.add(4.0);
        listX.add(4.0);
        listX.add(4.0);
        listX.add(4.0);
        return listX;
    }


    public static List<Double> getListY(){
        listY.add(5.0);
        listY.add(8.0);
        listY.add(8.0);
        listY.add(7.0);
        listY.add(9.0);
        listY.add(7.0);
        listY.add(9.0);
        listY.add(8.0);
        listY.add(9.0);
        listY.add(10.0);
        listY.add(10.0);
        listY.add(11.0);
        listY.add(10.0);
        listY.add(12.0);
        listY.add(9.0);
        
        return listY;
    }

    
    
}
