package br.com.metodosnumericos.CorrelacaodePearson;


import java.util.List;

public class Resolving {
    private double sumX = 0;
    private double sumY = 0;
    private double sumFXx = 0;
    private double sumXSquared = 0;
    private double sumYSquared = 0;

    private double r;

    public void sumAll(List<Double> listX, List<Double> listY) {
        for (int i = 0; i < listX.size(); i++) {
            sumX += listX.get(i);
            sumY += listY.get(i);
            sumFXx += listX.get(i) * listY.get(i);
            sumXSquared += Math.pow(listX.get(i), 2);
            sumYSquared += Math.pow(listY.get(i), 2);
        }

    }

    public Double calculate(int lenght) {
        this.r = ((lenght * sumFXx) - (sumX * sumY))
                / (Math.sqrt(((lenght * sumXSquared) - Math.pow(sumX, 2)))
                        * Math.sqrt((lenght * sumYSquared - Math.pow(sumY, 2))));
        return r;
    }

    public double getSumX() {
        return sumX;
    }

    public double getSumY() {
        return sumY;
    }

    public double getSumFXx() {
        return sumFXx;
    }

    public double getSumXSquared() {
        return sumXSquared;
    }

    public double getSumYSquared() {
        return sumYSquared;
    }

    public double getR() {
        return r;
    }
    

    @Override
    public String toString() {
        return "r = " + r;
    }

}