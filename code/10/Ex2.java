
public class Ex2 {
  static class LinkedList {
    static class Node {
      int data;
      Node next;
    }

    Node head;
  }

  static LinkedList.Node merge(LinkedList.Node headL1, LinkedList.Node headL2) {
    LinkedList.Node head = null;
    LinkedList.Node current = head;

    if (headL1.data < headL2.data) {
      head = headL1;
      headL1 = headL1.next;
    } else {
      head = headL2;
      headL2 = headL2.next;
    }

    current = head;

    while (headL1 != null && headL2 != null) {
      if (headL1.data < headL2.data) {
        current.next = headL1;
        headL1 = headL1.next;
      } else {
        current.next = headL2;
        headL2 = headL2.next;
      }
      current = current.next;
    }

    while (headL1 != null) {
      current.next = headL1;
      headL1 = headL1.next;
      current = current.next;
    }

    while (headL2 != null) {
      current.next = headL2;
      headL2 = headL2.next;
      current = current.next;
    }

    return head;
  }

  public static void main(String[] args) {

    LinkedList list1 = new LinkedList();
    list1.head = new LinkedList.Node();
    list1.head.data = 1;
    list1.head.next = new LinkedList.Node();
    list1.head.next.data = 3;
    list1.head.next.next = new LinkedList.Node();
    list1.head.next.next.data = 5;
    list1.head.next.next.next = new LinkedList.Node();
    list1.head.next.next.next.data = 7;
    list1.head.next.next.next.next = new LinkedList.Node();
    list1.head.next.next.next.next.data = 9;

    LinkedList list2 = new LinkedList();
    list2.head = new LinkedList.Node();
    list2.head.data = 2;
    list2.head.next = new LinkedList.Node();
    list2.head.next.data = 4;
    list2.head.next.next = new LinkedList.Node();
    list2.head.next.next.data = 6;
    list2.head.next.next.next = new LinkedList.Node();
    list2.head.next.next.next.data = 8;
    list2.head.next.next.next.next = new LinkedList.Node();
    list2.head.next.next.next.next.data = 10;

    LinkedList.Node current = list1.head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }

    System.out.println();

    current = list2.head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }

    System.out.println();

    LinkedList.Node l = merge(list1.head, list2.head);

    current = l;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }

    System.out.println();
  }
}
