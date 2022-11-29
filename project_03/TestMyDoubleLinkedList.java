public class TestMyDoubleLinkedList {
	public static void main(String[] args) {
		String[] name1 = { "Tom", "George", "Peter", "Jean", "Jane" };
		String[] name2 = { "George", "Michael", "Michelle", "Daniel" };
		String[] name3 = { "Tom", "Peter", "Jane", "Adam", "Mary", "David" };

		MyDoubleLinkedList<String> list1 = new MyDoubleLinkedList<String>();
		System.out.println("\nTesting addInOrder()");
		for (int i = 0; i < name1.length; ++i)
			list1.addInOrder(name1[i]);
		System.out.println("list1: " + list1);
		System.out.println("\nTesting overloaded constructor");
		MyDoubleLinkedList<String> list2 = new MyDoubleLinkedList<String>(name2);
		MyDoubleLinkedList<String> list3 = new MyDoubleLinkedList<String>(name3);
		System.out.println("list2: " + list2);
		System.out.println("list3: " + list3);
		System.out.println("\nTesting addLast");
		for (int i = 0; i < name3.length; ++i)
			list1.addLast(name3[i]);
		System.out.println("list1: " + list1);
		System.out.println("\nTesting set(10,\"Jane\")");
		list1.set(10, "Jane");
		System.out.println("list1: " + list1);
		System.out.println("\nTesting printReverse()");
		list2.printReverse();
		System.out.println("\nTesting printList()");
		list2.printList();
		System.out.println("\nTesting indexOf(\"Tom\")");
		System.out.println("First index of Tom is " + list1.indexOf("Tom"));
		System.out.println("\nTesting lastIndexOf(\"Tom\")");
		System.out.println("Last index of Tom is " + list1.lastIndexOf("Tom"));
		System.out.println("\nTesting contains(\"Bahram\")");
		System.out.println("list1 contains Bahram is " + list1.contains("Bahram"));
		System.out.println("\nTesting getLength()");
		System.out.println("Length if list1 is " + list1.getLength());

		System.out.println("list1: " + list1);
		System.out.println("Length if list1 is " + list1.getLength());
		System.out.println("\nTesting remove(\"Adam\")");
		list2.remove("Adam");
		System.out.println("list2: " + list2);
		System.out.println("\nTesting get(2) and get(10)");
		System.out.println(list1);
		System.out.println(list1.get(2));
		System.out.println(list1.get(10));

		System.out.println("\nTesting split()");
		System.out.println(list1);
		MyDoubleLinkedList<String> list4 = list1.split();
		System.out.println(list1);
		System.out.println(list4);

	}

}
