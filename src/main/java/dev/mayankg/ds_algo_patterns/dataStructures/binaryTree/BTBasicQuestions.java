package dev.mayankg.ds_algo_patterns.dataStructures.binaryTree;

import dev.mayankg.dataStructures.util.Pair;

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
        printSumOfNodesAtKthLevelInBT(bt1, 3);
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
        // System.out.println("Diameter of the BT: " + binaryTree.diameterOfBT(binaryTree.getRoot()));
        System.out.println("Diameter of the BT: " + binaryTree.diameterOfBT_optimized(binaryTree.getRoot()));
    }

    /**
     * Question 10: Are both identical binary trees
     */
    static void printWhetherBothBTsAreIdentical(BinaryTree binaryTree, BinaryTree subBinaryTree) {
        if (binaryTree.isSameBTree(binaryTree.getRoot(), subBinaryTree.getRoot()))
            System.out.println("Both are identical BinaryTrees");
        System.out.println("They are not identical BinaryTrees");
    }

    /**
     * Question 11: Sub binary tree of another binary tree
     */
    static void printWhetherBtIsSubBTreeOfAnotherBt(BinaryTree binaryTree, BinaryTree subBinaryTree) {
        if (binaryTree.isSubBTree(binaryTree.getRoot(), subBinaryTree.getRoot()))
            System.out.println("It is a SubBinaryTree of the BinaryTree");
        System.out.println("It isn't a SubBinaryTree of the BinaryTree");
    }

    /**
     * Question 12: Sum of Nodes at Kth Level of binary tree
     */
    static void printSumOfNodesAtKthLevelInBT(BinaryTree binaryTree, int k) {
        System.out.println("Sum of Nodes @ " + k + "th level of BinaryTree: " +
                binaryTree.sumOfNodesAtKthLevel_BFS(binaryTree.getRoot(), k));
        System.out.println("Sum of Nodes @ " + k + "th level of BinaryTree: " +
                binaryTree.sumOfNodesAtKthLevel_DFS(binaryTree.getRoot(), k));
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

        //root --> main BT and subRoot --> smaller BT
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
            if (root == null) return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size(); // Number of nodes at the current level
                for (int i = 0; i < levelSize; i++) {
                    Node currNode = queue.poll();
                    ans.add(currNode.data);
                    if (currNode.left != null) queue.add(currNode.left);
                    if (currNode.right != null) queue.add(currNode.right);
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

        // depth or height of the BT

        int depthOfBT(Node root) {
            if (root == null) return 0;

            return 1 + Math.max(depthOfBT(root.left), depthOfBT(root.right));
        }
        // O(n*n) approach

        int diameterOfBT(Node root) {
            if (root == null) return 0;

            // find the max of 3 cases: leftDia, rightDia, and currentDia //currentDia=(1 + leftHt + rightHt)
            int maxDiaOfSubTree = Math.max(diameterOfBT(root.left), diameterOfBT(root.right));
            return Math.max(maxDiaOfSubTree, 1 + depthOfBT(root.left) + depthOfBT(root.right));
        }
        // O(n) approach
        // Note: Height of root will be the max height of all the nodes, but the Diameter of root node may or may not be the maximum

        int diameterOfBT_optimized(Node root) {
            return heightAndDiameter(root).get_2(); //diameter
        }

        /**
         * Calculating height and diameter at the same time
         */
        private Pair<Integer, Integer> heightAndDiameter(Node root) {
            if (root == null) return new Pair<>(0, 0);

            Pair<Integer, Integer> left_HnD = heightAndDiameter(root.left);
            Pair<Integer, Integer> right_HnD = heightAndDiameter(root.right);

            int curr_H = 1 + Math.max(left_HnD.get_1(), right_HnD.get_1());
            int curr_D = 1 + left_HnD.get_1() + right_HnD.get_1();

            //Height of BT: curr_H (of root), Diameter of BT: Max of leftDia, rightDia or currDia
            return new Pair<>(
                    curr_H,
                    Math.max(curr_D, Math.max(left_HnD.get_2(), right_HnD.get_2()))
            );
        }

        boolean isSameBTree(Node rt, Node sRt) {
            if (rt == null && sRt == null) return true;
            if (rt == null || sRt == null) return false;

            return (rt.data == sRt.data) && isSameBTree(rt.left, sRt.left) && isSameBTree(rt.right, sRt.right);
        }

        boolean isSubBTree(Node root, Node subRoot) {
            if (subRoot == null) return true;   //null is always a subBTree of a BT
            if (root == null) return false;
            if (isSameBTree(root, subRoot)) return true;

            return isSubBTree(root.left, subRoot) || isSubBTree(root.right, subRoot);
        }

        int sumOfNodesAtKthLevel_BFS(Node root, int k) {
            if (root == null) return 0;

            int sum = 0, level = 0;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty() && level <= k) {
                level++;
                int levelSize = queue.size(); // Number of nodes at the current level
                for (int i = 0; i < levelSize; i++) {
                    Node node = queue.poll();
                    if (level == k) sum += node.data;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            return sum;
        }

        int sumOfNodesAtKthLevel_DFS(Node root, int k) {
            return sumAtKthLevel_helper(root, k, 1);
        }

        private int sumAtKthLevel_helper(Node node, int k, int level) {
            if (node == null) return 0;
            if (level == k) return node.data;
            return sumAtKthLevel_helper(node.left, k, level + 1)
                    + sumAtKthLevel_helper(node.right, k, level + 1);
        }
    }
}