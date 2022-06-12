
public abstract class Raza {
    protected int vida;
    protected int vidaInicial;
    protected int daño;
    protected int pasosMaximos;
    protected int rangoMax;
    protected int rangoMin;
    protected int bonusAtaque;
    protected int posActual;
    
    
    public int getVida() {
        return vida;
    }


    public int getVidaInicial() {
        return vidaInicial;
    }


    public int getPosActual() {
        return posActual;
    }


    
    
    
    
    
    public void atacar() {
    }
    
    
    public void descansar() {
        
    }
    
    public void recibirAtaque(int dañoRecibido) {
        
    }
    
    public void moverse() {
        
    }
    
    
    
    
}