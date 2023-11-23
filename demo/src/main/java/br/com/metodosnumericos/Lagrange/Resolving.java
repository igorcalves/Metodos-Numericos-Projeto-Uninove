package br.com.metodosnumericos.Lagrange;

import java.util.ArrayList;
import java.util.List;

import br.com.metodosnumericos.Lagrange.Objetos.ValorLagrange;



public class Resolving {

    private ValorLagrange vl;

    private List<ValorLagrange> lagrangesUpSide = new ArrayList<>();
    private List<ValorLagrange> finalUpSideList;
    private List<ValorLagrange> auxUpSideList = new ArrayList<>();
    private List<ValorLagrange> LnUpSide = new ArrayList<>();
    private List<ValorLagrange> LnXFn = new ArrayList<>();


    private List<Integer> LnDownSide = new ArrayList<>();

    private int sizeFinalList = 0;



    public void run(List<ValorLagrange> lagrangeListX,List<Double> lagrangeListY) {
        resolvingUpSide(lagrangeListX);
        resolvingDownSide(lagrangeListX);
        printLnResults(lagrangeListX,LnUpSide);
        multAllNumberForY(lagrangeListX,lagrangeListY);
        resolvingLastPart(lagrangeListX, LnXFn);

    }

    public void resolvingUpSide(List<ValorLagrange> lagrangeList) {
        for (int i = 0; i < lagrangeList.size(); i++) {
            List<ValorLagrange> auxLagrangeList = new ArrayList<>(lagrangeList);
            auxLagrangeList.remove(i);
            multplyXWithTwo(auxLagrangeList.get(0), auxLagrangeList.get(1));
            sameXType(finalUpSideList,false);
            auxLagrangeList.remove(0);
            auxLagrangeList.remove(0);
            lagrangesUpSide.addAll(auxLagrangeList);

            if (!lagrangesUpSide.isEmpty()) {
                while (true) {
                    if (lagrangesUpSide.isEmpty())
                        break;
                    auxUpSideList.add(0, lagrangesUpSide.get(0));
                    lagrangesUpSide.remove(0);
                    multiplyAll(finalUpSideList, auxUpSideList);
                    auxUpSideList.remove(0);
                }
            }
            System.out.println("\nL(" +i+")"+finalUpSideList);
            sizeFinalList = finalUpSideList.size() -1 ;
            LnUpSide.addAll(finalUpSideList);
        }
    }

    public void resolvingDownSide(List<ValorLagrange> lagrangeList) {
        for (int i = 0; i < lagrangeList.size(); i++) {
            int result = 1;
            List<Double> valueCalculate = new ArrayList<>();
            List<ValorLagrange> auxLagrangeList = new ArrayList<>(lagrangeList);
            Double x = auxLagrangeList.get(i).getValor();
            auxLagrangeList.remove(i);
            //System.out.println("X = " + x+" l = "+auxLagrangeList);
            for (ValorLagrange valueForCalc : auxLagrangeList) {
                valueCalculate.add((x * -1) - (valueForCalc.getValor() * -1));
            }
            for (Double calc : valueCalculate) {
                result *=calc;
                
            }
            LnDownSide.add(result);
        }


        

    }

    public void multiplyAll(List<ValorLagrange> listFinalValues, List<ValorLagrange> newValues) {

        List<ValorLagrange> results = new ArrayList<>();
        int mult = 1;

        for (ValorLagrange finalValue : listFinalValues) {

            if (newValues.isEmpty())
                break;
            for (ValorLagrange newValue : newValues) {
                // (x) * (x)
                if (finalValue.hasX() && newValue.hasX()) {
                    //System.out.println("sdsdsds " + finalValue.getValor() + " "+ newValue.getX() );
                    Double newValueValor = finalValue.getValor() * newValue.getX();
                    int newValueX = finalValue.getX() + newValue.getX();
                    
                    results.add(new ValorLagrange(newValueValor, newValueX));
                }
                // (x) * (n)
                if (finalValue.hasX() && newValue.getX() == 1) {
                    if (mult == 1) {
                        Double newValueValor = newValue.getValor();
                        int newValueX = finalValue.getX();
                        results.add(new ValorLagrange(newValueValor, newValueX));
                        mult++;
                    } else {
                        Double newValueValor = finalValue.getValor() * newValue.getValor();
                        int newValueX = finalValue.getX();
                        results.add(new ValorLagrange(newValueValor, newValueX));
                    }

                }

                else if (!finalValue.hasX()) {
                    results.add(new ValorLagrange(finalValue.getValor(), newValue.getX()));
                }

                else if (!finalValue.hasX() && newValue.hasX()) {
                    Double newValueValor = finalValue.getValor() * newValue.getX();
                    int newValueX = finalValue.getX() + newValue.getX();
                    results.add(new ValorLagrange(newValueValor, newValueX));
                }
            }

        }

        results.add(new ValorLagrange(listFinalValues.get((listFinalValues.size() - 1)).getValor()
                * newValues.get((newValues.size() - 1)).getValor(), 0));
        sameXType(results,false);
        finalUpSideList.clear();
        finalUpSideList.addAll(results);
    }

    public void multplyXWithTwo(ValorLagrange v1, ValorLagrange v2) {
        finalUpSideList = new ArrayList<>();
        // primeira distributiva (x) * (x)
        vl = new ValorLagrange(1.0, v1.getX() + v2.getX());

        finalUpSideList.add(vl);
        // segunda distributiva (x) * (n)
        vl = new ValorLagrange(v1.getX() * v2.getValor(), v1.getX());

        finalUpSideList.add(vl);
        // terceira distributiva (n) * (x)
        vl = new ValorLagrange(v1.getValor(), v1.getX());
        finalUpSideList.add(vl);
        // quarta distributiva (n) * (n)
        vl = new ValorLagrange(v1.getValor() * v2.getValor(), 0);
        finalUpSideList.add(vl);
        sameXType(finalUpSideList,false);
    }

    private void multAllNumberForY(List<ValorLagrange> lagrangeListX, List<Double> lagrangeListY){

        for (int ii = 0; ii <= lagrangeListX.size() +1; ii++) {
            if(!LnUpSide.isEmpty()){
                for(int i = 0;i <=sizeFinalList;i++){
                      LnXFn.add(new ValorLagrange(LnUpSide.get(0).getValor() * lagrangeListY.get(ii), LnUpSide.get(0).getX()));
                    LnUpSide.remove(0);
                } 
            }
        }
        printLnResults(lagrangeListX ,LnXFn);
    }

    public void sameXType(List<ValorLagrange> listP,boolean show) {
         //System.out.println("O que entrou = " + listP);
        int size = listP.size();

        for (int i = 0; i < size; i++) {
            ValorLagrange termoI = listP.get(i);

            if (termoI.getX() != null && termoI.getX() != 0) {
                for (int j = i + 1; j < size; j++) {
                    ValorLagrange termoJ = listP.get(j);

                    if (termoJ.getX() != null && termoJ.getX() != 0 && termoJ.getX().equals(termoI.getX())) {
                        Double novoValor = termoI.getValor() + termoJ.getValor();
                        termoI.setValor(novoValor);

                        listP.remove(j);
                        size--;
                        j--;
                    }
                }
            }else if(termoI.getX() ==0){
                for (int j = i + 1; j < size; j++) {
                    ValorLagrange termoJ = listP.get(j);
                    if(termoI.getX() == termoJ.getX()){
                        Double novoValor = termoI.getValor() + termoJ.getValor();
                        termoI.setValor(novoValor);
                        listP.remove(j);
                        size--;
                        j--;
                    } 
                }
            }
        }
        


         //System.out.println("O que saiu = " + listP);
         //System.out.println(listP);
         if(show) showList(listP);
        finalUpSideList = new ArrayList<>(listP);
    }


    /*
     * 
     public Double invertSignalNumber(int value) {
         if (Math.signum(value) == -1) {
             Double positiveValue = (~(value - 1));
             return positiveValue;
            } else {
                int negativeValue = ~(value - 1);
                return negativeValue;
            }
        }
        */

    private void printLnResults(List<ValorLagrange> lagrangeListX,List<ValorLagrange> lnList){

        List<ValorLagrange> auxLnList = new ArrayList<>(lnList);
        for (int ii = 0; ii <= lagrangeListX.size() +1; ii++) {
            if(!auxLnList.isEmpty()){
                System.out.print("\nL" + ii + "=  ");
                for(int i = 0;i <=sizeFinalList;i++){
                    System.out.print(" " + auxLnList.get(0));
                    auxLnList.remove(0);
                }  
                System.out.println("\n      _____________ \n           " + LnDownSide.get(ii)+"\n");    
            }
        }
    }


    private  int mdc(int a, int b){        
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public  int mmcLista(List<Integer> numberList){
        if(numberList.size() < 2){
            throw new IllegalArgumentException("A lista deve conter pelo menos dois números");
        }
        int mmcResultado = numberList.get(0);
        for(int i = 1; i < numberList.size(); i++){
            mmcResultado = mmcResultado * (Math.abs(numberList.get(i)) / mdc(mmcResultado, Math.abs(numberList.get(i))));
        }
        return mmcResultado;
    }

    public void resolvingLastPart(List<ValorLagrange> lagrangeListX,List<ValorLagrange> lnList){
        List<ValorLagrange> TERMINOOOO = new ArrayList<>();

        List<ValorLagrange> gx = new ArrayList<>();
        
        List<ValorLagrange> auxLnList = new ArrayList<>(lnList);

        int mmc = Math.abs(mmcLista(LnDownSide));

        for (int ii = 0; ii <= lagrangeListX.size() +1; ii++) {
            Double resuls = 0.0;
            if(!auxLnList.isEmpty()){
                for(int i = 0;i <=sizeFinalList;i++){
                    resuls = (mmc/LnDownSide.get(ii)) *  auxLnList.get(0).getValor();
                    TERMINOOOO.add(new ValorLagrange(resuls, auxLnList.get(0).getX()));
                    auxLnList.remove(0);
                }     
            }
        }
        System.out.println("*****************RESULTADO*****************\n\n");
        sameXType(TERMINOOOO,true);
        System.out.println("     -------------------\n             " + mmc +"\n");

        System.out.print("g(x) = ");
        for (ValorLagrange valorLagrange : TERMINOOOO) {

            if(valorLagrange.getValor() %mmc == 0){
                ValorLagrange vl = new ValorLagrange((valorLagrange.getValor() / mmc),
                valorLagrange.getX());
                System.out.print(vl + " ");                
            }else{
                reduce(valorLagrange.getValor(), mmc,valorLagrange.getX());
            }            
            
        }
        System.out.println();
    }

    private void showList(List<ValorLagrange> listShow){
        for (ValorLagrange values : listShow) {
            System.out.print(values + " ");
        }
        System.out.println();
    }

    private void reduce(double upside, double bottom,Integer xPow) {

        int div = 2;
        while (true) {
            if (div > upside && div > bottom) {
                System.out.print(upside + "\\" + bottom + "X" + getPowX(xPow) + " " );
                break;
            }
            if (upside % div == 0 && bottom % div == 0) {
                upside /= div;
                bottom /= div;
            } else {
                div++;
            }

        }

    }

    public  String getPowX(int numero) {
        if(numero == 1){
            return "";
        }

		String[] exp = { "⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸", "⁹" };

		StringBuilder expoente = new StringBuilder();
		String nStr = String.valueOf(numero);
		for (char digit : nStr.toCharArray()) {
			int indice = Character.getNumericValue(digit);
			expoente.append(exp[indice]);
		}

		return expoente.toString();
	}

}
