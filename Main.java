public class Main {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addFirst(12);
		assert ll.get(0) == 12;
		ll.addFirst(1337);
		assert ll.get(0) == 1337;
		assert ll.get(1) == 12;
		ll.addFirst(5647);
		assert ll.get(0) == 5647;
		assert ll.get(1) == 1337;
		assert ll.get(2) == 12;
		assert ll.length() == 3;
		assert ll.has(12);
		assert !ll.has(15);
		assert ll.ocurrencesOf(12) == 1;
		ll.addLast(12);
		ll.addLast(12);
		assert ll.ocurrencesOf(12) == 3;
		System.out.println(ll.get(2));
		ll.remove(5647);
		assert !ll.has(5647);
		assert ll.get(0) == 1337;
		assert ll.length() != 2 : "Length 2!";
		System.out.println(ll);
	}


}
