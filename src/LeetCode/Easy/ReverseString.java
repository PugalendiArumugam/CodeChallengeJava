package LeetCode.Easy;
/*
344. Reverse String

 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        rs.reverseString(new char[]{'h','e','l','l','o'});
        rs.reverseString(new char[]{'H','a','n','n','a','h'});
    }

    public void reverseString(char[] s) {
        if (s.length<2) return;
        int mid =s.length/2;
        for(int i=0;i<s.length;i++){
            if(i>mid-1) break;
            char c = s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1] = c;
        }
        System.out.println(s);
    }

//    public void reverseString(char[] s) {             //FASTER THAT ABOVE
//        int i = 0;
//        int j = s.length - 1;
//
//        while(i < j){
//            char temp = s[i];
//            s[i] = s[j];
//            s[j] = temp;
//            i++;
//            j--;
//        }
//    }

}
