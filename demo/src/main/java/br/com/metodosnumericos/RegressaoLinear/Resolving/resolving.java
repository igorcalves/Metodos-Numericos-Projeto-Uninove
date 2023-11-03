package br.com.metodosnumericos.RegressaoLinear.Resolving;

public class resolving {
    private double sumX=0;
    private double sumY=0;
    private double sumFXx=0;
    private double sumXXTwo=0;


    public void sumAll(double[] listX,double[] listY){
        for(int i =0;i <4; i++){
            sumX +=  listX[i];
            sumY +=  listY[i];
            sumFXx +=  listX[i] * listY[i];
            sumXXTwo +=  Math.pow(listX[i],2);
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


    public Double getSumXXTwo() {
        return sumXXTwo;
    }



    @Override
    public String toString() {
        return "resolving [sumX=" + String.format("%.3f", sumX) + 
        ", sumY=" + String.format("%.3f", sumY)
        + ", sumFXx=" + String.format("%.4f", sumFXx)
         + ", sumXXTwo=" + String.format("%.3f", sumXXTwo) + "]";
    }
    
    
    
}
