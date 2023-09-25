import java.util.*;

public class BinaryTreeTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null; // Because here the first root node itself is -1 means null ( no tree is here )
                             // // so return null
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {

        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    // add the nu.ll back
                    q.add(null);
                }
            } else {
                System.out.print((currNode.data + " "));
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }

    public static int countOfNodes(Node root) {
        if (root == null)
            return 0;

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodeSum = sumOfNodes(root.left);
        int rightNodeSum = sumOfNodes(root.right);

        return leftNodeSum + rightNodeSum + root.data;
    }

    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int totalHeight = Math.max(leftHeight, rightHeight) + 1;

        return totalHeight;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diamLeft = diameter(root.left);
        int diamRight = diameter(root.right);
        int diamOfRoot = height(root.left) + height(root.right) + 1;

        return Math.max(Math.max(diamLeft, diamRight), diamOfRoot);
    }

    static class TreeInfo {
        int ht; // height
        int diam; // diameter

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int finalDiam = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(myHeight, finalDiam);
    }

    public boolean isSubtree(Node root, Node subroot) {
        if (subroot == null) { // because every leaf has null
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) {
            if (isIdential(root, subroot)) {
                return true;
            }
        } 
        return (isSubtree(root.left, subroot) || isSubtree(root.right, subroot));
    

    }

    public boolean isIdential(Node root, Node subRoot) {
        if (root == null && subRoot == null) {// both are leafs
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            return (isIdential(root.left, subRoot.left) && isIdential(root.right, subRoot.right));
        }

        return false;
    }

    public static void main(String arg[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Preorder : ");
        preorder(root);
        System.out.println();
        System.out.println("Inorder : ");
        inorder(root);
        System.out.println();
        System.out.println("Postorder : ");
        postorder(root);
        System.out.println();
        System.out.println("Level Order : ");
        levelOrder(root);
        System.out.println();
        System.out.println("Count of Nodes : " + countOfNodes(root));
        System.out.println("Sum of Nodes : " + sumOfNodes(root));
        System.out.println("Height of Nodes : " + height(root));
        System.out.println("Diameter of Nodes : " + diameter(root));
        System.out.println("Diameter of Nodes : " + diameter2(root).diam);

    }

}
