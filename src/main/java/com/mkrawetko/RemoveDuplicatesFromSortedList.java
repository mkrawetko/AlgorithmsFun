package com.mkrawetko;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
