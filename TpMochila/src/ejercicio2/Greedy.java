package ejercicio2;

//import listaElementos.Lista;

public class Greedy {
	
	float[] relacionOrdenada = new float[10];
	
	public void ordenar(int[][] lista, float[] relacion, int[][] listaOrdenada){
	
		int aux=0;
		float auxr=0;
		for(int i=0;i<10;i++){
			relacionOrdenada[i] = relacion[i];
			for(int k=0;k<3;k++){
				listaOrdenada[i][k]=lista[i][k];
			}
			
		}
		
		for(int i=0; i<10; i++) {
	        int max = i;
	
	        //buscamos el mayor número
	        for (int j=i+1; j<10; j++){
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
	    			aux=listaOrdenada[i][k];
	    			listaOrdenada[i][k]=listaOrdenada[max][k];
	    			listaOrdenada[max][k]=aux;
	    			}
	        }
		}
	}
	
	
	
	public void cargarMochila(int[][] listaOrdenada){
		int banderaVol =0,i=0, contVol=0,contValor=0, entra=1; //entra = 1 SI ENTRA - entra = 0 NO ENTRA
		int[][] mochila = new int[10][3];
		
		contVol = listaOrdenada[0][0];
		contValor = listaOrdenada[0][1];
		mochila[0][0] = listaOrdenada[0][0];
		mochila[0][1] = listaOrdenada[0][1];
		mochila[0][2]= listaOrdenada[0][2];
		this.mostrar(contVol, contValor, mochila, i);
		i++;
		do{
			banderaVol = contVol + listaOrdenada[i+1][0];    //Como un acumulador "anticipado", banderaVol verifica si se puede llenar mas la mochila
			if(banderaVol >= 4200){
				entra = 0;									//Si el proximo obejeto va a supererar el tamaño disponible, no entra
			} else{
				mochila[i][2] = listaOrdenada[i][2];
				mochila[i][0] = listaOrdenada[i][0];		
				mochila[i][1] = listaOrdenada[i][1];
				contVol = contVol + listaOrdenada[i][0];
				contValor = contValor + listaOrdenada[i][1];
				this.mostrar(contVol, contValor, mochila, i);
			}
			i++;
		} while (entra != 0 && i<10);

	}
	
	public void mostrar(int contVol, int contValor, int[][] mochila, int i){
		System.out.println("Se introdujo el objeto "+mochila[i][2]);
		System.out.println("Contenido final "+contVol+ " cm3 con un valor de $"+contValor);
	}

}
