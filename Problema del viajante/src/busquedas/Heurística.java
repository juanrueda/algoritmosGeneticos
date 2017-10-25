package busquedas;


public class Heurística {

	int[] orden = new int[24];
	int[] disponible = new int[24];
	int total=0;
	
	
	public int buscarRecorrido(int[][] d, int n,String[][]ciud) {
		
		total=0;
		int j = n;
		inicializa(disponible);
		orden[0] = j;
		disponible[j] = 1;
		
		for (int z = 0; z < 22; z++){
			
			int menor = 5000;
			int pos = 0;
				for (int i = 0; i < 23; i++){
					if ((d[j][i] < menor) && (d[j][i] != 0) && (disponible[i] != 1)){
						menor = d[j][i];
						pos = i;
					}
				}
			j = pos;
			total = total + menor;
			orden[z + 1] = pos;
			disponible[pos] = 1;
		}
		
		total = total + d[j][n]; 
		
		return total;
		}
	
	
	public void inicializa(int[] disponible){
		
		for (int i = 0; i < 23; i++){
		
			disponible[i] = 0;
		}
	}
	
		
	public void mostrar(String[][] ciud, int total){
		
		System.out.println("La ciudad de partida fue: " + ciud[orden[0]][1]);
		System.out.println("El órden del mejor recorrido fue: \n");
		
		for (int w = 1; w < 23; w++){
			System.out.println(ciud[orden[w]][1]);
		}
		
		System.out.println("El total recorrido en kilómetros es:" + total);
	}

}
	


