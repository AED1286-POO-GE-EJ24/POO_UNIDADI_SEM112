package miPrincipal;

public class BilleteraV2 {
	class Denominacion{
		private int denominacion, noBilletes;

		public Denominacion(int denominacion, int noBilletes) {
			this.denominacion=denominacion;
			this.noBilletes=noBilletes;
		}
		public int getDenominacion() {
			return denominacion;
		}
		public void setDenominacion(int denominacion) {
			this.denominacion = denominacion;
		}
		public int getNoBilletes() {
			return noBilletes;
		}
		public void setNoBilletes(int noBilletes) {
			this.noBilletes = noBilletes;
		}
		
	}
	private String marca,color,material, msg;
	private Denominacion [] denominacion;
	private int maxBilletes, maxTarjetas, noBilletes, noTarjetas;
	private boolean cerrada;
	
	public BilleteraV2() {
		this("PATITO","AZUL","SINTETICO");
	}
	public BilleteraV2(String marca, String color, String material) {
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
		
		int [] den= {1000,500,200,100,50,20};
		denominacion=new Denominacion[den.length];
		for(int i=0 ; i<den.length ; i++)
			denominacion[i]=new Denominacion(den[i],0);
		
		
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
	public boolean MeterBilletes(int noBilletes, int denominacion) {
		if( !MeterBilletes(noBilletes) ) {
			
			return false;
		}	
		
		int pos=-1;
		for(int i=0 ; i<this.denominacion.length;i++) {
			if(this.denominacion[i].getDenominacion()==denominacion) {
				pos=i;
				break;
			}
		}
		if(pos==-1) {
			this.noBilletes-=noBilletes;
			msg="Denominacion incorrecta ";
			return false;
		}
		this.denominacion[pos].setNoBilletes(this.denominacion[pos].getNoBilletes()+noBilletes);
		
		return true;
	}
	public boolean SacarBilletes(int noBilletes,int denominacion) {
		
		return true;
	}
	
	private boolean MeterBilletes(int noBilletes) {
		
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
	private boolean SacarBilletes(int noBilletes) {
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
	
	public boolean SacarDinero(int importe) {
		if( cerrada ) {
			msg="Billetera cerrada";
			return false;
		}
		int aux=importe,nb,den,billetes;
		for(int i= 0 ; i<denominacion.length ; i++) {
			if(denominacion[i].getNoBilletes()==0)
				continue;
			nb=denominacion[i].getNoBilletes();
			den=denominacion[i].getDenominacion();
			billetes = aux / den ;
			if( billetes==0)
				continue;
			if( billetes>nb)
				billetes=nb;
			aux -= billetes * den ;
		}
		if( aux !=0)
			return false;
		aux=importe;
		for(int i= 0 ; i<denominacion.length ; i++) {
			if(denominacion[i].getNoBilletes()==0)
				continue;
			nb=denominacion[i].getNoBilletes();
			den=denominacion[i].getDenominacion();
			billetes = aux / den ;
			if( billetes==0)
				continue;
			if( billetes>nb)
				billetes=nb;
			aux -= billetes * den ;
			denominacion[i].setNoBilletes(denominacion[i].getNoBilletes()-billetes);
		}	
		return true;
	}
	public String EstadoCuenta() {
		String resultado="";
		// duplicar el arreglo denominacion
		Denominacion []clon = new Denominacion[denominacion.length];
		for(int i=0 ; i<denominacion.length ; i++)
			clon[i]=new Denominacion(denominacion[i].getDenominacion(),denominacion[i].getNoBilletes());
		// ordenar clon por noBilletes en forma descendente
		for(int i=0 ; i<clon.length-1;i++)
			for(int j=i+1 ; j<clon.length;j++)
				if(clon[i].getNoBilletes()< clon[j].getNoBilletes() ) {
					Denominacion aux= clon[i];
					clon[i]=clon[j];
					clon[j]=aux;
					
				}
		
		
		for(int i=0 ; i<clon.length ; i++)
			resultado+=String.format("%-5d\t%5d\n", clon[i].getDenominacion(),clon[i].getNoBilletes());
		return resultado;
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

