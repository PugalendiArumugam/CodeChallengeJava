
//************************************************************************
//* Reverse the string value.
//* 1) String builder can be used to reverse easily and efficiently
//* 2) Reverse Manually add it to StringBuilder.  and return the value
//*     if you use String to add, every time you add a character it creates
//*     a string in memory. so SB is more efficient
//* 3) you can use char[] charArray = str.toCharArray(); and loop thru charArray in reverse
//* 4) you can simply sout(str.charAt(i)) inside the forloop.
//*
//*  Str = immutable      sbuffer = mutable        sbuilder = mutable
//*  Str = Synchronised   sbuffer = Synchronised   sbuilder = non-Synchronised
//*  Str = Thread-safe    sbuffer = Thread-safe    sbuilder = non Thread-safe
//*  Str = less efficient sbuffer = efficient      sbuilder = more efficient
//************************************************************************

public class ReverseString {
    public static void main(String[] args) {
        String str = "Idli Sambar";
        //System.out.println(reverseUsingSB(str));
        System.out.println(reverseManually(str));
        char[] charArray = str.toCharArray();
        System.out.println(charArray);
    }

    public static String reverseUsingSB(String str){
        return new StringBuffer(str).reverse().toString();
    }

    public static String reverseManually(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i >=0; i-- ) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
