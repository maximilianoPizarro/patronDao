package test;

import negocio.ServicioMeteorologico;

public class OO2Test1Tema4 {
	
	public static void main(String[] args) {
		
		ServicioMeteorologico sm= new ServicioMeteorologico();
		
		int id = 1;
		int idM = 30;
		int idE = 47;
		try{
			System.out.println("\n---> Traer Medición con id=30 "+sm.traerMedicion(idM));
			System.out.println("\n---> Traer Estación con id=47 "+sm.traerEstacionMeteorologica(idE));
			System.out.println("\n---> Traer Provincia con id=1 "+sm.traerProvincia(id));
		
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());}
		
	}

}
