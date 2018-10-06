package com.ly;

/**
 * 树的深度
 *
 * @author yong.liang
 * 2018/10/5
 */
public class TreeDepth {
    public static void main(String args[]) {
        BRTree tree = new BRTree();
        tree.put(2, 2);
        tree.put(1, 1);
        tree.put(3, 3);
        tree.put(4, 4);
        tree.put(10, 10);
        tree.put(6, 6);
        tree.put(5, 5);
        tree.put(11, 11);

        tree.list(tree.root);
        int depth = treeDepth(tree.root);
        System.out.println(depth);
    }

    private static int treeDepth(BRTree.Node root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    static class Node {
        Node left;
        Node right;
    }
}
