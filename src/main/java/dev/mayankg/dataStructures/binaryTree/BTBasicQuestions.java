package dev.mayankg.dataStructures.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BTBasicQuestions {
    public static void main(String[] args) {
        int[] preorderArr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // creating a binary tree
        BinaryTree bt1 = buildTreeUsingPreorder(preorderArr);
        printPreOrderTraversalOfBT(bt1);
        printInOrderTraversalOfBT(bt1);
        printPostOrderTraversalOfBT(bt1);
        printLevelOrderTraversalOfBT(bt1);
        printNumberOfNodesInBT(bt1);
        printSumOfNodesInBT(bt1);
        printDepthOfBT(bt1);
        printDiameterOfBT(bt1);
    }

    /**
     * Question 1: Build a binary tree using an array which is in preorder form
     */
    static BinaryTree buildTreeUsingPreorder(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        return new BinaryTree(arr);
    }

    /**
     * Question 2: Print preorder traversal for a binary tree
     */
    static void printPreOrderTraversalOfBT(BinaryTree binaryTree) {
        ArrayList preOrderAns = new ArrayList();
        binaryTree.preOrderTraversal(binaryTree.getRoot(), preOrderAns);
        System.out.println("PreOrder Traversal: " + preOrderAns);
    }

    /**
     * Question 3: Print inorder traversal for a binary tree
     */
    static void printInOrderTraversalOfBT(BinaryTree binaryTree) {
        ArrayList inOrderAns = new ArrayList();
        binaryTree.inOrderTraversal(binaryTree.getRoot(), inOrderAns);
        System.out.println("InOrder Traversal: " + inOrderAns);
    }

    /**
     * Question 4: Print postorder traversal for a binary tree
     */
    static void printPostOrderTraversalOfBT(BinaryTree binaryTree) {
        ArrayList postOrderAns = new ArrayList();
        binaryTree.postOrderTraversal(binaryTree.getRoot(), postOrderAns);
        System.out.println("PostOrder Traversal: " + postOrderAns);
    }

    /**
     * Question 5: Print levelorder traversal for a binary tree
     */
    static void printLevelOrderTraversalOfBT(BinaryTree binaryTree) {
        ArrayList levelOrderAns = new ArrayList();
        binaryTree.levelOrderTraversal(binaryTree.getRoot(), levelOrderAns);
        System.out.println("LevelOrder Traversal: " + levelOrderAns);
    }

    /**
     * Question 6: Print the number of the nodes in the binary tree
     */
    static void printNumberOfNodesInBT(BinaryTree binaryTree) {
        System.out.println("Number of Nodes in the BT: " + binaryTree.countNodes(binaryTree.getRoot()));
    }

    /**
     * Question 7: Print the sum of the nodes in the binary tree
     */
    static void printSumOfNodesInBT(BinaryTree binaryTree) {
        System.out.println("Sum of all the nodes in the BT: " + binaryTree.sumOfNodes(binaryTree.getRoot()));
    }

    /**
     * Question 8: Print the depth of the binary tree
     */
    static void printDepthOfBT(BinaryTree binaryTree) {
        System.out.println("Depth of the BT: " + binaryTree.depthOfBT(binaryTree.getRoot()));
    }

    /**
     * Question 9: Print the diameter of the binary tree
     */
    static void printDiameterOfBT(BinaryTree binaryTree) {
        System.out.println("Diameter of the BT: " + binaryTree.diameterOfBT(binaryTree.getRoot()));
    }

    /**
     * Node class
     */
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Binary Tree class
     */
    static class BinaryTree {
        private static int idxPtr = -1;
        private Node root;

        BinaryTree(int[] arr) {
            this.root = buildBinaryTree(arr);
        }

        Node getRoot() {
            return root;
        }

        private Node buildBinaryTree(int[] arr) {
            ++idxPtr;
            if (arr[idxPtr] == -1) return null;

            Node newNode = new Node(arr[idxPtr]);
            newNode.left = buildBinaryTree(arr);
            newNode.right = buildBinaryTree(arr);
            return newNode;
        }

        void preOrderTraversal(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;

            ans.add(root.data);
            preOrderTraversal(root.left, ans);
            preOrderTraversal(root.right, ans);
        }

        void inOrderTraversal(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;

            inOrderTraversal(root.left, ans);
            ans.add(root.data);
            inOrderTraversal(root.right, ans);
        }

        void postOrderTraversal(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;

            postOrderTraversal(root.left, ans);
            postOrderTraversal(root.right, ans);
            ans.add(root.data);
        }

        void levelOrderTraversal(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node currNode = queue.poll();
                if (currNode != null) {
                    ans.add(currNode.data);
                    if (currNode.left != null) queue.add(currNode.left);
                    if (currNode.right != null) queue.add(currNode.right);
                } else if (currNode == null && !queue.isEmpty()) {
                    queue.add(null); //at level end
                }
            }
        }

        int countNodes(Node root) {
            if (root == null) return 0;

            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        int sumOfNodes(Node root) {
            if (root == null) return 0;

            return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
        }

        int depthOfBT(Node root) {
            if (root == null) return 0;

            return 1 + Math.max(depthOfBT(root.left), depthOfBT(root.right));
        }

        int diameterOfBT(Node root) {
            if (root == null) return 0;

            int maxDiaOfSubTree = Math.max(diameterOfBT(root.left), diameterOfBT(root.right));
            return Math.max(maxDiaOfSubTree, 1 + depthOfBT(root.left) + depthOfBT(root.right));
        }
    }
}