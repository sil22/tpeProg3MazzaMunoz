package library;

import java.util.LinkedList;

import util.*;


public class Library {
	
	ListaArreglo books;
	GenderTree indicePorGenero;

	public Library(){
		books = new ListaArreglo();
		indicePorGenero = new GenderTree();
	}
		
	public ListaArreglo getBooks() {
		return books;
	}

	public void setBooks(ListaArreglo books) {
		this.books = books;
	}

	public BinaryTree getIndicePorGenero() {
		return indicePorGenero;
	}

	public void setIndicePorGenero(GenderTree indicePorGenero) {
		this.indicePorGenero = indicePorGenero;
	}


	public void addBook(String [] items){
		
		Book book = new Book(items[0], items[1], items[2], items[3]);
		addLinkToBook(items[3],book);
		books.insert(book);
	}

	private void addLinkToBook(String generos, Book book) {
		
		String[] arrGeneros = generos.split(" ");
		for (String genero : arrGeneros) {
			indicePorGenero.addLinkToBook(genero, book);
		}
	}
	
	public LinkedList<Book> searchBooks(String gender){
		
		return indicePorGenero.getBookList(gender);
	}


}
