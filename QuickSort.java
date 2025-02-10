import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {7, 9, 5, 3, 6, 78, 24, 4, 0, 7, 7, 7, 7, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array);
//        System.out.println(quickSort.findKthLargest(array, 2));
        System.out.println(Arrays.toString(array));
    }

    // 数组中的第K个最大元素
    /*public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int left, int right, int k) {
        if (left == right) return nums[k];
        int partition = nums[left], less = left - 1, more = right + 1;
        while (less < more) {
            do {
                less++;
            } while (nums[less] < partition);
            do {
                more--;
            } while (nums[more] > partition);
            if (less < more) {
                swap(nums, less, more);
            }
        }
        if (k <= more) {
            return quickSort(nums, left, more, k);
        } else {
            return quickSort(nums, more + 1, right, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }*/

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }


    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = nums[left], less = left - 1, more = right + 1;
            while (less < more) {
                do {
                    less++;
                } while (nums[less] < partition);
                do {
                    more--;
                } while (nums[more] > partition);
                if (less < more) {
                    swap(nums, less, more);
                }
            }
            quickSort(nums, left, more);
            quickSort(nums, more + 1, right);
        }

    }

    /*public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // Math.random() [0,1) --> [0, r-l] + l --> [l, r]
            int random = (int) (Math.random() * (right - left + 1)) + left;
            // random = 3  {5, 4, 3, 2, 1} -> {5, 4, 3, 1, 2}
            swap(array, random, right);
            int[] p = partition(array, left, right);
            quickSort(array, left, p[0]);
            quickSort(array, p[1], right);
        }
    }

    public int[] partition(int[] array, int left, int right) {
        // {5, 4, 3, 1, 2}  left = 0 right = 4
        // less = -1  more = 4
        int less = left - 1;
        int more = right;
        while (left < more) {
            // 5 > 2  {1, 4, 3, 5, 2} more = 3
            // 1 < 2  {1, 4, 3, 5, 2} less = 0 left = 1
            if (array[left] < array[right]) {
                swap(array, ++less, left++);
            } else if (array[left] > array[right]) {
                swap(array, --more, left);
            } else {
                left++;
            }
        }
        swap(array, more, right);
        return new int[]{less, more + 1};
    }
*/
    public void swap(int[] array, int i, int j) {
        if (i == j) return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
