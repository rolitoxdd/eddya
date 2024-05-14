import java.util.LinkedList;

import org.w3c.dom.Node;

public class P2 {

  static class LinkedList {
    static class Node {
      int value;
      Node next;
    }

    Node head;
  }

  static LinkedList.Node addTwoLists(LinkedList.Node n1, LinkedList.Node n2) {
    LinkedList.Node dummyHead = new LinkedList.Node();
    LinkedList.Node current = dummyHead;
    int carry = 0;

    while (n1 != null || n2 != null) {
      int x, y;
      if (n1 == null)
        x = 0;
      else
        x = n1.value;
      if (n2 == null)
        y = 0;
      else
        y = n2.value;

      int sum = carry + x + y;
      carry = sum / 10;
      current.next = new LinkedList.Node();
      current.next.value = sum % 10;
      current = current.next;
      if (n1 != null)
        n1 = n1.next;
      if (n2 != null)
        n2 = n2.next;
    }

    if (carry > 0) {
      current.next = new LinkedList.Node();
      current.next.value = carry;
    }

    return dummyHead.next;
  }

  public static void main(String[] args) {

    LinkedList list1 = new LinkedList();
    list1.head = new LinkedList.Node();
    list1.head.value = 8;
    list1.head.next = new LinkedList.Node();
    list1.head.next.value = 3;
    list1.head.next.next = new LinkedList.Node();
    list1.head.next.next.value = 7;

    printList(list1.head);

    LinkedList list2 = new LinkedList();
    list2.head = new LinkedList.Node();
    list2.head.value = 3;
    list2.head.next = new LinkedList.Node();
    list2.head.next.value = 4;
    list2.head.next.next = new LinkedList.Node();
    list2.head.next.next.value = 3;

    printList(list2.head);

    LinkedList.Node result = addTwoLists(list1.head, list2.head);

    printList(result);
  }

  static void printList(LinkedList.Node n) {
    while (n != null) {
      System.out.print(n.value + "->");
      n = n.next;
    }
    System.out.println("null");
  }
}