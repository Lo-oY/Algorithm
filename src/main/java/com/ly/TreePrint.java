package com.ly;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 层级遍历
 *
 * @author yong.liang
 * 2018/10/5
 */
public class TreePrint {
    public static void main(String args[]) {
        BRTree tree = new BRTree();
        tree.put(2, 2);
        tree.put(1, 1);
        tree.put(3, 3);
        tree.put(4, 4);
        tree.put(6, 6);
        tree.put(5, 5);
        tree.put(10, 10);
        tree.put(11, 11);

        Queue<BRTree.Node> queue = new ArrayDeque<>();
        queue.add(tree.root);
        while (queue.size() > 0) {
            BRTree.Node node = queue.poll();
            System.out.println(node.value);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}
