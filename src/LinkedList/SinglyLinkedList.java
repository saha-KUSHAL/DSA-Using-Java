package LinkedList;

class Node<T> {
  T data;
  Node<T> next;

  /**
   * Constructor of node class
   *
   * @param data data of the node. Must be of string type
   */
  Node(T data) {
    this.data = data;
    this.next = null;
  }
}

public class SinglyLinkedList<T> {
  private Node<T> head;

  SinglyLinkedList() { head = null; }

  SinglyLinkedList(T data) { head = new Node<>(data); }

  /**
   * Returns the number of elements in the list.
   * Traverses from the head to the end of the list.
   * @return the number of nodes in the list.
   */
  protected int size() {
    Node<T> temp = head;
    int count = 0;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  /**
   *  Checks if the linked list is empty or not.
   * @return {@code True} is the list is empty. {@code False} if the list is not
   *     empty.
   */
  protected Boolean isEmpty() { return (head == null); }
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
    Node<T> temp = head;
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
  protected void addLast(T data) {
    if (head == null) {
      head = new Node<>(data);
      return;
    }
    Node<T> temp = head;
    while (temp.next != null)
      temp = temp.next;
    temp.next = new Node<>(data);
  }

  /**
   * Adds a new node with the specified data to the beginning of the linked
   * list. <p> If the linked list is empty, a new node is created with the given
   * data, and it becomes the head of the list.
   *
   * @param data The data to be added to the new node.
   */
  protected void addFirst(T data) {
    if (head == null) {
      head = new Node<>(data);
      return;
    }
    Node<T> temp = new Node<>(data);
    temp.next = head;
    head = temp;
  }
  /**
   * Inserts a new node with the specified data at the specified index in the
   * linked list.
   *
   * If the index is less than 0 or greater than the size of the linked list, an
   * IndexOutOfBoundsException is thrown. If the data is null, a
   * NullPointerException is thrown.
   *
   * @param index The index at which the new node should be inserted. Index
   *     Starts form 0.
   * @param data  The data to be added to the new node.
   * @throws IndexOutOfBoundsException If the index is less than 0 or greater
   *     than the size of the linked list.
   * @throws NullPointerException      If the data is null.
   */
  protected void add(int index, T data)
      throws IndexOutOfBoundsException, NullPointerException {
    if (index < 0)
      throw new IndexOutOfBoundsException("Index: " + index +
                                          " cannot be less than 0");
    if (index > size())
      throw new IndexOutOfBoundsException(
          "Index: " + index + " cannot be greater than size " + size());
    if (data == null)
      throw new NullPointerException("Data cannot be null.");

    if (index == 0)
      addFirst(data);
    else if (index == size())
      addLast(data);
    else {
      Node<T> temp = head;
      while (index > 1) {
        temp = temp.next;
        index--;
      }
      Node<T> newNode = new Node<>(data);
      newNode.next = temp.next;
      temp.next = newNode;
    }
  }

  /**
   * Modify the data of the node at specified index with specified data in
   * Linked List.
   *
   * If the Index is less than 0 , greater than or equal to size of the list,
   * then IndexOutOfBounds exception is thrown. If Data is null then
   * NullPointerException is thrown.
   *
   * @param index Index at which the data to be modified.
   * @param data The data to be modified with.
   * @throws IndexOutOfBoundsException If the index is less than 0, greater or
   *     equal to size of the linked list.
   * @throws NullPointerException      If the Data is null.
   */
  protected void set(int index, T data)
      throws IndexOutOfBoundsException, NullPointerException {
    if (index < 0)
      throw new IndexOutOfBoundsException("Index: " + index +
                                          " cannot be less than 0");
    if (index >= size())
      throw new IndexOutOfBoundsException(
          "Index: " + index + " cannot be greater than or equal to size " +
          size());
    if (data == null)
      throw new NullPointerException("Data cannot be null.");
    if (index == 0)
      head.data = data;
    else {
      Node<T> temp = head;
      while (index > 0) {
        temp = temp.next;
        index--;
      }
      temp.data = data;
    }
  }
  /**
   * Get the data of a node in specified index in the Linked List
   *
   * If the index is less than 0, greater than or equal to the size of the
   * Linked List then IndexOutOfBoundsException is thrown.
   * @param index the index of the data
   * @return the data at the index
   * @throws IndexOutOfBoundsException  If the index if less than 0, greater or
   *     equal to the size of the linked list
   */
  protected T get(int index) throws IndexOutOfBoundsException {
    if (index < 0)
      throw new IndexOutOfBoundsException("Index: " + index +
                                          " cannot be less than 0");
    if (index >= size())
      throw new IndexOutOfBoundsException(
          "Index: " + index + " cannot be greater or equal to the size " +
          size());
    if (index == 0)
      return head.data;
    Node<T> temp = head;
    while (index > 0) {
      temp = temp.next;
      index--;
    }
    return temp.data;
  }
  public static void main(String[] args) {
    SinglyLinkedList<String> singlyll = new SinglyLinkedList<>();
    singlyll.printList();
    singlyll.addLast("B");
    singlyll.addLast("C");
    singlyll.addLast("D");
    singlyll.printList();
    singlyll.addFirst("A");
    singlyll.printList();
    System.out.println("The no of elements in the list is " + singlyll.size());
    singlyll.add(1, "G");
    singlyll.printList();
    singlyll.add(0, "P");
    singlyll.printList();
    singlyll.set(5, "J");
    singlyll.printList();
    System.out.println("Element in index 4 is " + singlyll.get(4));
  }
}
