package listaElementos;

public class Lista2 {
	
	int[][] lista2 = new int[3][3];
	float[] relacion2 = new float[3];
	
	public int[][] cargaLista2(){
		lista2[0][2] = 1;
		lista2[1][2] = 2;
		lista2[2][2] = 3;
		
		lista2[0][0] = 1800;
		lista2[1][0] = 600;
		lista2[2][0] = 1200;
		
		lista2[0][1] = 72;
		lista2[1][1] = 36;
		lista2[2][1] = 60;
		
		return lista2;
		
	}
	
	public float[] cargarRelacion(){
		for (int i=0;i<3;i++){
			relacion2[i] = ((float) lista2[i][1]) / lista2[i][0];
		}
		return relacion2;

	}
	
	public void mostrarLista(){
		for(int i=0; i<3; i++){
			for(int j=0; j<2; j++){
				System.out.println("\n");
				System.out.println(lista2[i][j]);
			}
		}
	}

}
