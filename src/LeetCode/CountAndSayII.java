package LeetCode;

public class CountAndSayII {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i< n; i++) {
            s = countAndSayHelper(s);
        }
        return s;
    }

    public static String countAndSayHelper(String s) {
        StringBuilder sb = new StringBuilder();
        char previous =  s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == previous) {
                count++;
            } else {
                sb.append(count);
                sb.append(previous);
                previous = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(previous);
        return sb.toString();
    }
}
