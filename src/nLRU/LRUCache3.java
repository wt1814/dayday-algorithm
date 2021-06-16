package nLRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName：java-algorithm
 * @ClassName: LRUCache3
 * @Description:  基于JDK的哈希链表LinkedHashMap实现
 * @Author: wt 
 * @CreateDate: 2020-05-20 16:24
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class LRUCache3<K, V> {
    /**
     * 最大缓存大小
     */
    private int cacheSize;
    private LinkedHashMap<K, V> cacheMap;

    public LRUCache3(int cacheSize) {
        this.cacheSize = cacheSize;
        cacheMap = new LinkedHashMap(16, 0.75F, true) {
            //
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                // return this.size() > cacheSize;
                if (cacheSize + 1 == cacheMap.size()) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public V get(K key) {
        return cacheMap.get(key);
    }

    public static void main(String[] args) {
        LRUCache3 lruCache = new LRUCache3(10);
        for (int i = 0; i < 10; i++) {
            lruCache.cacheMap.put(i,i);
            System.out.println(lruCache.cacheMap.size());
        }
        System.out.println(lruCache.cacheMap);
        lruCache.put(10,10);
        System.out.println(lruCache.cacheMap);
    }

}