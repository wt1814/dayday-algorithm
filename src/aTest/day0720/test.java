package aTest.day0720;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args){

        Integer[] arr = {1,2,2,1};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr)) ;
        System.out.println(isHuiwen(list));

    }

    public static boolean isHuiwen(List<Integer> list){
        boolean result = true;
        int left = 0;
        int right = list.size()-1;
        while(left <= right){
            if(list.get(left) != list.get(right)){
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;
    }
}
