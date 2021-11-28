package leetcode.bisearch;

/**
 * @author lijt
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));


        String str = "abc";
        String str2 = new String("abc");
        String str3 = str.intern();
        String str4= str2.intern();
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str2 == str3);
        System.out.println(str == str4.intern());


    }
}
