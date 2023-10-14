package Models;

public class celsius extends Grado{
    public celsius(Double valor) {
        this.setValor(valor);
        this.setUnidad("C");
    }

    public celsius parse(Fahrenheit F)
    {
        Double valor = (F.getValor()-32) *5/9;
        return new celsius(valor);

    }
    public celsius parse(Kelvin K)
    {
        Double valor=(K.getValor()-273.15);
        return new celsius(valor);
    }
}
