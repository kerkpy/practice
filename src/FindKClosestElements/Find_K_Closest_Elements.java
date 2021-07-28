package FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

//Link to problem: https://leetcode.com/problems/find-k-closest-elements/
//Time complexity: O(n)
//Space complexity: O(n)


public class Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();
        int closestX = 0;

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < Math.abs(arr[closestX] - x)) {
                closestX = i;
            }

        }

        int left = closestX;
        int right = closestX + 1;

        while (k > 0) {


            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(0, arr[left]);
                    left--;

                } else if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                    result.add(result.size(), arr[right]);
                    right++;

                }
            } else {

                if (left < 0 && right >= arr.length) {
                    k = 0;
                    break;
                }

                if (right >= arr.length) {
                    result.add(0, arr[left]);
                    left--;


                } else if (left < 0) {
                    result.add(result.size(), arr[right]);
                    right++;


                }

            }



            k--;
        }

        return result;

    }
}