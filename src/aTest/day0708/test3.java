package aTest.day0708;

public class test3 {

    public static void main(String[] args){
        int[] a = {1,2,3,4};

        System.out.println(solve(a));

    }
    public static int solve (int[] a) {
        // write code here

        int result = a.length-1;

        for(int i = a.length-2;i>=1;i--){
            if(a[i]>a[i-1] && a[i]>a[i+1]){
                result = i;
                break;
            }
        }

        if(a[0] > a[result]){
            result = 0;
        }

        if(a[a.length-1] > a[result]){
            result = a.length-1;
        }
        return result;

    }
}
