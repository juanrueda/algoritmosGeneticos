
public class Principal {
	
	public static void main(String[] args){
		Linea ln = new Linea();
		double xi, xf, yi, yf;
		
		xi = 0.1;
		xf = 0.9;
		yi = 0.9;
		yf = 0.9;
		
		
		ln.dibujarSegmentos(xf - xi, xi, xf, yi, yf);
		
		//Se envia la longitud del primer segmento (como primer parametro) junto con las coordenadas de la primer linea
		
	}
	
	
}
