package principal;

import java.util.Scanner;

import busquedas.*;
import capitales.Capitales;
import distancias.*;

public class Menu {

	private static Scanner s;
	
	
	public static void main(String[] args) {
		int[][] d = new int[24][24];
		int op;
		int total=0;
		s = new Scanner(System.in);
		DistanciasCapitales dc = new DistanciasCapitales();
		Heurística h = new Heurística();
		Capitales cap = new Capitales();
		DistanciaMinima dm = new DistanciaMinima();
		AlgoritmoGenet ag = new AlgoritmoGenet();
		String ciud[][];
		
		ciud = cap.cargaCapitales();
		
		
		int n=0;
		d = (dc.cargarDistancias());
		do{
			System.out.println("\nIngrese una opcion:\n\n 1-Buscar distancia\n 2-Recorrido minimo\n 3-Algoritmo Genetico\n 0-Salir");
			op = Integer.parseInt(s.nextLine());
			switch(op){
				case 1:
					n = dc.buscarProvincia(n);
					total = (h.buscarRecorrido(d,n,ciud));
					h.mostrar(ciud, total);
					break;
				case 2:
					dm.buscarMinima(d,ciud);	
					break;
				case 3:
					ag.empezar(ciud,d);
				case 0: break;
				default:
					System.out.println("Opcion no valida");
					
				}
		}while(op >= 1 && op <4);
		
		s.close();
			
	}
	
	
		 
}
