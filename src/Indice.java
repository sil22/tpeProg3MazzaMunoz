import java.util.Iterator;
import java.util.LinkedList;

public class Indice implements Iterable<Integer>{
	String nombre;
	LinkedList<Integer> libros;
	
	public Indice(String n) {
		nombre = n;
		libros = new LinkedList<Integer>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Integer> getLibros() {
		return libros;
	}

	public void setLibros(LinkedList<Integer> libros) {
		this.libros = libros;
	}
	
	public void addBook(Integer idLibro) {
		libros.add(idLibro);
	}

	@Override
	public Iterator<Integer> iterator() {
		return libros.iterator();
	}
	
	
}
