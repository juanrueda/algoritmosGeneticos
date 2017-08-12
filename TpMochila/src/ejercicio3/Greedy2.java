package ejercicio3;

public class Greedy2 {
	
	float relacionOrdenada[] = new float[3];
	
	
	public void ordenar(int[][] lista2, float[] relacion2, int[][] listaOrdenada2){
		
		int aux=0;
		float auxr=0;
		for(int i=0; i<3; i++){
			relacionOrdenada[i] = relacion2[i];
			for(int j=0; j<3; j++){
				listaOrdenada2[i][j] = lista2[i][j];
			}
		}
		for(int i=0; i<3; i++){
			int max = i;
		
			//numero mayor
			for (int j = i+1; j<3; j++) {
	            if (relacionOrdenada[j] > relacionOrdenada[max]) {
	                max = j;    //encontramos el mayor número
	            }
	        }
			if (i != max) {
	            //permutamos los valores
	            auxr = relacionOrdenada[i];
	            relacionOrdenada[i] = relacionOrdenada[max];
	            relacionOrdenada[max] = auxr;
	            for(int k=0;k<3;k++)
	    		{
	    			aux=listaOrdenada2[i][k];
	    			listaOrdenada2[i][k]=listaOrdenada2[max][k];
	    			listaOrdenada2[max][k]=aux;
	    			}
	        }
		}	
	}
	
	public void cargarMochila(int[][] listaOrdenada2){
		int banderaPeso =0 ,i=0, contPeso=0,contValor=0, entra=1; //entra = 1 SI ENTRA - entra = 0 NO ENTRA
		int[][] mochila = new int[3][3];
		
		contPeso = listaOrdenada2[0][0];
		contValor = listaOrdenada2[0][1];
		mochila[0][0] = listaOrdenada2[0][0];
		mochila[0][1] = listaOrdenada2[0][1];
		mochila[0][2]= listaOrdenada2[0][2];
		this.mostrar(contPeso, contValor, mochila, i);
		do{
			banderaPeso = contPeso + listaOrdenada2[i++][0];
		
			if(banderaPeso <= 3000){
				
				mochila[i][2] = listaOrdenada2[i][2];
				mochila[i][0] = listaOrdenada2[i][0];		
				mochila[i][1] = listaOrdenada2[i][1];
				contPeso = contPeso + listaOrdenada2[i][0];
				contValor = contValor + listaOrdenada2[i][1];
				this.mostrar(contPeso, contValor, mochila, i);
			} else {
				entra = 0;
			}
			
			i++;
		} while(entra != 0 && i<2);

	}
	
	public void mostrar(int contPeso, int contValor, int[][] mochila, int i){
		System.out.println("Se introdujo el objeto "+mochila[i][2]);
		System.out.println("Contenido final "+contPeso+ " grs con un valor de $"+contValor);
	}
	
	/*public void mostrar(int[][] listaOrdenada2, float[] relacion2){
		int contPeso=0;
		int cont=0;
		int contValor=0;
		
		do{
			contPeso=contPeso+listaOrdenada2[cont][0];
			contValor=contValor+listaOrdenada2[cont][1];
			if(contPeso > 3000){
				contPeso = contPeso - listaOrdenada2[cont][0];
				contValor = contValor - listaOrdenada2[cont][1];
			}
			System.out.println(" \nse metio el objeto "+(listaOrdenada2[cont][2]));
			System.out.println(" contenido final "+contPeso+" con un valor de "+contValor);
			cont++;
		}while(contPeso < 3000 && cont<3);
	}*/

}
