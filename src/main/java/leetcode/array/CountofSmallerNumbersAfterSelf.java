package leetcode.array;

import java.util.*;

public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0 || nums == null){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int count = 0;
            for (int j = i; j <nums.length;j++){
                if (nums[i] > nums[j]){
                    count++;
                }
            }
            res.add(count);
        }

        return res;
    }

    private int[] c;
    private int[] a;

    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }


    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf countofSmallerNumbersAfterSelf = new CountofSmallerNumbersAfterSelf();
        int[] nums = {5,2,6,1};
        System.out.println(countofSmallerNumbersAfterSelf.countSmaller(nums));
    }
}
