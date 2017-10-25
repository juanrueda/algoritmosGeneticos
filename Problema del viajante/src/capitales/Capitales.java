package capitales;

public class Capitales {
	String ciudadesCapitales[][] = new String[23][2];
	
	
	public String[][] cargaCapitales(){
		
		for(int i=0; i<ciudadesCapitales.length; i++){
			ciudadesCapitales[i][0] = String.valueOf(i+1);
		}
		
		ciudadesCapitales[0][1] = "Buenos Aires";
		ciudadesCapitales[1][1] = "San S. de Jujuy";
		ciudadesCapitales[2][1] = "Salta";
		ciudadesCapitales[3][1] = "S. M. De Tucuman";
		ciudadesCapitales[4][1] = "Sgo del Estero";
		ciudadesCapitales[5][1] = "Formosa";
		ciudadesCapitales[6][1] = "Resistencia";
		ciudadesCapitales[7][1] = "Santa Fe";
		ciudadesCapitales[8][1] = "Corrientes";
		ciudadesCapitales[9][1] = "Posadas";
		ciudadesCapitales[10][1] = "Parana";
		ciudadesCapitales[11][1] = "Cordoba";
		ciudadesCapitales[12][1] = "La Rioja";
		ciudadesCapitales[13][1] = "San Juan";
		ciudadesCapitales[14][1] = "San Luis";
		ciudadesCapitales[15][1] = "Catamarca";
		ciudadesCapitales[16][1] = "Mendoza";
		ciudadesCapitales[17][1] = "Santa Rosa";
		ciudadesCapitales[18][1] = "Neuquen";
		ciudadesCapitales[19][1] = "Viedma";
		ciudadesCapitales[20][1] = "Rawson";
		ciudadesCapitales[21][1] = "Rio Gallegos";
		ciudadesCapitales[22][1] = "Ushuaia";
		
		return ciudadesCapitales;
	}
	
}

