package dev.mayankg.ds_algo_patterns.dataStructures.linkedList;

import dev.mayankg.dataStructures.linkedList.LinkedListImpl;

class LLMostFAQ {

    // O(n)
    // 3 pointers approach - without extra space!!
    static <T> void reverseLL_iterative(LinkedListImpl<T> ll) {
        if (ll == null || ll.head == null || ll.head.next == null) return;

        LinkedListImpl.Node<T> prevNode = ll.head;
        LinkedListImpl.Node<T> currNode = ll.head.next;
        while (currNode != null) {
            LinkedListImpl.Node<T> nextNode = currNode.next; //store ref of nextNode

            currNode.next = prevNode; //reverse link of currNode

            prevNode = currNode; //updating the prevNode & currNode
            currNode = nextNode;
        }
        ll.head.next = null; //head.next is still pointing to the 2nd node of the original list
        ll.head = prevNode; //updating the head
    }

    // assuming we will get the correct head for the reverse LL from the base case,
    // we will further do the work using the head at the current level and make the correct connection b/w newHead and currNode (head)
    static <T> LinkedListImpl.Node<T> reverseLL_recursive(LinkedListImpl.Node<T> head) {
        if (head == null || head.next == null) return head;

        LinkedListImpl.Node<T> newHead = reverseLL_recursive(head.next); //getting the newHead from the higher level in callStack
        head.next.next = head;  //reversing the connection b/w head of current level and head.next
        head.next = null;   //breaking the previous connection
        return newHead;
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     */
    // similar to three pointer approach but additionally 1 dummy pointer will be needed to update the head for the 1st iteration.
    static LinkedListImpl.Node<Integer> swapNodesInPair(LinkedListImpl.Node<Integer> head) {
        if (head == null || head.next == null) return head;

        LinkedListImpl.Node<Integer> dummyNode = new LinkedListImpl.Node<>(0, head);  //for maintaining the correct head

        LinkedListImpl.Node<Integer> prevNode = dummyNode;
        LinkedListImpl.Node<Integer> firstNode = head;  // firstNode and scndNode will be the pairs to be swapped
        while (firstNode != null && firstNode.next != null) {
            //saving the pointers
            LinkedListImpl.Node<Integer> scndNode = firstNode.next;
            LinkedListImpl.Node<Integer> nextNode = firstNode.next.next;

            //swapping them
            scndNode.next = firstNode;
            firstNode.next = nextNode;
            prevNode.next = scndNode;

            //updating the pointers
            prevNode = firstNode;
            firstNode = nextNode;   //because nextNode would be the correct new firstNode in next iteration
        }
        return dummyNode.next;
    }

    // Consider [1, 2, 3, 4, 5]. Now work for 1 and 2 and store 3's ref and apply recursion for 3,4 ...
    // https://leetcode.com/problems/swap-nodes-in-pairs/
    static LinkedListImpl.Node<Integer> swapNodesInPair_recursive(LinkedListImpl.Node<Integer> head) {
        if (head == null || head.next == null) return head;

        LinkedListImpl.Node<Integer> nextNode = head.next.next; //storing the nextNode for process (3)

        LinkedListImpl.Node<Integer> newHead = head.next;   //(2)
        newHead.next = head;    //reversing, (2)-->(1)
        head.next = nextNode;   //for now, connecting (1)-->(3)

        //Once the 2nd pair is fixed, this head will point to newHead of that pair, (1)-->(4)
        head.next = swapNodesInPair_recursive(nextNode);

        return newHead;
    }
}