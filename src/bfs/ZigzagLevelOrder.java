package bfs;

import java.util.*;

/**
 * @Author: huhan
 * @Date 2020/5/24 11:03 下午
 * @Description 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @Verion 1.0
 */
//方案一：这里改为用栈存储个层的元素，而且奇数层从右往左添加元素，偶数层从左往右添加元素
//方案二：这里每一层元素用队列从左到右入队，如果该层为偶数层，则出队列之后再执行翻转操作
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int count=1;
        if (root == null) {
            return result;
        }

        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        current.push(root);
        while (!current.isEmpty()) {
            ArrayList<Integer> nodes = new ArrayList<>();
            count++;
            while (!current.isEmpty()){
                TreeNode node = current.pop();
                nodes.add(node.value);
                if((count&1)==1){
                    if (node.right!=null){
                        next.push(node.right);
                    }
                    if (node.left!=null){
                        next.push(node.left);
                    }
                }else{
                    if (node.left!=null){
                        next.push(node.left);
                    }
                    if (node.right!=null){
                        next.push(node.right);
                    }
                }

            }
            result.add(nodes);
            Stack<TreeNode> temp;
            temp = current;
            current = next;
            next = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);*/
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        List<List<Integer>> lists = new ZigzagLevelOrder().zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
