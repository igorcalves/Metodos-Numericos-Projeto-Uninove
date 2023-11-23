package br.com.igor.app.Lagrange.Objetos;

import br.com.igor.app.Lagrange.Validations.inputValidations;

public abstract class regras {

    protected String value;

    public regras() {
    }

    public regras(String value) {
        this.value = value;
    }

    public boolean atribuirValorDouble(String value, char parameter) {
        if (value.equalsIgnoreCase("proximo") && parameter == 'X')
            return true;
        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            System.out.print(
                    "o valor de (" + parameter + ") é invalido por favor digite um numero!\n" + "Digite o valor de ("
                            + parameter + ") ou 'proximo' para digitar o proximo parametro ou encerrar: ");
            return false;
        }
        this.value = value;
        System.out.print(
                "Digite o valor de (" + parameter + ") ou 'proximo' para digitar o proximo parametro ou encerrar: ");
        return false;
    }

    public boolean atribuirValorInt(String value, char parameter) {
        if (value.equalsIgnoreCase("proximo"))
            return true;
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            System.out.print(
                    "o valor de (" + parameter + ") é invalido por favor digite um numero!\n" + "Digite o valor de ("
                            + parameter + ") ou 'proximo' para digitar o proximo parametro ou encerrar: ");
            return false;
        }
        this.value = value;
        System.out.print(
                "Digite o valor de (" + parameter + ") ou 'proximo' para digitar o proximo parametro ou encerrar: ");
        return false;
    }

    public Double getDoubleValue() {
        if (inputValidations.isValidDoubleNumeric(value)) {
            return Double.parseDouble(value);
        } else {
            return null;
        }
    }

    public Integer getInt() {
        if (inputValidations.isValidNumeric(value)) {
            return Integer.parseInt(value);
        } else {
            return null;
        }
    }

}
