//* check power of two
//* input 12 output : not a power of two
//* input 32 output : power of two
//* input 10 output : not a power of two
//* input 256 output: power of two
public class isPowerOfTwo {
    public static void main(String[] args) {
        int val = 256;
        boolean isPowerOfTwo = isPowerTwo(val);
        if (isPowerOfTwo) System.out.println("Power of two");
        else System.out.println("Not a power of two");
    }

    public static boolean isPowerTwo(int val) {
        if (val < 1) return false;
        else if (val == 1) {
            return true;
        } else {
            while (val % 2 ==0 ) {
                val = val /2;
            }
            if ( val == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
