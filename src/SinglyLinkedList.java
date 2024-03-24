import java.util.NoSuchElementException;

/**
 * A class representing a singly linked list with methods to add, remove, and sort elements.
 *
 * @author Joseph Kabesha
 * @author Isaiah Ayres
 */
public class SinglyLinkedList {
    // Reference to the head of the list
    private Node head;

    // A nested class to define the Node structure
    private static class Node {
        int data;
        Node next;

        // Constructor to create a new Node with the given data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add an element to the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to add an element to the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to remove an element from the beginning of the list
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
    }

    // Method to remove an element from the end of the list
    public void removeLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Method to display the list
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to sort the list using bubble sort
    public void bubbleSort() {
        Node current = head;
        Node index = null;
        int temp;

        // Traverse the list and compare adjacent elements
        while (current != null) {
            index = current.next;

            // Compare adjacent elements and swap them if needed
            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // Main method to demonstrate the functionality of the SinglyLinkedList class
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("attempt to remove from a empty list");
        try {
            list.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        list.addFirst(3);
        list.addFirst(1);
        list.addLast(5);
        list.addLast(2);
        list.addLast(4);

        // Display the original list
        System.out.println("Original list:");
        list.displayList();

        // Sort the list
        list.bubbleSort();

        // Display the sorted list
        System.out.println("Sorted list:");
        list.displayList();
    }
}