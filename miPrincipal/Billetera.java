package miPrincipal;

public class Billetera {
	private String marca,color,material, msg;

	private int maxBilletes, maxTarjetas, noBilletes, noTarjetas;
	private boolean cerrada;
	
	public Billetera() {
		this("PATITO","AZUL","SINTETICO");
	}
	public Billetera(String marca, String color, String material) {
		this.marca=marca;
		this.color=color;
		this.material=material;
		noBilletes=0;
		noTarjetas=0;
		cerrada=true;
		if( material.equalsIgnoreCase("Piel") ) {
			maxBilletes=50;
			maxTarjetas=5;
		}
		else {
			maxBilletes=20;
			maxTarjetas=3;
		}
	}
	public boolean Abrir() {
		if( !cerrada)
			return false;
		cerrada=false;
		return true;
	}
	public boolean Cerrar() {
		cerrada=true;
		return true;
	}
	public boolean MeterBilletes(int noBilletes) {
		
		if( cerrada) {
			msg="La billetera se encuentra cerrada";
			return false;
		}	
		if( this.noBilletes + noBilletes> maxBilletes) {
			msg="La capacidad de billetes es insuficiente";
			return false;
		}
		this.noBilletes += noBilletes; 
		// this.noBilletes = this.noBilletes + noBilletes
		msg="Todo almacenado";
		return true;
	}
	public boolean MaterTarjetas(int noTarjetas) {
		if( cerrada) {
			msg="La billetera esrá cerrada";
			return false;
		}
		if( this.noTarjetas + noTarjetas > maxTarjetas) {
			msg="No ha capacidad para las tarjetas";
			return false;
		}
		this.noTarjetas+=noTarjetas;
		msg="Tarjetas almacenadas correctamente";
		return true;
	}
	public boolean SacarBilletes(int noBilletes) {
		if( cerrada) {
			msg="La billetera se encuentra cerrada";
			return false;
		}
		if( noBilletes > this.noBilletes ) {
			msg="No hay sufientes billetes en la billetara";
			return false;
		}
		this.noBilletes-=noBilletes;
		msg="Extracción de billetes éxitosa";
		return true;
	}
	public boolean SacarTarjetas(int noTarjetas) {
		if( cerrada) {
			msg="La billetera se encuentra cerrada";
			return false;
		}
		if( noTarjetas > this.noTarjetas ) {
			msg="No hay sufientes tarjetas en la billetara";
			return false;
		}
		this.noTarjetas-=noTarjetas;
		msg="Extracción de tarjetas éxitosa";		
		return true;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getMaxBilletes() {
		return maxBilletes;
	}
	public void setMaxBilletes(int maxBilletes) {
		this.maxBilletes = maxBilletes;
	}
	public int getMaxTarjetas() {
		return maxTarjetas;
	}
	public void setMaxTarjetas(int maxTarjetas) {
		this.maxTarjetas = maxTarjetas;
	}
	public int getNoBilletes() {
		return noBilletes;
	}
	public void setNoBilletes(int noBilletes) {
		this.noBilletes = noBilletes;
	}
	public int getNoTarjetas() {
		return noTarjetas;
	}
	public void setNoTarjetas(int noTarjetas) {
		this.noTarjetas = noTarjetas;
	}
	public boolean isCerrada() {
		return cerrada;
	}
	public void setCerrada(boolean cerrada) {
		this.cerrada = cerrada;
	}
	public String getMsg() {
		return msg;
	}	
	
	

}

