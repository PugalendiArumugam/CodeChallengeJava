//*
//* Given array nums of n integers where n > 1 returns an array output
//* output[i] is equal to the product of all the elements of nums except the i.
//* input : [1,2,3,4]
//* output : [24,12,,8,6]   condition :  with 0(n) complexity and without division
//*********** MEDIUM COMPLEXITY *******************
//*

import java.util.Arrays;

public class ProuctOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] ia = new int[] {1,2,3,4};
        int[] res = solution(ia);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solution(int[] array1){
        int N = array1.length;
        int [] outArray = new int[N];
        outArray[0] = 1;

        for(int i =1; i<N; i++){
            outArray[i] = array1[i-1] * outArray[i-1];
        }
        int R=1;
        for(int i = N-1; i>=0;i-- ) {
            outArray[i] = outArray[i] * R;
            R = R * array1[i];
        }

        return outArray;
    }

}
