import java.util.NoSuchElementException;

public class SinglyLinkedList {
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

    // Method to add element to the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to add element to the end of the list
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

    // Method to remove element from the beginning of the list
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
    }

    // Method to remove element from the end of the list
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

        while (current != null) {
            index = current.next;
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

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(3);
        list.addFirst(1);   
        list.addLast(5);
        list.addLast(2);
        list.addLast(4);

        System.out.println("Original list:");
        list.displayList();

        list.bubbleSort();

        System.out.println("Sorted list:");
        list.displayList();

        System.out.println("Cleared list:");
        try {
            list.removeFirst();
            list.removeFirst();
            list.removeFirst();
            list.removeFirst();
            list.removeFirst();
            list.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}