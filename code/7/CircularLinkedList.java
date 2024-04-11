class CircularLinkedList {
  Node head;
  Node tail;

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  public void insert(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      tail = newNode;
      newNode.next = head;
    } else {
      tail.next = newNode;
      tail = newNode;
      tail.next = head;
    }
  }

  public void delete(int index) {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    Node current = head;
    Node previous = head;
    int i = 0;
    do {
      if (index == 0) {
        head = head.next;
        tail.next = head;
        break;
      } else if (i == index) {
        previous.next = current.next;
        if (current == tail) {
          tail = previous;
        }
        break;
      }
      previous = current;
      current = current.next;
      i++;
    } while (current != head);
  }

  public void display() {
    Node current = head;
    if (head == null) {
      System.out.println("List is empty");
    } else {
      do {
        System.out.print(" " + current.data);
        current = current.next;
      } while (current != head);
      System.out.println();
    }
  }

}