package aTest.day0602rewrite;

public class bPrintAllSubsquence {


    public static void main(String[] args) {
        printAllSubsquence("abc");
    }

    public static void printAllSubsquence(String str){
        if (str == null){
            return;
        }

        char[] chars = str.toCharArray();
        if (chars.length == 0){
            System.out.print("");
        }else {
            String pre = "";
            printAllSubsquence(0,pre,chars);
        }

    }

    private static void printAllSubsquence(int i, String pre, char[] chars) {
        if (i == chars.length){
            System.out.println(pre);
            return;
        }

        printAllSubsquence(i+1,pre,chars);
        printAllSubsquence(i+1,pre+chars[i],chars);

    }
}
