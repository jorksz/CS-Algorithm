package leetcode.array;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int rear = numbers.length -1;
        int[] res = new int[2];

        while (front < rear){
            int temp = numbers[front] + numbers[rear];
            if (temp == target){
                break;
            }

            else if (temp > target){
                rear --;
            }
            else {
                front++;
            }
        }
        res[0] = front + 1;
        res[1] = rear + 1;

        return res;
    }

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int target = 9;
        TwoSumII twoSumII = new TwoSumII();
        int[] res = twoSumII.twoSum(ints, target);

    }
}
