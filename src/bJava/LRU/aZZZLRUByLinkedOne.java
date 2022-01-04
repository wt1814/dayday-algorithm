package bJava.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * todo 基于LinkedHashMap实现，不重写removeEldestEntry
 * todo LinkedhashMap默认采用尾插法新增数据。
 */
public class aZZZLRUByLinkedOne {


    // https://mp.weixin.qq.com/s/pGNIEOGvOYDM5yiyMM8bRQ

    public static void main(String[] args) {
        aZZZLRUByLinkedOne lruCache = new aZZZLRUByLinkedOne(10);
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

    /**
     * todo 构造函数
     * @param capacity
     */
    public aZZZLRUByLinkedOne(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    /////////////////////////////////

    // https://blog.csdn.net/varyall/article/details/82319443
    // https://blog.csdn.net/weixin_45640609/article/details/105069981
    // afterNodeInsertion方法用于移除链表中的最旧的节点对象，也就是链表头部的对象。
    // 但是在JDK1.8版本中，可以看到removeEldestEntry一直返回false，所以该方法并不生效。如果存在特定的需求，比如链表中长度固定，并保持最新的N的节点数据，可以通过重写该方法来进行实现。

    /**
     * 1. 新增
     * @param key
     * @param value
     */
    public void put(int key, int value){

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

    /**
     * 2. 获取
     * @param key
     * @return
     */
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
