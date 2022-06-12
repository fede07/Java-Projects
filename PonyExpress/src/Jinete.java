
public class Jinete{

	public int jinetes(int[] estaciones) { 
		int jinetes = 1;
		int millas = estaciones[0];
		
		for(int i=1;i<estaciones.length;i++) {
			if((millas+estaciones[i])>100) {
				jinetes++;
				millas = estaciones[i];
			}else {
				millas+=estaciones[i];
			}
			
		}
		
		return jinetes;
	}

}
