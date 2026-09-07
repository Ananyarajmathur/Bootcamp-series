class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Check first window
        if (sum >= k * threshold) {
            count++;
        }

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            sum += arr[i];       // add new element
            sum -= arr[i - k];   // remove old element

            if (sum >= k * threshold) {
                count++;
            }
        }

        return count;
    }
}