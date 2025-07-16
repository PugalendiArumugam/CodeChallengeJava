package LeetCode;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String curr = "1";
        while (--n > 0) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < curr.length();) {
                int count = 0;
                char ch = curr.charAt(i);
                while (i < curr.length() && curr.charAt(i) == ch) {
                    i++;
                    count++;
                }
                next.append(count).append(ch);
            }
            curr = next.toString();
        }
        return curr;
    }
}
