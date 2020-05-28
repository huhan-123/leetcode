package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/26 8:25 上午
 * @Description 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * @Verion 1.0
 */
//每到一个节点，用list存储当前路径(这里用到了回溯法)，知道最后一个叶子节点，如果叶子节点满足条件，将其路径加入到result中
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        ArrayList<Integer> currentPath = new ArrayList<>();
        findPath(root,sum,result,currentPath);
        return result;
    }

    public void findPath(TreeNode node, int target, List<List<Integer>> result, List<Integer> currentPath) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                result.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size()-1);
                return;
            } else {
                currentPath.remove(currentPath.size()-1);
                return;
            }
        }

        findPath(node.left, target - node.val, result, currentPath);
        findPath(node.right, target - node.val, result, currentPath);
        currentPath.remove(currentPath.size()-1);
    }
}
