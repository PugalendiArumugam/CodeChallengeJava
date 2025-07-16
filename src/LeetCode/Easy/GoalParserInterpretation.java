package LeetCode.Easy;

/*
Example 1:
Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".

Example 2:
Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:
Input: command = "(al)G(al)()()G"
Output: "alGalooG"
 */
public class GoalParserInterpretation {
    public static void main(String[] args) {
        GoalParserInterpretation gp = new GoalParserInterpretation();
        System.out.println(gp.interpret("G()(al)"));  //Goal
        System.out.println(gp.interpret("G()()()()(al)"));   //Gooooal
        System.out.println(gp.interpret("(al)G(al)()()G"));  //alGalooG
    }

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder(command.length());
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(') {
                i++;
                if (command.charAt(i) == 'a' && command.charAt(i + 1) == ')') {
                    sb.append('a');
                    i++;
                } else if (command.charAt(i) == 'a' && command.charAt(i + 1) == 'l') {
                    sb.append("al");
                    i = i + 2;
                } else if (command.charAt(i) == ')') {
                    sb.append('o');
                }
            } else {
                sb.append(command.charAt(i));
            }
        }
        return sb.toString();
    }

    //another method
    public String interpret1(String command) {
        StringBuilder builder = new StringBuilder();
        for (int i=0 ; i < command.length();) {
            if (command.charAt(i) == 'G') {
                builder.append("G");
                i++;
            }
            else if(command.startsWith("()", i)) {
                builder.append("o");
                i+=2;
            }
            else if(command.startsWith("(al)", i)) {
                builder.append("al");
                i+=4;
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    //another method - simple but slower than first one
    public String interpret2(String command)
    {
        command=command.replace("()","o");
        command=command.replace("(al)","al");
        return command;
    }

    //another method
    public String interpret3(String command) {
        return command
                .replaceAll("\\(\\)", "o")
                .replaceAll("\\(al\\)", "al");
    }
}
