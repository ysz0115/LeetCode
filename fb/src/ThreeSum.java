import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YSZ on 2017/2/15.
 */
public class ThreeSum {
    public List<List<Integer>> ThreeSum (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int target = 0 - nums[i];
            int lo = i + 1, hi = len - 1;
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[lo]);
                        tmp.add(nums[hi]);
                        res.add(tmp);
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
}

    public static void main(String[] arg) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.ThreeSum(new int[]{-1, 0, 1, 2, -1, 4}));
    }
}
