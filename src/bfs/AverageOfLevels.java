package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/25 9:09 上午
 * @Description 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * @Verion 1.0
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        if(root==null){
            return result;
        }

        current.add(root);
        while(!current.isEmpty()){
            List<Integer> nodes = new ArrayList<>();
            double sum =0.0d;
            int count = 0;
            while(!current.isEmpty()){
                TreeNode node = current.poll();
                 sum+=node.value;
                 count++;
                if(node.left!=null){
                    next.add(node.left);
                }
                if(node.right!=null){
                    next.add(node.right);
                }
            }
            result.add(sum/count);

            LinkedList<TreeNode> temp;
            temp = current;
            current = next;
            next = temp;
        }
        return result;
    }

    public double average(List<Integer> list){
        if(list.size()==0){
            return 0;
        }
        int i=0;
        double sum=0d;
        for(i=0;i<list.size();i++){
            sum+=list.get(i);
            System.out.println("");
        }
        return sum/(i*1.0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        /*TreeNode root = new TreeNode(2147483647);
        TreeNode node1 = new TreeNode(2147483647);
        TreeNode node2 = new TreeNode(2147483647);
        root.left = node1;
        root.right = node2;*/
        System.out.println(new AverageOfLevels().averageOfLevels(root));
    }
}
