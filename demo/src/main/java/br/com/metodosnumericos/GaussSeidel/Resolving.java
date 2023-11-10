package br.com.metodosnumericos.GaussSeidel;

import java.util.List;

import br.com.metodosnumericos.Mocks.XYZ;

public class Resolving {

    public Double switSignal(Double value) {
        if (value > 0) {
            value = value - (value * 2);
            return value;
        }
        value = value + (Math.abs(value) * 2);
        return value;

    }

    public Double calculateX(Double y, Double z) {

        Double resultEqual = XYZ.getResults().get(0);

        Double firstValue = XYZ.getFirstLine().get(0);

        Double secondValue = switSignal(XYZ.getFirstLine().get(1));

        Double thirdValue = switSignal(XYZ.getFirstLine().get(2));
        

        Double result = 0.0;

        secondValue = secondValue * y;
        thirdValue = thirdValue  *z;



        ///Primeira Parte
        if(switSignal(XYZ.getFirstLine().get(1)) > 0 ) {

            result = resultEqual  -secondValue;

        }
        else result = resultEqual + secondValue;

        ///Segunda Parte

        if(switSignal(XYZ.getFirstLine().get(2)) > 0 ) {

            result = resultEqual - thirdValue;

        }
        else result = result + thirdValue;

        if (firstValue == 0) return result;
        else return result/firstValue;

    }

    public Double calculateY(Double x, Double y) {
        Double z = 0.0;

        Double resultEqual = XYZ.getResults().get(1);


        Double secondValue = switSignal(XYZ.getSecondLine().get(0));

        Double thirdValue = switSignal(XYZ.getSecondLine().get(2));
        

        Double result = 0.0;

        secondValue = secondValue * x;
        thirdValue = thirdValue  *z;



        ///Primeira Parte
        if(switSignal(XYZ.getSecondLine().get(1)) > 0 ) {

            result = resultEqual   + Math.abs(secondValue);

        }
        else result = resultEqual - Math.abs(secondValue);

        ///Segunda Parte

        if(switSignal(XYZ.getSecondLine().get(2)) > 0 ) {
            result = result   + Math.abs(thirdValue);
        }

        else result = result   - Math.abs(thirdValue);

        if(XYZ.getSecondLine().get(1) == 1 && XYZ.getSecondLine().get(1) != 0 ){
            return result;
        }
        else return result /x;

    }

    public Double calculateZ() {
        Double x =  calculateX(0.0, 0.0);
        Double y = calculateY(x, 0.0);


        Double resultEqual = XYZ.getResults().get(2);


        Double secondValue = switSignal(XYZ.getThirdLine().get(0));

        Double thirdValue = switSignal(XYZ.getThirdLine().get(1));
        System.out.println(resultEqual + " " + secondValue + " " + thirdValue);
        Double result = 0.0;

        secondValue = secondValue* x;
        thirdValue = thirdValue*y;

        System.out.println(resultEqual + " " + secondValue + " " + thirdValue);

        ///Primeira Parte
        if(switSignal(XYZ.getThirdLine().get(1)) > 0 ) {

            result = resultEqual   +secondValue;

        }
        else result = resultEqual - secondValue;

        ///Segunda Parte

        if(switSignal(XYZ.getThirdLine().get(2)) > 0 ) {
            result = result   - thirdValue;
        }

        else result = result   + thirdValue;


        if(XYZ.getThirdLine().get(1) == 1 && XYZ.getThirdLine().get(1) != 0 ){
            System.out.println("X = " + x + "Y = " + y + "Z = " + result );
            return result;
        }
        
        else
        {
            System.out.println("X = " + x + " Y = " + y + " Z = " + result/resultEqual );
            return result /resultEqual;
        } 


    }





}
