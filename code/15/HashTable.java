import java.util.LinkedList;

/**
 * HashTable
 */
public class HashTable {
  private static final int SIZE = 1783;
  private LinkedList<Node>[] table = new LinkedList[SIZE];

  private class Node {
    String key;
    String value;

    public Node(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    HashTable hashTable = new HashTable();
    hashTable.put("name", "John Doe");
    hashTable.put("age", "25");
    hashTable.put("city", "New York");

    System.out.println(hashTable.get("name"));
    System.out.println(hashTable.get("age"));
    System.out.println(hashTable.get("city"));

    hashTable.remove("age");
    System.out.println(hashTable.get("age"));
  }

  private int hash(String key) {
    // Division method
    int hash = 0;
    for (int i = 0; i < key.length(); i++) {
      hash = (256 * hash + key.charAt(i)) % SIZE;
    }
    return hash;
  }

  public void put(String key, String value) {
    int index = hash(key);
    if (table[index] == null) {
      table[index] = new LinkedList<>();
    }
    table[index].add(new Node(key, value));
  }

  public String get(String key) {
    int index = hash(key);
    if (table[index] == null) {
      return null;
    }
    for (Node node : table[index]) {
      if (node.key.equals(key)) {
        return node.value;
      }
    }
    return null;
  }

  public void remove(String key) {
    int index = hash(key);
    if (table[index] == null) {
      return;
    }
    for (Node node : table[index]) {
      if (node.key.equals(key)) {
        table[index].remove(node);
        return;
      }
    }
  }

}