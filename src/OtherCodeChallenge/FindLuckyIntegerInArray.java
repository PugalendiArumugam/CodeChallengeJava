//*
//*
//*
//***** SIMPLE COMPLEXITY ************
//*
//* Given an array of integers arr, a lucky integer is an integer that has a frequency
//* in the array equal to its value
//* Return largest lucky integer in the array
//* input : [2,2,3,4]
//* output: 2
//* explanation. lucky number 2 is 2 times present in the array
//*
//* input : [1,2,2,3,3,3]
//* output : 3
//* the lucky numbers are 1,2,3 .  1 is present 1 time. 2 is present 2 times, 3 is present 3 times
//* out of three lucky numbers 3 is the largest
//*
//* input :[2,2,2,3,3]
//* output : -1
//* There is no lucky number present in this because 2 is not preset 2 times instead 3 times.
//* 3 is not present 3 times instead 2 times.
//*

import java.util.HashMap;

public class FindLuckyIntegerInArray {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,2,3,4};     // ans 2 correct
        int[] nums = new int[]{1,2,2,4,4,4,3,3,3};     //ans 3 correct
//        int[] nums = new int[]{2,2,2,3,3};    // ans -1 correct
        int result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int element = nums[i];
            if(hm.containsKey(element)==true){
                hm.put(element,hm.get(element)+1);
            }else {
                hm.put(element,1);
            }
        }
        int ans = -1;
        for(int key: hm.keySet()){
            if(hm.get(key)==key){              // checks the value with the key if both are equal
                ans = Math.max(ans,key);
            }
        }
        return ans;
    }
}
