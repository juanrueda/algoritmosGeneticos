package ejercicio3;

import listaElementos.Lista2;

public class Exhaustiva2 {
	int maxPeso;
	int maxValor;
	
	public void combinaciones(int[] maxvec, Lista2 lis){
		int[] vec = new int[3];
		int max = 3000;
		maxPeso = 0;
		maxValor = 0;
		
		for(int i=0; i<2; i++){
			
			for(int j=0; j<2; j++){
				
				for(int k=0; k<2; k++){
					
					vec[0] = i;
					vec[1] = j;
					vec[2] = k;
					
					int acumPeso = 0;
					int acumValor = 0;
					for(int l =0; l<3; l++){
						if(vec[l] == 1){
							acumPeso = acumPeso + lis.cargaLista2()[l][0];
						}
					}
					if(acumPeso <= max){
						for(int l=0; l<3; l++){
							if(vec[l] == 1){
								acumValor = acumValor + lis.cargaLista2()[l][1];
							}
						}
						if(acumValor > maxValor){
							for(int l=0; l<3; l++){
								maxvec[l] = vec[l];
								maxValor = acumValor;
								maxPeso = acumPeso;
							}
						}
					}

				}
			}
			
		}
	}
	
	public void mostrarValores2(int[] maxvec){
		
		for (int a=0;a<3;a++){
			System.out.print(" "+maxvec[a]);
		}
		System.out.println("\nSin tomar el segundo, con un peso total de "+maxPeso+" grs \n, y un valor total de "+maxValor+" pesos. \n");
	}

}
