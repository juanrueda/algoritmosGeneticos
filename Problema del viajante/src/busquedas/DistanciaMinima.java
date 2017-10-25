package busquedas;

public class DistanciaMinima {
	
	int total=0;
	
	public void buscarMinima(int[][] d, String[][] ciud){
		int totales[] = new int[24];
		Heurística h = new Heurística();
		int min=50000;
		int i=0;
		
		for(i=0;i<23;i++){
			total = (h.buscarRecorrido(d,i,ciud));
			totales[i]= total;
		}
		
		
		for(i=0;i<23;i++){
			if(min > totales[i]){
				min=totales[i];
			}
		}
		
		for(i=0;i<23;i++){
			if(min == totales[i]){
				total = (h.buscarRecorrido(d,i,ciud));
				h.mostrar(ciud, total);
			}
		}
		
	}
}
