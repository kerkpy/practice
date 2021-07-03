//Link to problem: https://leetcode.com/problems/container-with-most-water/
//Time complexity: O(n)


public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            if (area > result) {
                result = area;
            }

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return result;

    }
}
