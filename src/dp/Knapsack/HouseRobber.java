package dp.Knapsack;

/**
 * @Author: huhan
 * @Date 2020/6/7 7:45 上午
 * @Description 打家劫舍3
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列
 * 类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * @Verion 1.0
 */
public class HouseRobber {
    //方法一：
    /*Map<TreeNode, Integer> cache = new HashMap<>();
    public int rob(TreeNode root) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        if ((result = cache.getOrDefault(root,0)) != 0) {
            return cache.get(root);
        }
        int n = rob(root.left) + rob(root.right);

        int y = root.val;
        if (root.left != null) {
            y = y + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            y = y + rob(root.right.left) + rob(root.right.right);
        }
        cache.put(root,Math.max(n,y));
        return cache.get(root);
    }*/

    //方法二：
    //https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = robOrNot(root);
        return Math.max(result[0], result[1]);
    }

    //当前节点偷或者不偷
    public int[] robOrNot(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] result = new int[2];
        int[] left = robOrNot(root.left);
        int[] right = robOrNot(root.right);

        //不偷
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷
        result[1] = left[0] + right[0] + root.val;
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        root.left.right = node3;
        root.right.right = node4;
        int rob = new HouseRobber().rob(root);
        System.out.println(rob);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
