package br.com.metodosnumericos.CorrelacaodePearson.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.metodosnumericos.CorrelacaodePearson.Resolving;
import br.com.metodosnumericos.Util.Messages;


public class MainInput {

    private Scanner sc = new Scanner(System.in);

    public void All() {
        Resolving resolving = new Resolving();
        List<Double> listX = getList('X', -1);
        resolving.sumAll(listX, getList('Y', listX.size()));
        resolving.calculate(listX.size());
        System.out.println(resolving);
    }

    private List<Double> getList(char option, int size) {
        List<Double> genericList = new ArrayList<>();
        String condition = "";
        System.out.print(Messages.rules);
        int cont = 0;
        while (!condition.equalsIgnoreCase("proximo")) {
            System.out.print("Digite O valor de " + option + ": ");
            String valueNumeric = sc.nextLine();
            condition = valueNumeric;
            if(! valueNumeric.equalsIgnoreCase("proximo")){
                if (option == 'X') {
                    if (isValidDoubleNumeric(valueNumeric)) {
                        genericList.add(Double.parseDouble(valueNumeric));
                    }else System.out.print(Messages.errorMessage);
                }
                if (option == 'Y') {
                    if (isValidDoubleNumeric(valueNumeric)) {
                        genericList.add(Double.parseDouble(valueNumeric));
                        cont++;
                        if (cont == size) {
                            return genericList;
                        }
                    }else System.out.print(Messages.errorMessage);
                }
    
            }
            }
            

        return genericList;
    }

    public static boolean isValidDoubleNumeric(String numeric) {
        try {
            Double.parseDouble(numeric);
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
    }

}
