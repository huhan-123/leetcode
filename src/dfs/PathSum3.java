package dfs;

/**
 * @Author: huhan
 * @Date 2020/5/25 11:09 上午
 * @Description 路径总和3
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @Verion 1.0
 */

/**
 * 思路一：结果可以分成三个部分：1.以根节点开头的路径和为sum的路径个数 2.不以根节点开头的路径和为sum的路径个数
 * （可能以root.left开头也可能不以root.left开头的路径和为sum的路径个数+可能以root.right开头也可能不以root.right开头的路径和为sum的路径个数）
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 思路二：https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
 */
public class PathSum3 {
    /*//找到以root为根节点的路径和等于sum的路径的总数（路径的起点可能是root，也可能不是root）
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    //找到以root为根节点的路径和等于sum的路径的总数（路径的起点一定是root）
    public int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //如果root的值等于sum，结果加1
        if (root.val == sum) {
            return findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val) + 1;
        } else {
            return findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
        }
    }*/

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //当前节点的值等于sum的情况
        map.put(0, 1);
        return countPath(root, map, sum, 0);
    }

    //当前节点到根节点路径和为sum的路径个数+当前节点子树上所有节点到根节点路径和为sum的路径个数
    public int countPath(TreeNode node, Map<Integer, Integer> map, int target, int currentSum) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        currentSum = node.val + currentSum;
        result += map.getOrDefault(currentSum - target, 0);
        int currentCount = map.getOrDefault(currentSum, 0) + 1;
        map.put(currentSum, currentCount);
        result = result + (countPath(node.left, map, target, currentSum) + countPath(node.right, map, target, currentSum));
        //遍历完子树后要将状态回退（其它路径不会再经过当前节点）
        map.put(currentSum, currentCount - 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        System.out.println(new PathSum3().pathSum(root, 8));
    }
}
