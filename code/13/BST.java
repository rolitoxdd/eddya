class BST {
  class Node {
    int data;
    Node left, right;

    Node(int value) {
      data = value;
      left = right = null;
    }
  }

  Node root;

  BST() {
    root = null;
  }

  Node insert(Node root, int value) {
    if (root == null)
      return new Node(value);
    if (root.data < value)
      root.right = insert(root.right, value);
    else if (root.data > value)
      root.left = insert(root.left, value);
    return root;
  }

  Node search(Node root, int value) {
    if (root == null || root.data == value)
      return root;
    if (root.data < value)
      return search(root.right, value);
    else
      return search(root.left, value);
  }

  Node remove(Node root, int value) {
    if (root == null)
      return root;
    if (root.data < value)
      root.right = remove(root.right, value);
    else if (root.data > value)
      root.left = remove(root.left, value);
    else {
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;
      root.data = minValue(root.right);
      root.right = remove(root.right, root.data);
    }
    return root;
  }

  int minValue(Node root) {
    int min = root.data;
    while (root.left != null) {
      min = root.left.data;
      root = root.left;
    }
    return min;
  }

  void printTree() {
    printTree(root, "", false);
  }

  void printTree(Node subtreeRoot, String indent, boolean isRight) {
    if (subtreeRoot.right != null) {
      printTree(subtreeRoot.right, indent + (isRight ? "        " : " |      "), true);
    }
    System.out.print(indent);
    if (isRight) {
      System.out.print(" /");
    } else {
      System.out.print(" \\");
    }
    System.out.print("----- ");
    System.out.println(subtreeRoot.data);
    if (subtreeRoot.left != null) {
      printTree(subtreeRoot.left, indent + (isRight ? " |      " : "        "), false);
    }
  }

  public static void main(String[] args) {

    BST tree = new BST();
    tree.root = tree.insert(tree.root, 10);
    tree.root = tree.insert(tree.root, 5);
    tree.root = tree.insert(tree.root, 15);
    tree.root = tree.insert(tree.root, 7);
    tree.root = tree.insert(tree.root, 12);
    tree.root = tree.insert(tree.root, 3);
    tree.root = tree.insert(tree.root, 17);

    tree.printTree();

  }

}