package br.com.metodosnumericos.RegressaoLinear.Input;

import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.metodosnumericos.RegressaoLinear.Resolving.Resolving;
import br.com.metodosnumericos.RegressaoLinear.Util.Messages;

public class MainInput {

    private Scanner sc = new Scanner(System.in);

    public void All(){
        Resolving resolving = new Resolving();
        List<Double> listX =getList('X');
        resolving.sumAll(listX, getList('Y'));
        resolving.firstFormula(listX.size());
        System.out.println(resolving.resultFirstFOrmula());
    }


     private List<Double> getList(char option) {
        List<Double> genericList = new ArrayList<>();
        String condition = "";
        System.out.print(Messages.rules);
        while (!condition.equalsIgnoreCase("proximo")) {
            System.out.print("Digite O valor de"+option+": ");
            String valueNumeric = sc.nextLine();
            if(isValidDoubleNumeric(valueNumeric)){
                genericList.add(Double.parseDouble(valueNumeric));

            }else {
                condition = valueNumeric;
                System.out.print(Messages.errorMessage);
            }
            
        }
        return genericList;
     }


     public static boolean isValidDoubleNumeric(String numeric){
        try {
             Double.parseDouble(numeric);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
     }



}
