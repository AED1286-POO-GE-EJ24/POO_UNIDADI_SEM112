package miPrincipal;

public class AplJaba {
    public static void main(String[] args) {
		Jaba jaba = new Jaba();
		
		jaba.LlenarAleatorio();
		System.out.println(jaba.Reporte1());
        System.out.println("Intentos para la última casilla "+jaba.Reporte2());

	}
}
