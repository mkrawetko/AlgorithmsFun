package com.mkrawetko;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            ListNode nextNode = currentNode.next;
            while (nextNode != null && currentNode.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode;
            currentNode = nextNode;
        }

        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val + "->" + next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            if (val != listNode.val) return false;
            return next != null ? next.equals(listNode.next) : listNode.next == null;

        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

}
