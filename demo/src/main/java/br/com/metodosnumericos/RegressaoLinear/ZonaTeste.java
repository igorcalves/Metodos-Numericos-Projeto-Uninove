package br.com.metodosnumericos.RegressaoLinear;

import java.util.List;

import br.com.metodosnumericos.RegressaoLinear.Mocks.array;
import br.com.metodosnumericos.RegressaoLinear.Resolving.resolving;

public class ZonaTeste {


    public static void main(String[] args) {
        resolving rs = new resolving();
        List<Double> testeX = array.getListX();
        List<Double> testeY = array.getListY();
        rs.sumAll(testeX, testeY);
        rs.firstFormula(testeX.size());
        System.out.println(rs.resultFirstFOrmula());
        System.out.println(testeX.size());
    }
    
}
