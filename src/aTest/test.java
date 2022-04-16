package aTest;

public class test {

    public static void main(String[] args) {

    }


    public static void helper(int[] arr,int left,int right){

        if (left > right){
            return;
        }

        int index = partion(arr,left,right);
        helper(arr,left,index-1);
        helper(arr,index+1,right);

    }

    private static int partion(int[] arr, int left, int right) {

        int base = arr[left];
        while (left < right){

        }

        return left;
    }


}
