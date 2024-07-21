package dev.mayankg.ds_algo_patterns.dataStructures.binaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
    }

    @Test
    void testAdd() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        assertEquals(3, tree.size());

        Node<Integer> root = tree.getRoot();
        assertNotNull(root);
        assertEquals(1, root.val);

        ArrayList<Node<Integer>> nodes = tree.getNodes();
        assertEquals(3, nodes.size());
        assertEquals(1, nodes.get(0).val);
        assertEquals(2, nodes.get(1).val);
        assertEquals(3, nodes.get(2).val);
    }

    @Test
    void testRemove() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);

        assertEquals(7, tree.size());
        tree.remove(3);
        assertEquals(6, tree.size());
        assertFalse(tree.contains(3));

        Node<Integer> root = tree.getRoot();
        assertNotNull(root);
        assertEquals(1, root.val);

        ArrayList<Node<Integer>> nodes = tree.getNodes();
        assertEquals(6, nodes.size());
        assertEquals(7, nodes.get(2).val);
    }

    @Test
    void testContains() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertFalse(tree.contains(4));
    }

    @Test
    void testSize() {
        assertEquals(0, tree.size());
        tree.add(1);
        tree.add(2);
        assertEquals(2, tree.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    void testClear() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertEquals(3, tree.size());
        tree.clear();
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }

    @Test
    void testLevelOrderTraversal() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);

        ArrayList<Integer> levelOrder = new ArrayList<>();
        levelOrderTraversal(node -> levelOrder.add(node.val));

        ArrayList<Integer> expectedOrder = new ArrayList<>();
        expectedOrder.add(1);
        expectedOrder.add(2);
        expectedOrder.add(3);
        expectedOrder.add(4);
        expectedOrder.add(5);
        expectedOrder.add(6);
        expectedOrder.add(7);

        assertEquals(expectedOrder, levelOrder);
    }

    @Test
    void testRemoveRoot() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        tree.remove(1);
        assertFalse(tree.contains(1));
        assertEquals(2, tree.size());
    }

    @Test
    void testRemoveLastNode() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        tree.remove(3);
        assertFalse(tree.contains(3));
        assertEquals(2, tree.size());
    }

    @Test
    void testRemoveNodeWithChildren() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        tree.remove(2);
        assertFalse(tree.contains(2));
        assertEquals(4, tree.size());
    }

    @Test
    void testSingleElement() {
        tree.add(1);
        assertEquals(1, tree.size());
        assertTrue(tree.contains(1));
        tree.remove(1);
        assertEquals(0, tree.size());
        assertFalse(tree.contains(1));
    }

    @Test
    void testMultipleAddRemove() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);

        tree.remove(2);
        assertEquals(3, tree.size());
        assertFalse(tree.contains(2));

        tree.add(5);
        assertEquals(4, tree.size());
        assertTrue(tree.contains(5));
    }

    // Custom level order traversal test with action interface
    @FunctionalInterface
    interface NodeAction<T> {
        void perform(Node<T> node);
    }

    void levelOrderTraversal(NodeAction<Integer> action) {
        if (tree.getRoot() == null) return;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(tree.getRoot());

        while (!queue.isEmpty()) {
            Node<Integer> currentNode = queue.poll();
            action.perform(currentNode);

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }
}