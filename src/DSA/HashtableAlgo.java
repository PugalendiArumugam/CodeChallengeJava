package DSA;

import java.util.Hashtable;

public class HashtableAlgo {
    public static void main(String[] args) {
        Hashtable<String,String> table = new Hashtable<>(10);


        table.put("100","Bob");
        table.put("123","Pat");
        table.put("321","San");
        table.put("555","Squid");
        table.put("777","Gary");
        table.put("874","John");

//        table.remove("874");

        for(String key: table.keySet()) {
            System.out.println(key.hashCode()+"\t"+key+"\t"+table.get(key));

        }

    }
}
