
//************************************************************************
//* Remove special characters
//* replaceAll of string function uses regex
//* [^a-zA-Z]  This allows only alphabets. removes every thing
//* [^a-zA-Z0-9] This allows all alphabets and numbers.
//* [^a-zA-Z0-9 ] This allows all alphabets and numbers and spaces
//* String myStr = "I love cats. Cats are very easy to love. Cats are very popular.";
//* String regex = "(?i)cat";
//* System.out.println(myStr.replaceAll(regex, "dog"));
//************************************************************************
public class RemoveSplChar {
    public static void main(String[] args) {
//        String str = "$P%ug^a7&len(di";
        String str = "a-bC-dEf=ghlj!!";
        String regex = "[^a-zA-Z]";
        String result = str.replaceAll(regex,"");
        System.out.println(ReverseString.reverseManually(result));

        String str2 = "Pug ale nd i Arumugam";
        result = str2.replaceAll("\\s","");    //   \\s removes all spaces
        System.out.println(result);

    }
}


