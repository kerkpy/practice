package BinaryTreePruning;



// Link to problem: https://leetcode.com/problems/binary-tree-pruning/


class Solution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

        public TreeNode pruneTree(TreeNode root) {

            // If the root is null, return null (Base case)

            if (root == null) {
                return null;
            }

            // ELse, we have to traverse into the left and right nodes, and prune them.

            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            root.left = pruneTree(leftNode);
            root.right = pruneTree(rightNode);


            // Suppose the left and right are both null, this implies that the subtree is a single Node.
            // Prune it (return null) if it is 0, else, return the subtree.
            if (root.left == null && root.right == null) {
                if (root.val == 0) {
                    return null;
                } else {
                    return root;
                }
            }


            return root;

        }
    }

