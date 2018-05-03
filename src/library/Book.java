package library;
 public class Book {
	int id;
	String titulo = "";
	String autor = "";
	String cantPaginas;
	String [] generos;

	public Book(int id, String t, String a, String cp, String[] g){
		this.id = id;
		titulo = t;
		autor = a;
		cantPaginas = cp;
		generos = g;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(String cantPaginas) {
		this.cantPaginas = cantPaginas;
	}

	public String[] getGeneros() {
		return generos;
	}

	public void setGeneros(String[] generos) {
		this.generos = generos;
	}
}
