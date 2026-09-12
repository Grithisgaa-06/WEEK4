import java.util.HashMap;
import java.util.Map;

public class w4a4 {

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSum = new HashMap<>();

        // Empty prefix
        prefixSum.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check whether currentSum - k appeared before
            if (prefixSum.containsKey(currentSum - k)) {
                count += prefixSum.get(currentSum - k);
            }

            prefixSum.put(
                currentSum,
                prefixSum.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Input: [1, 1, 1]");
        System.out.println("K: " + k);
        System.out.println("Number of Subarrays: " + result);
    }
}
