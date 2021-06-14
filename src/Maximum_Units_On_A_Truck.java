import java.util.Arrays;

//Link to problem: https://leetcode.com/problems/maximum-units-on-a-truck/
//Time complexity: O(n)
//Space complexity: O(n)

public class Maximum_Units_On_A_Truck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {


        //Sort the array boxtypes based on the number of units per box, in decreasing order.
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int numUnits = 0;

        for (int i = 0; i < boxTypes.length; i++) {

            if (truckSize == 0) {
                break;
            }

            int[] box = boxTypes[i];


            //If the number of boxes exceeds the truck size, multiply the remaining truck size by units per box, add to
            //the truck and return the result.
            //Else, reduce the truck size and add all the units into the truck.
            if (truckSize <= box[0]) {
                numUnits += truckSize * box[1];
                return numUnits;
            } else {
                truckSize -= box[0];
                numUnits += box[0] * box[1];
            }

        }


        return numUnits;
    }
}
