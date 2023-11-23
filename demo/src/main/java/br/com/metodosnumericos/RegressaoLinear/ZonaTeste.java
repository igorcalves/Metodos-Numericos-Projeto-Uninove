package br.com.metodosnumericos.RegressaoLinear;

import java.util.ArrayList;
import java.util.List;

import br.com.metodosnumericos.GaussSeidel.Resolving;
import br.com.metodosnumericos.Util.Mocks.XYZ;
import br.com.metodosnumericos.Util.Mocks.array;


public class ZonaTeste {


    public static void main(String[] args) {
        Resolving rs = new Resolving();

        rs.isolateAll(0, 0, 0,0,XYZ.getValuesXYZ(),XYZ.getResults());
  
    }
    
    
}
