
public class Empresa {

	public static Object empresa;
	/* https://ws-api.iextrading.com/1.0/ref-data/symbols */
	private String simbolo = "";
	private String nombre = "";
	private String fecha = "";
	private boolean habilitado;
	private String tipo = "";
	private String iexID = "";
	private float cantidad = 0;
	private float gastado = 0;

	Empresa() {
	}
	/**
	 * Se obtiene el simbolo
	 * @return el simbolo
	 */
	public String getSimbolo() {
		return simbolo;
	}
	/**
	 * Se introduce el nombre
	 * @param simbolo
	 */
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getNombre() {
		
		if(nombre=="") {
			return simbolo;
		}
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIexID() {
		return iexID;
	}

	public void setIexID(String iexID) {
		this.iexID = iexID;
	}
	/**
	 * Se obtiene la cantidad
	 * @return la cantidad
	 */
	public float getcantidad() {
		return cantidad;
	}
	/**
	 * Se introduce la cantidad
	 * @param simbolo
	 */
	public void setcantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Se obtiene el gasto
	 * @return el gasto
	 */
	public float getgastado() {
		return gastado;
	}
	/**
	 * Se introduce el gasto
	 * @param simbolo
	 */
	public void setgastado(float gastado) {
		this.gastado = gastado;
	}
}
