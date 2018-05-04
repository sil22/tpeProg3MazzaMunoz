package library;

public class Library {
	ListaArreglo books;
	BinaryTree indicePorGenero;
	int idBook;
	
	public Library(){
		idBook = 0;
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

	public void setIndicePorGenero(BinaryTree indicePorGenero) {
		this.indicePorGenero = indicePorGenero;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	
	public void addBook(String [] items){
		idBook++;
		String[] generos = items[3].split(" ");
		Book book = new Book(idBook,items[0], items[1], items[2], generos);
		addGender(generos);
		books.insert(book);
	}

	private void addGender(String[] generos) {
		for (int i = 0; i < generos.length; i++) {
			Gender g = new Gender(generos[i]);
			//antes preguntar si no existe en el arbol
			indicePorGenero.insert(g);
		}
	}

}
