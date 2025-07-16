package LeetCode.Playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {

//        String[] str = new String[]{"bat","tab","cas","eat","ate","ctc","tea"};
//        for(String word: str){
//            long total=0;
//            for(int i=0;i<word.length();i++){
//                int c = word.charAt(i)*(word.charAt(i)-'a'+1);
//                System.out.println(word.charAt(i)+" c "+ c);
//                total+=c;
//            }
//            System.out.println(total);
//        }


        // create a ConcurrentHashMap and
        // add some values
//        HashMap<String, String> map
//                = new HashMap<>();
////        map.put("Pencil", "1000");
////        map.put("Laptop", "55000");
//
//        // print map details
//        System.out.println("ConcurrentHashMap :\n "
//                + map.toString());
//
//        // provide value for new key which is absent
//        // using computeIfAbsent method
//        map.computeIfAbsent("PC", k -> "1500");
//        map.computeIfAbsent("Laptop", k -> "2500");
//
//        // print new mapping
//        System.out.println("new ConcurrentHashMap :\n "
//                + map);
//
//        boolean  sb = map.computeIfAbsent("PC", k -> "2100").equals("2100");
//        map.computeIfAbsent("PC", k -> "2100");
//        System.out.println(sb);
//        System.out.println("new ConcurrentHashMap :\n "
//                + map);
////


        Map<String, List<String>> anagramsMap = new HashMap<>();
        String sortedStr = "abc";
        String str = "cab";
        anagramsMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        str = "bac";
        anagramsMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        sortedStr = "cat";
        str = "tac";
        anagramsMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        str = "act";
        anagramsMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);

        System.out.println(anagramsMap);

        //computeIfAbsent

        Map<Integer,StringBuilder> techNames = new HashMap<>();
        techNames.computeIfAbsent(1,k->new StringBuilder("Java First"));     // not present(absent) and the value is updated from the function.
        System.out.println("1->"+techNames);
        techNames.put(1,new StringBuilder("Java Second"));
        techNames.put(2,null);
        System.out.println("2->"+techNames);
        techNames.computeIfAbsent(1,k->new StringBuilder().append("Java New"));    // this has no effect.  it is present and value is not null
        techNames.computeIfAbsent(2,k->new StringBuilder("Python"));  // this is changed. Because it is present and the value is "null"
        System.out.println("3->"+techNames);
        techNames.computeIfAbsent(2,k->new StringBuilder("Python 6"));
        System.out.println("4->"+techNames);
        techNames.computeIfAbsent(2,k->new StringBuilder("Python 6")).replace(0,999999,"New Python");
        System.out.println("5->"+techNames);

            System.out.println("Map merge");

        // map merge
            Map<String,Integer> mergeMap = new HashMap<>();
            mergeMap.merge("Java",6,Integer::sum);    // it will just add
            System.out.println(mergeMap);
            mergeMap.merge("Java",1,Integer::sum);    // merge.. the value if present
            System.out.println(mergeMap);     //{Java=7}
            System.out.println(mergeMap);     // {}
            mergeMap.merge("Java",9,(oldval, newval)->{
                    System.out.println("Old val:"+oldval+" New val:"+newval);
//                    return oldval+newval;
                    return null;
            });
            System.out.println(mergeMap);   //if the return value is null and key is present, then the key is removed      //{} // java removed
            mergeMap.merge("Java",5,(x,y)->{return 5*y;});
            System.out.println(mergeMap);
            mergeMap.put("Python",null);
            mergeMap.merge("Python",9,Integer::sum);
            System.out.println(mergeMap);   //if null is already present like the first absent case. it will add new value ignoring the null.





        //1444 = 38
        //144 =12
        //225 = 15

//        int high=0,low=0;
//
//        for(int i=102;i>0;){
//            high = Integer.highestOneBit(i);
//            low = Integer.lowestOneBit(i);
////            System.out.println("i:"+i+" high:"+high+" "+Integer.toBinaryString(i));
////            System.out.println("i:"+i+" low:"+low+" "+Integer.toBinaryString(i));
//
//            System.out.println("i:"+i+" "+Integer.toBinaryString(i));
//            i>>>=1;
//        }


//        long exp = 11,temp=0;
//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.toBinaryString(16));
//        int test = 4 + 16 >>> 1;
//        System.out.println(Integer.toBinaryString(test)+" Int val"+test);
    }
}
