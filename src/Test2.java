import java.util.ArrayList;
import java.util.List;

public class Test2 {


    public static void main(String[] args){
        int[]  a = {0,1,2,3,4,5,7};
        System.out.println(solve(a));
    }

    public static int solve (int[] a) {
        // write code here
        if(a.length == 0){
            return -1;
        }

        List<Integer> aTemp = new ArrayList<>();
        for(int i = 0;i<a.length;i++){
            aTemp.add(a[i]);
        }

        int left = 0;
        int right = a.length-1;
        while(left <= right){
            if (!aTemp.contains(a[right]-1)){
                return a[right]-1;
            }else if (aTemp.contains(a[right])){
                right--;
            }

            if (!aTemp.contains(a[left]+1)){
                return a[left]+1;
            }else if (aTemp.contains(a[left])){
                left++;
            }
        }
        return -1;
    }
}
