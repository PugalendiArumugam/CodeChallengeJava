import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        int input=2449;
        System.out.println("Input :"+input);
        String result = intToRoman(input);
        System.out.println("Roamn :"+result);
        input = romanToInt(result);
        System.out.println("input :"+input);
    }

    public static String intToRoman(int num){

//        if (num>3999 || num <1) {
//            return "range exceed, below 3999 and above 0 expected";
//        }
//        String[] thousands = new String[]{"","M","MM","MMM"};
//        String[] hundreds = new String[] {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
//        String[] tens = new String[]     {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
//        String[] units = new String[]    {"","I","II","III","IV","V","VI","VII","VIII","IX"};
//
//        return thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + units[num%10];

        //  This is a good logic.... remove the values from the integer value of the roman values one by one. and add the symbols depends on the value

        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<values.length; i++){
            if (num == 0)
                break;
            while(num>=values[i]){
                sb.append(symbol[i]);
                num-=values[i];
            }
        }
        return sb.toString();

    }

    public static int romanToInt(String str){
//        Map<Character,Integer> map = new HashMap();
//        map.put('I',1);
//        map.put('V',5);
//        map.put('X',10);
//        map.put('L',50);
//        map.put('C',100);
//        map.put('D',500);
//        map.put('M',1000);
//
//        int result = 0;
//        for(int i =0; i<str.length();i++){
//            if(i>0 && map.get(str.charAt(i)) > map.get(str.charAt(i-1))){
//                result += map.get(str.charAt(i)) - 2*map.get(str.charAt(i-1));
//            }
//            else {
//                result += map.get(str.charAt(i));
//            }
//        }
//        return result;
// instead of map... use case.

        int total = 0;

        int prev = total;

        for (int i = str.length() - 1; i >= 0; i--) {
            // int curr = numerals.get(s.charAt(i));
            int curr = char2num(str.charAt(i));

            if (prev - curr > 0) {
                total -= curr;
            } else {
                total += curr;
            }

            prev = curr;
        }
        return total;
    }

    private  static int  char2num(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
