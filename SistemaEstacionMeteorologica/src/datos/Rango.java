package datos;

import funciones.Funciones;

public class Rango {
	private float maximo;
	private float minimo;
	private float promedio;
	
	public Rango(){};
	
	public Rango(float maximo, float minimo, float promedio) {
		super();
		this.maximo = maximo;
		this.minimo = minimo;
		this.promedio = promedio;
	}

	public float getMaximo() {
		return maximo;
	}

	public void setMaximo(float maximo) {
		this.maximo = maximo;
	}

	public float getMinimo() {
		return minimo;
	}

	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "Rango [maximo=" + maximo + ", minimo=" + minimo + ", promedio="
				+ Funciones.aproximar1Decimal((double) promedio) + "]";
	}
	
	

}
