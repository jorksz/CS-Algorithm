package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i : nums){
            if (res.containsKey(i)){
                int count = res.get(i);
                res.put(i,count+1);
            }
            else {
                res.put(i, 1);
            }
        }

        Map.Entry<Integer, Integer> numMap = null;
        for (Map.Entry<Integer, Integer> map : res.entrySet()){
            if (numMap == null || map.getValue() > numMap.getValue()){
                numMap = map;
            }
        }
        return numMap.getKey();
    }
}
