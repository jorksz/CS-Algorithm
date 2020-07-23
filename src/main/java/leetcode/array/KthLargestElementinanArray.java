package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length < k){
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        if (nums.length < k){
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();


        for (int i = 0; i < nums.length; i++){
            if (priorityQueue.size() < k){
                priorityQueue.add(nums[i]);
            }
            else if (nums[i] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        System.out.println(findKthLargest2(nums, k));
    }
}
