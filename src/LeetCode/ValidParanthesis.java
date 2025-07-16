package LeetCode;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
//        String str = "([)]";
//        String str = "({})";
//        String str="([])";
 //       String str = "]";
        String str = "(){}[]";
        System.out.println(solution(str));
    }


    public static boolean solution(String s){
//        Stack<Character> stack = new Stack<>();
//        if(s==null || s.isEmpty()) return false;
//        char c =' ';
//        char cc = ' ';
//        for(int i =0;i<s.length();i++){
//            c = s.charAt(i);
//            if (c == '(' || c == '[' || c=='{' ){
//                stack.push(c);
//                continue;
//            }
//            if (c == '}' || c == ']' || c==')') {
//                if(stack.isEmpty()) return false;
//                cc = stack.pop();
//            }
//
//                switch (c) {
//                case '}' :
//                    if(cc!='{') return false;
//                    break;
//
//                case ']' :
//                    if(cc!='[') return false;
//                    break;
//
//                case ')' :
//                    if(cc!='(') return false;
//                    break;
//
//                default:
//                    break;
//            }
//        }
//        if(stack.isEmpty()) return true;
//        else return false;



        int[] ans = new int[s.length()];
        int total =-1;
        for(char c : s.toCharArray()){
            if(c == '('){
                ans[++total] = ')';
            }
            else if(c == '{'){
                ans[++total]= '}';
            }
            else if(c =='['){
                ans[++total] =']';
            }
            else if( total == -1 || ans[total--] != c){
                return false;
            }
        }
        return total == -1;
    }
}
