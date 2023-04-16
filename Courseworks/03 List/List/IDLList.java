/* Homework 3
 * Section: CS 570-PA
 * Name-Lastname: Thanapoom Phatthanaphan
 * CWID: 20011296
 */

import java.util.ArrayList;

public class IDLList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        // a constructor that creates a node holding elem (element)
        public Node(E elem) {
        	this.data = elem;
        }

        // a constructor that creates a node holding element with next as next element and prev as previous element
        public Node(E elem, Node<E> prev, Node<E> next) {
            this.data = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    // creates an empty double-linked list
    public IDLList() {
        head = null;
        tail = null;
        size = 0;
        indices = new ArrayList<Node<E>>();
    }

    // adds elem at position index
    public boolean add(int index, E elem) {
    	if (elem == null) {
            throw new IllegalArgumentException();
        }
    	if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
		if (head == null) {
			Node<E> newNode = new Node<E>(elem, null, null);
			head = newNode;
			tail = newNode;
			indices.add(index, newNode);
		} else if (index == 0) {
			Node<E> newNode = new Node<E>(elem, null, null);
			newNode.next = head;
            head.prev = newNode;
            head = newNode;
            indices.add(0, newNode);
		} else {
			Node<E> currNode = indices.get(index);
			Node<E> newNode = new Node<E>(elem, currNode.prev, currNode);
			currNode.prev.next = newNode;
			currNode.prev = newNode;
			indices.add(index, newNode);
		}
        size++;
        return true;
    }

    // adds elem at the head
    public boolean add(E elem) {
    	if (elem == null) {
            throw new IllegalArgumentException();
        }
        Node<E> newNode = new Node<E>(elem);
        if (head == null) {
            head = newNode;
            tail = newNode;
            indices.add(newNode);
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            indices.add(0, newNode);
        }
        size++;
        return true;
    }

    // adds elem as the new last element of the list
    public boolean append(E elem) {
    	if (elem == null) {
    		throw new IllegalArgumentException();
        }
        Node<E> newNode = new Node<E>(elem);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            indices.add(newNode);
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            indices.add(newNode);
        }
        size++;
        return true;
    }

    // returns the object at position index from the head. It uses the index for fast access. Indexing starts from 0
    // thus get(0) returns the head element of the list
    public E get(int index) {
        if (index < 0 || index > size) {
        	throw new IndexOutOfBoundsException();
        }
        return indices.get(index).data;
    }

    // returns the object at the head
    public E getHead() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    // returns the object at the tail
    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    // returns the list size
    public int size() {
        return size;
    }

    // removes and returns the element at the head
    public E remove() {
        if (head == null) {
        	throw new IndexOutOfBoundsException();
        }
        Node<E> oldHead = head;
        if (size == 1) {
            head = null;
            tail = null;
            indices.clear();
        } else {
            head = oldHead.next;
            head.prev = null;
            indices.remove(0);
        }
        size--;
        return oldHead.data;
    }

    // removes and returns the element at the tail
    public E removeLast() {
        if (tail == null) {
        	throw new IndexOutOfBoundsException();
        }
        Node<E> oldTail = tail;
        if (size == 1) {
            head = null;
            tail = null;
            indices.clear();
        } else {
            tail = oldTail.prev;
            tail.next = null;
            indices.remove(size - 1);
        }
        size--;
        return oldTail.data;
    }

    // removes and returns the element at the index
    public E removeAt(int index) {
    	if (index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException();
    	} else if (size == 1) {
    		Node<E> currNode = head;
            head = null;
            tail = null;
            indices.clear();
            size--;
    		return currNode.data;
    	} else if (index == 0) {
    		Node<E> currNode = head;
    		head = currNode.next;
            head.prev = null;
    		indices.remove(index);
    		size--;
    		return currNode.data;
    	} else if (index == size - 1) {
    		Node<E> currNode = tail;
    		tail = currNode.prev;
            tail.next = null;
            indices.remove(index);
            size--;
            return currNode.data;
    	} else {
    		Node<E> currNode = indices.get(index);
    		currNode.prev.next = currNode.next;
    		currNode.next.prev = currNode.prev;
    		indices.remove(index);
    		size--;
    		return currNode.data;
    	}
    }
    
    // removes the first occurrence of elem in the list and returns true.
    // return false if elem was not in the list.
    public boolean remove(E elem) {
    	Node<E> currNode = head;
    	if (head == null) {
    		throw new IndexOutOfBoundsException();
    	}
    	for (int i = 0; i < size; i++) {
    		if (currNode.data == elem) {
    			if (size == 1) {
    	            head = null;
    	            tail = null;
    	            indices.clear();
    			} else if (i == 0) {
    				head = currNode.next;
    	            head.prev = null;
    	            indices.remove(0);
    			} else if (i == size - 1) {
    				tail = currNode.prev;
    	            tail.next = null;
    	            indices.remove(size - 1);
    			} else {
    				currNode.prev.next = currNode.next;
    				currNode.next.prev = currNode.prev;
    				indices.remove(i);
    			}
    			size--;
    			return true;
    		} else {
    			currNode = currNode.next;
    		}
    	}
    	return false;
    }
    
    // presents a string representation of the list
    public String toString() {
    	Node<E> currNode = head;
    	String strPresent = "";
    	while (currNode != null) {
    		strPresent += currNode.data;
    		if (currNode.next != null) {
    			strPresent += " -> ";
    		}
    		currNode = currNode.next;
    	}
    	return strPresent.toString();
    }
}