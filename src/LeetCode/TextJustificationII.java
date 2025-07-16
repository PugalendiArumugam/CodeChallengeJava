package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationII {
    public static void main(String[] args) {
        String[] words = new String[]{"Give","me","my","Romeo;","and,","when","he","shall","die,","Take","him","and","cut","him","out","in","little","stars,",
        "And","he","will","make","the","face","of","heaven","so","fine","That","all","the","world","will","be","in","love","with","night","And","pay","no","worship","to","the","garish","sun."};    // textWidth=25
        int textWidth =25;
        System.out.println(fullJustify(words, textWidth));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;


            while (last < words.length && totalChars + words[last].length() + (last - index) <= maxWidth) {
                totalChars += words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numWords = last - index;
            int numSpaces = maxWidth - totalChars;


            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");
            }
            else {
                int spaceBetween = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j < spaceBetween + (extraSpaces > 0 ? 1 : 0); j++) {
                            line.append(" ");
                        }
                        extraSpaces--;
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }

}
