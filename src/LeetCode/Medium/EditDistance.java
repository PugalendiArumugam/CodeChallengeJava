package LeetCode.Medium;
/*
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 */
public class EditDistance {
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("horse","ros"));
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dpTable = new int[n1 + 1][n2 + 1];
        for (int id2 = 1; id2 <= n2; ++id2) {
            dpTable[0][id2] = id2;
        }
        for (int id1 = 1; id1 <= n1; ++id1) {
            dpTable[id1][0] = id1;

            for (int id2 = 1; id2 <= n2; ++id2) {
                if (word1.charAt(id1 - 1) == word2.charAt(id2 - 1)) {
                    dpTable[id1][id2] = dpTable[id1 - 1][id2 - 1];
                } else {
                    int isrt = dpTable[id1][id2 - 1];
                    int dlet = dpTable[id1 - 1][id2];
                    int rpl = dpTable[id1 - 1][id2 - 1];

                    dpTable[id1][id2] = Math.min(isrt, Math.min(dlet, rpl)) + 1;
                }
            }
        }
        return dpTable[n1][n2];
    }

}
