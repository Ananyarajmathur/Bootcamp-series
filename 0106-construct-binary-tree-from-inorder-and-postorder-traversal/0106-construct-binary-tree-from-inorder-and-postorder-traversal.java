class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store value -> index of inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Start from the last element of postorder
        postorderIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        // No elements available
        if (left > right) {
            return null;
        }

        // Last element of postorder is the root
        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = map.get(rootValue);

        // IMPORTANT: Build RIGHT first
        root.right = build(postorder, index + 1, right);

        // Then build LEFT
        root.left = build(postorder, left, index - 1);

        return root;
    }
}