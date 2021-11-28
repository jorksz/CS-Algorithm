package leetcode.design;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 设计和实现一个  LRU (最近最少使用) 缓存机制
 * 利用 linkedHashMap 来实现
 * @author lijt
 */
public class LRUCache {

    private LRUCacheLinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int size) {
        this.linkedHashMap = new LRUCacheLinkedHashMap<>(size);
    }

    public int get(int key) {
        return this.linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.linkedHashMap.put(key, value);
    }

    class LRUCacheLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

        /**
         * 缓存大小
         */
        private final int size;

        public LRUCacheLinkedHashMap(int size) {
            // accessOrder 很重要，每次使用之后将当前节点移动了末尾，后边当元素数量超过缓存大小时，会移除头部节点
            super(size, 0.75f, true);
            this.size = size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            // 当元素数量大于规定的缓存 size
            return size() > size;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruCache.get(1) == 1);    // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2) == -1);    // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lruCache.get(1) == -1);    // 返回 -1 (未找到)
        System.out.println(lruCache.get(3) == 3);    // 返回 3
        System.out.println(lruCache.get(4) == 4);    // 返回 4
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */