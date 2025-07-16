package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        currList.add(1);
        result.add(currList);
        if(numRows==1) {
            return result;
        }
        for(int i=2;i<=numRows;i++){
            currList = new ArrayList<>();
            int l=2;
            currList.add(1);
            int k=0;
            while(l<=i){
                if (l==i){
                    currList.add(1);
                    break;
                }
                List<Integer> list1 = result.get(result.size()-1);
                int num1 = list1.get(k);
                int num2 = list1.get(k+1);
                currList.add(num1+num2);
                l++;
                k++;
            }
            result.add(currList);
        }
        return result;
    }

    //optimized code
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int temp = 1;
        for(int i = 1; i <= numRows; i++) {
            ArrayList<Integer> rowAns = new ArrayList<>();
            rowAns.add(1);
            for(int j = 1; j <  i; j++) {
                temp *= (i -j);
                temp = temp / j;
                rowAns.add(temp);
            }
            ans.add(rowAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
//        System.out.println(pt.generate(1));
        System.out.println(pt.generate1(5));
//        System.out.println(pt.generate(7));
        System.out.println(pt.generate(0));
    }
}
