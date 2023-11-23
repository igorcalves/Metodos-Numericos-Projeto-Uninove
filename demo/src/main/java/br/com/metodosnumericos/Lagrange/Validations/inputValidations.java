package br.com.metodosnumericos.Lagrange.Validations;

public class inputValidations {

    public static boolean isValidNumeric(String numeric) {
        try {
            Integer.parseInt(numeric);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean isValidDoubleNumeric(String numeric) {
        try {
            Double.parseDouble(numeric);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean rangeNumeric(String numberInString) {
        if (isValidNumeric(numberInString)) {
            int number = Integer.parseInt(numberInString);
            if (number >= 0 && number <= 9) {
                return true;
            }
        }
        return false;
    }

}