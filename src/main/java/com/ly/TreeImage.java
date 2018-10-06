package com.ly;

/**
 * @author yong.liang
 * 2018/10/6
 */
public class TreeImage {
    public static void main(String args[]) {
        BRTree tree = new BRTree();
        tree.put(1, 1);
        tree.put(2, 2);
        tree.put(3, 3);
        tree.put(4, 4);
        tree.put(10, 10);
        tree.put(6, 6);
        tree.put(5, 5);
        tree.put(11, 11);
        tree.list(tree.root);
        BRTree newTree = new BRTree();
        newTree.put(tree.root.key, tree.root.value);
        preOrderTraverse1(tree.root.left, newTree.root, false);
        preOrderTraverse1(tree.root.right, newTree.root, true);
        newTree.list(newTree.root);
    }

    public static void preOrderTraverse1(BRTree.Node root, BRTree.Node parent, boolean isLeft) {
        if (root != null) {
            BRTree.Node newParent = null;
            if (isLeft) {
                parent.left = new BRTree.Node();
                newParent = parent.left;
            } else {
                parent.right = new BRTree.Node();
                newParent = parent.right;
            }

            preOrderTraverse1(root.left, newParent, false);
            preOrderTraverse1(root.right, newParent, true);
            System.out.print(root.value + "  ");
            if (isLeft) {
                parent.left.value = root.value;
                parent.left.key = root.key;
            } else {
                parent.right.value = root.value;
                parent.right.key = root.key;
            }
        }
    }
}
