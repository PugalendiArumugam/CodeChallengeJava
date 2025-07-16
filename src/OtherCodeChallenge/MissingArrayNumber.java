//*
//* Given array intArray containing n distinct numbers in the range [0,n] return only the
//* number in the range that is missing from the array
//*
//* input [3,0,1]
//* output 2 == the missing number from 0 to 3 is 2
//* input [0,1]
//* output 2  == the missing number is 2
public class MissingArrayNumber {
    public static void main(String[] args) {
//        int [] intArray = new int[]{0,1,2,4,5,6,7};   //ans 3
        int [] intArray = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,14};    //ans 13
        int result = missingNumber(intArray);
        System.out.println("Missing number "+result);
    }

    public static int missingNumber(int[] array1){
        int array = array1.length;
        int totalvalue = (array*(array+1))/2 ;   //n*(n+1)/2
        int arrayvalue = 0;
        for(int i =0;i<=array-1;i++){
            arrayvalue += array1[i];
        }
        return totalvalue-arrayvalue;
    }
}
