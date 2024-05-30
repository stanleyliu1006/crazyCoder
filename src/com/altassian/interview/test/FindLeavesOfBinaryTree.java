package com.altassian.interview.test;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class FindLeavesOfBinaryTree {

    private static final Logger logger = Logger.getLogger(FindLeavesOfBinaryTree.class.getName());
    public List<List<Integer>> currentSubTreeAndRemoveLeaves(TreeNode root) {
        if (root == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = removeLeaves(root, leaves);
            if(!leaves.isEmpty()) {
                result.add(leaves);
            }
        }
        return result;
    }

    private TreeNode removeLeaves(TreeNode node, List<Integer> leaves) {
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            return null; // current node is removed
        }
        node.left = removeLeaves(node.left, leaves);
        node.right = removeLeaves(node.right, leaves);
        return node; // returns the modified left and right children after the removal of leaves
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args) {
        FindLeavesOfBinaryTree collector = new FindLeavesOfBinaryTree();
        List<List<Integer>> collectedLeaves = collector.currentSubTreeAndRemoveLeaves(buildTree());
        logger.info(String.valueOf(collectedLeaves.get(0).toString().equalsIgnoreCase("[4, 5, 3]")));
        logger.info(String.valueOf(collectedLeaves.get(1).toString().equalsIgnoreCase("[2]")));
        logger.info(String.valueOf(collectedLeaves.get(2).toString().equalsIgnoreCase("[1]")));
    }
}

