import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //************************************************************************
    //* is there a sum of two  numbers present in a array.  Ans yes or
    //* return the position of array from the two numbers.
    //* eg If target is 7 is sum of two numbers present in array {2,3,1,5,7,8}
    //************************************************************************

    public static void main(String[] args) {
        int[] numbers = new int[] {2,7,11,15};
        int target = 18;
        int[] result = getTwoNumbers(numbers,target);
        System.out.println(result[1]+" "+result[0]);
    }

    public static int[] getTwoNumbers(int[] numbers,int target){
        Map<Integer,Integer> checkednumbers = new HashMap<>();

        for (int i =0;i < numbers.length; i++){
            int delta = target - numbers[i];
            if (checkednumbers.containsKey(delta)){
                return new int[] {i, checkednumbers.get(delta)};
            }
            checkednumbers.put(numbers[i],i);
        }
        return new int[]{-1,-1};

    }

}
