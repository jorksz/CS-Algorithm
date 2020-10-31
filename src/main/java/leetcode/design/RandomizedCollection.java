package leetcode.design;

import java.util.*;

import static java.util.Collections.swap;

public class RandomizedCollection {
    // key -> value ： 值 -> 索引
    private Map<Integer, Set<Integer>> map;
    // 存值， 有序链表 ，通过该索引也可以获取到该值
    List<Integer> mapValueList;
    // 插入元素统计
    int index;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        mapValueList = new ArrayList<>();
        index = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set = map.get(val);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(index);
        mapValueList.add(val);
        map.put(val, set);
        index++;
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastButOneIndex = index - 1;
            Set<Integer> lastButOneSet = map.get(mapValueList.get(lastButOneIndex));
            Set<Integer> currSet = map.get(val);
            int curIndex = currSet.iterator().next();
            // 要求复杂度为 O（1）, 集合删除末尾值，复杂度才为1，
            // 所以将要删除的值与 末尾的值进行置换、
            swap(mapValueList, curIndex, lastButOneIndex);
            // 删除最后一个值
            mapValueList.remove(index - 1);
            // 删除该值索引
            currSet.remove(curIndex);
            // map要删除该值，需要等索引集合为0才能删除
            if (currSet.size() == 0) {
                map.remove(val);
            }
            // 修改最后一个值的索引
            lastButOneSet.remove(index - 1);
            lastButOneSet.add(curIndex);
            index --;
            return true;
        }
        else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return mapValueList.get((int) (Math.random() * index));
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.remove(0));
        System.out.println(randomizedCollection.remove(0));
        System.out.println(randomizedCollection.insert(0));
        System.out.println(randomizedCollection.getRandom());
    }
}
