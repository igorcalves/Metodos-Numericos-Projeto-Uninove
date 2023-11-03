package br.com.metodosnumericos.RegressaoLinear;

import br.com.metodosnumericos.RegressaoLinear.Mocks.array;
import br.com.metodosnumericos.RegressaoLinear.Resolving.resolving;

public class ZonaTeste {


    public static void main(String[] args) {
        resolving rs = new resolving();

        rs.sumAll(array.getListX(), array.getListY());
        System.out.println(rs);
    }
    
}
