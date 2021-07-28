package MergeKLists;

import java.util.PriorityQueue;

/**
 * Link to Problem: https://leetcode.com/problems/merge-k-sorted-lists/
 * Time complexity: O(n log(n))
 */
class Solution {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val > b.val ? 1 : -1);
        // Add the nodes in lists into pq.
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                pq.add(lists[i]);

            }
        }
        ListNode result = null;
        ListNode temp = null;
        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            if (result == null) {
                result = current;
                temp = result;
            } else {
                temp.next = current;
                temp = current;
            }

            if (current.next != null) {
                pq.add(current.next);
            }
        }

        return result;



    }
}