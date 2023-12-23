package LinkedList;

class Node {
    String data;
    Node next;

    /**
     * Constructor of node class
     *
     * @param data data of the node. Must be of string type
     */
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    SinglyLinkedList() {
        head = null;
    }

    SinglyLinkedList(String data) {
        head = new Node(data);
    }

    /**
     * Returns the number of elemnts in the list.
     * Traverses from the head to the end of the list.
     * @return the number of nodes in the list.
     */
    protected int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     *  Checks if the linked list is empty or not.
     * @return {@code True} is the list is empty. {@code False} if the list is not empty.
     */
    protected Boolean isEmpty(){
        return (head == null);
    }
    /**
     * Prints the elements of the linked list on the console.
     * Each element is printed on the same line indicated by '->'.
     * Prints if the list is empty.
     */
    protected void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Adds a new node with the specified data to the end of the linked list.
     * <p>
     * If the linked list is empty, a new node is created with the given data,
     * and it becomes the head of the list.
     *
     * @param data The data to be added to the new node.
     */
    protected void addLast(String data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
    }

    /**
     * Adds a new node with the specified data to the beginning of the linked list.
     * <p>
     * If the linked list is empty, a new node is created with the given data,
     * and it becomes the head of the list.
     *
     * @param data The data to be added to the new node.
     */
    protected void addFirst(String data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyll = new SinglyLinkedList();
        singlyll.printList();
        singlyll.addLast("B");
        singlyll.addLast("C");
        singlyll.addLast("D");
        singlyll.printList();
        singlyll.addFirst("A");
        singlyll.printList();
        System.out.println("The no of elements in the list is " + singlyll.size());
    }
}
