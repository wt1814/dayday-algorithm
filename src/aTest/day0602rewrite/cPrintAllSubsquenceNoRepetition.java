package aTest.day0602rewrite;

import java.util.HashSet;
import java.util.Iterator;

public class cPrintAllSubsquenceNoRepetition {

    public static void main(String[] args) {
        HashSet<String> hashSet = printAllSubsquence("abc");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static HashSet<String> printAllSubsquence(String str){
        if (str == null){
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();

        char[] chars = str.toCharArray();
        if (chars.length == 0){
            System.out.print("");
        }else {
            String pre = "";
            printAllSubsquence(0,pre,chars,hashSet);
        }

        return hashSet;

    }

    private static void printAllSubsquence(int i, String pre, char[] chars,HashSet<String> hashSet) {
        if (i == chars.length){
            //System.out.println(pre);
            hashSet.add(pre);
            return;
        }

        printAllSubsquence(i+1,pre,chars,hashSet);
        printAllSubsquence(i+1,pre+chars[i],chars,hashSet);

    }
}

