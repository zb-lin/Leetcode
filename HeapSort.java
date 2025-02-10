import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {7, 9, 5, 3, 6, 78, 24, 4, 0, 7, 7, 7, 7, 7};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void heapSort(int[] nums) {
        if (nums.length < 2)
            return;
        for (int i = 0; i < nums.length; ++i) {
            heapInsert(nums, i);
        }
        int size = nums.length - 1;
        while (size > 0) {
            swap(nums, 0, size);
            heapity(nums, size--);
        }
    }

    public void heapInsert(int[] nums, int i) {
        while (nums[i] < nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void heapity(int[] nums, int size) {
        int curr = 0;
        int left = 1;
        while (left < size) {
            int min = left + 1 < size && nums[left + 1] < nums[left] ? left + 1 : left;
            min = nums[curr] < nums[min] ? curr : min;
            if (curr == min)
                return;
            swap(nums, curr, min);
            curr = min;
            left = curr * 2 + 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    /*public void heapSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            heapInsert(nums, i);
        }
        int size = nums.length - 1;
        while (size > 0) {
            swap(nums, 0, size);
            heapify(nums, size--);
        }
    }

    public void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void heapify(int[] nums, int size) {
        int curr = 0;
        int left = 1;
        while (left < size) {
            int max = (left + 1 < size && nums[left + 1] > nums[left]) ? left + 1 : left;
            max = nums[curr] > nums[max] ? curr : max;
            if (max == curr) {
                return;
            }
            swap(nums, max, curr);
            curr = max;
            left = 2 * curr + 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }*/
}
