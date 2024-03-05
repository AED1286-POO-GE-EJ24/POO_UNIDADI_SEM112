package miPrincipal;
import java.util.*;
public class Rutinas {
	static Random r=new Random();
	static String []VN ={"Diego","Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
			"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={true,true,false,true,false,true,false,false,false,true,false,false,
			false,true,true};	
	public static int Comparar(String texto, String otroTexto) {
		//vERSION I
		int minimoCaracteres = Math.min(texto.length(), otroTexto.length());
/*
		//VERSION II
		minimoCracteres=texto.length();
		if(otroTexto.length()<minimoCaracteres)
			minimoCracteres=otroTexto.length();
		// VERSION III
		if(texto.length()<otroTexto.length())
			minimoCaracteres=texto.length();
		else
			minimoCaracteres=otroTexto.length();
		// VERSION IV
		minimoCaracteres= texto.length()<otroTexto.length() ?texto.length():otroTexto.length();
*/	
		char carTexto,carOtroTexto;
		for(int i=0 ; i<minimoCaracteres ; i++) {
			carTexto=texto.charAt(i);
			carOtroTexto=otroTexto.charAt(i);
			if( carTexto > carOtroTexto )
				return 1;
			if( carTexto < carOtroTexto)
				return -1;
		}
		if( texto.length() == otroTexto.length())
			return 0;
		if( texto.length() > otroTexto.length())
			return 1;
		return -1;
	}
	public static String SinBlancos(String texto) {
		String textoNuevo="";
		// Eliminar los blancos de inicio
		int pos=0;
//		while ( texto.charAt(pos)==' ')
//			pos++;
//		texto=texto.substring(pos);
//		// Eliminar los blancos del final
//		pos=texto.length()-1;
//		while ( texto.charAt(pos)==' ')
//			pos--;
//		texto=texto.substring(0,pos+1);
		
		// Eliminar los blancos que hay de mas entre cada palabra
		while (texto.indexOf("  ")>=0)
			texto=texto.replace("  ", " ");
		if(texto.charAt(0)==' ')
			texto=texto.substring(1);
		if(texto.charAt(texto.length()-1)==' ')
			texto=texto.substring(0,texto.length()-1);
		return texto;
/*
		char car;
		for(int i=0 ; i<texto.length(); i++) {
			car=texto.charAt(i);
			if(car != ' ') {
				 textoNuevo+=car;
				 continue;
			}
			if(textoNuevo.length()==0 ||  textoNuevo.charAt( textoNuevo.length()-1) ==' ')
				continue;
			textoNuevo+=" ";
		}
*	
		if(textoNuevo.charAt(0)==' ')
			textoNuevo=textoNuevo.substring(1);
		if(textoNuevo.charAt(textoNuevo.length()-1)==' ')
			textoNuevo=textoNuevo.substring(0,textoNuevo.length()-1);

		return textoNuevo;
*/		
		
	}
	
	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;;

		for(int i=0;i<Numero;i++){
			Pos=r.nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}	

			Nom+=NomTra;

		}
		NomTra="";
		for(byte i=0;i<2;i++){
			NomTra+=VA[r.nextInt(VA.length)]+" ";
		}
		Nom=Nom+NomTra;
		return Nom.trim();
	} 	
	public static int nextInt(int li, int ls) {
		return r.nextInt(ls-li+1)+li;
	}
	public static String PonCeros(long numero, int tamaño) {
		String texto=numero+"";
		while (texto.length()<tamaño)
			texto="0"+texto;
		return texto;
	}
	public static String PonBlancos(String texto, int tamaño) {
		while (texto.length()<tamaño)
			texto=texto+" ";
		return texto;
	}

	public static String nextColor() {
		String [] colores= {"rojo","rosa","violeta","negro","amarillo","blanco","gris","azul","verde","cafe","naranja","lila"};
		return colores[ Rutinas.nextInt(0,colores.length-1)   ];
	}
}

