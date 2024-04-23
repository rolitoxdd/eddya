public class Ex1 {
  static class LinkedList {
    static class Node {
      int data;
      Node next;
    }

    Node head;
  }

  static LinkedList.Node iterativeReverse(LinkedList.Node originalHead) {
    LinkedList.Node prev = null;
    LinkedList.Node current = originalHead;
    LinkedList.Node next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  static LinkedList.Node recursiveReverse(LinkedList.Node llist) {
    if (llist == null || llist.next == null) {
      return llist;
    }

    LinkedList.Node newHead = recursiveReverse(llist.next);
    llist.next.next = llist;
    llist.next = null;
    return newHead;
  }

  public static void main(String[] args) {

    LinkedList list = new LinkedList();
    list.head = new LinkedList.Node();
    list.head.data = 1;
    list.head.next = new LinkedList.Node();
    list.head.next.data = 2;
    list.head.next.next = new LinkedList.Node();
    list.head.next.next.data = 3;
    list.head.next.next.next = new LinkedList.Node();
    list.head.next.next.next.data = 4;
    list.head.next.next.next.next = new LinkedList.Node();
    list.head.next.next.next.next.data = 5;

    LinkedList.Node current = list.head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }

    System.out.println();

    // LinkedList.Node l = iterativeReverse(list.head);
    // LinkedList.Node l = recursiveReverse(list.head);

    // current = l;
    // while (current != null) {
    // System.out.print(current.data + " ");
    // current = current.next;
    // }

  }

}
