import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class API_Acciones {
	/**
	 *Con la api del json saca las empresas
	 * @param empresas Clase donde se guardan las empresas
	 * @throws JSONException
	 */
	public static void lista_empresas(ArrayList<Empresa> empresas/* empresa empresas[]/*,int posicion */)
			throws JSONException {

		String JSON = "";

		String url = "https://ws-api.iextrading.com/1.0/ref-data/symbols?filter=symbol,isEnabled";

		JSON = API.request_empresas(url/* ,2500 */)/* +']' */;

		System.out.println(JSON);

		JSONArray empresas1 = new JSONArray(JSON);
		for (int i = 0; i < empresas1.length(); i++) {

			/* empresas[i]=new empresa(); */

			JSONObject empresa1 = empresas1.getJSONObject(i);

			/*
			 * if(empresa1.getBoolean("isEnabled")) {
			 * empresas[i].setSimbolo(empresa.getString("symbol")); }
			 */
			if (empresa1.getBoolean("isEnabled")) {
				empresas.add(i, new Empresa());
				empresas.get(i).setSimbolo(empresa1.getString("symbol"));
			} else {
				empresas.add(i, new Empresa());
				empresas.get(i).setSimbolo("nada");
			}
			/*
			 * empresas.add(new empresa());
			 * empresas.get(empresas.size()).setSimbolo(empresa1.getString("symbol"));
			 * /*empresas[i].setSimbolo(empresa.getString("symbol"));
			 * /*empresas[i].setNombre(empresa.getString("name"));
			 * empresas[i].setFecha(empresa.getString("date"));
			 * empresas[i].setHabilitado(empresa.getBoolean("isEnabled"));
			 * empresas[i].setTipo(empresa.getString("symbol"));
			 * empresas[i].setIexID(empresa.getString("type"));
			 * 
			 * 
			 * System.out.println(empresas[i].getSimbolo()+empresas[i].getNombre()+empresas[
			 * i].getFecha()+empresas[i].getHabilitado()+empresas[i].getTipo()+empresas[i].
			 * getIexID());
			 */

			/*
			 * System.out.println(API.request("https://api.iextrading.com/1.0/stock/"+
			 * empresas[i].getSimbolo()+"/quote",2000));
			 * System.out.println(API.request("https://api.iextrading.com/1.0/stock/"+
			 * empresas[i].getSimbolo()+"/price",2000));
			 */
			/*
			 * if(i==posicion) {return empresas[posicion].getSimbolo(); }
			 */
		}

		/* return empresas[posicion].getSimbolo(); */

	}
	/**
	 * Se obtiene el precio de una accion
	 * @param simbolo
	 * @return precio de una una accion
	 * @throws JSONException
	 */
	public static String precio_empresa(String simbolo) throws JSONException {

		String JSON = "";
		String JSON2 = "";
		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/price";

		JSON = API.request(url);

		//System.out.println(JSON);
		/*
		 * for(int i=0;i<JSON.length();i++) { if(JSON.charAt(i)=='.') { JSON2=JSON2+',';
		 * }else { JSON2=JSON2+JSON.charAt(i); }
		 * 
		 * 
		 * } ;
		 */
		
		
		String devolver= String.valueOf(Float.parseFloat(JSON));
		 return devolver;
	}
	/**
	 * Se obtiene el nombre
	 * @param simbolo
	 * @return nombre
	 * @throws JSONException
	 */
	public static String quota_empresa_nombre(String simbolo) throws JSONException {

		String JSON = "";

		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/quote";

		JSON = API.request(url);

		//System.out.println(JSON);

		
		 JSONObject json = new JSONObject(JSON);
		String vuelta= json.getString("companyName");
		return vuelta;
				

	}
	/**
	 * Se obtiene el nombre del sector
	 * @param simbolo
	 * @return sector
	 * @throws JSONException
	 */
public static String quota_empresa_sector(String simbolo) throws JSONException {

		String JSON = "";

		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/quote";

		JSON = API.request(url);

		//System.out.println(JSON);

		 JSONObject json = new JSONObject(JSON);
		 /* System.out.println(json.getString("companyName"));
		 * System.out.println(json.getString("sector"));
		 * System.out.println(json.getString("open"));
		 * System.out.println(json.getString("close"));
		 * System.out.println(json.getString("high"));
		 * System.out.println(json.getString("low"));
		 */
		 return json.getString("sector");

	}
/**
 * Se obtiene el mercado de la empresa
 * @param simbolo
 * @return mercado
 * @throws JSONException
 */
	public static String quota_empresa_mercado(String simbolo) throws JSONException {

		String JSON = "";

		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/quote";

		JSON = API.request(url);

		//System.out.println(JSON);

		 JSONObject json = new JSONObject(JSON);
		 /* System.out.println(json.getString("companyName"));
		 * System.out.println(json.getString("sector"));
		 * System.out.println(json.getString("open"));
		 * System.out.println(json.getString("close"));
		 * System.out.println(json.getString("high"));
		 * System.out.println(json.getString("low"));
		 */
		 return json.getString("primaryExchange");

	}
	/**
	 * Se obtiene el precio de apertura
	 * @param simbolo
	 * @return precio de apertura
	 * @throws JSONException
	 */
	public static String quota_empresa_open(String simbolo) throws JSONException {

		String JSON = "";

		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/quote";

		JSON = API.request(url);

		//System.out.println(JSON);

		 JSONObject json = new JSONObject(JSON);
		 /* System.out.println(json.getString("companyName"));
		 * System.out.println(json.getString("sector"));
		 * System.out.println(json.getString("open"));
		 * System.out.println(json.getString("close"));
		 * System.out.println(json.getString("high"));
		 * System.out.println(json.getString("low"));
		 */
		 
		 String devolver= String.valueOf(json.getInt("open"));
		 return devolver;
	}
/**
 * Se obtiene el precio de cierre
 * @param simbolo
 * @return precio de cierre
 * @throws JSONException
 */
	public static String quota_empresa_close(String simbolo) throws JSONException {

		String JSON = "";

		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/quote";

		JSON = API.request(url);

		//System.out.println(JSON);

		 JSONObject json = new JSONObject(JSON);
		 /* System.out.println(json.getString("companyName"));
		 * System.out.println(json.getString("sector"));
		 * System.out.println(json.getString("open"));
		 * System.out.println(json.getString("close"));
		 * System.out.println(json.getString("high"));
		 * System.out.println(json.getString("low"));
		 */
		 
		 String devolver= String.valueOf(json.getInt("close"));
		 return devolver;
	}
	/**
	 * Se obtiene el precio alto
	 * @param simbolo
	 * @return precio alto
	 * @throws JSONException
	 */
	public static String quota_empresa_high(String simbolo) throws JSONException {

		String JSON = "";

		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/quote";

		JSON = API.request(url);

		//System.out.println(JSON);

		 JSONObject json = new JSONObject(JSON);
		 /* System.out.println(json.getString("companyName"));
		 * System.out.println(json.getString("sector"));
		 * System.out.println(json.getString("open"));
		 * System.out.println(json.getString("close"));
		 * System.out.println(json.getString("high"));
		 * System.out.println(json.getString("low"));
		 */
		 
		 String devolver= String.valueOf(json.getInt("high"));
		 return devolver;
	}
	/**
	 * Se obtiene el precio bajo
	 * @param simbolo
	 * @return precio bajo
	 * @throws JSONException
	 */
	public static String quota_empresa_low(String simbolo) throws JSONException {

		String JSON = "";

		String url = "https://api.iextrading.com/1.0/stock/" + simbolo + "/quote";

		JSON = API.request(url);

		//System.out.println(JSON);

		 JSONObject json = new JSONObject(JSON);
		 /* System.out.println(json.getString("companyName"));
		 * System.out.println(json.getString("sector"));
		 * System.out.println(json.getString("open"));
		 * System.out.println(json.getString("close"));
		 * System.out.println(json.getString("high"));
		 * System.out.println(json.getString("low"));
		 */
		 String devolver= String.valueOf(json.getInt("low"));
		 return devolver;

	}

}
