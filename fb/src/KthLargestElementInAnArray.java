/**
 * Created by YSZ on 2017/2/16.
 */
public class KthLargestElementInAnArray {
    public int KthLargestElementInAnArray(int[] nums, int k) {
        if (nums.length < k) return 0;
        int res = partition(nums, 0, nums.length - 1);
        while (res != k) {
            if (res < k) {
                res = partition(nums, res + 1, nums.length - 1);
            } else {
                res = partition(nums,0, res);
            }
        }

        return nums[res];

    }
    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int left = lo + 1, right = hi;
        while (left != right) {
            if (nums[left] > nums[right]) swap (nums, left, right);
            if (pivot == nums[left]) right --;
            else left ++;
        }
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] arg) {
        KthLargestElementInAnArray kleia = new KthLargestElementInAnArray();
        System.out.println(kleia.KthLargestElementInAnArray(new int[] {2, 1, 1, 3}, 2));
    }
}
