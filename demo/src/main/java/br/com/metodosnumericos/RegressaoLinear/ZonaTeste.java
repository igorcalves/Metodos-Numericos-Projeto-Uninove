package br.com.metodosnumericos.RegressaoLinear;

import java.util.ArrayList;
import java.util.List;

import br.com.metodosnumericos.Mocks.array;
import br.com.metodosnumericos.RegressaoLinear.Input.MainInput;
import br.com.metodosnumericos.RegressaoLinear.Resolving.Resolving;

public class ZonaTeste {


    public static void main(String[] args) {
        List<Double> listX = new ArrayList<>();
        listX = array.getListX();

        Resolving rs = new Resolving();
        rs.sumAll(listX, array.getListY());
        rs.firstFormula(listX.size());
        System.out.println(rs.resultFirstFOrmula());
    }
    
}
