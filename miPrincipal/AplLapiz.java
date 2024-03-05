package miPrincipal;

public class AplLapiz {
    public static void main(String[] args) {
		Lapiz lapiz = new Lapiz();
		Sacapunta sacapunta = new Sacapunta(100);
		
		
		
		if(!lapiz.Escribir("1 2 3 4 5 6 7 8 9 0 1")) {
			sacapunta.SacarPunta(lapiz);
			sacapunta.SacarPunta(lapiz);
			sacapunta.SacarPunta(lapiz);
			sacapunta.SacarPunta(lapiz);
			sacapunta.SacarPunta(lapiz);
			sacapunta.SacarPunta(lapiz);
			
		}
		
		//System.out.println(lapiz.Escribir("1 2 3 4 5 6 7 8 9 0 1"));
		while (lapiz.Escribir("1 2 3 4 5 6 7 8 9 0 1")) 
			System.out.println("____\n"+lapiz);

		
	}

}
