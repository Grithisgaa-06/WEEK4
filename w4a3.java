import java.util.*;

public class w4a3 {

    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Since array is sorted, no possible triplet after this
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});

                    int leftValue = nums[left];
                    int rightValue = nums[right];

                    // Skip duplicates
                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }

                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[][] result = threeSum(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.deepToString(result));
    }
}
