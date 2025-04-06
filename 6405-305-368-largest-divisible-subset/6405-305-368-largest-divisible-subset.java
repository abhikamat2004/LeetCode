import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array
        
        int[] dp = new int[n];        // dp[i] = size of largest subset ending at i
        int[] prev = new int[n];      // prev[i] = previous index in the subset
        Arrays.fill(dp, 1);           // Minimum subset size is 1
        Arrays.fill(prev, -1);        // Initialize previous index as -1
        
        int maxSize = 1;
        int maxIndex = 0;
        
        // Build DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // Update max subset size
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            result.add(nums[current]);
            current = prev[current];
        }
        
        Collections.reverse(result); // To return in increasing order
        return result;
    }
}
