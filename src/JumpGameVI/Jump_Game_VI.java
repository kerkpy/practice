package JumpGameVI;

import java.util.ArrayDeque;
import java.util.Deque;


//Link to problem: https://leetcode.com/problems/jump-game-vi/
//Time complexity: O(n)
//Space complexity: O(n)

public class Jump_Game_VI {
    public int maxResult(int[] nums, int k) {

        //Store the index of the largest elements inside a deque. The index of the largest element will be at the front.
        //The larger INDEX will be stored at the back of the deque.
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);


        //For any given i, the max score that one can get jumping to nums[i] is equivalent to
        //max(nums[i-k], nums[i-k+1],....,nums[i-1]) + nums[i]
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[deque.peekFirst()] + nums[i];


            //While the deque is not empty, remove the indexes of the elements in nums that are smaller than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();

            }

            deque.offerLast(i);

            //Remove the first index in the deque if it is more than k steps away from the current i.
            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }

        return nums[nums.length - 1];
    }

}
