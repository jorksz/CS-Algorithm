package offer.array;

public class RotateTheMinimumNumberofTheArray_11 {
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]){
                high = mid;
            }
            else if(numbers[mid] > numbers[high]){
                low = mid + 1;
            }else {
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        System.out.println(minArray(numbers));
    }
}
