
public class Linea {


	
	public void dibujarLinea(double xi, double yi, double xf,double yf){
		
		StdDraw.line(xi, yi, xf, yf);  // x0, y0, x1, y1
		
	}
	
	public void dibujarSegmentos(double seg, double xi, double xf, double yi, double yf){
		
		yi = yi - 0.1;
		yf = yf - 0.1;
		
		//Con las respectivas restas a las coord. "y", se mueven los segmentos hacia abajo
		
		if(yf > 0){

			this.dibujarLinea(xi, yi, xf, yf); //dibuja una linea segun las coordenadas que recibe
			seg = seg / 3; //Se obtiene la longitud de cada segmento cuando la linea es dividida en 3
			dibujarSegmentos(seg, xi, xi + seg, yi, yf);  //Dibuja segmentos desde la izquierda (segmento 1) 
			dibujarSegmentos(seg, xf - seg, xf, yi, yf);  //Dibuja segmentos desde la derecha (segmento 3)
			
			
		
		}
		
	}
	
}
