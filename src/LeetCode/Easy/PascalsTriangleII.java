package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            row.add(1);
        }
        for (int i = 2; i <= rowIndex; ++i) {
            for (int j = i - 1; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    //fastest
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long n = 1;
        result.add((int)n);
        for(int j=1; j<=rowIndex; j++){
            n = n*(rowIndex+1-j)/j;
            result.add((int)n);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangleII pt = new PascalsTriangleII();
//        System.out.println(pt.generate(1));
        System.out.println(pt.getRow(3));
        System.out.println(pt.getRow(0));
        System.out.println(pt.getRow(1));
        System.out.println(pt.getRow(5));
//        System.out.println(pt.generate(0));
    }
}
