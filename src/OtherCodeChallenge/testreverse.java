public class testreverse {
    public static void main(String[] args) {
        String str = "Pugalendi";
        int ival = 342729;
        System.out.println(intReverse(ival));
        System.out.println(stringReverse(str));
    }

    public static int intReverse(int i) {
        int reverse = 0;
        while(i > 0) {
            reverse = reverse * 10  + i % 10;
            i = i/10;
        }
        return reverse;
    }

    public static String stringReverse(String str){
        StringBuilder result = new StringBuilder();;
        for(int i = str.length()-1; i>=0;i-- ) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
}
