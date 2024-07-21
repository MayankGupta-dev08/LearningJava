package dev.mayankg.ds_algo_patterns.dataStructures.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree implementation with level order list<br>
 * Let i be the parent node index, then left child index = 2i + 1, right child index = 2i + 2
 */
@SuppressWarnings({"unused"})
class BinaryTree<T> {
    private Node<T> root;
    private ArrayList<Node<T>> nodes;

    public BinaryTree() {
        this.root = null;
        this.nodes = new ArrayList<>();
    }

    // left_child_idx = 2i + 1, right_child_idx = 2i + 2
    // parent_idx = (left_child_idx - 1) / 2
    // Time complexity: O(1)
    public void add(T val) {
        Node<T> newNode = new Node<>(val);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> parent = nodes.get((nodes.size() - 1) / 2);
            if (parent.left == null) parent.left = newNode;
            else parent.right = newNode;
        }
        nodes.add(newNode);
    }

    // Replace the node to be removed with the last node and remove the last node
    // To maintain the complete binary tree property
    // Time complexity: O(n)
    public boolean remove(T val) {
        if (root == null) return false;

        // finding nodeToRemove and lastNode
        Node<T> nodeToRemove = null;
        Node<T> lastNode = nodes.get(nodes.size() - 1);
        for (Node<T> node : nodes) {
            if (node.val.equals(val)) {
                nodeToRemove = node;
                break;
            }
        }
        if (nodeToRemove == null) return false;

        // replace nodeToRemove with lastNode
        nodeToRemove.val = lastNode.val;

        // remove the last node by updating parent's left/right child to null
        Node<T> parent = nodes.get((nodes.size() - 2) / 2);
        if (parent.right != null && parent.right.equals(lastNode)) {
            parent.right = null;
        } else if (parent.left != null && parent.left.equals(lastNode)) {
            parent.left = null;
        }

        // remove the last node from the list
        nodes.remove(nodes.size() - 1);
        return true;
    }

    public boolean contains(T val) {
        for (Node<T> node : nodes) {
            if (node.val.equals(val)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return nodes.size();
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public void clear() {
        root = null;
        nodes.clear();
    }

    @Override
    public String toString() {
        return nodes.toString();
    }

    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();
            System.out.print(currentNode.val + " ");

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

    // For testing purposes
    Node<T> getRoot() {
        return root;
    }

    ArrayList<Node<T>> getNodes() {
        return nodes;
    }
}