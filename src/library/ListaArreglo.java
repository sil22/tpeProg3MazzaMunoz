package library;

public class ListaArreglo {

	Object arr[];
	int size = 0;

	public ListaArreglo(){
		arr = new Object[500];
	}

	public ListaArreglo(Object arr[]){
		this.arr = arr;
		size = arr.length;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public Object getElement(int pos){
		if(pos < size){
			return arr[pos];
		}
		return null;
	}


	public void insert(Object o){

		if(arr[arr.length-1] != null){
			Object nuevoArreglo[] = new Object[size*2];
			for (int i = 0; i < size; i++) {
				nuevoArreglo[i] = arr[i];
			}
			arr = nuevoArreglo;
		}
		for (int i = 0; i < size; i++) {
			if(arr[i] == null){
				arr[i] = o;
			}
		}
		size++;
	}


	public boolean isSorted(){

		if(size > 2){
			return isSorted(0);
		}
		return true;
	}

	private boolean isSorted(Integer pos){

		Integer next = pos+1;
		if((int) next < (int)size){
			if((int)arr[pos] <= (int)arr[next]){
				return isSorted(next);
			}
			else{
				return false;
			}
		}
		return true;

	}

	public void quickSort(){

		quickSort(0, size-1);

	}

	private void quickSort(int start, int end) {


		int i = start;
		int j = end;
		int pivot = (int)arr[start+(end-start)/2];

		while(i <= j){

			while((int)arr[i] < pivot){
				i++;
			}
			while((int)arr[j] > pivot){
				j--;
			}
			if(i <= j){
				swap(i,j);
				i++;
				j--;
			}
		}
		if(start < j ){
			quickSort(start,j);
		}
		if(i < end){
			quickSort(i, end);
		}

	}

	private void swap(int i, int j) {
		int aux = 0;
		aux = (int) arr[i];
		arr[i] = arr[j];
		arr[j] = aux;
	}

	public Object getElementRecursively(int pos){

		int count = 0;

		if(pos >= 0 && pos < size){
			if(count == pos){
				return arr[count];
			}
			count++;
			return getElementRecursively(pos, count);   
		}
		return null;

	}

	private Object getElementRecursively(int pos, int count) {

		if(count == pos){
			return arr[count]; 
		}
		count++;
		return getElementRecursively(pos, count);

	}

	public Object binarySearch(Object o){

		if(!isEmpty() && isSorted()){
			int inicio = 0;
			int fin  = size - 1;
			int medio = inicio+fin/2;
			return binarySearch(inicio, fin, medio, o);
		}
		return null;

	}
	public Object binarySearch(int inicio, int fin, int medio, Object o){

		Object current = arr[medio];

		if(o.equals(current)){
			return current;
		}
		if(inicio == fin){
			return null;
		}

		if((int)o < (int)current){
			fin = medio-1;
			medio = (inicio+fin)/2;
		}
		else{
			inicio = medio+1;
			medio = (inicio+fin)/2;
		}
		return binarySearch(inicio, fin, medio, o);
	}

	public void print(){

		for (int i = 0; i != size; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}

	public void deleteAll(){
		arr = new Object[10];
		size = 0;
	}

	public ListaArreglo copy(){

		ListaArreglo copy = new ListaArreglo();
		for (int i = 0; i < size; i++) {
			copy.insert(arr[i]);
		}
		return copy;
	}


}
