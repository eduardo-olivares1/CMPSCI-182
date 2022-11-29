public class MyDoubleLinkedList<E extends Comparable<E>> {

   private Node<E> head, tail;
   private int size;

   /** DONE: Create a default list */
   public MyDoubleLinkedList() {
      this.size = 0;
      this.head = null;
      this.tail = null;
   }

   /** DONE: Create a list from an array of objects */
   public MyDoubleLinkedList(E[] objects) {
      for (int i = 0; i < objects.length; i++) {
         this.addInOrder(objects[i]);
      }
   }

   /** DONE: Return the head element in the list */
   public E getFirst() {
      if (size == 0) {
         return null;
      } else {
         return head.element;
      }
   }

   /** DONE: Return the last element in the list */
   public E getLast() {
      if (size == 0) {
         return null;
      } else {
         return tail.element;
      }
   }

   /** DONE: Add an element to the beginning of the list */
   public void addFirst(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new node
      newNode.next = head; // link the new node with the head
      head = newNode; // head points to the new node
      size++; // Increase list size

      if (tail == null) // the new node is the only node in list
         tail = head;

      if (head != tail)
         head.next.previous = head; // For a two-way linked list
   }

   /** DONE: Add an element to the end of the list */
   public void addLast(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new for element e

      Node<E> temp = tail; // For a two-way linked list

      if (tail == null) {
         head = tail = newNode; // The new node is the only node in list
      } else {
         tail.next = newNode; // Link the new with the last node
         tail = tail.next; // tail now points to the last node
      }

      size++; // Increase size

      tail.previous = temp; // For a two-way linked list
   }

   /**
    * DONE: Add a new element at the specified index in this list The index of the
    * head element is 0
    */
   public void add(int index, E e) {
      // "Implementation left as an exercise"
      int maxIndex = size - 1;
      if (index == 0) { // Add to head
         this.addFirst(e);
      } else if (index == maxIndex) { // Add to tail
         this.addLast(e);
      } else { // Add in middle
         Node<E> newNode = new Node<E>(e);
         Node<E> previous = head;
         Node<E> proceeding = null;

         // Get previous node
         int count = 0;
         while (count < (index - 1)) {
            previous = previous.next;
            count++;
         }

         proceeding = previous.next;

         previous.next = newNode;
         newNode.next = proceeding;
         newNode.previous = previous;

         this.size++;
      }
   }

   /**
    * DONE: Add a new element at the specified index in this list in ascending
    * order
    */
   public void addInOrder(E e) {
      // "Implementation left as an exercise";

      // If list is empty just add to head
      if (this.head == null) {
         this.addFirst(e);
         return;
      }

      int maxIndex = size - 1;

      Node<E> newNode = new Node<E>(e);
      Node<E> previous = head;
      Node<E> proceeding = head.next;

      // Check if less than head
      if (this.head.element.compareTo(e) > 0) {
         this.addFirst(e);
         return;
      } else if (tail.element.compareTo(e) < 0) { // Check if less than tail
         this.addLast(e);
         return;
      } else { // Check middle elements
         // Go through the middle and check iteravly to compare
         int count = 0;
         while (count < maxIndex) {

            if (proceeding.element.compareTo(newNode.element) > 0) {
               previous.next = newNode;
               newNode.previous = previous;
               newNode.next = proceeding;
               proceeding.previous = newNode;

               this.size++;
               return;
            }

            // Next iteration
            previous = previous.next;
            proceeding = previous.next;
            count++;
         }
      }

   }

   /** DONE: Return true if this list contains no elements */
   public boolean isEmpty() {
      return size() == 0;
   }

   /** DONE: Check to see if this list contains element e */
   public boolean contains(E e) {
      // "Implementation left as an exercise";

      // If list is empty just return false
      if (this.head == null) {
         return false;
      }

      int maxIndex = size - 1;

      Node<E> previous = head;
      Node<E> proceeding = null;

      // Check if in head
      if (this.head.element.compareTo(e) == 0) {
         return true;
      } else if (tail.element.compareTo(e) == 0) { // Check if in tail
         return true;
      } else { // Check if in middle elements
         // Go through all elements and check iteravly to compare
         int count = 0;
         while (count < maxIndex) {
            proceeding = previous.next;

            if (proceeding.element.compareTo(e) == 0) {
               return true;
            }

            // Next iteration
            previous = previous.next;
            count++;
         }

         return false;
      }
   }

   /**
    * DONE: Remove the head node and return the object that is contained in the
    * removed node.
    */
   public E removeFirst() {
      if (size == 0) {
         return null;
      } else {
         Node<E> temp = head;
         head = head.next;
         size--;
         if (head == null) {
            tail = null;
         }
         return temp.element;
      }
   }

   /**
    * DONE: Remove the last node and return the object that is contained in the
    * removed node.
    */
   public E removeLast() {
      if (size == 0) {
         return null;
      } else if (size == 1) {
         Node<E> temp = head;
         head = tail = null;
         size = 0;
         return temp.element;
      } else {
         Node<E> current = head;

         for (int i = 0; i < size - 2; i++) {
            current = current.next;
         }

         Node<E> temp = tail;
         tail = current;
         tail.next = null;
         size--;
         return temp.element;
      }
   }

   /**
    * DONE : Remove the element at the specified position in this list. Return the
    * element that was removed from the list.
    */
   public E remove(int index) {
      // "Implementation left as an exercise";

      int maxIndex = size - 1;
      if (index == 0) { // Add to head
         return this.removeFirst();
      } else if (index == maxIndex) { // Add to tail
         return this.removeLast();
      } else { // Add in middle
         Node<E> previous = head;
         Node<E> proceeding = null;
         Node<E> removed = null;

         // Get previous node
         int count = 0;
         while (count < (index - 1)) {
            previous = previous.next;
            count++;
         }

         removed = previous.next;
         proceeding = removed.next;

         previous.next = proceeding;
         proceeding.previous = previous;

         this.size--;

         return removed.element;
      }
   }

   /**
    * DONE: Remove the first occurrence of the element e
    * from this list. Return true if the element is removed.
    */
   public boolean remove(E e) {
      if (this.contains(e)) {
         for (int i = 0; i < this.size; i++) {
            if (this.get(i).compareTo(e) == 0) {
               this.remove(i);
               return true;
            }
         }
         return false;
      } else {
         return false;
      }
   }

   /** DONE: Return the length of this list using recursion */
   public int getLength() {
      // "Implementation left as an exercise";

      if (this.head == null) {
         if (this.tail == null) {
            return 0;
         } else {
            // If you get to the end, reset head back to its original value
            Node<E> current = this.tail;
            while (current.previous != null) {
               current = current.previous;
            }
            this.head = current;
            // Then exit case
            return 0;
         }

      } else {
         this.head = this.head.next;
         return 1 + getLength();
      }

   }

   @Override
   public String toString() {
      StringBuilder result = new StringBuilder("[");

      Node<E> current = head;
      for (int i = 0; i < size; i++) {
         result.append(current.element);
         current = current.next;
         if (current != null) {
            result.append(", "); // Separate two elements with a comma
         } else {
            result.append("]"); // Insert the closing ] in the string
         }
      }

      return result.toString();
   }

   // /** DONE: Print the list in reverse order */
   public void printReverse() {
      // "Implementation left as an exercise";
      Node<E> current = this.tail;

      System.out.print("[");
      while (current != null) {
         System.out.print(" " + current.element + " ");
         current = current.previous;
      }
      System.out.println("]");
   }

   // /** DONE: Print this list using recursion */
   public void printList() {
      // "Implementation left as an exercise";
      if (this.head == null) {
         if (this.tail == null) {
            return;
         }

         // If you get to the end, reset head back to its original value
         Node<E> current = this.tail;
         while (current.previous != null) {
            current = current.previous;
         }
         this.head = current;
         // Then exit case
         System.out.println("");

      } else {
         System.out.print(" " + this.head.element + " ");
         this.head = this.head.next;
         this.printList();
      }

   }

   /** DONE: Clear the list */
   public void clear() {
      head = tail = null;
   }

   /** DONE: Return the element from this list at the specified index */
   public E get(int index) {
      // "Implementation left as an exercise"

      if (this.isEmpty()) {
         return null;
      }

      int maxIndex = size - 1;
      if (index == 0) { // Add to head
         return this.head.element;
      } else if (index == maxIndex) { // Add to tail
         return this.tail.element;
      } else { // Add in middle
         Node<E> previous = head;
         Node<E> indexNode = null;

         // Get previous node
         int count = 0;
         while (count < (index - 1)) {
            previous = previous.next;
            count++;
         }

         indexNode = previous.next;
         return indexNode.element;
      }
   }

   /**
    * DONE: Return the index of the head matching element in this list. Return -1
    * if
    * no match.
    */
   public int indexOf(Object e) {
      // "Implementation left as an exercise"
      int maxIndex = size - 1;

      Node<E> previous = head;
      Node<E> proceeding = null;

      // Check if in head
      if (e.equals(this.head.element)) {
         return 0;
      } else if (e.equals(this.tail.element)) { // Check if in tail
         return maxIndex;
      } else { // Check if in middle elements
         // Go through all elements and check iteravly to compare
         int count = 0;
         while (count < maxIndex) {
            proceeding = previous.next;

            if (e.equals(proceeding.element)) {
               return count;
            }

            // Next iteration
            previous = previous.next;
            count++;
         }

         return -1;
      }
   }

   /**
    * DONE: Return the index of the last matching element in this list Return -1 if
    * no match.
    */
   public int lastIndexOf(Object e) {
      // "Implementation left as an exercise";
      int lastIndex = -1;
      int count = 0;
      Node<E> current = this.head;

      while (current != null) {
         if (e.equals(current.element)) {
            lastIndex = count;
         }

         current = current.next;
         count++;
      }

      return lastIndex;
   }

   /**
    * DONE: Replace the element at the specified position in this list with the
    * specified element.
    */
   public E set(int index, E e) {
      // "Implementation left as an exercise";
      int maxIndex = size - 1;
      E replaced = null;

      if (index > maxIndex || index < 0) {
         return null;
      } else {
         if (index == 0) {
            replaced = this.head.element;
            this.head.element = e;
            return replaced;
         } else if (index == maxIndex) {
            replaced = this.tail.element;
            this.tail.element = e;
            return replaced;
         } else {
            Node<E> current = head;

            // Get previous node
            int count = 0;
            while (count < index) {
               current = current.next;
               count++;
            }

            replaced = current.element;
            current.element = e;

            return replaced;
         }
      }
   }

   public class Node<T> {
      T element;
      Node<T> next;
      Node<T> previous;

      public Node(T o) {
         element = o;
      }
   }

   public int size() {
      return size;
   }

   /**
    * DONE: Split the original list in half. The original
    * list will continue to reference the
    * front half of the original list and the method
    * returns a reference to a new list that stores the
    * back half of the original list. If the number of
    * elements is odd, the extra element should remain
    * with the front half of the list.
    */
   public MyDoubleLinkedList<E> split() {
      // "Implementation left as an exercise";
      int midpoint = (int) Math.ceil((double) this.size / 2);
      int amountToRemove = this.size - midpoint;
      MyDoubleLinkedList<E> backHalf = new MyDoubleLinkedList<E>();

      for (int i = midpoint; i < this.size; i++) {
         E val = this.get(i);
         backHalf.addLast(val);

      }

      for (int i = 0; i < amountToRemove; i++) {
         this.removeLast();
      }

      return backHalf;

   }

}
