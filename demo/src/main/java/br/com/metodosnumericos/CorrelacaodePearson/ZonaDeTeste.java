package br.com.metodosnumericos.CorrelacaodePearson;

import java.util.ArrayList;
import java.util.List;

import br.com.metodosnumericos.CorrelacaodePearson.Input.MainInput;
import br.com.metodosnumericos.Util.Mocks.array;

public class ZonaDeTeste {

    public static void main(String[] args) {

        Resolving rs = new Resolving();

        rs.sumAll(array.getListX(), array.getListY());

        rs.calculate(15);
        System.out.println(rs);
    }
    
}
