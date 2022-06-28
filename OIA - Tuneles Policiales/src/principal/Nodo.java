package principal;


public class Nodo implements Comparable<Nodo>{

    private int numero;
    private int distancia;

    public Nodo(int numero, int distancia) {

        this.numero = numero;
        this.distancia = distancia;

    }

    public int getNumero() {
        return numero;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public int compareTo(Nodo o) {
        return this.distancia - o.distancia;
    }



}