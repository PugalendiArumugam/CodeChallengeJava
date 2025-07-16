import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//*
//* Add to array form of integer and convert result into array
//* input array [1,2,0,0]  + k= 34
//* output array should be  [1,2,3,4]
//* input array converted to 1200 + 34 = 1234 => [1,2,3,4]
//* eg2
//* input array [2,7,4] k = 181
//* output array [4,5,5]  calculation 274 + 181 = 455
//*
public class AddArrayFormInteger {
    public static void main(String[] args) {
        int [] intArray = new int[] {2,7,4,7,0,0,0,0};
        int k = 98199;
        int [] resultArray = resultArray(intArray, k);
        System.out.println(Arrays.toString(resultArray));
    }

    public static int[] resultArray(int[]inputArray, int k) {
        if (k == 0) {
            return inputArray;
        }
        int resultInt = 0;
        for (int i = 0; i <= inputArray.length-1 ; i++) {
            resultInt = resultInt * 10 + inputArray[i];
        }
        //* add the k valkue
        resultInt += k;
        int len = Integer.toString(resultInt).length();
        int [] resultArray = new int[len];
        for (int i = resultArray.length-1; i>=0;i--){
            resultArray[i] = resultInt % 10;
            resultInt /= 10;
        }
        return resultArray;
    }
}
