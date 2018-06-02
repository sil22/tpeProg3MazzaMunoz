package library;

import java.util.LinkedList;

import util.*;


public class Library {
	
	BookList books;
	GenderTree genderIndex;

	public Library(){
		books = new BookList();
		genderIndex = new GenderTree();
	}
		
	public BookList getBooks() {
		return books;
	}

	public void setBooks(BookList books) {
		this.books = books;
	}

	public GenderTree getGenderIndex() {
		return genderIndex;
	}

	public void setGenderIndex(GenderTree genderIndex) {
		this.genderIndex = genderIndex;
	}


	public void addBook(String [] items){
		
		Book book = new Book(items[0], items[1], items[2], items[3]);
		addLinkToBook(items[3],book);
		books.insert(book);
	}

	private void addLinkToBook(String gendersStr, Book book) {
		
		String[] genders = gendersStr.split(" ");
		for (String gender : genders) {
			genderIndex.addLinkToBook(gender, book);
		}
	}
	
	public LinkedList<Book> searchBooks(String gender){
		
		return genderIndex.getBookList(gender);
	}


}
