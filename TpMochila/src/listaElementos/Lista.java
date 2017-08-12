package listaElementos;

public class Lista {
	
	int[][] lista = new int[10][3];
	float[] relacion = new float[10];
	
	
	public int[][] cargaLista(){
		//Carga Volumen
		lista[0][0] = 150;
		lista[1][0] = 325;
		lista[2][0] = 600;
		lista[3][0] = 805;
		lista[4][0] = 430;
		lista[5][0] = 1200;
		lista[6][0] = 770;
		lista[7][0] = 60;
		lista[8][0] = 930;
		lista[9][0] = 353;
				
		//Carga Valor
				
		lista[0][1] = 20;
		lista[1][1] = 40;
		lista[2][1] = 50;
		lista[3][1] = 36;
		lista[4][1] = 25;
		lista[5][1] = 64;
		lista[6][1] = 54;
		lista[7][1] = 18;
		lista[8][1] = 46;
		lista[9][1] = 28;
		
		//Carga Objetos
		lista[0][2] = 1;
		lista[1][2] = 2;
		lista[2][2] = 3;
		lista[3][2] = 4;
		lista[4][2] = 5;
		lista[5][2] = 6;
		lista[6][2] = 7;
		lista[7][2] = 8;
		lista[8][2] = 9;
		lista[9][2] = 10;
				
		return lista;
	}
	
	public float[] cargarRelacion(){
		for(int i=0;i<10;i++){
			relacion[i] = ((float) lista[i][1]) / lista[i][0];
		}
		return relacion;

	}
	
	public void mostrarLista(){
		for(int i=0; i<10; i++){
			for(int j=0; j<2;j++){
				System.out.println("\n");
				System.out.println(lista[i][j]);
			}
		}
	}
}
