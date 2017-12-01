/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example
    Given 1->4->3->2->5->2->null and x = 3,
    return 1->2->2->4->3->5->null.
*/

/*
Thought process:
    Create two lists, one storing every node whose value is less than x, the other storing those whose value is greater than or equals to x.
    Two dummy heads and two running pointers will be needed because:
        1) The head of the first list will be returned as the result.
        2) The head of the second list will be appended to the tail of the first list.
    Don't forget to set the second list's tail to null for the proper ending of the linked list.
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smallDummyhead = new ListNode(-1);
        ListNode smallRunner = smallDummyhead;
        ListNode largeDummyhead = new ListNode(-1);
        ListNode largeRunner = largeDummyhead;
        ListNode runner = head;
        while (runner != null) {
            if (runner.val < x) {
                smallRunner.next = runner;
                smallRunner = smallRunner.next;
            } else {
                largeRunner.next = runner;
                largeRunner = largeRunner.next;
            }
            runner = runner.next;
        }
        // end the list with null or it will cause MLE
        largeRunner.next = null;
        smallRunner.next = largeDummyhead.next;
        return smallDummyhead.next;
    }
}
