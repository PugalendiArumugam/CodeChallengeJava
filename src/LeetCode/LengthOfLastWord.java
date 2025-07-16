package LeetCode;

public class LengthOfLastWord {
    public static void main(String[] args) {
//        String str = "   fly me   to   the 1moon  ";
        String str = "Hello World";
//        String str = "luffy is still joyboy";
//        String str = "";
        int res = lengthOfLastWord(str);
        System.out.println(res);
    }

    public static int lengthOfLastWord(String s){
//        if(s.isEmpty() || s.isBlank()) return 0;
//        String[] arr = s.split(" ");
//        return arr[arr.length-1].length();

//        int siz = 0;
//        for (int i = s.length() - 1; i >= 0 ; i--) {
//            char l = s.charAt(i);
//            if (Character.isLetter(l)) {
//                siz++;
//            }else if(siz > 0){
//                return siz;
//            }
//        }
//        return siz;


        int result = 0;
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if ((c>='a' && c<='z') ||(c>='A' && c<='Z'))  {
                result++;
            } else {
                if(result>0) return result;
            }
        }
        return result;


    }
}
