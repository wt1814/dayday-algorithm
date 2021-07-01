package aTest.day0701;

public class ts2 {
    public static void main(String[] args) {

        int[] a = {1,2,3};
        System.out.println(minNumberdisappered(a));
    }

    public static int minNumberdisappered (int[] arr) {
        // write code here
        int result = 0;
        int index = -1;
        if(arr[arr.length-1]<=0){
            return 1;
        }

        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] >0){
                index = i;
                break;
            }
        }

        if(arr[index] != 1){
            return 1;
        }

        for(int j = index;j<arr.length-1;j++){
            result++;
            if(arr[j] != result){
                return result;
            }
        }
        result++;
        return result;
    }
}
