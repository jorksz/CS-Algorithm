package leetcode.tree;

import leetcode.list.RemoveNthNodeFromEndOfList;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    // 和之前树的层次遍历差不多，这里通过一个辅助队列来记录每层的 Node 节点信息
    // 第一层循环 while 记录 Node 的层数， 通过 size 来记录 每一层的节点的数量，可能
    // 有小伙伴会有疑问，为什么 size 可以用来记录每一层的节点数量，因为下面的 for 循环
    // 遍历了这层的节点，遍历的同时也有出队、连接，同时将该节点的子节点入队，当内循环结束，当前
    // 这层就遍历完全了，而此时，队列中的节点数正好是下一层的数量，依次往下。
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
        }
        return root;
    }

    public Node connect2(Node root) {
        helper(root, null);
        return root;
    }

    private void helper(Node root, Node next) {
        if (root == null) {
            return;
        }
        root.next = next;
        helper(root.left, root.right);
        helper(root.right, root.next == null ? null : root.next.left);
    }
}
