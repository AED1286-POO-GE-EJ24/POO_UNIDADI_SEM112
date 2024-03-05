package miPrincipal;

public class Sacapunta {
    private int vidaNavaja, maxContenedor, nivelContenedor;
	private String msg;
	
	public Sacapunta() {
		this(250);
	}
	public Sacapunta(int maxContenedor) {
		vidaNavaja=Rutinas.nextInt(97, 100);
		this.maxContenedor=maxContenedor;
		nivelContenedor=0;
	}
	public boolean SacarPunta(Lapiz lapiz) {
		if( vidaNavaja < 31) {
			msg="La vida util de la  navaja llegó su limite";
			return false;
		}
		if( nivelContenedor >= maxContenedor) {
			msg="Contenedor lleno";
			return false;
		}
		if( lapiz.getLongPunta() >20) {
			msg="El lapiz ya cuenta con punta";
			return false;
		}
		if( lapiz.getLongLapiz()<30) {
			msg="El tamaño del lápin no pirete sacar punta";
			return false;
		}
		
		if( lapiz.getTipoMadera().equalsIgnoreCase("suave")) {
			vidaNavaja -= vidaNavaja * 0.01;
		}
		else {
			if( lapiz.getTipoMadera().equalsIgnoreCase("mediano")) {
				vidaNavaja -= vidaNavaja * 0.02;
			}
			else {
				vidaNavaja -= vidaNavaja * 0.03;
			}
		}
		nivelContenedor+=10;
		lapiz.setLongLapiz(lapiz.getLongLapiz()-2);
		lapiz.setLongPunta(lapiz.getLongPunta()+2);
		System.out.println(lapiz.getLongLapiz());
		msg="Punta ok";
		return true;
	}
	public boolean VaciarContenedor() {
		if( nivelContenedor==0) {
			msg="el contenedor se encuentra vacio";
			return false;
		}
		msg="Contenedor limpio";
		nivelContenedor=0;
		return true;
	}

	public int getVidaNavaja() {
		return vidaNavaja;
	}

	public void setVidaNavaja(int vidaNavaja) {
		this.vidaNavaja = vidaNavaja;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}
