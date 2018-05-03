package library;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	ListaArreglo books;
	BinaryTree indicePorGenero;
	int idBook;
	
	public Library(){
		idBook = 0;
	}
	
	public ListaArreglo getLibros() {
		return books;
	}
	
	public void setLibros(ListaArreglo libros) {
		this.books = libros;
	}
	
//	public ArrayList<Indice> getIndicePorGenero() {
//		return indicePorGenero;
//	}
//	
//	public void setIndicePorGenero(ArrayList<Indice> indicePorGenero) {
//		this.indicePorGenero = indicePorGenero;
//	}
//	
	private void addLinkToBook(String[] generos, Integer idBook){
		for (String genero : generos) {
//			indicePorGenero.get(genero).add(idBook);
		}
	}
	
	public void addBook(String [] items){
		idBook++;
		String[] generos = items[3].split(" ");
		Book book = new Book(idBook,items[0], items[1], items[2], generos);
		addLinkToBook(generos, idBook);
		books.insert(book);
	}

}
