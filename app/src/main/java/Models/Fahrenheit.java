package Models;

public class Fahrenheit extends  Grado
{
    public Fahrenheit(Double valor)
    {
        this.setValor(valor);
        this.setUnidad("F");
    }
    public Fahrenheit parse(celsius C)
    {
        Double valor=(C.getValor()*1.8)+32;
        return new Fahrenheit(valor);

    }
    public Fahrenheit parse(Kelvin K)
    {
        Double valor=(K.getValor() - 273.15)* 1.8000+ 32.00;
        return new Fahrenheit(valor);
    }
}
