package distancias;

import java.util.Scanner;
import capitales.Capitales;

public class DistanciasCapitales {
	
	int distancias[][] = new int[24][24];
	int distanciasOrdenadas [][] = new int[23][2];
	private Scanner s;
	
	
	public int buscarProvincia(int n){
		
		s = new Scanner(System.in);
		int prov;
		String nombre;
		String ciud[][];
		Capitales cap = new Capitales();
		//int distanciasOrdenadas [][] = new int[23][2];
		
		this.cargarDistancias();
		
		System.out.println("Ingrese el numero de la provincia");
		prov = Integer.parseInt(s.nextLine());
		
		//encontrar ubicacion de provincia ingresada ---- prov -1 es la posicion de la provincia en el arreglo
		
		n = prov -1;
		ciud = cap.cargaCapitales();
		
		nombre = ciud[n][1];
		
		System.out.println("Ingreso la provincia:"+nombre);
				
		
		return n;
	}
	
	public void ordenarDistancias(int n){
		
		int aux = 0, aux2=0;
		
		this.cargarDistancias();
		
		for(int i =0; i<23; i++){
			distanciasOrdenadas[i][0] = i+1; 
			distanciasOrdenadas[i][1] = distancias[n][i];
		}
		
		
		for(int i=0; i< (distanciasOrdenadas.length-1); i++){
			for(int j=i+1; j < distanciasOrdenadas.length; j++){
				if(distanciasOrdenadas[i][1] > distanciasOrdenadas[j][1]){
					aux = distanciasOrdenadas[i][1];
					aux2 = distanciasOrdenadas[i][0];
					distanciasOrdenadas[i][1] = distanciasOrdenadas[j][1];
					distanciasOrdenadas[i][0] = distanciasOrdenadas[j][0];
					distanciasOrdenadas[j][1] = aux;
					distanciasOrdenadas[j][0] = aux2;
				}
			}
		}
		
		for(int i =0; i< 23; i++){
			for(int j=0; j< 2; j++){
			System.out.println(distanciasOrdenadas[i][j]);
			System.out.println("\n");
			}
		}
		
	}
	
	public int[][] cargarDistancias(){
		
		// BS. AS.
		distancias[0][0]=0;
		distancias[0][1]=1543;
		distancias[0][2]=1510;
		distancias[0][3]=1203;
		distancias[0][4]=1043;
		distancias[0][5]=1191;
		distancias[0][6]=1023;
		distancias[0][7]=478;
		distancias[0][8]=940;
		distancias[0][9]=1040;
		distancias[0][10]=480;
		distancias[0][11]=715;
		distancias[0][12]=1150;
		distancias[0][13]=1110;
		distancias[0][14]=790;
		distancias[0][15]=1155;
		distancias[0][16]=1050;
		distancias[0][17]=620;
		distancias[0][18]=1158;
		distancias[0][19]=960;
		distancias[0][20]=1455;
		distancias[0][21]=2635;
		distancias[0][22]=3228;
		distancias[0][23]=1;

		//San s. d. Jujuy
		
		distancias[1][0]=distancias[0][1];
		distancias[1][0] = 1543;
		distancias[1][1] =0;
		distancias[1][2] =99;
		distancias[1][3] =340; 
		distancias[1][4] =500;
		distancias[1][5] =960; 
		distancias[1][6] =860 ;
		distancias[1][7] =1107 ;
		distancias[1][8] =883 ;
		distancias[1][9] =1198 ;
		distancias[1][10] =1138 ;
		distancias[1][11] =930 ;
		distancias[1][12] =770 ;
		distancias[1][13] =1220;
		distancias[1][14] =1320;
		distancias[1][15] = 572 ;
		distancias[1][16] =1345;
		distancias[1][17] = 1530;
		distancias[1][18] =2200 ;
		distancias[1][19] =2124 ;
		distancias[1][20] =	2385;
		distancias[1][21] = 3565;
		distancias[1][22] = 4158;
		distancias[1][23]=2;
		
		//Salta
		distancias[2][0]=distancias[0][2];
		distancias[2][1]=distancias[1][2];
		distancias[2][2]=0;
		distancias[2][3]=307 ;
		distancias[2][4]=467 ;
		distancias[2][5]=948 ;
		distancias[2][6]=780 ;
		distancias[2][7]=1074 ;
		distancias[2][8]=803 ;
		distancias[2][9]=1118;
		distancias[2][10]= 1105 ;
		distancias[2][11]=897 ;
		distancias[2][12]=695 ;
		distancias[2][13]=1145 ;
		distancias[2][14]=1245 ;
		distancias[2][15]=539 ;
		distancias[2][16]=1227 ;
		distancias[2][17]=1497 ;
		distancias[2][18]=2082 ;
		distancias[2][19]=2091 ;
		distancias[2][20]=2352 ;
		distancias[2][21]=3532;
		distancias[2][22]= 4125;
		distancias[2][23]=3;
		
		
		
		// San m. de Tucuman.
		distancias[3][0]=distancias[0][3];
		distancias[3][1]=distancias[1][3];
		distancias[3][2]=distancias[2][3];
		distancias[3][3]=0;
		distancias[3][4]=160 ;
		distancias[3][5]=936 ;
		distancias[3][6]=768 ;
		distancias[3][7]=767 ;
		distancias[3][8]=791 ;
		distancias[3][9]=1106 ;
		distancias[3][10]=798 ;
		distancias[3][11]=590 ;
		distancias[3][12]=338 ;
		distancias[3][13]=838 ;
		distancias[3][14]=938 ;
		distancias[3][15]=232;
		distancias[3][16]= 1005;
		distancias[3][17]= 1190;
		distancias[3][18]= 1860 ;
		distancias[3][19]=1784;
		distancias[3][20]= 2045 ;
		distancias[3][21]=3225 ;
		distancias[3][22]=3818;
		distancias[3][23]=4;
		
		
		// Santiago del estero
		distancias[4][0]=distancias[0][4];
		distancias[4][1]=distancias[1][4];
		distancias[4][2]=distancias[2][4];
		distancias[4][3]=distancias[3][4];
		distancias[4][4]=0;
		distancias[4][5]=776; 
		distancias[4][6]=610;
		distancias[4][7]= 607;
		distancias[4][8]= 633;
		distancias[4][9]= 948;
		distancias[4][10]= 638;
		distancias[4][11]= 430 ;
		distancias[4][12]=360;
		distancias[4][13]= 810;
		distancias[4][14]= 850;
		distancias[4][15]= 212 ;
		distancias[4][16]=977;
		distancias[4][17]= 1030 ;
		distancias[4][18]=1567;
		distancias[4][19]= 1624;
		distancias[4][20]= 1885;
		distancias[4][21]= 3065 ;
		distancias[4][22]=3658;
		distancias[4][23]=5;
		
		// Formosa
		distancias[5][0]=distancias[0][5];
		distancias[5][1]=distancias[1][5];
		distancias[5][2]=distancias[2][5];
		distancias[5][3]=distancias[3][5];
		distancias[5][4]=distancias[4][5];
		distancias[5][5]=0;
		distancias[5][6]=168 ;
		distancias[5][7]=713 ;
		distancias[5][8]=191 ;
		distancias[5][9]=506 ;
		distancias[5][10]=744 ;
		distancias[5][11]=1043 ;
		distancias[5][12]=1136;
		distancias[5][13]= 1543 ;
		distancias[5][14]=1463;
		distancias[5][15]= 988 ;
		distancias[5][16]=1710 ;
		distancias[5][17]=1523 ;
		distancias[5][18]=2060 ;
		distancias[5][19]=2117 ;
		distancias[5][20]=2378 ;
		distancias[5][21]=3558 ;
		distancias[5][22]=4151;
		distancias[5][23]=6;
		
		// Resistencia.
		distancias[6][0]=distancias[0][6];
		distancias[6][1]=distancias[1][6];
		distancias[6][2]=distancias[2][6];
		distancias[6][3]=distancias[3][6];
		distancias[6][4]=distancias[4][6];
		distancias[6][5]=distancias[5][6];
		distancias[6][6]=0;
		distancias[6][7]=545 ;
		distancias[6][8]=23 ;
		distancias[6][9]=338;
		distancias[6][10]= 576 ;
		distancias[6][11]=875 ;
		distancias[6][12]=970 ;
		distancias[6][13]=1420 ;
		distancias[6][14]=1295 ;
		distancias[6][15]=822 ;
		distancias[6][16]=1587;
		distancias[6][17]= 1475 ;
		distancias[6][18]=2012 ;
		distancias[6][19]=2069 ;
		distancias[6][20]=2210 ;
		distancias[6][21]=3390;
		distancias[6][22]= 3983;
		distancias[6][23]=7;
		
		// Santa fe
		distancias[7][0]=distancias[0][7];
		distancias[7][1]=distancias[1][7];
		distancias[7][2]=distancias[2][7];
		distancias[7][3]=distancias[3][7];
		distancias[7][4]=distancias[4][7];
		distancias[7][5]=distancias[5][7];
		distancias[7][6]=distancias[6][7];
		distancias[7][7]=0;
		distancias[7][8]=568;
		distancias[7][9]= 883 ;
		distancias[7][10]=31;
		distancias[7][11]= 330;
		distancias[7][12]= 765 ;
		distancias[7][13]=830 ;
		distancias[7][14]=625;
		distancias[7][15]= 770;
		distancias[7][16]= 885;
		distancias[7][17]= 810;
		distancias[7][18]= 1347;
		distancias[7][19]= 1404 ;
		distancias[7][20]=1665 ;
		distancias[7][21]=2845;
		distancias[7][22]=3438;
		distancias[7][23]=8;
		
		
		//Corrientes
		distancias[8][0]=distancias[0][8];
		distancias[8][1]=distancias[1][8];
		distancias[8][2]=distancias[2][8];
		distancias[8][3]=distancias[3][8];
		distancias[8][4]=distancias[4][8];
		distancias[8][5]=distancias[5][8];
		distancias[8][6]=distancias[6][8];
		distancias[8][7]=distancias[7][8];
		distancias[8][8]=0;
		distancias[8][9]=315;
		distancias[8][10]=590;
		distancias[8][11]= 898;
		distancias[8][12]= 993;
		distancias[8][13]= 1398;
		distancias[8][14]= 1318;
		distancias[8][15]= 845 ;
		distancias[8][16]=1565 ;
		distancias[8][17]=1378;
		distancias[8][18]=1989;
		distancias[8][19]= 2046;
		distancias[8][20]= 2187;
		distancias[8][21]= 3367;
		distancias[8][22]=3960;
		distancias[8][23]=9;
		
		
		// Posadas
		distancias[9][0]=distancias[0][9];
		distancias[9][1]=distancias[1][9];
		distancias[9][2]=distancias[2][9];
		distancias[9][3]=distancias[3][9];
		distancias[9][4]=distancias[4][9];
		distancias[9][5]=distancias[5][9];
		distancias[9][6]=distancias[6][9];
		distancias[9][7]=distancias[7][9];
		distancias[9][8]=distancias[8][9];
		distancias[9][9]=0;
		distancias[9][10]=820 ;
		distancias[9][11]=1213;
		distancias[9][12]= 1308 ;
		distancias[9][13]=1758 ;
		distancias[9][14]=1633 ;
		distancias[9][15]=1160 ;
		distancias[9][16]=1925 ;
		distancias[9][17]=1660 ;
		distancias[9][18]=2198;
		distancias[9][19]= 2000 ;
		distancias[9][20]=2495 ;
		distancias[9][21]=3675 ;
		distancias[9][22]=4268;
		distancias[9][23]=10;
		
		// Paraná
		distancias[10][0]=distancias[0][10];
		distancias[10][1]=distancias[1][10];
		distancias[10][2]=distancias[2][10];
		distancias[10][3]=distancias[3][10];
		distancias[10][4]=distancias[4][10];
		distancias[10][5]=distancias[5][10];
		distancias[10][6]=distancias[6][10];
		distancias[10][7]=distancias[7][10];
		distancias[10][8]=distancias[8][10];
		distancias[10][9]=distancias[9][10];
		distancias[10][10]=0;
		distancias[10][11]=361 ;
		distancias[10][12]=796 ;
		distancias[10][13]=861 ;
		distancias[10][14]=656 ;
		distancias[10][15]=801;
		distancias[10][16]= 916;
		distancias[10][17]= 841 ;
		distancias[10][18]= 1378 ;
		distancias[10][19]=1435;
		distancias[10][20]= 1696 ;
		distancias[10][21]=2876  ;
		distancias[10][22]=3469;
		distancias[10][23]=11;
		
		//Córdoba
		distancias[11][0]=distancias[0][11];
		distancias[11][1]=distancias[1][11];
		distancias[11][2]=distancias[2][11];
		distancias[11][3]=distancias[3][11];
		distancias[11][4]=distancias[4][11];
		distancias[11][5]=distancias[5][11];
		distancias[11][6]=distancias[6][11];
		distancias[11][7]=distancias[7][11];
		distancias[11][8]=distancias[8][11];
		distancias[11][9]=distancias[9][11];
		distancias[11][10]=distancias[10][11];
		distancias[11][11]=0;
		distancias[11][12]=435;
		distancias[11][13]=500 ;
		distancias[11][14]=420;
		distancias[11][15]= 440;
		distancias[11][16]= 670;
		distancias[11][17]=600;
		distancias[11][18]= 1137;
		distancias[11][19]= 1194;
		distancias[11][20]= 1455;
		distancias[11][21]= 3635 ;
		distancias[11][22]=3228;
		distancias[11][23]=12;
		
		
		// La rioja
		distancias[12][0]=distancias[0][12];
		distancias[12][1]=distancias[1][12];
		distancias[12][2]=distancias[2][12];
		distancias[12][3]=distancias[3][12];
		distancias[12][4]=distancias[4][12];
		distancias[12][5]=distancias[5][12];
		distancias[12][6]=distancias[6][12];
		distancias[12][7]=distancias[7][12];
		distancias[12][8]=distancias[8][12];
		distancias[12][9]=distancias[9][12];
		distancias[12][10]=distancias[10][12];
		distancias[12][11]=distancias[11][12];
		distancias[12][12]=0;
		distancias[12][13]=450;
		distancias[12][14]=550 ;
		distancias[12][15]=156;
		distancias[12][16]= 617 ;
		distancias[12][17]=1035 ;
		distancias[12][18]=1472;
		distancias[12][19]= 1629 ;
		distancias[12][20]=1890;
		distancias[12][21]= 3070 ;
		distancias[12][22]=3663;
		distancias[12][23]=13;
		
		// San Juan
		distancias[13][0]=distancias[0][13];
		distancias[13][1]=distancias[1][13];
		distancias[13][2]=distancias[2][13];
		distancias[13][3]=distancias[3][13];
		distancias[13][4]=distancias[4][13];
		distancias[13][5]=distancias[5][13];
		distancias[13][6]=distancias[6][13];
		distancias[13][7]=distancias[7][13];
		distancias[13][8]=distancias[8][13];
		distancias[13][9]=distancias[9][13];
		distancias[13][10]=distancias[10][13];
		distancias[13][11]=distancias[11][13];
		distancias[13][12]=distancias[12][13];
		distancias[13][13]=0;
		distancias[13][14]=320 ;
		distancias[13][15]=606 ;
		distancias[13][16]=167 ;
		distancias[13][17]=825 ;
		distancias[13][18]=1022 ;
		distancias[13][19]=1419 ;
		distancias[13][20]=1680 ;
		distancias[13][21]=2860 ;
		distancias[13][22]=3453;
		distancias[13][23]=14;
		
		//  San Luis
		distancias[14][0]=distancias[0][14];
		distancias[14][1]=distancias[1][14];
		distancias[14][2]=distancias[2][14];
		distancias[14][3]=distancias[3][14];
		distancias[14][4]=distancias[4][14];
		distancias[14][5]=distancias[5][14];
		distancias[14][6]=distancias[6][14];
		distancias[14][7]=distancias[7][14];
		distancias[14][8]=distancias[8][14];
		distancias[14][9]=distancias[9][14];
		distancias[14][10]=distancias[10][14];
		distancias[14][11]=distancias[11][14];
		distancias[14][12]=distancias[12][14];
		distancias[14][13]=distancias[13][14];
		distancias[14][14]=0;
		distancias[14][15]=705 ;
		distancias[14][16]=260 ;
		distancias[14][17]=505 ;
		distancias[14][18]=883 ;
		distancias[14][19]=1099 ;
		distancias[14][20]=1360 ;
		distancias[14][21]=2540 ;
		distancias[14][22]=3133;
		distancias[14][23]=15;
		
		// Catamarca
		distancias[15][0]=distancias[0][15];
		distancias[15][1]=distancias[1][15];
		distancias[15][2]=distancias[2][15];
		distancias[15][3]=distancias[3][15];
		distancias[15][4]=distancias[4][15];
		distancias[15][5]=distancias[5][15];
		distancias[15][6]=distancias[6][15];
		distancias[15][7]=distancias[7][15];
		distancias[15][8]=distancias[8][15];
		distancias[15][9]=distancias[9][15];
		distancias[15][10]=distancias[10][15];
		distancias[15][11]=distancias[11][15];
		distancias[15][12]=distancias[12][15];
		distancias[15][13]=distancias[13][15];
		distancias[15][14]=distancias[14][15];
		distancias[15][15]=0;
		distancias[15][16]=773 ;
		distancias[15][17]=1040 ;
		distancias[15][18]=1588 ;
		distancias[15][19]=1634 ;
		distancias[15][20]=1895 ;
		distancias[15][21]=3075 ;
		distancias[15][22]=3668;
		distancias[15][23]=16;
		
		// Mendoza
		distancias[16][0]=distancias[0][16];
		distancias[16][1]=distancias[1][16];
		distancias[16][2]=distancias[2][16];
		distancias[16][3]=distancias[3][16];
		distancias[16][4]=distancias[4][16];
		distancias[16][5]=distancias[5][16];
		distancias[16][6]=distancias[6][16];
		distancias[16][7]=distancias[7][16];
		distancias[16][8]=distancias[8][16];
		distancias[16][9]=distancias[9][16];
		distancias[16][10]=distancias[10][16];
		distancias[16][11]=distancias[11][16];
		distancias[16][12]=distancias[12][16];
		distancias[16][13]=distancias[13][16];
		distancias[16][14]=distancias[14][16];
		distancias[16][15]=distancias[15][16];
		distancias[16][16]=0;
		distancias[16][17]=765 ;
		distancias[16][18]=855 ;
		distancias[16][19]=1359 ;
		distancias[16][20]=1620 ;
		distancias[16][21]=2800 ;
		distancias[16][22]=3393;
		distancias[16][23]=17;
		
		// Santa Rosa
		distancias[17][0]=distancias[0][17];
		distancias[17][1]=distancias[1][17];
		distancias[17][2]=distancias[2][17];
		distancias[17][3]=distancias[3][17];
		distancias[17][4]=distancias[4][17];
		distancias[17][5]=distancias[5][17];
		distancias[17][6]=distancias[6][17];
		distancias[17][7]=distancias[7][17];
		distancias[17][8]=distancias[8][17];
		distancias[17][9]=distancias[9][17];
		distancias[17][10]=distancias[10][17];
		distancias[17][11]=distancias[11][17];
		distancias[17][12]=distancias[12][17];
		distancias[17][13]=distancias[13][17];
		distancias[17][14]=distancias[14][17];
		distancias[17][15]=distancias[15][17];
		distancias[17][16]=distancias[16][17];
		distancias[17][17]=0;
		distancias[17][18]=537;
		distancias[17][19]= 594;
		distancias[17][20]= 855;
		distancias[17][21]= 2035 ;
		distancias[17][22]=2628;
		distancias[17][23]=18;
		// Neuquen
		distancias[18][0]=distancias[0][18];
		distancias[18][1]=distancias[1][18];
		distancias[18][2]=distancias[2][18];
		distancias[18][3]=distancias[3][18];
		distancias[18][4]=distancias[4][18];
		distancias[18][5]=distancias[5][18];
		distancias[18][6]=distancias[6][18];
		distancias[18][7]=distancias[7][18];
		distancias[18][8]=distancias[8][18];
		distancias[18][9]=distancias[9][18];
		distancias[18][10]=distancias[10][18];
		distancias[18][11]=distancias[11][18];
		distancias[18][12]=distancias[12][18];
		distancias[18][13]=distancias[13][18];
		distancias[18][14]=distancias[14][18];
		distancias[18][15]=distancias[15][18];
		distancias[18][16]=distancias[16][18];
		distancias[18][17]=distancias[17][18];
		distancias[18][18]=0;
		distancias[18][19]=660;
		distancias[18][20]= 750 ;
		distancias[18][21]=1930;
		distancias[18][22]=2523;
		distancias[18][23]=19;
		
		
		// Viedma
		distancias[19][0]=distancias[0][19];
		distancias[19][1]=distancias[1][19];
		distancias[19][2]=distancias[2][19];
		distancias[19][3]=distancias[3][19];
		distancias[19][4]=distancias[4][19];
		distancias[19][5]=distancias[5][19];
		distancias[19][6]=distancias[6][19];
		distancias[19][7]=distancias[7][19];
		distancias[19][8]=distancias[8][19];
		distancias[19][9]=distancias[9][19];
		distancias[19][10]=distancias[10][19];
		distancias[19][11]=distancias[11][19];
		distancias[19][12]=distancias[12][19];
		distancias[19][13]=distancias[13][19];
		distancias[19][14]=distancias[14][19];
		distancias[19][15]=distancias[15][19];
		distancias[19][16]=distancias[16][19];
		distancias[19][17]=distancias[17][19];
		distancias[19][18]=distancias[18][19];
		distancias[19][19]=0;
		distancias[19][20]=495;
		distancias[19][21]=1675;
		distancias[19][22]=2268;
		distancias[19][23]=20;
		
		
		// Rawson
		distancias[20][0]=distancias[0][20];
		distancias[20][1]=distancias[1][20];
		distancias[20][2]=distancias[2][20];
		distancias[20][3]=distancias[3][20];
		distancias[20][4]=distancias[4][20];
		distancias[20][5]=distancias[5][20];
		distancias[20][6]=distancias[6][20];
		distancias[20][7]=distancias[7][20];
		distancias[20][8]=distancias[8][20];
		distancias[20][9]=distancias[9][20];
		distancias[20][10]=distancias[10][20];
		distancias[20][11]=distancias[11][20];
		distancias[20][12]=distancias[12][20];
		distancias[20][13]=distancias[13][20];
		distancias[20][14]=distancias[14][20];
		distancias[20][15]=distancias[15][20];
		distancias[20][16]=distancias[16][20];
		distancias[20][17]=distancias[17][20];
		distancias[20][18]=distancias[18][20];
		distancias[20][19]=distancias[19][20];
		distancias[20][20]=0;
		distancias[20][21]=1180;
		distancias[20][22]=1773;
		distancias[20][23]=21;
		
		
		// RIO GALLEGOS
		distancias[21][0]=distancias[0][21];
		distancias[21][1]=distancias[1][21];
		distancias[21][2]=distancias[2][21];
		distancias[21][3]=distancias[3][21];
		distancias[21][4]=distancias[4][21];
		distancias[21][5]=distancias[5][21];
		distancias[21][6]=distancias[6][21];
		distancias[21][7]=distancias[7][21];
		distancias[21][8]=distancias[8][21];
		distancias[21][9]=distancias[9][21];
		distancias[21][10]=distancias[10][21];
		distancias[21][11]=distancias[11][21];
		distancias[21][12]=distancias[12][21];
		distancias[21][13]=distancias[13][21];
		distancias[21][14]=distancias[14][21];
		distancias[21][15]=distancias[15][21];
		distancias[21][16]=distancias[16][21];
		distancias[21][17]=distancias[17][21];
		distancias[21][18]=distancias[18][21];
		distancias[21][19]=distancias[19][21];
		distancias[21][20]=distancias[20][21];
		distancias[21][21]=0;
		distancias[21][22]=593;
		distancias[21][23]=22;
		
		// USHUAIA
		distancias[22][0]=distancias[0][22];
		distancias[22][1]=distancias[1][22];
		distancias[22][2]=distancias[2][22];
		distancias[22][3]=distancias[3][22];
		distancias[22][4]=distancias[4][22];
		distancias[22][5]=distancias[5][22];
		distancias[22][6]=distancias[6][22];
		distancias[22][7]=distancias[7][22];
		distancias[22][8]=distancias[8][22];
		distancias[22][9]=distancias[9][22];
		distancias[22][10]=distancias[10][22];
		distancias[22][11]=distancias[11][22];
		distancias[22][12]=distancias[12][22];
		distancias[22][13]=distancias[13][22];
		distancias[22][14]=distancias[14][22];
		distancias[22][15]=distancias[15][22];
		distancias[22][16]=distancias[16][22];
		distancias[22][17]=distancias[17][22];
		distancias[22][18]=distancias[18][22];
		distancias[22][19]=distancias[19][22];
		distancias[22][20]=distancias[20][22];
		distancias[22][21]=distancias[21][22];
		distancias[22][22]=0;
		distancias[22][23]=23;
		
		return distancias;
	}

	public DistanciasCapitales() {
	}
	
	
	

}
