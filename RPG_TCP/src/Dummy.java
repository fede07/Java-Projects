public class Dummy extends Raza{
    
    Dummy(){
        this.vidaInicial = 1000;
        this.vida = 1000;
        this.da�o = 20;
        this.pasosMaximos = 0;
        this.rangoMax = 900;
        this.rangoMin = 0;
        this.bonusAtaque = 0;
        this.posActual = 0;
    }
    
    public void atacar(Raza otro) {
        otro.recibirAtaque(this.da�o);
    }
    
    public void descansar() {
        this.vida = this.vidaInicial;
    }
    
    
    //ANTES DEL ATAQUE REVISAR SI EL PERSONAJE ESTA MUERTO
    public void recibirAtaque(int da�oRecibido) {        
        this.vida -= da�oRecibido;
        if(this.vida <= 0) {
            descansar();
        }
    }
        

    //EL PLANO DE MOVIMIENTO ES 1D Y DE LARGO INFINITO
    public void moverse(int pasos) {
        System.out.println("no me puedo mover, toy chikito");
    }
}