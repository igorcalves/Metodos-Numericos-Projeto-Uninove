package br.com.metodosnumericos.Cramer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.metodosnumericos.Util.Messages;

public class MainInput {
    private Scanner sc = new Scanner(System.in);
    private double valuesXYZ[][] = new double[3][3];
    private double matrizResults[] = new double[3];

    public void all() {

        System.out.println(Messages.rulesGaus);

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "º" + " Linha");
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor de x" + (j + 1) + ": ");
                String value = sc.nextLine();

                while (isValidDoubleNumeric(value) != true) {
                    System.out.println(Messages.errorMessage);
                    System.out.print("Digite o valor de x" + (j + 1) + ": ");
                    value = sc.nextLine();
                }
                valuesXYZ[i][j] = Double.parseDouble(value);

            }
            System.out.print("Digite o resultado da " + (i + 1) + "º linha: ");
            String value = sc.nextLine();
            while (isValidDoubleNumeric(value) != true) {
                System.out.println(Messages.errorMessage);
                System.out.print("Digite o resultado da " + (i + 1) + "º linha: ");
                value = sc.nextLine();
            }
            matrizResults[i] = Double.parseDouble(value);
        }
        sc.close();
        showVector(valuesXYZ);
        Resolving rs = new Resolving(valuesXYZ, matrizResults);

    }

    public static boolean isValidDoubleNumeric(String numeric) {
        try {
            Double.parseDouble(numeric);
            return true;
        } catch (NumberFormatException e) {

            return false;
        }
    }

    public void showVector(double[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.print(" " + values[i][j] + "X" + (j + 1) + " = " + matrizResults[i]);
            }
            System.out.println();
        }
    }

}