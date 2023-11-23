package br.com.igor.app.Lagrange.Objetos;

public class ValorLagrange {

    private Double valor;
    private Integer x;

    public ValorLagrange(Double valor, int x) {
        this.valor = valor;
        this.x = x;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public boolean hasX() {
        if (this.getX() == 0 || this.getX() == null)
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        String op = "";
        if(valor>0) op = "+";
        if(valor == -1){
            op = "-";
        }
        if (hasX()) {
            if (getX() == 1) {
                if (getValor() == 1 || getValor() == -1) {
                    return op +""+"X";
                } else
                    return op+ "" +valor + "X";
            }
            else
            if(getValor() == 1 || getValor() == -1){
                return op+ "" + "X^" + getPowX(getX());
            }
                return op+ "" +valor + "X^" + getPowX(getX());
        } else
            if(valor == 0) return "";
            return op+"" + valor + "";
    }


    public static String getPowX(int numero) {

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
