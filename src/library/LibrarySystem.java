package library;

public class LibrarySystem {
	
	Library library;
	Scanner scanner;
	
	public LibrarySystem(String path){
		library = new Library();
		scanner = new Scanner(path);
		scanner.importBooks(library);
	}
	
	public LibrarySystem(){
		library = null;
		scanner = null;
	}
	
	public void setLibrary(Library l){
		library = l;
	}
	
	public void setScanner(Scanner s){
		scanner = s;
	}
	
	public ListaArreglo getBooks(){
		return library.getBooks();
	}
	
	public void printBooksByGender(String gender, String path){
		scanner.printBooksByGeneder(library.searchBooks(gender), path);
	}
	
	public static void main(String[] args) {
		
		LibrarySystem ls = new LibrarySystem("C:/Users/Eloy/Desktop/temporalWSPC/datasets/primerEtapa/dataset1.csv");
		System.out.println(ls.getBooks().toString());
		ls.printBooksByGender("asdas", "C:/Users/Eloy/Desktop/temporalWSPC/datasets/primerEtapa/salidaDataset1.csv");
	}
	
}
