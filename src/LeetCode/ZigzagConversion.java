package LeetCode;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;    // output PAHNAPLSIIGYIR"

//        String s ="ABCD";
//        int numRows=4;

        System.out.println(convert(s,numRows));
    }

//    public static String convert(String s, int numRows) {
//        if(s.length()==1) return s;
//        if(numRows<s.length()) return "";
//        StringBuilder result = new StringBuilder();
//        String[] sArray= new String[numRows];
//
//        boolean isAscending=true;
//        for(int i =0,j=0;i<s.length();i++){
//            if (i<sArray.length){
//                sArray[i] ="";
//            }
//
//            sArray[j] = sArray[j]+(s.charAt(i));
//            if(isAscending){
//                if(j>=numRows-1)
//                {
//                    j--;
//                    isAscending=false;
//                } else j++;
//            } else {
//                if(j<=0)
//                {
//                    j++;
//                    isAscending=true;
//                } else j--;
//            }
//        }
//        for(String word: sArray){
//            if(word!=null){
//                result.append(word);
//            }
//        }
//        return result.toString();
//    }


    public static String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        char[] result = new char[n];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            int fromPos = i;
            result[index++] = s.charAt(fromPos);
            int firstStep = (numRows - 1 - i) << 1;
            int lastStep = i << 1;
            while (fromPos < n) {
                if (firstStep != 0) {
                    fromPos += firstStep;
                    if (fromPos < n) {
                        result[index++] = s.charAt(fromPos);
                    }
                }
                if (lastStep != 0) {
                    fromPos += lastStep;
                    if (fromPos < n) {
                        result[index++] = s.charAt(fromPos);
                    }
                }
            }
        }
        return new String(result);
    }


}
