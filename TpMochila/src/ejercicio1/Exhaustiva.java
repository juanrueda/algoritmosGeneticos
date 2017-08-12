package ejercicio1;

import listaElementos.Lista;

public class Exhaustiva {
	
	static int maxvol;
	static int maxp;
	
	public void combinaciones(int[] maxvec, Lista lis){
		int[] vec = new int[10];
		int max = 4200;
		maxp =0;
		maxvol= 0;

		for(int i=0;i<2;i++){
			
			for(int j=0;j<2;j++){
				
				for(int k=0;k<2;k++){
					
					for(int l=0;l<2;l++){
						
						for(int m=0;m<2;m++){
							
							for(int n=0;n<2;n++){
								
								for(int p=0;p<2;p++){
									
									for(int q=0;q<2;q++){
										
										for(int r=0;r<2;r++){
											
											for(int s=0;s<2;s++){
												
												vec[0]= i;
												vec[1]= j;
												vec[2]= k;
												vec[3]= l;
												vec[4]= m;
												vec[5]= n;
												vec[6]= p;
												vec[7]= q;
												vec[8]= r;
												vec[9]= s;
						
							   					int acum=0;
							   					int acump=0;
							   					for (int a=0;a<10;a++){
								  						if (vec[a]==1){
								  							acum=acum+lis.cargaLista()[a][0];
														  }
												}
												if (acum<=max){
														for (int a=0;a<10;a++){
															if (vec[a]==1){
																acump=acump+lis.cargaLista()[a][1];
															}
														}
														if (acump>maxp)
														{
															for (int a=0;a<10;a++)
															{
																maxvec[a]=vec[a];
																maxp=acump;
																maxvol=acum;
															}
														}
													}


		}	}	}	}	}	}	}	}	}	}
	}
	
	public void mostrarValores(int[] maxvec){
		
		for (int a=0;a<10;a++){
			System.out.print(" "+maxvec[a]);
		}
		System.out.println("\n\n Sin tomar el cuarto y el noveno, con un volumen total de "+ maxvol +" cm cubicos \n y un valor total de "+maxp+" pesos. \n");

	}
	}
