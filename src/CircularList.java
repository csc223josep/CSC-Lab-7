import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularList {
    private Node head;

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add element to the list
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

    // Method to remove element from the list
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

    // Method to display the list
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

        System.out.println("Original list:");
        list.displayList();

        // Ask user for item to search
        System.out.print("Enter item to search: ");
        int itemToSearch = scanner.nextInt();

        // Search for the item
        System.out.println("Item " + itemToSearch + " found: " + list.search(itemToSearch));

        // Close scanner
        scanner.close();
    }
}