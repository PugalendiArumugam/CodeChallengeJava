package LeetCode.Easy;
/* 190 Reverse Bits
Example 1:
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192
    which its binary representation is 00111001011110000010100101000000.

Example 2:
Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471
    which its binary representation is 10111111111111111111111111111111.
 */
public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            System.out.println("i "+i);
            System.out.println("result "+result+" "+Integer.toBinaryString(result));
            System.out.println("n "+n+" "+Integer.toBinaryString(n));
            result |= ((n & 1) << (31 - i));
            n >>>= 1;
            System.out.println("n "+n+" "+Integer.toBinaryString(n));
            System.out.println("=======================");
        }
        return result;
    }

    public int reverseBits1(int n) {
        int result = 0;

        // Loop over all the 32 bits of an integer
        // The loop continues while there are non-zero bits remaining
        for (int i = 0; i < 32 && n != 0; i++) {
            // Using bitwise OR and shift to add the least significant bit of 'number' to the result
            // (1) number & 1 isolates the least significant bit of 'number'
            // (2) << (31 - i) moves the bit to its reversed position
            // (3) |= assigns the bit to the correct position in result
            result |= ((n & 1) << (31 - i));

            // Unsigned right shift the 'number' by one to process the next bit in the next iteration
            n >>>= 1;
        }

        // Return the reversed bits integer
        return result;
    }

}
