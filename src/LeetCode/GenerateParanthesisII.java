package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesisII {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> content = new ArrayList<>();
        // back track all the possible states
        backTrack(new StringBuilder(),content,0,0,n);
        return content;

    }

    public static void backTrack(StringBuilder string,List<String> list, int open, int close, int n){

        // if we have reached 2 x the length of the string
        if(string.length() == 2*n){
            list.add(string.toString());
            return;
        }

        // we can add upto n combination of data
        if(open < n){
            string.append('(');
            backTrack(string,list,open+1,close,n);
            string.deleteCharAt(string.length()-1);
        }

        // we can add upto few combination of ) braces
        if(close<open){
            string.append(')');
            backTrack(string,list,open,close+1,n);
            string.deleteCharAt(string.length()-1);

        }

    }

}


