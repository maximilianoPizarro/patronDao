package test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import datos.Medicion;
import datos.Rango;

import negocio.ServicioMeteorologico;

public class OO2Test2Tema4 {

	public static void main(String[] args) {
		
		ServicioMeteorologico sm = new ServicioMeteorologico();

		Calendar fecha = new GregorianCalendar(2016,2, 01);

		int idProvincia = 1;
		
		try {
			// Escenario 1
			System.out.println("\n---> Traer Mediciones de la Provincia con id=1 para el 1/3/2016\n"+sm.traerProvincia(idProvincia));
			List<Medicion> lista = sm.traerMedicion(sm.traerProvincia(idProvincia), fecha);

			for (Medicion m : lista) {
				System.out.println("\n" + m.toString());
			}
			
			//Escenario 2
			System.out.println("\n---> Calcular Rango de presión para la Provincia con id=1 entre el 25/3/2016 y el 5/4/2016");
			Rango r= new Rango();						
			r=sm.calcularRangoPresion(sm.traerProvincia(1), new GregorianCalendar(2016,02,25),new GregorianCalendar(2016,03,05));
			System.out.println("\n"+r.toString()); 
			
			//Escenario 3
			System.out.println("\n---> Calcular Rango de P. Corregida para la Provincia con id=1 entre el 25/3/2016 y el 5/4/2016");
			r=sm.calcularRangoPresionCorregida(sm.traerProvincia(1),new GregorianCalendar(2016,02,25),new GregorianCalendar(2016,03,05));
			System.out.println("\n"+r.toString());
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

}
