import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Guardado {
	/**
	 * Guarda los datos en ficheros para una proxima recuperacion
	 * @param empresas
	 * @param favoritos
	 * @param saldo
	 * @param gastos
	 * @param beneficio
	 */
	public void guardar(ArrayList<Empresa> empresas, ArrayList<Empresa> favoritos, String saldo, String gastos,
			String beneficio) {

		FileWriter fichero = null;
		FileWriter base = null;
		FileWriter base2 = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("c:guardado/usuario.txt");
			base = new FileWriter("c:guardado/base.txt");
			base2 = new FileWriter("c:guardado/base2.txt");
			pw = new PrintWriter(fichero);
			pw.print("\\{\"saldo\"\\:\"" + saldo + "\"\\,\"gasto\"\\:\"" + gastos + "\"\\,\"beneficio\"\\:\""
					+ beneficio + "\"\\}");
			pw = new PrintWriter(base);
			pw.print("[");
			for (int i = 0; i < empresas.size(); i++) {

				pw.print("\\{\"symbol\"\\:\"" + empresas.get(i).getSimbolo() + "\"\\,");
				pw.print("\"cantidad\"\\:\"" + empresas.get(i).getcantidad() + "\"\\,");
				pw.print("\"gasto\"\\:\"" + empresas.get(i).getgastado() + "\"\\}");

			}
			pw.print("]");
			pw = new PrintWriter(base2);
			pw.print("[");
			for (int i = 0; i < favoritos.size(); i++) {

				pw.print("\\{\"symbol\"\\:\"" + empresas.get(i).getSimbolo() + "\"\\}");

			}
			pw.print("]");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
				if (null != fichero)
					base.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
}
