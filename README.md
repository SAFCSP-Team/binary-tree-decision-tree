# Binary tree - Decision tree

### Objective
In this project, our objective is to understand how to build the decesion tree, how to define the decesion based on specific questions.

### Problem
Create a decision tree to decide whether to accept the job offer or not.

- Ahmed received a job offer and he has some questions to be asked before he can decide to accept the offer or not:   
Is the salary above 10,000 SAR?   
Is the office near my hosue?   
Is the work enivironment convenient?   

If the above questions answered with a 'yes' Ahmed will accept the offer otherwise he will rejects the offer.

- Decision tree for the above questions should be the same as below (Figuer 1):

Figuer 1    
<img width="910" alt="Introduction to Arrays-01" src="https://github.com/SAFCSP-Team/data-structures-and-algorithms-bootcamp/blob/main/data-structures-and-algorithms-101/02-data-structures/05-tree/images/Decision-Tree-Project.jpg">



### Implementation
Using Java programming language: 

- `Node` class is already implemented and added to the DecesionTree java file as the below:
```java
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

```


- `DecesionTree` class is already implemented and added to the DecesionTree java file as the below:

```java
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

```  
  
In `main` function perform the following actions:

1 - Create a DecisionTree object with the name (decisionTree) and (decisionTree) should hold the root question.   
2 - Add the rest of the questions to complete the tree.     
3 - Run the code and try it.

```java

public static void main(String[] args) {

        /* Add your code here */

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
```
