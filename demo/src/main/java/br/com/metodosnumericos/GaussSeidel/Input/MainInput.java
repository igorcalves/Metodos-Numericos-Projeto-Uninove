package br.com.metodosnumericos.GaussSeidel.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.metodosnumericos.GaussSeidel.Resolving;
import br.com.metodosnumericos.Util.Messages;

public class MainInput {
    Scanner sc = new Scanner(System.in);
    public static double valuesXYZ[][] = new double[3][3];
    Resolving rs = new Resolving();
    public static List<Double> results = new ArrayList<>();



    public void all(){

        System.out.println(Messages.rulesGaus);
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "º" + " Linha");
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor de x" + (j+1) +": ");
                String value = sc.nextLine();

                while (isValidDoubleNumeric(value) != true) {
                    System.out.println(Messages.errorMessage);
                    System.out.print("Digite o valor de x" + (j+1) +": ");
                    value = sc.nextLine();
                }
                valuesXYZ[i][j] = Double.parseDouble(value);
        
            }
            System.out.print("Digite o resultado da " + (i +1) +"º linha: ");
                String value = sc.nextLine();
                while (isValidDoubleNumeric(value) != true) {
                    System.out.println(Messages.errorMessage);
                    System.out.print("Digite o resultado da " + (i +1) +"º linha: ");
                    value = sc.nextLine();
                }
                results.add(Double.parseDouble(value));
            System.out.println();
        }
   

        List<Double> defaultXYZ = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String value = "";
            System.out.println("Digite os valores default de X Y Z");
            System.out.print((1+i) + "º" + " Valor : ");
            value = sc.nextLine();
             while (isValidDoubleNumeric(value) != true) {
                System.out.println(Messages.errorMessage);
                System.out.print((i +1) +"º" +  " Valor: ");
                value = sc.nextLine();
 }            
        defaultXYZ.add(Double.parseDouble(value));
        }
        sc.close();
        showVector(valuesXYZ);
        rs.isolateAll(defaultXYZ.get(0), defaultXYZ.get(1), defaultXYZ.get(2), 0, valuesXYZ, results);


 
    }



    public static boolean isValidDoubleNumeric(String numeric) {
        try {
            Double.parseDouble(numeric);
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
    }

    public void showVector(double[][] values){
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.print(" "+values[i][j]+"X"+(j+1) + " = " + results.get(i));
            }
            System.out.println();
        }
    }
    
}
