package problem1008;

public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            int curr = preorder[i];
            putValToTreeNode(node, curr);
        }
        return node;
    }

    private void putValToTreeNode(TreeNode node, int curr) {
        if(node == null){
            return;
        }
        if (node.val > curr) {
            if (node.left == null) {
                node.left = new TreeNode(curr);
            } else {
                putValToTreeNode(node.left, curr);
            }
        }
        if (node.val < curr) {
            if (node.right == null) {
                node.right = new TreeNode(curr);
            } else {
                putValToTreeNode(node.right, curr);
            }
        }
    }
}

