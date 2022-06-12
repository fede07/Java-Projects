
public class Detonadora extends Raza {
    
   int bonusDescanso = 0;

    Detonadora(){
        this.vidaInicial = 93;
        this.vida = 93;
        this.daño = 72;
        this.pasosMaximos = 10;
        this.rangoMax = 50;
        this.rangoMin = 3;
        this.bonusAtaque = 3;
        this.posActual = 0;
    }
    
    public void atacar(Raza otro) {
        if( Math.abs(posActual - otro.posActual) > rangoMax) {
            return;
        }
        
        int ataqueDañoExtra = this.daño;
        if(bonusDescanso>0) {
            ataqueDañoExtra *= this.bonusAtaque;
            this.bonusDescanso--;
        }
        
        this.vida += this.vidaInicial * 0.03;
        
        if(this.vida> this.vidaInicial)
        	this.vida = this.vidaInicial;
        //ESTA FALLANDO
        
        otro.recibirAtaque(ataqueDañoExtra);
    }
    
    public void descansar() {
    	this.bonusAtaque = 2;
    }
    
    
    //ANTES DEL ATAQUE REVISAR SI EL PERSONAJE ESTA MUERTO
    public void recibirAtaque(int dañoRecibido) {        
        this.vida -= dañoRecibido;
        if(this.vida <= 0) {
        	this.vida = 0;
            System.out.println("me mori");
        }
    }
        

    //EL PLANO DE MOVIMIENTO ES 1D Y DE LARGO INFINITO
    public void moverse(int pasos) {
    	this.posActual += pasos;
    }
    
}