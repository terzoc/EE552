package hw7;

// Simple Node class
class Node{
	int data;
	Node next;
	
//	Constructor
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class SinglyLinkedList {
//	Store head of list
	Node head;

//	Add list element
	public void add(int data) {
//		new node with user input data
		Node newNode = new Node(data);
		
//		Check if list is empty
		if(head == null) {
//			if list is empty, set the head to the new node
			head = newNode;
		}else{
//			if list isn't empty, traverse to end and append new node
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		
	}
	
	public void reverse() {
		Node last = null;
		Node current = head;
		Node next = null;
		while(current != null) {
			next = current.next; //store next node
			current.next = last; //Reverse current node pointer
			last = current; //Save last position
			current = next;
		}
		head = last;
	}
	
	public void display() {
		Node current = head;
//		Print till current node is null
		while(current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
//		Print the null at the end
		System.out.println("null");
	}

	public static void main(String[] args) {
		 	SinglyLinkedList list = new SinglyLinkedList();
	        list.add(1);
	        list.add(2);
	        list.add(3);
	        System.out.println("Original List:");
	        list.display();  // Expected Output: 1 2 3

	        list.reverse();
	        System.out.println("Reversed List:");
	        list.display();  // Expected Output: 3 2 1
	}

}
