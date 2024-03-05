package miPrincipal;
public class AplBilletera {
    public static void main(String [] args){
        Billetera billetera = new Billetera("CUADRA","CAFE","PIEL");
		
		billetera.Abrir();
		if( billetera.MeterBilletes(50) )
			System.out.println(billetera.getMsg());
		else
			System.out.println("no se almacenaron, CAUSA "+billetera.getMsg());
		
		System.out.println(billetera.MeterBilletes(50) );
		
		System.out.println("____________________");
		System.out.println("MARCA "+billetera.getMarca());
		System.out.println("Billeters soporta "+billetera.getMaxBilletes());
		
		billetera = new Billetera("CUADRA","CAFE","PIEL");
		int capacidad=0;
		if( billetera.isCerrada())
			billetera.Abrir();
		while ( billetera.MeterBilletes(1)) {
			capacidad=billetera.getMaxBilletes()-billetera.getNoBilletes();
			System.out.println("capacidad de billetes "+capacidad);
		}
		billetera.Cerrar();
		
		System.out.println(" la segunda billetera");
		BilleteraV2 billeterav2=new BilleteraV2("CUADRA","CAFE","PIEL");
		
		billeterav2.Abrir();
		System.out.println(billeterav2.MeterBilletes(5, 20));
		System.out.println(billeterav2.MeterBilletes(3,1000));
		billeterav2.MeterBilletes(5,500);
		billeterav2.MeterBilletes(2,200);
		
		System.out.println(billeterav2.EstadoCuenta());
		System.out.println(billeterav2.SacarDinero(1720));

		System.out.println(billeterav2.EstadoCuenta());
    }
}