class Solution {

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {

        HashMap<Long, Integer> map = new HashMap<>();

        // Empty path has sum 0
        map.put(0L, 1);

        dfs(root, 0L, targetSum, map);

        return count;
    }

    private void dfs(TreeNode node, long currentSum,
                     int targetSum, HashMap<Long, Integer> map) {

        if (node == null) {
            return;
        }

        // Add current node to running sum
        currentSum += node.val;

        // Check if a valid path exists
        count += map.getOrDefault(
            currentSum - targetSum, 0
        );

        // Store current prefix sum
        map.put(
            currentSum,
            map.getOrDefault(currentSum, 0) + 1
        );

        // Explore children
        dfs(node.left, currentSum, targetSum, map);
        dfs(node.right, currentSum, targetSum, map);

        // Backtrack
        map.put(
            currentSum,
            map.get(currentSum) - 1
        );
    }
}