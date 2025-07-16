package CodeWars;

import java.util.HashMap;
import java.util.Map;

import static java.util.regex.Pattern.matches;

public class CreditCardChecking {
    public static void main(String[] args) {
        System.out.println(getIssuer("4111111111111111"));
        System.out.println(getIssuer("378282246310005"));
        System.out.println(getIssuer("9111111111111111"));
        System.out.println(getIssuer("5105105105105100"));
    }

    public static String getIssuer(String cardNumber) {
        HashMap<Integer,String> cardMap = new HashMap<>();
        cardMap.put(6011,"Discover");
        cardMap.put(34,"AMEX");
        cardMap.put(37,"AMEX");
        cardMap.put(4,"VISA");
        cardMap.put(51,"Mastercard");
        cardMap.put(52,"Mastercard");
        cardMap.put(53,"Mastercard");
        cardMap.put(54,"Mastercard");
        cardMap.put(55,"Mastercard");

        Map <Integer,String> sizeMap = Map.of(
                15,"AMEX",
                16,"Discover^Mastercard^VISA",
                3,"VISA"
        );

//        sizeMap.put(15,"AMEX");
//        sizeMap.put(16,"Discover^Mastercard^VISA");
//        sizeMap.put(13,"VISA");

        for(int i=4;i>=1;i--){
            Integer cardPrefix = Integer.parseInt( cardNumber.substring(0,i));
            String result = cardMap.getOrDefault(cardPrefix,null);
            if (result!=null){
                int size=cardNumber.length();
                String cardType = sizeMap.getOrDefault(size,null);
                if (cardType!=null && cardType.contains(result)) {
                    return result;
                }
            }
        }
        return "Unknown";
    }

    //import static java.util.regex.Pattern.matches;
    //use Regex
    public static String getIssuer1(String cn) {
        if (matches("^3[4|7].{13}$", cn)) return "AMEX";
        if (matches("^6011.{12}$", cn)) return "Discover";
        if (matches("^5[1-5].{14}$", cn)) return "Mastercard";
        if (matches("^4.{12}(...)?$", cn)) return "VISA";
        return "Unknown";
    }

    public static String getIssuer2(String cn) {
        return
                cn.matches("^3[4|7].{13}$")   ? "AMEX"
                        : cn.matches("^6011.{12}$")     ? "Discover"
                        : cn.matches("^5[1-5].{14}$")   ? "Mastercard"
                        : cn.matches("^4.{12}(...)?$")  ? "VISA"
                        : "Unknown";
    }


    public static String getIssuer3(String cardNumber) {
        if (cardNumber.startsWith("34") || cardNumber.startsWith("37") && cardNumber.length() == 15){
            return "AMEX";
        }
        else if (cardNumber.startsWith("6011") && cardNumber.length() == 16){
            return "Discover";
        }
        else if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16) ){
            return "VISA";
        }
        else if (cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53") ||
                cardNumber.startsWith("54") || cardNumber.startsWith("55") && cardNumber.length() == 16){
            return "Mastercard";
        }
        return "Unknown";
    }

    private static Map<String, String> regexps = Map.of(
            "AMEX",       "^3[4|7]\\d{13}",
            "Discover",   "^6011\\d{12}",
            "Mastercard", "^5[1-5]\\d{14}",
            "VISA",       "^4(\\d{12}|\\d{15})");

    public static String getIssuer4(String cardNumber) {
        return regexps.entrySet()
                .stream()
                .filter(entry -> cardNumber.matches(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("Unknown");
    }

}
