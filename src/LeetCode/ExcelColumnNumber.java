package LeetCode;

public class ExcelColumnNumber {
    public static void main(String[] args) {
//        String col = "AA";
//        String col = "BZ";
        String col ="FXSHRXW";   //2147483647
        System.out.println(titleToNumber(col));
    }

    public static int titleToNumber(String columnTitle) {
//        int total =0;
//        int index = 0;
//        for (int i = columnTitle.length()-1;i>=0;i--){
//            char c = columnTitle.charAt(i);
//            total = total + (c-64) * (int) Math.pow(26,index++);      // instead of c-64 you can use c-'A'+1 // ALSO INSTEAD OF POW USE Total*=26
//        }
//        return total;


        // Brilliant strategy

        int result=0;
        for(int i=0;i<columnTitle.length();i++)
        {
            result*=26;
            result+=(columnTitle.charAt(i)-'A'+1);
        }
        return result;
    }
}
