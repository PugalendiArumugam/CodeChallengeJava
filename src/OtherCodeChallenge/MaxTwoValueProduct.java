//* find two maximum value in a array and product of those two elements
//* num[i]-1 * num[j]-1
//* eg [3,4,5,2] max values 4 and 5 their indices 1 and 2
//* product of those numbers 4-1=3 5-1=4  3 * 4 = 12
//*

public class MaxTwoValueProduct {
    public static void main(String[] args) {
//        int[] intArray = new int[] {3,4,5,2,1};
        int[] intArray = new int[] {1,5,4,5};
//        int[] intArray = new int[] {3,7};
        int result = getProduct(intArray);
        System.out.println(result);
    }

    public static int getProduct(int[] intAraay){
        int max =0, smax = 0;
        for (int i =0; i <= intAraay.length-1;i++){
            if (intAraay[i]>max){
                smax = max;
                max = intAraay[i];
            }else if (intAraay[i]>smax) {
                smax = intAraay[i];
            }
        }
        return (max-1) * (smax-1);
    }
}

