package CodeWars;

public class CountSetBit {
    public static void main(String args[])
    {
        System.out.println(countSetBits(9));
        System.out.println(countSetBits(4));
        System.out.println(countSetBits(7));
        System.out.println(countSetBits(9));
        System.out.println(countSetBits(10));
        System.out.println(countSetBits(2999));
    }


    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
//            System.out.println(Integer.toBinaryString(n)+" "+n+" n & 1"+(n & 1));
//            System.out.println("Count :"+count);
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static int countBits1(int n){
        return Integer.bitCount(n);
    }

    public static class BitCounting2 {
        public static int countBits(int n){
            int ret = n % 2;
            while ((n /= 2) > 0) ret += n % 2;
            return ret;
        }
    }

}
