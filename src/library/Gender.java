package library;
import java.util.Iterator;
import java.util.LinkedList;

public class Gender implements Iterable<Book> {

	String name;
	LinkedList<Book> books;
	
	public Gender(String n) {
		name = n;
		books = new LinkedList<Book>();
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public LinkedList<Book> getbooks() {
		return books;
	}

	public void setbooks(LinkedList<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book idLibro) {
		books.add(idLibro);
	}

	@Override
	public Iterator<Book> iterator() {
		return books.iterator();
	}
	
}
