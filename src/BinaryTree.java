
import java.util.Stack;

class Node {

  String fileName;

  Node left;
  Node right;

  public Node(String fileName) {

    this.fileName = fileName;
    this.left = null;
    this.right = null;

    }
}



class BinaryTree {

  Node root;

  public BinaryTree(Node root) {
    this.root = root;
  }


  // Pre-order traverse
  public void printTreeValues() {

    if (this.root == null) {
      System.out.println("Tree is empty");
      return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();

      System.out.println(" " + currentNode.fileName);

      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }

      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }

    }
    return;
  }

  public Node search(String target) {

    if (this.root == null) {
      System.out.println("Tree is empty");
      return null;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(this.root);

    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();

      if (currentNode.fileName == target) {
        return currentNode;
      }

      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }

      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }

    }
    return null;
  }

  public void addRight(String parentData, String newData) {

    Node newNode = new Node(newData);
    Node parent = search(parentData);

    if (parent != null) {

      if (parent.right == null) {
        parent.right = newNode;
        System.out.println(newNode.fileName + " added successfully");
      } else {
        System.out.println("parent already has a right child");
        return;
      }
    } else {
      System.out.println(parent + " parent not fount");
    }

  }

  public void addLeft(String parentData, String newData) {

    Node newNode = new Node(newData);
    Node parent = search(parentData);

    if (parent != null) {

      if (parent.left == null) {
        parent.left = newNode;
        System.out.println(newNode.fileName + " added successfully");
      } else {
        System.out.println("parent already has a left child");
        return;
      }
    } else {
      System.out.println(parentData + " parent not fount");
    }

  }

  public static void main(String[] args) {

    BinaryTree tree = new BinaryTree(new Node("This Computer"));

    tree.addLeft("This Computer", "Local disk C:");
    tree.addRight("This Computer", "Disk D:");

    tree.addLeft("Local disk C:","Programs" );
    tree.addRight("Local disk C:","Windows" );

    System.out.println("Print tree values: ");
    tree.printTreeValues();

  }

}