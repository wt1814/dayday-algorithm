package nLRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMap实现
 * 不重写removeEldestEntry
 */
public class LRUByLinkedOne {


    // https://mp.weixin.qq.com/s/pGNIEOGvOYDM5yiyMM8bRQ

    public static void main(String[] args) {
        LRUByLinkedOne lruCache = new LRUByLinkedOne(10);
        for (int i = 0; i < 10; i++) {
            lruCache.map.put(i,i);
            System.out.println(lruCache.map.size());
        }
        System.out.println(lruCache.map);
        lruCache.put(10,200);
        System.out.println(lruCache.map);
    }

    ////////////////////////////////////////////////////////////////////////////////////

    int capacity;
    Map<Integer,Integer> map;

    public LRUByLinkedOne(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    ////////////////////////////////////////////////////////////////////////////////////

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

    public void put(int key,int value){
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        map.put(key,value);
        //todo 超出capacity，删除最久没用的即第一个,
        // 或者可以复写removeEldestEntry方法
        if (map.size() > capacity){
            map.remove(map.entrySet().iterator().next().getKey()); // todo 删除最久没用的，即第一个
        }
    }

}
