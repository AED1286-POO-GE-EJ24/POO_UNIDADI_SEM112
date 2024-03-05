package miPrincipal;

class Dato{
	private boolean ocupada;
	private String  refresco;
	private int     frecuencia;
	public Dato() {
		ocupada=false;
		refresco="";
		frecuencia=0;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	public String getRefresco() {
		return refresco;
	}
	public void setRefresco(String refresco) {
		this.refresco = refresco;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
}
public class Jaba {
	
	private Dato [][] contenedor;
	private int maxEspacios, espaciosOcupados;
	private int total;
	
	public Jaba() {
		int filas=Rutinas.nextInt(3,5);
		int columnas=Rutinas.nextInt(5, 8);
		contenedor= new Dato[filas][columnas];
		for(int i= 0 ; i<filas ; i++)
			for(int j=0 ; j<columnas ; j++)
				contenedor[i][j]=new Dato();
		maxEspacios=filas*columnas;// contenedor.length * contenedor[0].length;
		espaciosOcupados=0;
	}
	
	public void LlenarSecuencial() {
		String [] refrescos= {"Coca Cola","Fanta","Agua Mineral"};
/*
		String bebida=refrescos[Rutinas.nextInt(0, refrescos.length-1)];
		for(int i=0 ; i<contenedor.length ; i++) {
			for(int j=0 ; j<contenedor[i].length ; j++) {
				contenedor[i][j].setRefresco(bebida);
				contenedor[i][j].setOcupada(true);
			}
		}
*/
		int cont=0;
		String bebida;
		for(int i=0 ; i<contenedor.length ; i++) {
			bebida=refrescos[cont % 3];
			cont++;
			for(int j=0 ; j<contenedor[i].length ; j++) {
				contenedor[i][j].setRefresco(bebida);
				contenedor[i][j].setOcupada(true);
			}
		}
		
			
		
	}

	public void LlenarAleatorio() {
		String [] refrescos= {"Coca Cola","Fanta","Agua Mineral"};
		String bebida;
		total=0;

		while (  espaciosOcupados < maxEspacios) {
			int fila=Rutinas.nextInt(0, contenedor.length-1);
			int columna=Rutinas.nextInt(0,contenedor[0].length-1);
			if( contenedor[fila][columna].isOcupada()) {
				contenedor[fila][columna].setFrecuencia(contenedor[fila][columna].getFrecuencia()+1);
				if( maxEspacios-espaciosOcupados==1)
					total++;
				continue;
			}
			bebida=refrescos[Rutinas.nextInt(0, refrescos.length-1)];
			contenedor[fila][columna].setRefresco(bebida);;
			contenedor[fila][columna].setOcupada(true);
			espaciosOcupados++;
		}
	}
	public String Reporte1() {
		String resultado="";
		for(int i=0 ; i<contenedor.length ; i++) {
			for(int j=0 ; j<contenedor[i].length;j++) {
				resultado+= contenedor[i][j].getFrecuencia()+"  ";
			}
			resultado+="\n";
		}
		return resultado;
	}
	public int Reporte2() {
		
		return total;
	}   
}
