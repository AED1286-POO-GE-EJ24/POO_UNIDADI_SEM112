package miPrincipal;

public class Lapiz {

	private String tipoMadera,msg;
	private float longLapiz, longBorrador, longPunta;
	public Lapiz() {
		this("mediana",13);
	}
	public Lapiz(String tipoMadera, int longLapiz) {
		this(tipoMadera,longLapiz,1);
	}
	// longLapiz y logBorrador se recibe en cm pero se maneja en mm
	public Lapiz(String tipoMadera, int longLapiz, int longBorrador) {
		this.tipoMadera=tipoMadera;
		this.longLapiz=longLapiz*10;
		this.longBorrador=longBorrador*10;
		longPunta=0.0f;
	}
	public boolean Escribir(String texto) {
		if( texto.length()==0) {
			msg="Debe enviar texto";
			return false;
		}
		if( longPunta < 2 ) {
			msg="La punta tiene menos de 2 mm";
			return false;
		}
		texto=Rutinas.SinBlancos(texto);
		String [] palabras = texto.split(" ");
		int desgaste = palabras.length / 10 ;
		if( longPunta-desgaste<2) {
			msg="La punta del lapiz no es sufiente";
			return false;
		}
		longPunta-=desgaste;
		
		msg="ESCRITURA REALIZADA";
		return true;
	}
	
	public boolean Borrar(int noPalabras) {
		if( noPalabras<1) {
			msg="No proporcionó número de palabras";
			return false;
		}
		if( longBorrador < 1  ) {
			msg="El tamaño de borrador es insuficiente";
			return false;
		}
		int desgaste = noPalabras / 2 ;
		if( longBorrador-desgaste < 0) {
			msg="El bprrador no tine capacidad para borrar las palabras";
			return false;
		}
		longBorrador-=desgaste;
		return true;
	}
	
	public String toString() {
		return "Madera tipo:"+tipoMadera+"\n tamaño punta : "+longPunta
				+"\n longBorrador : "+longBorrador+"\n longLapiz "+longLapiz; 
	}
	public String getTipoMadera() {
		return tipoMadera;
	}
	public void setTipoMadera(String tipoMadera) {
		this.tipoMadera = tipoMadera;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public float getLongLapiz() {
		return longLapiz;
	}
	public void setLongLapiz(float longLapiz) {
		this.longLapiz = longLapiz;
	}
	public float getLongBorrador() {
		return longBorrador;
	}
	public void setLongBorrador(float longBorrador) {
		this.longBorrador = longBorrador;
	}
	public float getLongPunta() {
		return longPunta;
	}
	public void setLongPunta(float longPunta) {
		this.longPunta = longPunta;
	}
	
}

