package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: huhan
 * @Date 2020/5/24 9:12 下午
 * @Description 二叉树级顺序遍历（如果是从下往上遍历，最后加一个将集合翻转的操作就可以了）
 * 给定一个二叉树，返回其节点值的级别顺序遍历。（即，从左到右，逐级）。
 * @Verion 1.0
 */
//将根节点放入队列，出队列时再将其左右孩子按顺序放入另一个队列，然后再将另一个队列的元素依次出队列，如此循环直至队列为空
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        current.offer(root);
        while (!current.isEmpty()) {
            ArrayList<Integer> nodes = new ArrayList<>();
            while (!current.isEmpty()){
                TreeNode node = current.poll();
                nodes.add(node.value);
                if (node.left!=null){
                    next.offer(node.left);
                }
                if (node.right!=null){
                    next.offer(node.right);
                }
            }
            result.add(nodes);
            Queue<TreeNode> temp;
            temp = current;
            current = next;
            next = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        head.left = node2;
        head.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        List<List<Integer>> lists = new LevelOrder().levelOrder(head);
        System.out.println();
        int cout=2;
    }
}
