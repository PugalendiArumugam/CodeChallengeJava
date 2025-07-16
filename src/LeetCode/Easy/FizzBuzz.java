package LeetCode.Easy;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/*
answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.

Example 1:
Input: n = 3
Output: ["1","2","Fizz"]

Example 2:
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]

Example 3:
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

 */
public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        System.out.println(fb.fizzBuzz1(5));
        System.out.println(fb.fizzBuzz1(15));
        System.out.println(fb.fizzBuzz1(3));
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                result.add("FizzBuzz");
            } else if(i%5==0){
                result.add("Buzz");
            } else if(i%3==0){
                result.add("Fizz");
            } else {
                result.add(i+"");
            }
        }
        return result;
    }

    public List<String> fizzBuzz1(int n) {
        List<String> result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%5!=0 && i%3!=0){
                result.add(i+"");
            } else if(i%15==0){
                result.add("FizzBuzz");
            } else if(i%5==0) {
                result.add("Buzz");
            } else{
                result.add("Fizz");
            }
        }
        return result;
    }


    // BEST FASTEST SOLUTION.

    public List<String> fizzBuzz2(int n) {
        return new AbstractList<>() {

            @Override
            public String get(int i) {
                i++;
                boolean divisableBy3 = i % 3 == 0;
                boolean divisableBy5 = i % 5 == 0;
                String result = "";

                if (divisableBy3) {
                    result += "Fizz";
                }
                if (divisableBy5) {
                    result += "Buzz";
                }
                if (result.isEmpty()) {
                    return String.valueOf(i);
                }
                return result;
            }

            @Override
            public int size() {
                return n;
            }

        };
    }


}
