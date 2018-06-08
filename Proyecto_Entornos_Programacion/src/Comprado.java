import java.util.ArrayList;

import org.json.JSONException;

public class Comprado {

	private ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	private static ArrayList<Empresa> favoritas = new ArrayList<Empresa>();
	private static ArrayList<Empresa> recomendado = new ArrayList<Empresa>();
	private ArrayList<Empresa> otros = new ArrayList<Empresa>();
	private float diferencia=0;
	
	/**
	 * Se comprar accionesa de una empresa apartir del dinero disponible
	 * @param simbolo la empresa
	 * @param gasto lo que se gastara
	 * @param saldo  el precio
	 * @param precio el precio
	 * @return true si se ha realizado la compra
	 */
	public Boolean comprar_precio(String simbolo, float gasto, float saldo, float precio) {
		int cantidad = 0;
		if ((gasto > saldo)||(gasto<precio)) {

			return false;

		} else {

			cantidad = (int) (gasto / precio);
			this.diferencia=gasto-Float.valueOf(cantidad)*precio;
			gasto=Float.valueOf(cantidad)*precio;
			boolean hay = false;
			int posicion = 0;
			for (int i = 0; i < empresas.size(); i++) {
				if (empresas.get(i).getSimbolo().equals(simbolo)) {
					hay = true;
					posicion = i;
				}

			}
			if (!hay) {
				empresas.add(new Empresa());
				empresas.get(empresas.size() - 1).setSimbolo(simbolo);
				empresas.get(empresas.size() - 1).setcantidad(cantidad);
				empresas.get(empresas.size() - 1).setgastado(gasto);
			} else {

				empresas.get(posicion).setcantidad(cantidad + empresas.get(posicion).getcantidad());
				empresas.get(posicion).setgastado(gasto + empresas.get(posicion).getgastado());

			}
			return true;
		}

	}
	/**
	 * Se comprar accionesa de una empresa apartir de una cantidad
	 * @param simbolola empresa
	 * @param saldo el precio
	 * @param precio el precio
	 * @param cantidad la cantidad que se quiere comprar
	 * @return
	 */
	public Boolean comprar_cantidad(String simbolo,float saldo, float precio,float cantidad) {
		float gasto=cantidad*precio;
		if (gasto > saldo) {

			return false;

		} else {

			cantidad = (int) cantidad;

			boolean hay = false;
			int posicion = 0;
			for (int i = 0; i < empresas.size(); i++) {
				if (empresas.get(i).getSimbolo().equals(simbolo)) {
					hay = true;
					posicion = i;
				}

			}
			if (!hay) {
				empresas.add(new Empresa());
				empresas.get(empresas.size() - 1).setSimbolo(simbolo);
				empresas.get(empresas.size() - 1).setcantidad(cantidad);
				empresas.get(empresas.size() - 1).setgastado(gasto);
			} else {

				empresas.get(posicion).setcantidad(cantidad + empresas.get(posicion).getcantidad());
				empresas.get(posicion).setgastado(gasto + empresas.get(posicion).getgastado());

			}
			return true;
		}

	}
	/**
	 * vende las acciones por cantidades
	 * @param simbolo
	 * @param cantidad
	 * @param precio
	 * @return Devuelve lo que se ha ganado
	 */
	public String vender_cantidad(String simbolo, float cantidad,float precio ) {
		
			
		if (empresas.size() != 0) {
			float beneficio=cantidad*precio;
			int posicion = 0;
			for (int i = 0; i < empresas.size(); i++) {
				if (empresas.get(i).getSimbolo().equals(simbolo)) {

					posicion = i;
				}

			}

			empresas.get(posicion).setcantidad(empresas.get(posicion).getcantidad()-cantidad);
			empresas.get(posicion).setgastado(empresas.get(posicion).getgastado()-beneficio);

			if (empresas.get(posicion).getcantidad() == 0) {

				empresas.remove(posicion);

			}
			return String.valueOf(beneficio);
		}
		return "0";
	}
	/**
	 * Muestra la primera empresa
	 * @return el nombre primera empresa
	 * @throws JSONException
	 */
	public String empresa1() throws JSONException {

		if (empresas.size() > 0) {
			return API_Acciones.quota_empresa_nombre(empresas.get(0).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Muestra la segunda empresa
	 * @return el nombre segunda empresa
	 * @throws JSONException
	 */
	public String empresa2() throws JSONException {

		if (empresas.size() > 1) {
			return API_Acciones.quota_empresa_nombre(empresas.get(1).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Devuelve todas las empresas
	 * @return todas las empresas
	 */
	public ArrayList<Empresa> paravender() {

		return this.empresas;
		

	}
	/**
	 * Devuelve todas las empresas
	 * @return todas las empresas
	 */
	public ArrayList<Empresa> parafavoritas() {

		return this.favoritas;
		

	}
	/**
	 * Devuelve todas las empresas
	 * @return todas las empresas
	 */
	public ArrayList<Empresa> pararecomendados() {


		return this.recomendado;
		

	}
	/**
	 * Devuelve todas las empresas
	 * @return todas las empresas
	 */
	public ArrayList<Empresa> paraotros() {


		return this.otros;
		

	}
	
	
	/**
	 * Añade una empresa al arraylist favoritos
	 * @param simbolo
	 */
	public void añadir_favoritas(String simbolo) {
		

			boolean hay = false;
			int posicion = 0;
			for (int i = 0; i < favoritas.size(); i++) {
				
				if (favoritas.get(i).getSimbolo().equals(simbolo)) {
					hay = true;
					posicion = i;
					
				}

			}
			
			if (hay==false) {
				favoritas.add(new Empresa());
				favoritas.get(favoritas.size()-1).setSimbolo(simbolo);
				
			} else {

				favoritas.remove(posicion);
				
			}
			
	}
	/**
	 * Muestra la primera empresa
	 * @return el nombre primera empresa
	 * @throws JSONException
	 */
	public String favoritas1() throws JSONException {

		if (favoritas.size() > 0) {
			return API_Acciones.quota_empresa_nombre(favoritas.get(0).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Muestra la segunda empresa
	 * @return el nombre segunda empresa
	 * @throws JSONException
	 */
	public String favoritas2() throws JSONException {

		if (favoritas.size() > 1) {
			return API_Acciones.quota_empresa_nombre(favoritas.get(1).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Aleatoriamente añade 10 empresas al arraylist recomendado
	 * @param empresas
	 * @throws JSONException
	 */
	public  void recomendaciones10(ArrayList<Empresa> empresas) throws JSONException {
		int numero=0;
		for(int i=0;i<10;i++) {
			numero=(int) Math.floor(Math.random()*(empresas.size()-1-0+1)+0);
			System.out.println(numero);
			recomendado.add(new Empresa());
			recomendado.get(recomendado.size() - 1).setSimbolo(empresas.get(numero).getSimbolo());
			
		}
		
		
		
		
	}
	/**
	 * Muestra la primera empresa
	 * @return el nombre primera empresa
	 * @throws JSONException
	 */
	public String recomendado1() throws JSONException {

		if (recomendado.size() > 0) {
			return API_Acciones.quota_empresa_nombre(recomendado.get(0).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Muestra la segunda empresa
	 * @return el nombre segunda empresa
	 * @throws JSONException
	 */
	public String recomendado2() throws JSONException {

		if (recomendado.size() > 1) {
			return API_Acciones.quota_empresa_nombre(recomendado.get(1).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Enseña 10 inversiones realizadas por otras personas
	 * @param empresas
	 * @throws JSONException
	 */
	public void otros10(ArrayList<Empresa> empresas) throws JSONException {
		
		///////
		
		//
		//
		///
		//
		//
		//
		//
		///
		/////
		////
		//
		//
		//
		//
		//
		//
		//
		
		
		
		
	}
	/**
	 * Muestra la primera empresa
	 * @return el nombre primera empresa
	 * @throws JSONException
	 */
	public String otros1() throws JSONException {

		if (otros.size() > 0) {
			return API_Acciones.quota_empresa_nombre(otros.get(0).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Muestra la segunda empresa
	 * @return el nombre segunda empresa
	 * @throws JSONException
	 */
	public String otros2() throws JSONException {

		if (otros.size() > 1) {
			return API_Acciones.quota_empresa_nombre(otros.get(1).getSimbolo());
		} else {
			return "-";
		}

	}
	/**
	 * Elimina todos los datos de los arrays
	 */
	public void borrar_todo() {
		
		empresas.clear();
		favoritas.clear();
		recomendado.clear();
		otros.clear();
		
		
		
		
	}
	/**
	 * Al comprar con dinero puede sobrar, con esto lo sobrante se devuelve se recomienda utilizar despues de comprar_precio
	 * @return
	 */
	public float diferencia() {
		return this.diferencia;
	}
}
