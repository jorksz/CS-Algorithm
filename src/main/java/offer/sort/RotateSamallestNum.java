package offer.sort;

/**
 * 旋转数组的最小数字
 *
 *
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class RotateSamallestNum {

    public static int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(array[high] < array[mid]){
                low = mid + 1;
            }

            else if(array[high] == array[mid]){
                high--;
            }

            else {
                high = mid;
            }
        }

        return array[low];
    }

    public static void main(String[] args) {
        int[] array ={4,5,1,2,3};
        System.out.println("zzz");
        System.out.println(minNumberInRotateArray(array));
    }
}
