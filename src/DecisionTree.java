import java.util.Scanner;
import java.util.Stack;

class Node {

    String question;

    Node right;
    Node left;

    public Node(String question) {
        this.question = question;
        this.right = null;
        this.left = null;
    }
}

public class DecisionTree {

    Node root;

    public DecisionTree(Node root) {
        this.root = root;
    }

    public void addRight(String parentQu, String newNodeData) {

        Node newNode = new Node(newNodeData);
        Node parent = search(parentQu);

        if (parent != null) {

            if (parent.right == null) {
                parent.right = newNode;
                System.out.println(newNodeData + " added successfully");
            } else {
                System.out.println("parent already has a right child");
                return;
            }
        } else {
            System.out.println(parentQu + " parent not fount");
        }

    }

    public void addLeft(String parentQu, String newNodeData) {
        Node newNode = new Node(newNodeData);
        Node parent = search(parentQu);

        if (parent != null) {

            if (parent.left == null) {
                parent.left = newNode;
                System.out.println(newNodeData + " added successfully");
            } else {
                System.out.println("parent already has a right child");
                return;
            }
        } else {
            System.out.println(parentQu + " parent not fount");
        }

    }

    public Node search(String target) {

        if (root == null) {
            System.out.println("Tree is empty");
            return null;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            if (currentNode.question == target) {
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

    public static void main(String[] args) {

        DecisionTree decisionTree = new DecisionTree(new Node("is the salary above 10k sar?"));
        decisionTree.addRight("is the salary above 10k sar?", "is the office near my house?");
        decisionTree.addRight("is the office near my house?", "is the work enviroment convinient?");

        System.out.println("---------------------------------------------");

        Node currentNode = decisionTree.root;
        System.out.println(decisionTree.root.question);
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        Boolean acceptOffer = true;

        while (currentNode.right != null) {


            if ("yes".equalsIgnoreCase(userInput)) {

                currentNode = currentNode.right;
                System.out.println(currentNode.question);
                userInput = scanner.nextLine();
                acceptOffer = true;

            } else if ("no".equalsIgnoreCase(userInput)) {

                acceptOffer = false;
                break;


            } else {

                System.out.println("Invalid input. Please answer with yes or no.");

            }

        }
        scanner.close();

        if(acceptOffer){
            System.out.println("Accept the offer");
        }else {
            System.out.println("Reject the offer");
        }

    }

}
