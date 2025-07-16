package LeetCode;

import java.util.*;

public class TextJustification {
    public static void main(String[] args) {
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification.","for","more","test","cases","Completely","Examined"};
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};

//        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};    // width 20
        String[] words = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};      // width 20
//        String[] words = new String[]{"Give","me","my","Romeo;","and,","when","he","shall","die,","Take","him","and","cut","him","out","in","little","stars,",
//        "And","he","will","make","the","face","of","heaven","so","fine","That","all","the","world","will","be","in","love","with","night","And","pay","no","worship","to","the","garish","sun."};    // textWidth=25
        int textWidth =20;
        System.out.println(fullJustify(words, textWidth));
    }

    public static   List<String> fullJustify(String[] words, int maxWidth) {
        String space100 = new String(new char[100]).replace('\0', ' ');
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        int lineLen = 0;
        int spacer = 0;
        for (String word : words) {
            int wordLen = word.length();

            if (lineLen + wordLen + spacer <= maxWidth) {
                queue.add(word);
                lineLen = lineLen + wordLen;
                spacer++;
            } else if (lineLen + wordLen + spacer >= maxWidth) {
                result.add(buildLine(queue, maxWidth, spacer-1, lineLen,true,space100));
                if(word.equals(words[words.length-1])) {
                    word=(word+space100).substring(0,maxWidth);
                    result.add(word);
                    queue.clear();
                } else {
                    queue.clear();
                    queue.add(word);
                    lineLen=wordLen;
                    spacer=1;
                }
            }
        }
        if(queue.size()!=0){
            result.add(buildLine(queue, maxWidth, spacer, lineLen,false,space100));
        }
        return result;
    }

    public static String buildLine(Queue<String> q,int mxw, int spacer, int linelen,boolean just,String space100){
        StringBuilder sb= new StringBuilder();
        Iterator<String> iq = q.iterator();
        if(q.size()==1) {
            sb.append((q.peek()+space100).substring(0,mxw));
            return sb.toString();
        }
        int words = q.size()-1;
        int calcspacer = mxw-linelen;
        int spacefactor = calcspacer/words;
        int extra = calcspacer%words;
        while (iq.hasNext()){
            sb.append(iq.next());
            if(!just){
                if(sb.length()!=mxw){
                    sb.append(" ");
                }
                continue;
            }
            if(spacefactor==0){
                if(extra!=0){
                    sb.append(" ");
                    extra--;
                }
            } else {
                if (calcspacer>=1){
                    StringBuilder ss= new StringBuilder();
                    int i=spacefactor;
                    while(i>=1){
                        ss.append(" ");
                        i--;
                        calcspacer--;
                    }
                    if(extra>0){
                        ss.append(" ");
                        extra--;
                        calcspacer--;
                    }
                    sb.append(ss);
                }
            }
        }
        if(!just){
            sb.append(space100.substring(0,mxw-sb.length()));
        }
        return sb.toString();
    }
}
