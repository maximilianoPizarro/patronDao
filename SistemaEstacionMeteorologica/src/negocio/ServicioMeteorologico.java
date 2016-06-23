package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.EstacionMeteorologicaDao;
import dao.MedicionDao;
import dao.ProvinciaDao;
import datos.EstacionMeteorologica;
import datos.Medicion;
import datos.Provincia;
import datos.Rango;

public class ServicioMeteorologico {
	MedicionDao dao = new MedicionDao();
	EstacionMeteorologicaDao daoE = new EstacionMeteorologicaDao();
	ProvinciaDao daoP = new ProvinciaDao();

	public Provincia traerProvincia(int idProvincia) throws Exception {

		Provincia p = daoP.traerProvincia(idProvincia);

		if (p == null) {
			throw new Exception("No existe Provincia con ese id");
		}
		return p;
	}

	public EstacionMeteorologica traerEstacionMeteorologica(
			int idEstacionMeteorologica) throws Exception {

		EstacionMeteorologica e = daoE.traerEstacionMeteorologica(idEstacionMeteorologica);

		if (e == null)
			throw new Exception("No existe estacion con ese id");
		return e;
	}

	public Medicion traerMedicion(int idMedicion) throws Exception {

		Medicion m = dao.traerMedicion(idMedicion);

		if (m == null)
			throw new Exception("No se encontraron mediciones");
		return m;
	}

	public List<Medicion> traerMedicion(Provincia provincia, Calendar fechaInicial, Calendar fechaFinal)
			throws Exception {

		List<Medicion> m = dao.traerMedicion(provincia, fechaInicial,
				fechaFinal);

		if (m == null)
			throw new Exception("No se encontraron mediciones");
		return m;
	}

	public List<Medicion> traerMedicion(Provincia provincia, Calendar fecha) throws Exception {

		List<Medicion> m = dao.traerMedicion(provincia, fecha);

		if (m == null)
			throw new Exception("No se encontraron mediciones");
		return m;
	}

	public List<Medicion> traerMedicion(Calendar fecha)
			throws Exception {

		List<Medicion> m = dao.traerMedicion(fecha);

		if (m == null)
			throw new Exception("No se encontraron mediciones");
		return m;
	}

	public Rango calcularRangoPresion(Provincia provincia, Calendar fechaInicial, Calendar fechaFinal)
			throws Exception {
		Rango rango = new Rango(0,1020,0);
		List<Medicion> lista= dao.traerMedicion(provincia, fechaInicial, fechaFinal);
		if (lista == null)
			throw new Exception("No se encontraron mediciones");
		for (Medicion m:lista){
			
			if(m.getPresion()>rango.getMaximo()){  //si es maximo sett maximo
				rango.setMaximo(m.getPresion());
			}
			if(m.getPresion()<rango.getMinimo()){ //si es minimo sett minimo
				rango.setMinimo(m.getPresion());
			}
			rango.setPromedio(rango.getPromedio()+m.getPresion()); //acumulo las presiones
		}
		rango.setPromedio(rango.getPromedio()/lista.size());	//divido por la cantidad de elementos de la lista
		return rango;
	}

	public Rango calcularRangoPresionCorregida(Provincia provincia,
			GregorianCalendar fechaInicial, GregorianCalendar fechaFinal)
			throws Exception {
		Rango rango = new Rango(0,1020,0);
		List<Medicion> lista= dao.traerMedicion(provincia, fechaInicial, fechaFinal);
		if (lista == null)
			throw new Exception("No se encontraron mediciones");
		for (Medicion m:lista){
			
			if(m.calcularPresionCorregida()>rango.getMaximo()){  //si es maximo sett maximo
				rango.setMaximo(m.calcularPresionCorregida());
			}
			if(m.calcularPresionCorregida()<rango.getMinimo()){ //si es minimo sett minimo
				rango.setMinimo(m.calcularPresionCorregida());
			}
			rango.setPromedio(rango.getPromedio()+m.calcularPresionCorregida()); //acumulo las presiones
		}
		rango.setPromedio(rango.getPromedio()/lista.size());	//divido por la cantidad de elementos de la lista
	
		
		return rango;
	}

	public Rango calcularRangoPrecipitacion(GregorianCalendar fechaInicial,
			GregorianCalendar fechaFinal) throws Exception {
		Rango rango = new Rango(0,1020,0);
	
		List<Medicion> lista=dao.traerMedicion(fechaInicial, fechaFinal);
		
		if (lista == null)
			throw new Exception("No se registraron mediciones");
		
		for(Medicion m:lista){
			
			if(m.getPrecipitacion()>rango.getMaximo()){  //si es maximo sett maximo
				rango.setMaximo(m.getPrecipitacion());
			}
			if(m.getPrecipitacion()<rango.getMinimo()){ //si es minimo sett minimo
				rango.setMinimo(m.getPrecipitacion());
			}
			rango.setPromedio(rango.getPromedio()+m.getPrecipitacion()); //acumulo las precipitaciones
		}
		rango.setPromedio(rango.getPromedio()/lista.size());	//divido por la cantidad de elementos de la lista

		return rango;
	}

}
