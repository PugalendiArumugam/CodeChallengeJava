package LeetCode;

public class ExcelColumnTitle {
    public static void main(String[] args) {

//        int num = 1;    //A
//          int num = 27;    //AA
//          int num = 52;    //AZ
//        int num = 7;    //G
//        int num = 28;   //AB
//        int num = 701;   //ZY
        int num =78;    //BZ
//          int num = 2147483647;   // expected "FXSHRXW"
//
         System.out.println(convertToTitle(num));
//
//        int n = 2147483647;
//        int n=701;
//        decToHexa(n);

    }

    public static String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        if (columnNumber<1) return "";

        int total = 0;

        while (columnNumber != 0){
            int temp =0;
            temp = columnNumber % 26;
            columnNumber /= 26;
            if(temp==0 && columnNumber!=0){
                columnNumber--;
                sb.append('Z');
                continue;
            } else {
                char c = (char) (temp + 64);
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }

    public static void decToHexa(int n)
    {
        // char array to store hexadecimal number
        char[] hexaDeciNum = new char[100];

        // counter for hexadecimal number array
        int i = 0;
        while (n != 0) {
            // temporary variable to store remainder
            int temp = 0;

            // storing remainder in temp variable.
            temp = n % 26;

            if(temp==0 && n!=0){
                hexaDeciNum[i] = 'Z';
                i++;
                n = n - 26;
                continue;
            }

            // check if temp < 10
//            if (temp < 10) {
//                hexaDeciNum[i] = (char)(temp + 48);
//                i++;
//            }
//            else {
//                hexaDeciNum[i] = (char)(temp + 55);
//                i++;
//            }

            char c = (char) (temp + 64);
            hexaDeciNum[i] = c;
            i++;

            n = n / 26;
        }

        // printing hexadecimal number array in reverse
        // order
        for (int j = i - 1; j >= 0; j--)
            System.out.print(hexaDeciNum[j]);
    }


}
