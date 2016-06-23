package datos;

import java.util.Set;

public class Provincia {
	
	private int idProvincia;
    private String provincia;
    private Set<Medicion> mediciones;
    
    public Provincia()
    {}
    
	public Provincia(String provincia) {
		super();
		this.provincia = provincia;
	}
	
	public int getIdProvincia() {
		return idProvincia;
	}
	protected void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public Set<Medicion> getMediciones() {
		return mediciones;
	}

	public void setMediciones(Set<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	@Override	
	public String toString()
	{
		return("Provincia de "+provincia);
	}
	  

}
