/**
 * This class implements a circular singly linked list where the last node points back to the head.
 * It provides basic operations such as add, remove, display, and search within the list.
 * 
 * @author Joseph Kabesha 
 * @author Isaiah Ayres
 
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularList {
    private Node head;

    /**
     * The Node class represents a single node in the circular list.
     */
    private static class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node in the list

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Adds a new element to the circular list.
     * @param data The data to be added to the list.
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Points back to itself to form a circle
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    /**
     * Removes an element from the circular list.
     * @param data The data to be removed from the list.
     * @throws NoSuchElementException if the list is empty or element is not found.
     */
    public void remove(int data) {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (head.data == data) {
            if (head.next == head) {
                head = null;
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
            return;
        }
        Node current = head;
        Node prev = null;
        do {
            prev = current;
            current = current.next;
            if (current.data == data) {
                prev.next = current.next;
                return;
            }
        } while (current != head);
        throw new NoSuchElementException("Element not found");
    }

    /**
     * Displays all elements in the circular list.
     */
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Method to search for an item in the list
    public boolean search(int data) {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    public static void main(String[] args) {
        CircularList list = new CircularList();
        Scanner scanner = new Scanner(System.in);

        // Add some elements to the list
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(9);
        list.add(10);
        list.add(7);
        list.add(8);
        list.add(11);

        System.out.println("Original list:");
        list.displayList();
        list.remove(3);
        list.displayList();
        System.out.println("Item found: " + list.search(3));


        // Ask user for item to search
        System.out.print("Enter item to search: ");
        int itemToSearch = scanner.nextInt();

    
        // Search for the item
        System.out.println("Item " + itemToSearch + " found: " + list.search(itemToSearch));

        // Close scanner
        scanner.close();
    }
}