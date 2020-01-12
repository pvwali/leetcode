import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        int n = nums.length;

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i=0; i<n; i++) {
            int rem = target - nums[i];
            if (idxMap.containsKey(rem)) {
                return new int[] {i, idxMap.get(rem)};
            }
            idxMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] ans = ts.twoSum(new int[] {3,2,4,1}, 6);
        System.out.println(Arrays.toString(ans));
    }
}
