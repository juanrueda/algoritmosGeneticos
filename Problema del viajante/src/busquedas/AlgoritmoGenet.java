package busquedas;

import java.util.ArrayList;
import java.util.Random;
//import java.util.Scanner;

public class AlgoritmoGenet
{

	// Declaraci�n de variables de clase
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
		// M�todo de clase que crea la poblaci�n inicial (primeros padres): 		
	 	// 50 individuos/cromosomas de 23 genes 
		crearPoblacionInicial();
		
		// M�todo que calcula para cada cromosoma de la poblaci�n, el 			
		// recorrido total de cada uno (eval�a cada cromosoma en la funci�n 		
		// objetivo que calcula la distancia)
		calcularRecorridos(d);
		
		// M�todo que calcula el total de todos los recorridos
		calcularTotal();
		
		// M�todo que calcula el Fitness para cada individuo de la 			
		// poblaci�n
		calcularFitness();
		
		// M�todo que crea la ruleta para la poblaci�n en base al Fitness 		
		// de cada uno de sus integrantes
		crearRuleta();

		
		// Mostramos en pantalla cada uno de los cromosomas de la poblaci�n 		
		// inicial (recorridos) con su respectiva distancia, Fitness y 			
		// porcentaje del Fitness
		System.out.println("Recorrido\t\t\t\tDistancia");
		for(int i=0;i<50;i++){
			for(int j=0;j<23;j++){
				System.out.print(poblacionInicial[i][j]+" ");
			}
			System.out.println(" "+recorridos[i]+" \t"+fitness[i]+"	  \t"+porcFitness[i]);
		}
		
		// Guardamos en un arreglo que acumular� por cada iteraci�n la 			
		// menor distancia de toda la poblaci�n (recorridosMenores[]), la 		
		// menor distancia de la poblaci�n inicial
		recorridosMenores[0]=buscarMenor();
		
		// Mostramos por consola: la menor distancia, la sumatoria de las 		
		// distancias de la poblaci�n y la suma de los Fitness (para 			
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
			
			System.out.println("\nTama�o ruleta: "+ruleta.size());
		
			// Hacemos las tiradas a la ruleta (generamos 50 n�meros 				
			// aleatorios de 0 a 99, 50 ubicaciones en la ruleta que 				
			// ser�n los padres que van reproducirse)
			tiradas = new int[50];
			for(int i=0;i<50;i++)
			{
				// generarAleatorio que calcula n�meros aleatorios a 				
				// partir del ingreso del rango y del inicio, a partir 				
				// de cual generar el n�mero
				tiradas[i] = generarAleatorio(100,0);
			}
			
			// Generamos 25 n�meros aleatorios del 1 al 100 que 				
			// corresponder�n a las probabilidades de cruza para cada par 			
			// de padres elegidos en las tiradas a la ruleta
			probCruza = new int[25];
			for(int i=0;i<25;i++)
			{
				probCruza[i] = generarAleatorio(100,1);
			}
	
			// Generamos 50 n�meros aleatorios del 1 al 100 que 				
			// corresponder�n a las probabilidades de mutaci�n para cada 			
			// todas las cruzas obtenidas
			probMuta = new int[50];
			for(int i=0;i<50;i++)
			{
				probMuta[i] = generarAleatorio(100,1);
			}

			poblacionHija = new int[50][23];
			
			// Inicializamos los �ndices de los hijos
			int m = 0;
			int n = 1;

			// Comenzamos las cruzas: para cada par de padres, le 				
			// corresponde uno de los 25 n�meros aleatorios 					
			// correspondientes a la probabilidad de cruza
			for(int i=0;i<25;i++)
			{


				// Identificamos en dos �ndices a y b los padres en la 				
				// ruleta que corresponden a las tiradas
				int a = ruleta.get(tiradas[m]);
				int b = ruleta.get(tiradas[n]);

				System.out.println(a+" "+b);

				// Guardamos el primer gen de los cromosomas padres 				
				// (correspondientes a los �ndices a y b) en el primer 				
				// gen de los cromosomas hijos respectivamente
				poblacionHija[m][0] = poblacionInicial[a][0];
				poblacionHija[n][0] = poblacionInicial[b][0];

				// Si la probabilidad[i] es menor o igual a la 					
				// variable estatica pc (instanciada con un valor 					
				// determinado por el grupo)�
				if(probCruza[i]<=pc)
				{
					// Se cruzan: crossover c�clico
					System.out.println("Cruzan\n");
					
					// Con el segundo cromosoma padre
					// Asignamos a una variable entera r, el primer 					
					// gen del segundo padre
					int r = poblacionInicial[b][0];

					// Una iteraci�n while donde la condici�n est� 					
					// determinada por la funci�n esta(): recibe 						
					// como par�metro el primer gen del segundo 						
					// padre y el �ndice del primer padre). 
					// Si la funci�n devuelve verdadero, se termina 					
					// la iteraci�n, en cambio, si devuelve falso, 					
					// contin�a con la iteraci�n
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
								// en la misma ubicaci�n 									
								// donde se encontraba r									
								poblacionHija[m][j] = r;


								// Asignamos a la variable r 								
								// (para las siguientes 									
								// iteraciones) el valor del 								
								// gen del segundo padre, en 								
								// la misma ubicaci�n donde 								
								// se encontr� que el valor 								
								// anterior de r coincid�a 								
								// con el gen del primer 									
								// padre
								r = poblacionInicial[b][j];

								// Al realizar estos 									
								// pasajes, cortamos la 									
								// iteraci�n for.
								break;
							}
						}
					}												
					// Cuando ya est� el valor de r en el gen del 					
					// segundo padre, es decir, que se termina la 					
					// iteraci�n while. Completamos el primer 						
					// cromosoma hijo con los genes del segundo 						
					// padre, en la misma ubicaci�n en la que estos 					
					// se encuentran.
					for(int j=0;j<23;j++)
					{
						if(poblacionHija[m][j] == 0)
						{
							poblacionHija[m][j] = poblacionInicial[b][j];
						}
					}

					//Lo mismo que se aplic� anteriormente, pero 						
					// iniciando con el primer gen del primer padre
					r = poblacionInicial[a][0];

					// La funci�n esta recibe el gen del primer 						
					// cromosoma	padre (r) y el �ndice que 						
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
				
				// Si la probabilidad[i] no es menor o igual�
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
			
			// Mostramos en pantalla la poblaci�n hija sin mutar
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

			// Para los 50 n�meros aleatorios (probMuta[]) que 					
			// corresponden a la mutaci�n
			for(int i=0;i<50;i++)
			{
				



				// Si la probMuta[i] es menor a la probabilidad de 					
				// mutar (determinada por el programador)�
				if(probMuta[i]<=pm)
				{
					// Existe mutaci�n: de intercambio
					System.out.println("Muta");

					// Para esta mutaci�n, generamos dos n�meros 						
					// aleatorios de 0 a 22, correspondientes a dos 					
					// ubicaciones del cromosoma[i] de la poblaci�n 					
					// hija que van a intercambiarse
					int ub1 = generarAleatorio(23,0);
					System.out.print(ub1+" ");
					int ub2;
					do{
						// Al haber generado el primer n�mero 							
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
				// mutar� No muta
				else
				{
					System.out.println("No muta");
				}
			}
						
			System.out.println(" ");
			
			// Pasamos el arreglo multidimensional (todo el conjunto) de 			
			// cromosomas hijas a otro arreglo del mismo estilo que 				
			// corresponder� a los cromosomas padres de la siguiente 				
			// iteraci�n
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
			
			// Mostramos en pantalla: poblaci�n hija resultante, por cada 			
			// cromosoma su evaluaci�n en la funci�n objetivo, su Fitness 			
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
			// recorrido de la iteraci�n (rep)
			recorridosMenores[rep]=buscarMenor();
			
			// Mostramos en pantalla, la menor distancia de la iteraci�n, 			
			// la sumatoria de todos los recorridos de la iteraci�n y la 			
			// suma de todos los Fitness de la iteraci�n 
			System.out.println("\nLa menor distancia es: " 		+recorridosMenores[rep]+" kilometros.");
			System.out.println("\nTotal: "+total+" km. Suma Fitness: " 				+sumarFitness()+"\n");	
			
			// Calculamos total, Fitness y creamos la ruleta, para la 			
			// siguiente iteraci�n
			calcularTotal();
			calcularFitness();
			crearRuleta();
			
		}
		
		// Mostramos el arreglo de distancias menores obtenidas en cada 			
		// iteraci�n
		System.out.println("Menores distancias recorridas por poblaci�n:");
		for(int i=0;i<200;i++)
		{
			System.out.println(recorridosMenores[i]);			
		}
		
		// Mostramos el recorrido/la ruta correspondiente a la �ltima menor 		
		// distancia obtenida
		System.out.println("\nRecorrido con menor distancia:");
		for(int i=0;i<23;i++)
		{
			System.out.println(poblacionHija[49][i]+" - " 		+ciudades[poblacionHija[49][i]-1][1]);
		}
		// Agregamos a lo �ltimo, la vuelta hacia la ciudad de partida
		System.out.println(poblacionHija[49][0]+" - " 		+ciudades[poblacionHija[49][0]-1][1]);
		
		// Mostramos la  distancia de dicho recorrido
		System.out.println("Distancia: "+recorridosMenores[199]+" km.");
}

	
	
	
	// M�todo que crea la ruleta
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
			
			// Agregamos a la ruleta el �ndice que corresponde a los 				
			// cromosomas de la poblaci�n (0 a 49) tantas repeticiones 			
			// como su porcentaje de Fitness (redondeado) lo indique
			for(int j=0;j<rep;j++)
			{
				ruleta.add(i);
			}
		}
		
		// En el caso de que el tama�o de la ruleta no llegue a 100, 			
		// corregimos este error, agregando tantos lugares que faltan del 		
		// �ltimo �ndice (49)
		if(ruleta.size()<100)
		{
			for(int i=0;ruleta.size()+i<=100;i++)
			{
				ruleta.add(49);
			}
		}
		
	}
	
	
	
	// M�todo que calcula/acumula los Fitness de la poblaci�n
	private float sumarFitness() {
		float cont = 0;
		for(int i=0;i<fitness.length;i++)
		{
			cont = cont + fitness[i];
		}
		return cont;
	}
	// M�todo que calcula el Fitness de cada cromosoma en la poblaci�n (en 	
	// este caso aplicamos el concepto del Complemento). Adem�s calculamos su 	
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

	
	
	
	// M�todo que calcula el total de los recorridos (el recorrido de cada 	
	// cromosoma) de la poblaci�n
	public void calcularTotal() {
		total = 0;
		for(int i=0;i<recorridos.length;i++)
		{
			total = total + recorridos[i];
		}
	}
	
	
	
	// M�todo que recibe dos enteros: un n�mero que se va a buscar (r) y un 	
	// �ndice (m) que identificar� a un individuo de la poblaci�n hija. 	
	// Devuelve verdadero si el n�mero r se encuentra en el individuo hijo, 	
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






	// M�todo que busca el menor recorrido de la poblaci�n (en cada 		
	// repetici�n busca la menor distancia en cada iteraci�n)
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

	// M�todo que calcula el recorrido para cada cromosoma (eval�a cada 	
	// cromosoma en la funci�n objetivo)
	public void calcularRecorridos(int[][] d) {
		recorridos = new int[50];
		
		// Para cada cromosoma (0 a 49 = 50 individuos)
		for(int i=0;i<50;i++)
		{
			int cont = 0;
			int a,b = 0;

			// Calculamos para cromosoma la distancia total, �leyendo� 			
			// los �ndices del cromosoma: tomamos un �ndice como punto de 			
			// partida y el siguiente otro punto de fin y buscamos por la 			
			// tabla dicha distancia; as� nos vamos moviendo siguiendo 			
			// los �ndice.
			for(int j=0;j<22;j++)
			{
				a = poblacionInicial[i][j];
				b = poblacionInicial[i][j+1];
				cont = cont + d[a-1][b-1];
			}
			
			// Sumamos al acumulado, lo que deber�a ser volver del punto 			
			// final del recorrido (�ltimo �ndice del cromosoma) hasta el 			
			// inicio del recorrido (primer �ndice)
			cont = cont + d[b-1][poblacionInicial[i][0]-1];

			// Agregamos dicho total, al arreglo de recorridos para cada 			
			// cromosoma de la poblaci�n
			recorridos[i] = cont;
		}
		
	}



	// M�todo que crea la Poblaci�n Inicial: generamos 23 n�meros aleatorios 	
	// (del 1 al 23), verificando que dichos n�meros no se repitan
	public void crearPoblacionInicial() {
		for(int i=0;i<50;i++)
		{
			int cont = 0;
			
			//Iteraci�n do while que valida que se hayan generado los 23 			
			// n�meros y que todos no se repitan en el cromosoma[i]
			do
			{
				int nroRandom = generarAleatorio(23,1);
				// Valida que dicho n�mero generado no se encuentre en 				
				// el cromosoma[i] de la poblaci�n indicial
				if(!(estaNro(i,nroRandom)))
				{
					// Si no est�, se guarda
					poblacionInicial[i][cont] = nroRandom;
					cont = cont+1;
				}
			} while (cont<23);
		}
		
	}
	
	

	// M�todo que genera el n�mero aleatorio a partir de un rango y un n�mero 	
	// de inicio
	private int generarAleatorio(int rango, int inicio) {
		return (int)(rnd.nextDouble()*rango+inicio);
	}

	// M�todo que valida si un n�mero (nro) se encuentra en un cromosoma (que 	
	// indica ind) de la poblaci�n inicial
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
