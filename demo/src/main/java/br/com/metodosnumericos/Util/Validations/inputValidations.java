package br.com.metodosnumericos.Util.Validations;

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
            if (number > 0 && number <= 5) {
                return true;
            }
        }
        return false;
    }

}