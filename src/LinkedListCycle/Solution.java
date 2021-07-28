package LinkedListCycle;

// Link to Problem: https://leetcode.com/problems/linked-list-cycle/
// Time Complexity: O(n)
// Walker traverses the nodes one node at a time. Runner traverses the nodes two nodes at a time.
// At any point in time, if the end if reached (null), the program terminates and returns false, since there is no cycle.
// If Runner == Walker, this implies that runner "caught up" with walker, and thus there is a cycle.
public class Solution {

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode walker;

        if (head.next == null) {
            return false;
        } else {
            walker = head.next;
        }
        ListNode runner;

        if (head.next.next == null) {
            return false;
        } else {
            runner = head.next.next;
        }

        while (walker != null || runner != null) {
            if (walker == runner) {
                return true;
            }

            if (walker.next != null) {
                walker = walker.next;
            } else {
                return false;
            }



            if (runner.next != null) {
                if (runner.next.next != null) {
                    runner = runner.next.next;

                } else {
                    return false;
                }


            } else {
                return false;
            }

        }

        return false;

    }
}
