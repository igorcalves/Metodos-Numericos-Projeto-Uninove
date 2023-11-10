package br.com.metodosnumericos.Mocks;

import java.util.ArrayList;
import java.util.List;

public class XYZ {

    public static List<Double> firstLine = new ArrayList<>();
    public static List<Double> secondLine = new ArrayList<>();
    public static List<Double> thirdLine = new ArrayList<>();
    public static List<Double> results = new ArrayList<>();


    public static List<Double> getFirstLine() {
        firstLine.add(1.0);
        firstLine.add(1.0);
        firstLine.add(1.0);
        return firstLine;
    }



    public static List<Double> getSecondLine() {
        secondLine.add(2.0);
        secondLine.add(1.0);
        secondLine.add(-1.0);
        return secondLine;
    }



    public static List<Double> getThirdLine() {
       thirdLine.add(1.0);
       thirdLine.add(-2.0);
       thirdLine.add(2.0);
       return thirdLine;
    }


    public static List<Double> getResults() {
       results.add(7.0);
       results.add(9.0);
       results.add(2.0);
       return results;

       
    }
    }

  



    
    
