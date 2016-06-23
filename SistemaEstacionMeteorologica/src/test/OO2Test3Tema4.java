package test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import datos.Medicion;
import datos.Rango;

import negocio.ServicioMeteorologico;

public class OO2Test3Tema4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServicioMeteorologico sm = new ServicioMeteorologico();
		try {
			//Escenario 1
			Calendar fecha = new GregorianCalendar(2016,3,1);
			
			List<Medicion> lista = sm.traerMedicion(fecha);

			System.out.println("\n---> Traer Mediciones para todo el país para la fecha 1/4/2016");
			
			for (Medicion m : lista) {
					System.out.println("\n" + m.toString());
				}
			//Escenario 2		
			System.out.println("\n---> Calcular Rango de precipitación para todo el país entre el 25/3/2016 y el 5/4/2016");
			Rango r= new Rango();
			r= sm.calcularRangoPrecipitacion(new GregorianCalendar(2016,02,25), new GregorianCalendar(2016,03,05));
			System.out.println("\n"+r.toString());
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

}
