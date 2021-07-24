package pLRU;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        int[][] a= {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        LRU(a,3);
    }

    public LinkedHashMap<Integer,Integer> map;
    public int K;

    public Solution(){

    }

    public Solution(int K,LinkedHashMap linkedHashMap){
        this.K = K;
        this.map = linkedHashMap;
    }

    public static int[] LRU (int[][] operators, int k) {
        // write code here
        Solution solution = new Solution(k,new LinkedHashMap());

        List<Integer> list = new ArrayList();
        for(int i = 0;i<operators.length;i++){
            if(operators[i][0] == 1){
                solution.set(operators[i][1],operators[i][2]);
            }

            if(operators[i][0] == 2){
                int num = solution.get(operators[i][1]);
                list.add(num);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public void set(int key,int value){
        if(map.containsValue(key)){
            map.remove(map.get(key));
            map.put(key,value);
            return;
        }

        map.put(key,value);
        if(map.size()>K){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public int get(int key){
        //如果没有找到
        if (!map.containsKey(key)){
            return -1;
        }
        //找到了就刷新数据
        Integer value = map.remove(key);
        map.put(key,value);
        return value;
    }
}
