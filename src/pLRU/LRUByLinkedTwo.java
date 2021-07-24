package pLRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMap实现
 * 重写removeEldestEntry
 */
public class LRUByLinkedTwo<K, V> {


    public static void main(String[] args) {
        LRUByLinkedTwo lruCache = new LRUByLinkedTwo(10);
        for (int i = 0; i < 10; i++) {
            lruCache.cacheMap.put(i,i);
            System.out.println(lruCache.cacheMap.size());
        }
        System.out.println(lruCache.cacheMap);
        lruCache.put(10,10);
        System.out.println(lruCache.cacheMap);
    }

    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * 最大缓存大小
     */
    private int cacheSize;
    private LinkedHashMap<K, V> cacheMap;

    public LRUByLinkedTwo(int cacheSize) {
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

    ////////////////////////////////////////////////////////////////////////////////////

    public void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public V get(K key) {
        return cacheMap.get(key);
    }

}