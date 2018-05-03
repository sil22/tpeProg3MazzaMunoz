package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Scanner {
	Library library;

	public Scanner(Library l) {
		library = l;
	}

	public void leerArchivos(String path) {

		String line = "";
		String cvsSplitBy = ",";
		long inicio, fin, tiempoTotal;

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			inicio = System.nanoTime();

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				library.addBook(items);

			}
			fin = System.nanoTime();
			tiempoTotal = fin - inicio;

			System.out.println(Long.toString(tiempoTotal));// Imprimo tiempo que
															// tarda en leer el
															// archivo

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resultadoLibrosxGeneros(ArrayList<Book> books, String path) {
		// CSVWritter
		BufferedWriter bw = null;
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (int j = 0; j < books.size(); j++) {
				String tituloLibro = books.get(j).getTitulo();
				bw.write(tituloLibro);
				bw.newLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}

		}
	}

}
