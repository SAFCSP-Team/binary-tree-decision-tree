
class Employee {

    int id;
    String name;
    String role;

    Employee(int id, String name, String role){
        this.id = id;
        this.name = name;
        this.role = role;
    }
  
}

// Node creation
 class Node {
  Employee data;
  Node left;
  Node right;

  public Node(Employee e) {
  data = e;
  left = null;
  right = null;
  }

}

 public class BinaryTree {
  Node root;

  BinaryTree(Employee e) {
  root = new Node(e);
  }

  BinaryTree() {
  root = null;
  }

  // Traverse Inorder
  public void traverseInOrder(Node node) {
    if (node != null) {
      traverseInOrder(node.left);
      System.out.println(" id: " + node.data.id+ " name: " + node.data.name + " Role: " + node.data.role) ;
      traverseInOrder(node.right);
    }
    }
  
    // Traverse Postorder
    public void traversePostOrder(Node node) {
    if (node != null) {
      traversePostOrder(node.left);
      traversePostOrder(node.right);
      System.out.println(" id: " + node.data.id+ " name: " + node.data.name + " Role: " + node.data.role) ;
    }
    }
  
    // Traverse Preorder
    public void traversePreOrder(Node node) {

    // ** 1- add your code here ** //

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
      
        Employee e = new Employee(01,"Ahmed","CEO");
    // ** 2- add your code here ** //

    // ** 3- add your code here ** //
        tree.root.left = new Node(e1);
        tree.root.right = new Node(e2);
        tree.root.left.left = new Node(e3);
      
        System.out.println("Pre order Traversal: ");
        tree.traversePreOrder(tree.root);
        System.out.println("\nIn order Traversal: ");
        tree.traverseInOrder(tree.root);
        System.out.println("\nPost order Traversal: ");
        tree.traversePostOrder(tree.root);
        }


}


