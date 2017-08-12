package ui;

import ejercicio1.Exhaustiva;
import ejercicio2.Greedy;
import ejercicio3.*;
import listaElementos.Lista;
import listaElementos.Lista2;

public class Principal {
	
	public static void main(String[] args){
		int[] maxvec = new int[10];
		int[] maxvec2 = new int[3];
		//int[][] lista = new int[10][3];
		int[][] listaOrdenada = new int[10][3];
		int[][] listaOrdenada2 = new int[3][3];
		
		Lista lis = new Lista();
		lis.cargaLista();
		lis.cargarRelacion();
		//lis.mostrarLista();
		
		Lista2 lis2 = new Lista2();
		lis2.cargaLista2();
		lis2.cargarRelacion();
		//lis2.mostrarLista();
		System.out.println("Primera busqueda exhaustiva");
		
		Exhaustiva ej1 = new Exhaustiva();
		ej1.combinaciones(maxvec, lis);
		ej1.mostrarValores(maxvec);
		
		System.out.println("Primera busqueda golosa");
		
		Greedy ej2 = new Greedy();
		ej2.ordenar(lis.cargaLista(),lis.cargarRelacion(), listaOrdenada);
		ej2.cargarMochila(listaOrdenada);
		
		System.out.println("\n\n*******************************");
		
		System.out.println("\n\nSegunda busqueda exhaustiva");
		
		Exhaustiva2 ej3 = new Exhaustiva2();
		ej3.combinaciones(maxvec2, lis2);
		ej3.mostrarValores2(maxvec2);
		
		System.out.println("\n\nSegunda busqueda golosa");
		
		Greedy2 ej32 = new Greedy2();
		ej32.ordenar(lis2.cargaLista2(), lis2.cargarRelacion(), listaOrdenada2);
		ej32.cargarMochila(listaOrdenada2);
		
	}
}
