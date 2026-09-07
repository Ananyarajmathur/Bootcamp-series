class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfs(root, "", result);

        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {

        path = path + node.val;

        // If leaf node
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        path = path + "->";

        if (node.left != null) {
            dfs(node.left, path, result);
        }

        if (node.right != null) {
            dfs(node.right, path, result);
        }
    }
}