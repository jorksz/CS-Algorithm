package offer.sort;

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
