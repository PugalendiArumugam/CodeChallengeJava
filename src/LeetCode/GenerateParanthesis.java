package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n<1 || n>8) return res;
        int max =n;
        generate(0,0,"",res, max);
        return res;

    }


    public static void generate(int oc, int cc, String curr, List<String> res, int max){
        if(oc>max || cc>max || oc<cc){
            return;
        }
        if(oc==max && cc==max){
            res.add(curr);
            return;
        }
        generate(oc+1,cc,curr+"(",res,max);
        generate(oc,cc+1,curr+")",res,max);
    }

}
