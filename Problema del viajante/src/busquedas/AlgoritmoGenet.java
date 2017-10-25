package busquedas;

import java.util.ArrayList;
import java.util.Random;
//import java.util.Scanner;

public class AlgoritmoGenet
{

	// Declaración de variables de clase
	int[][] poblacionInicial = new int[50][23];
	int[] recorridos;
	int[] recorridosMenores = new int[200];
	int[] tiradas;
	int[] probCruza;
	int[] probMuta;
	int[][] poblacionHija;
	float[] fitness;
	float[] porcFitness;
	int total;
	ArrayList<Integer> ruleta;
	Random rnd = new Random();
	int pc = 90;
	int pm = 2;
	

	public void empezar(String[][] ciudades, int[][] d){		
		// Método de clase que crea la población inicial (primeros padres): 		
	 	// 50 individuos/cromosomas de 23 genes 
		crearPoblacionInicial();
		
		// Método que calcula para cada cromosoma de la población, el 			
		// recorrido total de cada uno (evalúa cada cromosoma en la función 		
		// objetivo que calcula la distancia)
		calcularRecorridos(d);
		
		// Método que calcula el total de todos los recorridos
		calcularTotal();
		
		// Método que calcula el Fitness para cada individuo de la 			
		// población
		calcularFitness();
		
		// Método que crea la ruleta para la población en base al Fitness 		
		// de cada uno de sus integrantes
		crearRuleta();

		
		// Mostramos en pantalla cada uno de los cromosomas de la población 		
		// inicial (recorridos) con su respectiva distancia, Fitness y 			
		// porcentaje del Fitness
		System.out.println("Recorrido\t\t\t\tDistancia");
		for(int i=0;i<50;i++){
			for(int j=0;j<23;j++){
				System.out.print(poblacionInicial[i][j]+" ");
			}
			System.out.println(" "+recorridos[i]+" \t"+fitness[i]+"	  \t"+porcFitness[i]);
		}
		
		// Guardamos en un arreglo que acumulará por cada iteración la 			
		// menor distancia de toda la población (recorridosMenores[]), la 		
		// menor distancia de la población inicial
		recorridosMenores[0]=buscarMenor();
		
		// Mostramos por consola: la menor distancia, la sumatoria de las 		
		// distancias de la población y la suma de los Fitness (para 			
		// verificar que dan aproximadamente 1)
		System.out.println("\nLa menor distancia es: 		"+recorridosMenores[0]+" kilometros");
		System.out.println("\nTotal: "+total+" km. Suma Fitness: 			"+sumarFitness()+"\n");	
			




		// Comenzamos los 200 ciclos
		for(int rep=0;rep<200;rep++){
			// Mostramos la ruleta
			System.out.println("\nRuleta:");
			
			for(Integer ind : ruleta){
				System.out.print(ind+" ");
			}
			
			System.out.println("\nTamaño ruleta: "+ruleta.size());
		
			// Hacemos las tiradas a la ruleta (generamos 50 números 				
			// aleatorios de 0 a 99, 50 ubicaciones en la ruleta que 				
			// serán los padres que van reproducirse)
			tiradas = new int[50];
			for(int i=0;i<50;i++)
			{
				// generarAleatorio que calcula números aleatorios a 				
				// partir del ingreso del rango y del inicio, a partir 				
				// de cual generar el número
				tiradas[i] = generarAleatorio(100,0);
			}
			
			// Generamos 25 números aleatorios del 1 al 100 que 				
			// corresponderán a las probabilidades de cruza para cada par 			
			// de padres elegidos en las tiradas a la ruleta
			probCruza = new int[25];
			for(int i=0;i<25;i++)
			{
				probCruza[i] = generarAleatorio(100,1);
			}
	
			// Generamos 50 números aleatorios del 1 al 100 que 				
			// corresponderán a las probabilidades de mutación para cada 			
			// todas las cruzas obtenidas
			probMuta = new int[50];
			for(int i=0;i<50;i++)
			{
				probMuta[i] = generarAleatorio(100,1);
			}

			poblacionHija = new int[50][23];
			
			// Inicializamos los índices de los hijos
			int m = 0;
			int n = 1;

			// Comenzamos las cruzas: para cada par de padres, le 				
			// corresponde uno de los 25 números aleatorios 					
			// correspondientes a la probabilidad de cruza
			for(int i=0;i<25;i++)
			{


				// Identificamos en dos índices a y b los padres en la 				
				// ruleta que corresponden a las tiradas
				int a = ruleta.get(tiradas[m]);
				int b = ruleta.get(tiradas[n]);

				System.out.println(a+" "+b);

				// Guardamos el primer gen de los cromosomas padres 				
				// (correspondientes a los índices a y b) en el primer 				
				// gen de los cromosomas hijos respectivamente
				poblacionHija[m][0] = poblacionInicial[a][0];
				poblacionHija[n][0] = poblacionInicial[b][0];

				// Si la probabilidad[i] es menor o igual a la 					
				// variable estatica pc (instanciada con un valor 					
				// determinado por el grupo)…
				if(probCruza[i]<=pc)
				{
					// Se cruzan: crossover cíclico
					System.out.println("Cruzan\n");
					
					// Con el segundo cromosoma padre
					// Asignamos a una variable entera r, el primer 					
					// gen del segundo padre
					int r = poblacionInicial[b][0];

					// Una iteración while donde la condición está 					
					// determinada por la función esta(): recibe 						
					// como parámetro el primer gen del segundo 						
					// padre y el índice del primer padre). 
					// Si la función devuelve verdadero, se termina 					
					// la iteración, en cambio, si devuelve falso, 					
					// continúa con la iteración
					while(!(esta(r,m)))
					{
						// Recorremos el primer padre, hasta 							
					// encontrar el gen que coincida con el 						
					// gen r (del segundo padre)								
					for(int j=0;j<23;j++)
						{
							if(poblacionInicial[a][j]==r)
							{
								// Si lo encuentra, agrega 								
								// ese gen del segundo 									
								// padre, en el gen del hijo 								
								// en la misma ubicación 									
								// donde se encontraba r									
								poblacionHija[m][j] = r;


								// Asignamos a la variable r 								
								// (para las siguientes 									
								// iteraciones) el valor del 								
								// gen del segundo padre, en 								
								// la misma ubicación donde 								
								// se encontró que el valor 								
								// anterior de r coincidía 								
								// con el gen del primer 									
								// padre
								r = poblacionInicial[b][j];

								// Al realizar estos 									
								// pasajes, cortamos la 									
								// iteración for.
								break;
							}
						}
					}												
					// Cuando ya esté el valor de r en el gen del 					
					// segundo padre, es decir, que se termina la 					
					// iteración while. Completamos el primer 						
					// cromosoma hijo con los genes del segundo 						
					// padre, en la misma ubicación en la que estos 					
					// se encuentran.
					for(int j=0;j<23;j++)
					{
						if(poblacionHija[m][j] == 0)
						{
							poblacionHija[m][j] = poblacionInicial[b][j];
						}
					}

					//Lo mismo que se aplicó anteriormente, pero 						
					// iniciando con el primer gen del primer padre
					r = poblacionInicial[a][0];

					// La función esta recibe el gen del primer 						
					// cromosoma	padre (r) y el índice que 						
					// identifica al segundo padre (cromosoma)
					while(!(esta(r,n)))
					{			
						for(int j=0;j<23;j++)
						{
							if(poblacionInicial[b][j]==r)
							{
								poblacionHija[n][j] = r;
								r = poblacionInicial[a][j];
								break;
							}
						}
					}


					for(int j=0;j<23;j++)
					{
						if(poblacionHija[n][j] == 0)
						{
							poblacionHija[n][j] = poblacionInicial[a][j];
						}
					}

				}
				
				// Si la probabilidad[i] no es menor o igual…
				else
				{
					// No cruzan
					System.out.println("No cruzan\n");

					// Los cromosomas padres, pasan a ser hijas, sin 					
					// cruzarse
					for(int j=0;j<23;j++)
					{
						poblacionHija[m][j] = poblacionInicial[a][j];
						poblacionHija[n][j] = poblacionInicial[b][j];
					}
				}

				// Pasamos al siguiente par de padres
				m = m+2;
				n = n+2;

			}
			
			// Mostramos en pantalla la población hija sin mutar
			System.out.println("Poblacion hija sin mutar:");
			for(int i=0;i<50;i++)
			{
				for(int j=0;j<23;j++)
				{
					System.out.print(poblacionHija[i][j]+" ");			
				}
				System.out.println(recorridos[i]);
			}	
			
			System.out.println(" ");

			// Para los 50 números aleatorios (probMuta[]) que 					
			// corresponden a la mutación
			for(int i=0;i<50;i++)
			{
				



				// Si la probMuta[i] es menor a la probabilidad de 					
				// mutar (determinada por el programador)…
				if(probMuta[i]<=pm)
				{
					// Existe mutación: de intercambio
					System.out.println("Muta");

					// Para esta mutación, generamos dos números 						
					// aleatorios de 0 a 22, correspondientes a dos 					
					// ubicaciones del cromosoma[i] de la población 					
					// hija que van a intercambiarse
					int ub1 = generarAleatorio(23,0);
					System.out.print(ub1+" ");
					int ub2;
					do{
						// Al haber generado el primer número 							
						// aleatorio, debemos validar que el 							
						// segundo no sea el mismo que el primero
						ub2 = generarAleatorio(23,0);
					}while(ub1 == ub2);
					System.out.println(ub2);
					int mut1 = poblacionHija[i][ub1];
					int mut2 = poblacionHija[i][ub2];
					
					poblacionHija[i][ub1] = mut2;
					poblacionHija[i][ub2] = mut1;
				}

				// Si la probMuta[i] no es menor a la probabilidad de				
				// mutar… No muta
				else
				{
					System.out.println("No muta");
				}
			}
						
			System.out.println(" ");
			
			// Pasamos el arreglo multidimensional (todo el conjunto) de 			
			// cromosomas hijas a otro arreglo del mismo estilo que 				
			// corresponderá a los cromosomas padres de la siguiente 				
			// iteración
			// Por conveniencia, hemos optado por repetir nombres
			poblacionInicial = new int[50][23];
			for(int i=0;i<50;i++)
			{
				for(int j=0;j<23;j++)
				{
					poblacionInicial[i][j] = poblacionHija[i][j];			
				}
			}	
			

			// Calculamos el recorrido para cada cromosoma padre (o hija 			
			// resultante)
			calcularRecorridos(d);
			
			// Mostramos en pantalla: población hija resultante, por cada 			
			// cromosoma su evaluación en la función objetivo, su Fitness 			
			// y su porcentaje de Fitness
			System.out.println("Poblacion hija ("+rep+") final");
			for(int i=0;i<50;i++)
			{
				for(int j=0;j<23;j++)
				{
					System.out.print(poblacionHija[i][j]+" ");			
				}
				System.out.println(" "+recorridos[i]+" 	 \t"+fitness[i]+" \t"+porcFitness[i]);
			}	
			
			// Agregamos al arreglo de recorridosMenores, el menor 				
			// recorrido de la iteración (rep)
			recorridosMenores[rep]=buscarMenor();
			
			// Mostramos en pantalla, la menor distancia de la iteración, 			
			// la sumatoria de todos los recorridos de la iteración y la 			
			// suma de todos los Fitness de la iteración 
			System.out.println("\nLa menor distancia es: " 		+recorridosMenores[rep]+" kilometros.");
			System.out.println("\nTotal: "+total+" km. Suma Fitness: " 				+sumarFitness()+"\n");	
			
			// Calculamos total, Fitness y creamos la ruleta, para la 			
			// siguiente iteración
			calcularTotal();
			calcularFitness();
			crearRuleta();
			
		}
		
		// Mostramos el arreglo de distancias menores obtenidas en cada 			
		// iteración
		System.out.println("Menores distancias recorridas por población:");
		for(int i=0;i<200;i++)
		{
			System.out.println(recorridosMenores[i]);			
		}
		
		// Mostramos el recorrido/la ruta correspondiente a la última menor 		
		// distancia obtenida
		System.out.println("\nRecorrido con menor distancia:");
		for(int i=0;i<23;i++)
		{
			System.out.println(poblacionHija[49][i]+" - " 		+ciudades[poblacionHija[49][i]-1][1]);
		}
		// Agregamos a lo último, la vuelta hacia la ciudad de partida
		System.out.println(poblacionHija[49][0]+" - " 		+ciudades[poblacionHija[49][0]-1][1]);
		
		// Mostramos la  distancia de dicho recorrido
		System.out.println("Distancia: "+recorridosMenores[199]+" km.");
}

	
	
	
	// Método que crea la ruleta
	public void crearRuleta() {
		
		// Instancia la ruleta como un ArrayList de enteros
		ruleta = new ArrayList<Integer>();
		for(int i=0;i<porcFitness.length;i++)
		{
			int rep = Math.round(porcFitness[i]);
			if(rep==0)
			{
				// En el caso de que tenga el individuo tenga un 					
				// porcentaje de Fitness menor a 0 le debemos asignar  				
				// un lugar en la ruleta
				rep = 1;
			}
			
			// Agregamos a la ruleta el índice que corresponde a los 				
			// cromosomas de la población (0 a 49) tantas repeticiones 			
			// como su porcentaje de Fitness (redondeado) lo indique
			for(int j=0;j<rep;j++)
			{
				ruleta.add(i);
			}
		}
		
		// En el caso de que el tamaño de la ruleta no llegue a 100, 			
		// corregimos este error, agregando tantos lugares que faltan del 		
		// último índice (49)
		if(ruleta.size()<100)
		{
			for(int i=0;ruleta.size()+i<=100;i++)
			{
				ruleta.add(49);
			}
		}
		
	}
	
	
	
	// Método que calcula/acumula los Fitness de la población
	private float sumarFitness() {
		float cont = 0;
		for(int i=0;i<fitness.length;i++)
		{
			cont = cont + fitness[i];
		}
		return cont;
	}
	// Método que calcula el Fitness de cada cromosoma en la población (en 	
	// este caso aplicamos el concepto del Complemento). Además calculamos su 	
	// porcentaje.
	public void calcularFitness() {
		fitness = new float[50];
		porcFitness = new float[50];
		int[] complemento = new int[50];
		int cont = 0;
		
		for(int i=0;i<recorridos.length;i++)
		{
			complemento[i] = total - recorridos[i];
			cont += complemento[i];
		}
		
		for(int i=0;i<recorridos.length;i++)
		{
			
			fitness[i] = ((float)complemento[i]/(float)cont);
			porcFitness[i] = fitness[i]*100;
		}
		
	}

	
	
	
	// Método que calcula el total de los recorridos (el recorrido de cada 	
	// cromosoma) de la población
	public void calcularTotal() {
		total = 0;
		for(int i=0;i<recorridos.length;i++)
		{
			total = total + recorridos[i];
		}
	}
	
	
	
	// Método que recibe dos enteros: un número que se va a buscar (r) y un 	
	// índice (m) que identificará a un individuo de la población hija. 	
	// Devuelve verdadero si el número r se encuentra en el individuo hijo, 	
	// sino, devuelve falso.
	private boolean esta(int r, int m) {
		boolean esta = false;
		for(int i=0;i<23;i++)
		{
			if(poblacionHija[m][i] == r)
			{
				esta = true;
			}
		}		
		return esta;
	}






	// Método que busca el menor recorrido de la población (en cada 		
	// repetición busca la menor distancia en cada iteración)
	private int buscarMenor() {
		int menor = 1000000000;
		for(int i=0;i<50;i++)
		{
			if(recorridos[i]<menor)
			{
				menor = recorridos[i];
			}
		}		
		return menor;
	}

	// Método que calcula el recorrido para cada cromosoma (evalúa cada 	
	// cromosoma en la función objetivo)
	public void calcularRecorridos(int[][] d) {
		recorridos = new int[50];
		
		// Para cada cromosoma (0 a 49 = 50 individuos)
		for(int i=0;i<50;i++)
		{
			int cont = 0;
			int a,b = 0;

			// Calculamos para cromosoma la distancia total, “leyendo” 			
			// los índices del cromosoma: tomamos un índice como punto de 			
			// partida y el siguiente otro punto de fin y buscamos por la 			
			// tabla dicha distancia; así nos vamos moviendo siguiendo 			
			// los índice.
			for(int j=0;j<22;j++)
			{
				a = poblacionInicial[i][j];
				b = poblacionInicial[i][j+1];
				cont = cont + d[a-1][b-1];
			}
			
			// Sumamos al acumulado, lo que debería ser volver del punto 			
			// final del recorrido (último índice del cromosoma) hasta el 			
			// inicio del recorrido (primer índice)
			cont = cont + d[b-1][poblacionInicial[i][0]-1];

			// Agregamos dicho total, al arreglo de recorridos para cada 			
			// cromosoma de la población
			recorridos[i] = cont;
		}
		
	}



	// Método que crea la Población Inicial: generamos 23 números aleatorios 	
	// (del 1 al 23), verificando que dichos números no se repitan
	public void crearPoblacionInicial() {
		for(int i=0;i<50;i++)
		{
			int cont = 0;
			
			//Iteración do while que valida que se hayan generado los 23 			
			// números y que todos no se repitan en el cromosoma[i]
			do
			{
				int nroRandom = generarAleatorio(23,1);
				// Valida que dicho número generado no se encuentre en 				
				// el cromosoma[i] de la población indicial
				if(!(estaNro(i,nroRandom)))
				{
					// Si no está, se guarda
					poblacionInicial[i][cont] = nroRandom;
					cont = cont+1;
				}
			} while (cont<23);
		}
		
	}
	
	

	// Método que genera el número aleatorio a partir de un rango y un número 	
	// de inicio
	private int generarAleatorio(int rango, int inicio) {
		return (int)(rnd.nextDouble()*rango+inicio);
	}

	// Método que valida si un número (nro) se encuentra en un cromosoma (que 	
	// indica ind) de la población inicial
	private boolean estaNro(int ind, int nro) {
		boolean esta = false;
		
		for(int r=0;r<23;r++)
		{
			if(poblacionInicial[ind][r] == nro)
			{
				esta = true;
			}
		}
		
		return esta;
	}

}
