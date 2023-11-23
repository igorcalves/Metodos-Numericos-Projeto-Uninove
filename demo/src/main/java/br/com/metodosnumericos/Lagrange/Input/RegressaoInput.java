package br.com.igor.app.Lagrange.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.igor.app.Lagrange.Objetos.fx;
import br.com.igor.app.Lagrange.Objetos.x;
import br.com.igor.app.RegressaoLinear.resolving;

public class RegressaoInput {

    resolving rs = new resolving();

    private List<Double> listX = new ArrayList<>();

    private List<Double> listY = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public void atomicCreate() {
        addValuesInListX();
        addValuesInListY();
        showListx();
        sc.close();
        rs.atomicCreate(listX, listY);
    }

    public void addValuesInListX() {
        x valueOfX = new x("");
        System.out.print("Digite o valor de (X) ou 'proximo' para digitar o proximo parametro: ");
        while (!valueOfX.atribuirValorDouble(sc.nextLine(), 'X')) {
            if (valueOfX.getDoubleValue() != null) {
                listX.add(valueOfX.getDoubleValue());
            }
            valueOfX = new x("");
        }
    }

    public void addValuesInListY() {
        int cont = 0;
        fx valueOfX = new fx("");
        System.out.println("f(x) deve conter " + listX.size() + " valores");
        System.out.print("Digite o valor de (Y) ou 'proximo' para encerrar: ");
        while (true) {
            if (cont == listX.size())
                break;
            valueOfX.atribuirValorDouble(sc.nextLine(), 'Y');
            if (valueOfX.getDoubleValue() != null) {
                listY.add(valueOfX.getDoubleValue());
            }
            valueOfX = new fx("");
            cont++;
        }
    }

    public void showListx() {
        int i = 0;
        System.out.println("\nx            y");
        for (Double x : listX) {
            System.out.println(+x + "       " + listY.get(i));
            i++;
        }
    }

    public List<Double> getListX() {
        return listX;
    }

    public List<Double> getListY() {
        return listY;
    }
}
