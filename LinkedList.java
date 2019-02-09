public class LinkedList {
	private Node head;
	private int length;

	/* No hace falta crear un constructor
	 * que no tome parametros que ponga
	 * head y length a valores iniciales
	 * (null, y 0 respectivamente) debido
	 * a §4.12.5 de la especificación de java.
	 */
	/* En cualquier caso, se haría de esta 
	 * forma:
	 * public LinkedList() {
	 * 	this.head = null;
	 * 	this.lentgh = 0;
	 * }
	 */
	 
	/* Devuelve el numero de elementos
	 * de la linked list
	 */
	public int length() {
		return length;
	}
	
	public boolean has(int elem) {
		return find(elem) != -1;
	}

	/* devuelve el elemento en la posicion
	 * index 
	 */
	public int get(int index) throws ArrayIndexOutOfBoundsException {
		return getNode(index).getData();
	}

	public int ocurrencesOf(int elem) {
		int result = 0;
		Node currentNode = head;
		for(int i = 0; i < length; i++) {
			if(currentNode.getData() == elem) {
				result++;
			}
			currentNode = getNode(1,currentNode);
		}
		return result;
	}

	public int find(int elem) {
		int index = -1;
		Node currentNode = head;
		for( int i = 0; i < length && index == -1; i++ ) {
			if(currentNode.getData() == elem) {
				index = i;
			}
			currentNode = getNode(1,currentNode);
		}
		return index;
	}

	public void remove(int elem) {
		int index_to_delete = find(elem);
		if(index_to_delete == -1) {
			return;
		}

		length--;

		if(index_to_delete == 0) {
			head = head.getNext();
			return;
		}

		Node backNode = getNode(index_to_delete - 1);
		backNode.setNext(getNode(2,backNode));	
	}

	public Node getNode(int index) throws ArrayIndexOutOfBoundsException {
		if(index < 0 || index >= length) {
			System.err.println("indice fuera de la lista");
			throw new ArrayIndexOutOfBoundsException();
		}
		Node current = head;
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return current;
	}

	public Node getNode(int index, Node startingNode){	
		Node current = startingNode;

		for(int i = 0; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}

		return current;
	}

	public void addFirst(int elem) {
		Node newHead = new Node(elem,head);
		head = newHead;
		length++;
	}

	public void addLast(int elem) {
		Node newEnd = new Node(elem,null);
		getNode(length-1).setNext(newEnd);
		length++;
	}

	public String toString() {
		String result = "";
		for(int i = 0; i < length; i++) {
			Node current = getNode(i);
			result += "-> Data: " + current.getData() ;
		}
		return result + " :: length("+length+")";
	}
}
