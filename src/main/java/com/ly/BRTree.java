package com.ly;

/**
 * 红黑树
 *
 * @author yong.liang
 * 2018/9/24
 */
public class BRTree {

    private static boolean BLACK = false;
    private static boolean RED = true;

    class Node {
        Node left;
        Node right;
        Node parent;
        int key;
        int value;
        boolean isRed;
    }

    Node root;

    public void put(int key, int value) {
        Node t = root;
        if (t == null) {
            Node node = new Node();
            node.key = key;
            node.value = value;

            root = node;
            return;
        }

        Node parent;
        do {
            parent = t;
            if (t.key < key)
                t = t.right;
            else if (t.key > key)
                t = t.left;
            else
                t.value = value;
        } while (t != null);

        Node node = new Node();
        node.key = key;
        node.value = value;
        node.parent = parent;

        if (parent.key < key)
            parent.right = node;
        else
            parent.left = node;

        fixAfterInsert(node);
    }

    private void fixAfterInsert(Node node) {
        if (node == null)
            return;
        node.isRed = true;
        while (node != root && parentOf(node).isRed) {
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                if (colorOf(rigthOf(parentOf(parentOf(node)))) == RED) {
                    setColor(parentOf(parentOf(node)), RED);
                    setColor(rigthOf(parentOf(parentOf(node))), BLACK);
                    setColor(parentOf(node), BLACK);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == parentOf(node).right) {
                        node = parentOf(node);
                        rotateLeft(parentOf(node));
                    }

                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
//                    setColor(node, BLACK);
                    rotateRight(parentOf(parentOf(node)));
                }
            } else {
                if (colorOf(leftOf(parentOf(parentOf(node)))) == RED) {
                    setColor(parentOf(parentOf(node)), RED);
                    setColor(leftOf(parentOf(parentOf(node))), BLACK);
                    setColor(parentOf(node), BLACK);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == leftOf(node)) {
                        node = parentOf(node);
                        rotateRight(parentOf(node));
                    }

                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
//                    setColor(node, BLACK);
                    rotateLeft(parentOf(parentOf(node)));
                }
            }
        }
        root.isRed = false;
    }

    void rotateLeft(Node node) {
        if (node != null) {
            Node r = node.right;
            node.right = r.left;
            if (r.left != null) {
                r.left.parent = node;
            }

            r.parent = parentOf(node);
            if (parentOf(node) == null)
                root = r;
            else if (node == leftOf(node))
                node.left = r;
            else
                parentOf(node).right = r;

            node.parent = r;
            r.left = node;
        }
    }

    void rotateRight(Node node) {
        if (node != null) {
            Node l = node.left;
            node.left = l.right;
            if (l.right != null) {
                l.right.parent = node;
            }

            l.parent = parentOf(node);
            if (parentOf(node) == null)
                root = l;
            else if (node == leftOf(node))
                parentOf(node).left = l;
            else
                parentOf(node).right = l;

            node.parent = l;
            l.right = node;
        }

    }


    private Node parentOf(Node node) {
        return node == null ? null : node.parent;
    }

    private Node leftOf(Node node) {
        return node == null ? null : node.left;
    }

    private Node rigthOf(Node node) {
        return node == null ? null : node.right;
    }

    private boolean colorOf(Node node) {
        return node == null ? BLACK : node.isRed;
    }

    private void setColor(Node node, boolean color) {
        if (node != null) {
            node.isRed = color;
        }
    }

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

        tree.list();
    }

    public void list() {
        list(root);
    }

    public void list(Node node) {
        if (node == null)
            return;
        System.out.println(node.key + "," + node.value + "," + (node.isRed ? "红 " : "黑"));
        Node l = node.left;
        Node r = node.right;
        list(l);
        list(r);
    }
}
