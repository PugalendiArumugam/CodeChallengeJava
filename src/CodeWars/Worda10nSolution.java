package CodeWars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worda10nSolution {
    public static void main(String[] args) {
        Worda10nSolution ws = new Worda10nSolution();
        System.out.println(ws.abbreviate2("internationalization"));   //i18n
        System.out.println(ws.abbreviate6("elephant-rides are really fun!"));    //e6t-r3s are r4y fun!
    }

    public String abbreviate(String string) {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<string.length();i++){
            char c = string.charAt(i);
            StringBuilder curr = new StringBuilder();
            while ((c>=65 && c<=90) ||(c>=97&&c<=122)){
                curr.append(c);
                i++;
                if(i>=string.length()){
                 break;
                }
                c=string.charAt(i);
            }
            if (curr.length()>3){
               result.append(curr.charAt(0)).append(curr.length()-2).append(curr.charAt(curr.length()-1));
            } else {
                result.append(curr);
            }
            if(i<string.length()){
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    //best and fast
    public String abbreviate2(String string) {
        for (var s : string.split("[^a-zA-Z]")) {
            string = string.replaceFirst(s, s.length() > 3 ? "" + s.charAt(0) + (s.length() - 2) + s.substring(s.length() - 1) : s);
        }
        return string;
    }

    public String abbreviate3(String string) {

        String res = string;
        Pattern p = Pattern.compile("([a-zA-Z]{4,})");
        Matcher m = p.matcher(string);

        while(m.find())
        {
            String part = m.group();
            String repl = "" + part.charAt(0) + (part.length()-2) + part.charAt(part.length()-1);
            res = res.replaceFirst(part, repl);
        }

        return res;
    }

    //using regex
    public String abbreviate4(String inputString) {
        return Pattern.compile("([a-zA-Z])([a-zA-Z]{2,})([a-zA-Z])").matcher(inputString)
                .replaceAll(mr -> mr.group(1) + mr.group(2).length() + mr.group(3));
    }

    public String abbreviate5(String string) {
        String[] split = string.split("[^a-zA-Z]+");
        for (String s : split) {
            string = string.replaceFirst(s,
                    s.length() < 4 ? s : s.substring(0, 1) + (s.length() - 2)
                            + s.substring(s.length() - 1));
        }
        return string;
    }

    public String abbreviate6(String string) {
        Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(string);
        while(matcher.find()){
            String wrd = matcher.group();
            if(wrd.length()>3)
                string = string.replaceFirst(wrd, ""+wrd.charAt(0)+(wrd.length()-2)+wrd.charAt(wrd.length()-1));
        }
        return string;
    }


}
