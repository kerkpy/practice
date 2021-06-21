import java.util.ArrayList;
import java.util.List;

//Link to problem: https://leetcode.com/problems/pascals-triangle/

class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        result.add(temp);

        for (int i = 1; i < numRows; i++) {
            temp = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {

                    List<Integer> temp2 = result.get(result.size() - 1);

                    temp.add(temp2.get(j-1) + temp2.get(j));
                }
            }

            result.add(temp);
        }

        return result;

    }
}
