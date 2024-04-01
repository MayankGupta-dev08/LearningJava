package dev.mayankg.dataStructures.binaryTree;

import java.util.ArrayList;

class BTBasicQuestions {
    public static void main(String[] args) {
        int[] preorderArr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // creating a binary tree
        BinaryTree bt1 = buildTreeUsingPreorder(preorderArr);

        //Checking the preorder traversal of the BT formed.
        printPreOrderTraversalOfBT(bt1);

        //Checking the inorder traversal of the BT formed.
        printInOrderTraversalOfBT(bt1);

        //Checking the postorder traversal of the BT formed.
        printPostOrderTraversalOfBT(bt1);
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
    }
}