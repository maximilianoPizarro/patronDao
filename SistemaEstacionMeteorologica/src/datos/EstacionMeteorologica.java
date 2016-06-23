package datos;

import java.util.Set;

public class EstacionMeteorologica {
	
	 private int idEstacionMeteorologica;
	 private String estacionMeteorologica;
	 private int altura;
	 private Set<Medicion> mediciones;
	 
	public EstacionMeteorologica()
	{}
	 
	public EstacionMeteorologica(String estacionMeteorologica, int altura) {
		super();
		this.estacionMeteorologica = estacionMeteorologica;
		this.altura = altura;
	}

	public int getIdEstacionMeteorologica() {
		return idEstacionMeteorologica;
	}

	protected void setIdEstacionMeteorologica(int idEstacionMeteorologica) {
		this.idEstacionMeteorologica = idEstacionMeteorologica;
	}

	public String getEstacionMeteorologica() {
		return estacionMeteorologica;
	}

	public void setEstacionMeteorologica(String estacionMeteorologica) {
		this.estacionMeteorologica = estacionMeteorologica;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public Set<Medicion> getMediciones() {
		return mediciones;
	}

	public void setMediciones(Set<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	@Override
	public String toString() {
		return "EstacionMeteorologica "
				+ estacionMeteorologica + ", altura=" + altura + " msnm";
	}
	
	 
	 

}
