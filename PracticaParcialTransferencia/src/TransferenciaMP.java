
public class TransferenciaMP extends Transferencia3 {

	private double saldo;
	
	TransferenciaMP(double saldo){
		this.saldo = saldo;
	}
	
	public void transferir(Receptor receptor, double cantidad) {
		try {
			if(saldo - cantidad < 0) {
				throw new Exception("Saldo insuficiente");
			}
			
			if(!receptor.acreditar(cantidad)) {
				throw new Exception("Receptor invalido");
			}
			
			saldo -= cantidad;
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
		
	}
	
}
