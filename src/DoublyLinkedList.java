/**
 * DoublyLinkedList represents a doubly linked list data structure that allows
 * adding and removing elements from both ends efficiently.
 * 
 * This implementation provides methods for adding elements to the beginning and
 * end of the list, removing elements from the beginning and end of the list,
 * checking if the list is empty, getting the length of the list, and displaying
 * the list.
 * 
 * @author Joseph Kabesha
 * @author Isaiah Ayres
 */
import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head; // Reference to the first node of the list
    private Node tail; // Reference to the last node of the list
    private int size; // Size of the list

    // Node class representing individual elements in the list
    private static class Node {
        int data; // Data stored in the node
        Node prev; // Reference to the previous node
        Node next; // Reference to the next node

        // Constructor to create a new node with the given data
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Method to add an element to the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to add an element to the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Method to remove the first element from the list
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    // Method to remove the last element from the list
    public void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    // Method to display the elements of the list
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to get the length of the list
    public int getLength() {
        return size;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("List is empty: " + list.isEmpty());
        
        list.addFirst(3);
        list.addFirst(1);
        list.addLast(5);
        list.addLast(2);
        list.addLast(4);

        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Original list:");
            list.displayList();

            System.out.println("Original list length:");
            System.out.println(list.getLength());

            // Adding an element from the end
            list.addLast(6);
            System.out.println("List after adding an element from the end:");
            list.displayList();

            // Adding an element from the beginning
            list.addFirst(7);
            System.out.println("List after adding an element from the beginning:");
            list.displayList();
            
            // Removing an element from the end
            list.removeLast();
            System.out.println("List after removing an element from the end:");
            list.displayList();

            // Removing an element from the beginning
            list.removeFirst();
            System.out.println("List after removing an element from the beginning:");
            list.displayList();
        }
    }
}
