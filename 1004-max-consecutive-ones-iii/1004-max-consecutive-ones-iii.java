class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // If we encounter a zero
            if (nums[right] == 0) {
                zeros++;
            }

            // Too many zeros, shrink window
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            // Current valid window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}