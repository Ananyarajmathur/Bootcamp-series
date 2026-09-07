class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Maximum contribution from left subtree
        int left = Math.max(0, dfs(node.left));

        // Maximum contribution from right subtree
        int right = Math.max(0, dfs(node.right));

        // Maximum path passing through current node
        int currentPath = left + node.val + right;

        // Update global answer
        maxSum = Math.max(maxSum, currentPath);

        // Return maximum one-sided path
        return node.val + Math.max(left, right);
    }
}