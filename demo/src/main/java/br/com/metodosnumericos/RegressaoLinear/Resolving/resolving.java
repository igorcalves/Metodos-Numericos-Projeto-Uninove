package br.com.metodosnumericos.RegressaoLinear.Resolving;

import java.util.List;

public class resolving {
    private double sumX=0;
    private double sumY=0;
    private double sumFXx=0;
    private double sumXSquared=0;
    private double firstFormulaA;
    private double firstFormulaB;


    public void sumAll(List<Double> listX,List<Double> listY){
        for (int i = 0; i < listX.size(); i++) {
            sumX += listX.get(i);
            sumY += listY.get(i);
            sumFXx += listX.get(i) * listY.get(i);
            sumXSquared +=  Math.pow(listX.get(i),2);
        }
        
        
    }



    public Double getSumX() {
        return sumX;
    }


    public Double getSumY() {
        return sumY;
    }


    public Double getSumFXx() {
        return sumFXx;
    }


    public Double getSumXSquared() {
        return sumXSquared;
    }


    public void firstFormula(int lenght){
        firstFormulaA = ((sumX * sumFXx) - (sumXSquared * sumY)) / (Math.pow(sumX, 2) - (lenght * sumXSquared));
        firstFormulaB = ((sumX * sumY) - (lenght * sumFXx)) / ((Math.pow(sumX, 2)) - (lenght * sumXSquared));
    }

    public String resultFirstFOrmula(){
        String op = "+";
        if(firstFormulaB <0){
            op = "-";
        }
        return "g(x) = " + String.format("%.4f", firstFormulaA) + " "+ op +" " + String.format("%.4f", firstFormulaB) +"x";
    }

    @Override
    public String toString() {
        return "resolving [sumX=" + String.format("%.3f", sumX) + 
        ", sumY=" + String.format("%.3f", sumY)
        + ", sumFXx=" + String.format("%.4f", sumFXx)
         + ", sumXXTwo=" + String.format("%.3f", sumXSquared) + "]";
    }
    
    
    
}
