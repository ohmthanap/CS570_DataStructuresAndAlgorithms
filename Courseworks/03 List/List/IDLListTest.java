/* Homework 3
 * Section: CS 570-PA
 * Name-Lastname: Thanapoom Phatthanaphan
 * CWID: 20011296
 */

public class IDLListTest {

	public static void main(String[] args) {
		
		IDLList<Integer> List= new IDLList<Integer>();
		
		// add new element at the front of the list
		List.add(3);
		System.out.println(List);
		
		// add new element at the front of the list
		List.add(2);
		System.out.println(List);
		
		// add new element at the front of the list
		List.add(1);
		System.out.println(List);
		
		// add new element at the end of the list
		List.append(4);
		System.out.println(List);
		
		// add new element at the end of the list
		List.append(5);
		System.out.println(List);
		
		// add new element at the end of the list
		List.append(6);
		System.out.println(List);
		
		// add new element at the end of the list
		List.append(7);
		System.out.println(List);
		
		// add new element at the end of the list
		List.append(8);
		System.out.println(List);
		System.out.println();
		
		// remove and return the element at the front of the list
		System.out.println("Remove: " + List.remove());
		System.out.println(List);
		
		// remove and return the element at the end of the list
		System.out.println("Remove: " + List.removeLast());
		System.out.println(List);
		
		// remove and return the element at the specific index of the list
		System.out.println("Remove: " + List.removeAt(2));
		System.out.println(List);
		System.out.println("Remove: " + List.removeAt(0));
		System.out.println(List);
		System.out.println("Remove: " + List.removeAt(1));
		System.out.println(List);
		
		// removes the first occurrence of elem in the list and returns true.
		// return false if elem was not in the list.
		System.out.println("Remove: " + List.remove(5));
		System.out.println(List);
		System.out.println("Remove: " + List.remove(6));
		System.out.println(List);
		System.out.println("Remove: " + List.remove(3));
		System.out.println(List);
		System.out.println("Remove: " + List.remove(7));
		System.out.println(List);
		
		// add element at the specific index of the list
		List.add(0, 5);
		System.out.println(List);
		List.add(0, 1);
		System.out.println(List);
		List.add(1, 2);
		System.out.println(List);
		List.add(2, 4);
		System.out.println(List);
		List.add(2, 3);
		System.out.println(List);
		System.out.println();
		
		// obtain the object at position index from the head
		for (int i = 0; i < List.size(); i++) {
			System.out.println("Element at index " + i + " : " + List.get(i));
		}
		
		// obtain the object at the head
		System.out.println("Head element: " + List.getHead());
		
		// obtain the object at the tail
		System.out.println("Tail element: " + List.getLast());
		
		// obtain the list size
		System.out.println("List size: " + List.size());
		
		// presents a string representation of the list
		System.out.println("String representation of the list: " + List.toString());

	}

}
