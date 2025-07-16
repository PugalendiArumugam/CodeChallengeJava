//************************************************************************
//* Reverse the special string value.
//* Reverse only the alphabetic characters.  The special characters staysin the same
//* position
//* eg1.  ab-cd              output : dc-ba
//* eg2.  a-bC-dEf=ghlj!!    output : j-lhf-gfE=dCba!!
//************************************************************************

public class SpecialReverse {
    public static void main(String[] args) {
        String str1 = "a-bcd";
        String str2 = "a-bC-dEf=ghlj!!";
        String charString = str2.replaceAll("[^a-zA-Z]","");
        System.out.println("Original string");
        System.out.println(str2);
        System.out.println("Characters Reversed");
        String reversedCharString = reverseSpl(charString);
        System.out.println(reversedCharString);
        System.out.println("Original Reversed");
        System.out.println(mergeString(str2,reversedCharString));
    }

    public static String mergeString(String originalString , String charStr){
        StringBuilder sb = new StringBuilder();
        for(int i=0, j=0; i<=originalString.length()-1; i++ ) {
            String str = ""+originalString.charAt(i);    // charAt returns char to convert char to string add "" (trick) at the beginning
            if (str.matches("[a-zA-Z]")){
                sb.append(charStr.charAt(j));
                j++;
            } else {
                sb.append(originalString.charAt(i));
            }
//            char str = originalString.charAt(i);      // This also works.  But  have a long if condition below.
//            if ((str >= 'a' && str <= 'z' ) || (str >= 'A' && str <= 'Z')) {
//                sb.append(charStr.charAt(j));
//                j++;
//            } else {
//                sb.append(originalString.charAt(i));
//            }
        }
        return sb.toString();
    }

    public static String reverseSpl(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i >=0; i-- ) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
