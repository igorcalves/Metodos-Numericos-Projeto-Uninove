package br.com.metodosnumericos.Mocks;

import java.util.ArrayList;
import java.util.List;

public class XYZ {

   public static double valuesXYZ[][] = {
    {3,-1,1},
    {1,3,0},
    {2,1,-2}
   };
    public static List<Double> results = new ArrayList<>();



    public static List<Double> getResults() {
       results.add(5.0);
       results.add(7.0);
       results.add(-4.0);
       return results;

       
    }



    public static double[][] getValuesXYZ() {
        return valuesXYZ;
    }


    
    }

  



    
    
