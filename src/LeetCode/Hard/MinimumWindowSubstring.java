package LeetCode.Hard;
/* 76
Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

"aaaaaaaaaaaabbbbbcdd", "abcdd" -> "abbbbbcdd"

s || t
"aaaaaaaaaaaabbbbbcdd" || "abcdd"
"caccaacaaaabbcaccaccc" || "acccacbccc"
"aaaaaaaaaaaabbbbbcdd" || "abcdd"
"cbbbacccccbbbacbabbabacbabbbabaacbaccccbcbcbcca" || "abcbcabaacccababacbabcacbc"
"babb" || "baba"


"e"
"Y"

"g"
"g"

"zxgsxsczeymhaqkerxyumpjazzjfqsgRVJWEHWXNOUOpsorapwtdlyhxoplpvyVCQYSOGYAXNjwnpnrivyftoalcqnkptmudwpic"
"OVUCOQNYXSWOHGEYWAJXVNR"

"zzzzzzzzz"
"zzzzzzzzzz"

"HRULTrctorlsshmgtarxadgosylsmxsorskzqfdkujoJQTUHzRLPPyjllmvqopolorblqrijdpytjzxxvnyqihohrszawlvetnrgcnrknuandawlfzthoeoeiqsxliroreemjvqfzuimacidfymmpyljzxtwatvqszhtsjsmpgzjozxvcygidhsunqtvlbvamafbjmplrbrehjmvvlxyluuaqgbrmfxrygeylkzlflbfcwqnemigwhrrshdqiwvifoifxsaxfyqnibcwrkffbtjqxjubgrfvexqhocdvyyavdmujnfwwecqkantiaogsrgvwtwwkcczydpevynzvirsppgrdmfhbdtczprkrrvxxlxjcvauaharesmqjxhjwmrrtspsbobgofrnvdzbwiibqhrrqbtxyspnszwpxbqrwtavsmhhqrqkjegvhbeftfbicnhamhwyonlwlzysocyzshhyknbdkelplkkvazqpnzhydraoyiodssA"
"HRULTPQPJA"

"RBCPEYZQBMHUMPFLRRUELWUXBLNRTZHLKZMKBEQPNRLTVVYMZJQGVWRHBQCYFMMVCCZXBGDFZJVVYKWXVSNRNIUQNPKCETURLVQBVZMJQOGFTODPPJLFWDWUELJUUvamwdzmthclrlftcjhqadncmirlmzopyzgeamfdjqowanvsfhbdoegawcdnfholkmbvsjtfijgzoimzwspmozwhlkyusyxtstlaoiubxuxcancdKBPCECUOIBTUQBKDYIWUGGGWOFULSXHFBULUDFJPOFOJZBVRTCPQIRSXKVJFGXCVMYQHWGJMVTRPEKZLZRLXWERLPUMQYPBlhcbetrmdjjcslbzcayvtxkpczonehbyvrplbrpjtbwbqwnmhpftcjmdxlmiRCEZBHMFRULUBNTHKMBQNLVYZQVRBCFMCZBDZVYWVNNUNKEULQVMQGTDPLWWEJUUMXZQFDZIYYJRWVGJPMHYZXJDRVJEBKHhffnxramgnukqvcutbqhlgxuhtgoxudeqrcisnmtqcztsyeqdlklbuiwkqzobuitspvohwliaknzzpppexcnaeepejntqdviyhekbwwxdjuaghqjfrksponrdwkdemedsntxuhgvwbjA"
"RBCPEYZQBMHUMPFLRRUELWUXBLNRTZHLKZMKBEQPNRLTVVYMZJQGVWRHBQCYFMMVCCZXBGDFZJVVYKWXVSNRNIUQNPKCETURLVQBVZMJQOGFTODPPJLFWDWUELJUUBUFMHXXZSQLFUDFZOIWYGYGJGRUWWVIGYJDPKMBHQYUZTXBJIDORUVCJEECBPKBHKA"

"ABCllBBBBBlllllllABCDEFAAAllBBBBllZ"
"ABAAACDEFZ"

"ZSLDMKRUWQRDUHYZPEKTCSFOCIBQJVFZRBQVLNDVLHYKELDIHFOWMLDWCZTSTDJFKZOIQOGZYCOMCDBCMMQQURWNQNEKHSMLZMHPXVRCDQOZQKFXQJYXHEIPPLWQOSVTDZIHUNMOVZHBEDUJEFVLLLRNSUMWLWNBFSQXLRKVCQHRCWNFMIRVJQRISDCIJZYTHHOVBQOXPEVWOLTWYINUWWLNCOMZXPJNGNTWYIWQJFKVCTHCJERXLQOBBFHHZRFJJSIQYQDWYBTYKMQVFHOKHUMGPVIPWZGTMCKZEGWGKXIHUIJWJZMOULSMHQWZSPFTRDLZUVNWXBCKYESRNXFSSDIDWGVMQZOZEDSUGJMKUNMGMVWHFFBTWUMNJCKHXVRLSNWOTLGXQHNKSMSDRBIYWDTRGDZJHIGMIZNOKLOZVESGGQBLMBIWCOHSTRQEVZA"
"AhxByySKjQEmNdfgyqVhLuXKELUmNwBKnoxXMeOQOxqphcmftZkiqyzGOEUmtLhrBCbYkWNGrFhTaeWxrdNnwGFDFnVWHtXdJXUFqoEdoCRaqhMeXchQljqMlbJgcnsgVzxdduFVGGlxpzmIWZCLLJHfclwtRKGckNmitLXJaqEPzQaoGkdfUmSWuxsXSsihtOEeXEhIcDKjuyPdDbsVfroicpYNcPtegIMskYRRgXObOXfwPRrajGzxuCxNqgxIlSDGPhEuVlNqVQajUJpOZUMjXxsObrVhcViRidPvizmyOmDCoUnXbocUBweIdMPfmbzbvBEmDooZpYEdrOIJpFxmRdVhIEVSwYaJqWqbflPKSbrPhCgUFvaGViZTdkYYXSgpFbLRrIjsjrStTHdBqFbfsbgSOsSTdCXsRmZLhiuWosgjlcPXUzTLUFtmgNgooqteQqMvxDpJVTQjFvHYrmOqWfFpnHBUkiCaYCQpDZKSoPOnmVDavpxckwusmFsLQESlJulplWoucfcvNSbXNYHPINlSfBZHWGcPxykQurSzjfgLxtKMLyFDjJJuOoqrFrcLmYYuMcqeRKoIBIoOlUyHznxsHwibUTuTaaQopMSJqVxLZRfutStGcIVNhrbFgDHVBTCocxlHvBLlINXHYBuJpdGvZqXenqnJHuQvBpVnLOpMBYEcPOlTWoYUBvTTTvQcvJMglYgshNzxbHuhXfdedJJeSJCqhakDNlNjIREgCXhogTfxBiBbghIyyJjTVJVWQdqCyEpYTMloxLbxtJNXqfwJCvQcezblztCegIHorfHnoeEEBZrwPeveKqRxCyZImzjVRgaRkIkRqzxCjsTgKvkVvlIVIiKUPCybvHcWlhZntixLaHxEYjjdEWzyDNqOHRhheOTacIsCncMfRCLUwlWMGgDskDiaKFVFkvzsBGqrpywgvkjokjyeaxxfintejzyedqsycwtdzqhocktoqloyyeocexoxmpfgiyecollixxasxemwzsxucfdfuysnmmmzwrdvxgpirbzhechkqjxvswskbjtlhserzgnwfnqyyorjgfvlricsjesucykzbgfbaujcigyirgtpatwdhfwoujjoryryywpevwzixeocjigrrkzsgfjudawrzwnrpcsjfuplqbqkprcgrnjbtdepgjkhbgbuuumikevbqwgeukdbystfxhhqbgsgsmpwxauwlvtgrypqwufjveitlxytgmvzwptbhqfixadtvgropzodnkyspchuuknjtmctrmewztoyffliaktdcmolbimndnfelazwwbogyjvdzhvthiegoerlghlubmucxnadosforhzstbrzeplnwnelrxaijphventqqavqksqvvepnjejtqfhjrgbhwxqxwxpvreryyizyqbuzuifgpeexanoculgkxnpupgqndpcqvzlnbsxszafhsorkpvjpfzsjmbuifqxkfdemyqlgcpaodpyhihviekqbywvtubujfjglocsxaccxpwtumxeijtoqafokjrsdwjavnwcvtclqemkoadvkaydupveyijejpblkvicygovadnzexsplomzkfxstghgrhorbnpumxrdyytktekbwewwbmlbxcmhvhpmdqvsioethwawkaoiyxlusoaolpeetatdcqegtyfpsynsnrhbwnjjmsiqazstmwqvilemwzhjzlmubserxwuzqasgvwldkobgsouieebbbrituligojxrklsaiwvvzkpuyjvtymeprfarjdbonzlqepcreldeqnwrhzxtbbmvorrkmxcffpotkzznsatezzagcthclkzobsfcvcvijbzqvdwqlhnqbizkjjrwloswaexufzswbdghjadnuruqjmzjkijdqcwmxwfxzadartconewannbnmzgdzgnuinrabdhfhxwsplwzfnaandtdogzjijqadbvebzywuymgihdzvbxbudqeyalmr"

"GBFVFKDDGMWULCRMCITORHONDWEYEHLZWHCPUKIVIVKTCRIRRVIZCRKPZBEEHHICQCJXNJLMTYECQWVJVTJIBBTXCERINNDCJSJJXHNYMJQTTTBUYWTOPEYBMOLVBQHJXZGJBYHXNILBHCTBVHDFNVIGSRZLVJSMQTTUHHUOIBIKRMYYLFOJJDFLMKLSQPGWHZBSNIPHYNXSNWJSEQLFDVOPSKZDQCYCUBHFWOYHFQTVJDMQNFULTUXPWLZRXCTSOSFBHTSIRLFSXYYTZVGFUCPSKPWJYSVEIVRFJIOEYZDEBPMIBUXUCDOPRVVOXMUZOJUQVNVEPGDSINCGRPXOOXRRYMIPNYVDPKDIEXEOSXWSUGQPEJXLNGKRHJLLCZWIGGVFVJMQXMRCEFUXJXHWVFDFGNWTFGNWYCBLUEOGZOQOMXKBNULEKXLVNEQKSBA"


 */
//
// USE TWO POINTER STRATEGY
//
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s ="ADOBECODEBANC";
        String s1="ABCllBBBBBlllllllABCDEFAAAllBBBBllZ", t1="ABAAACDEFZ";
        String s2="ZSLDMKRUWQRDUHYZPEKTCSFOCIBQJVFZRBQVLNDVLHYKELDIHFOWMLDWCZTSTDJFKZOIQOGZYCOMCDBCMMQQURWNQNEKHSMLZMHPXVRCDQOZQKFXQJYXHEIPPLWQOSVTDZIHUNMOVZHBEDUJEFVLLLRNSUMWLWNBFSQXLRKVCQHRCWNFMIRVJQRISDCIJZYTHHOVBQOXPEVWOLTWYINUWWLNCOMZXPJNGNTWYIWQJFKVCTHCJERXLQOBBFHHZRFJJSIQYQDWYBTYKMQVFHOKHUMGPVIPWZGTMCKZEGWGKXIHUIJWJZMOULSMHQWZSPFTRDLZUVNWXBCKYESRNXFSSDIDWGVMQZOZEDSUGJMKUNMGMVWHFFBTWUMNJCKHXVRLSNWOTLGXQHNKSMSDRBIYWDTRGDZJHIGMIZNOKLOZVESGGQBLMBIWCOHSTRQEVZA";
        String t2="AhxByySKjQEmNdfgyqVhLuXKELUmNwBKnoxXMeOQOxqphcmftZkiqyzGOEUmtLhrBCbYkWNGrFhTaeWxrdNnwGFDFnVWHtXdJXUFqoEdoCRaqhMeXchQljqMlbJgcnsgVzxdduFVGGlxpzmIWZCLLJHfclwtRKGckNmitLXJaqEPzQaoGkdfUmSWuxsXSsihtOEeXEhIcDKjuyPdDbsVfroicpYNcPtegIMskYRRgXObOXfwPRrajGzxuCxNqgxIlSDGPhEuVlNqVQajUJpOZUMjXxsObrVhcViRidPvizmyOmDCoUnXbocUBweIdMPfmbzbvBEmDooZpYEdrOIJpFxmRdVhIEVSwYaJqWqbflPKSbrPhCgUFvaGViZTdkYYXSgpFbLRrIjsjrStTHdBqFbfsbgSOsSTdCXsRmZLhiuWosgjlcPXUzTLUFtmgNgooqteQqMvxDpJVTQjFvHYrmOqWfFpnHBUkiCaYCQpDZKSoPOnmVDavpxckwusmFsLQESlJulplWoucfcvNSbXNYHPINlSfBZHWGcPxykQurSzjfgLxtKMLyFDjJJuOoqrFrcLmYYuMcqeRKoIBIoOlUyHznxsHwibUTuTaaQopMSJqVxLZRfutStGcIVNhrbFgDHVBTCocxlHvBLlINXHYBuJpdGvZqXenqnJHuQvBpVnLOpMBYEcPOlTWoYUBvTTTvQcvJMglYgshNzxbHuhXfdedJJeSJCqhakDNlNjIREgCXhogTfxBiBbghIyyJjTVJVWQdqCyEpYTMloxLbxtJNXqfwJCvQcezblztCegIHorfHnoeEEBZrwPeveKqRxCyZImzjVRgaRkIkRqzxCjsTgKvkVvlIVIiKUPCybvHcWlhZntixLaHxEYjjdEWzyDNqOHRhheOTacIsCncMfRCLUwlWMGgDskDiaKFVFkvzsBGqrpywgvkjokjyeaxxfintejzyedqsycwtdzqhocktoqloyyeocexoxmpfgiyecollixxasxemwzsxucfdfuysnmmmzwrdvxgpirbzhechkqjxvswskbjtlhserzgnwfnqyyorjgfvlricsjesucykzbgfbaujcigyirgtpatwdhfwoujjoryryywpevwzixeocjigrrkzsgfjudawrzwnrpcsjfuplqbqkprcgrnjbtdepgjkhbgbuuumikevbqwgeukdbystfxhhqbgsgsmpwxauwlvtgrypqwufjveitlxytgmvzwptbhqfixadtvgropzodnkyspchuuknjtmctrmewztoyffliaktdcmolbimndnfelazwwbogyjvdzhvthiegoerlghlubmucxnadosforhzstbrzeplnwnelrxaijphventqqavqksqvvepnjejtqfhjrgbhwxqxwxpvreryyizyqbuzuifgpeexanoculgkxnpupgqndpcqvzlnbsxszafhsorkpvjpfzsjmbuifqxkfdemyqlgcpaodpyhihviekqbywvtubujfjglocsxaccxpwtumxeijtoqafokjrsdwjavnwcvtclqemkoadvkaydupveyijejpblkvicygovadnzexsplomzkfxstghgrhorbnpumxrdyytktekbwewwbmlbxcmhvhpmdqvsioethwawkaoiyxlusoaolpeetatdcqegtyfpsynsnrhbwnjjmsiqazstmwqvilemwzhjzlmubserxwuzqasgvwldkobgsouieebbbrituligojxrklsaiwvvzkpuyjvtymeprfarjdbonzlqepcreldeqnwrhzxtbbmvorrkmxcffpotkzznsatezzagcthclkzobsfcvcvijbzqvdwqlhnqbizkjjrwloswaexufzswbdghjadnuruqjmzjkijdqcwmxwfxzadartconewannbnmzgdzgnuinrabdhfhxwsplwzfnaandtdogzjijqadbvebzywuymgihdzvbxbudqeyalmr";
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
//        System.out.println(mws.minWindow(s,"ABC"));
//        System.out.println(mws.minWindow("a","a"));
//        System.out.println(mws.minWindow("a","aa"));
        System.out.println(mws.minWindow(s1,t1));
        System.out.println(mws.minWindow(s2,t2));
    }

    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        if(s.length()<t.length()) return "";
        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];

        int sourceLength = s.length();
        int targetLength = t.length();
        int minLength = Integer.MAX_VALUE;
        int matchCount = 0;
        int windowStart = 0;
        int minWindowStart = -1;
        for (int i = 0; i < targetLength; ++i) {
            targetFreq[t.charAt(i)]++;
        }
        for (int windowEnd = 0; windowEnd < sourceLength; ++windowEnd) {
            windowFreq[s.charAt(windowEnd)]++;
            if (targetFreq[s.charAt(windowEnd)] >= windowFreq[s.charAt(windowEnd)]) {
                matchCount++;
            }
            while (matchCount == targetLength) {
                int windowLength = windowEnd - windowStart + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    minWindowStart = windowStart;
                }
                char charAtStart = s.charAt(windowStart);
                if (targetFreq[charAtStart] >= windowFreq[charAtStart]) {
                    matchCount--;
                }
                windowFreq[charAtStart]--;
                windowStart++;
            }
        }
        return minWindowStart < 0 ? "" : s.substring(minWindowStart, minWindowStart + minLength);
    }
}
